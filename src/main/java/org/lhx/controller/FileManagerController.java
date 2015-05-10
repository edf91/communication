package org.lhx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.lhx.domain.User;
import org.lhx.dto.FileInfoDTO;
import org.lhx.dto.comm.ShowFileInfoDTO;
import org.lhx.kindeditor.NameComparator;
import org.lhx.kindeditor.SizeComparator;
import org.lhx.kindeditor.TypeComparator;
import org.lhx.service.FileInfoService;
import org.lhx.utils.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * kindEditor 文件管理
 */
@Controller
@RequestMapping("/fileManager")
public class FileManagerController {
	@Resource
	private FileInfoService fileInfoService;
	
	@ResponseBody
	@RequestMapping(value = "/down")
	public void down(String fileId,HttpServletResponse response){
		FileInfoDTO dto = fileInfoService.getById(fileId);
		response.setContentType("application/x-download");
		try {
			response.addHeader("Content-Disposition","attachment;filename=" + new String(dto.getFileName().getBytes("GBK"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		FileInputStream fis = null;
		OutputStream os =  null;
		try {
			fis = new FileInputStream(new File(dto.getFilePath()));
			os = response.getOutputStream();
			byte b[] = new byte[1024];
			int len = 0;
			while((len = fis.read(b)) > 0){
				os.write(b,0,len);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fis.close();
				fis = null;
				os.close();
				os = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@ResponseBody
	@RequestMapping("/findAllFiles")
	public List<ShowFileInfoDTO> findAllFiles(HttpServletRequest request){
		UserUtil.setSession(request.getSession());
		User currentUser = UserUtil.getUser();
		// userType 0为学生1为老师
		if(currentUser.getUserType().equals("1")){
			return fileInfoService.findMyFilesByUserId(currentUser.getId());
		}else{
			return fileInfoService.findAllFiles();
		}
			
	}	
	/**
	 * 删除文件
	 * @param fileInfoId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delFile")
	public String delFile(String fileInfoId,HttpServletResponse response){
		return fileInfoService.deleteById(fileInfoId);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping("/listFile")
	public String listFile(HttpServletRequest request,HttpServletResponse response){
		UserUtil.setSession(request.getSession());
		User currentUser = UserUtil.getUser();
		//根目录路径，可以指定绝对路径
		String rootPath = request.getServletContext().getRealPath("/") + "/sysMsgFile/" + currentUser.getAccount() + "/";
		//根目录URL，可以指定绝对路径
		String rootUrl  = request.getContextPath() + "/sysMsgFile/"+ currentUser.getAccount() + "/";
		//图片扩展名
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};
		String dirName = request.getParameter("dir");
		if (dirName != null) {
			if(!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)){
				return "Invalid Directory name.";
			}
			rootPath += dirName + "/";
			rootUrl += dirName + "/";
			File saveDirFile = new File(rootPath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
		}
		//根据path参数，设置各路径和URL
		String path = request.getParameter("path") != null ? request.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		//排序形式，name or size or type
		String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

		//不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			return "Access is not allowed.";
		}
		//最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			return "Parameter is not valid.";
		}
		//目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if(!currentPathFile.isDirectory()){
			return "Directory does not exist.";
		}

		//遍历目录取的文件信息
		List<Hashtable> fileList = new ArrayList<Hashtable>();
		if(currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if(file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if(file.isFile()){
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}

		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		JSONObject result = new JSONObject();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);

		response.setContentType("application/json; charset=UTF-8");
		return result.toJSONString();
	}
}
