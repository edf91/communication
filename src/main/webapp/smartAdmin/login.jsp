<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> 大学师生信息交流网 </title>
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">	
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.css">	
		
		<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->
		
		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

	</head>
	<body style="font-family: 微软雅黑;" id="login" class="animated fadeInDown">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">
			<!--<span id="logo"></span>-->

			<div id="logo-group">
				<span id="logo"> <img style="width: 32px;" src="img/logo.png" alt="大学师生信息交流网"> </span>

				<!-- END AJAX-DROPDOWN -->
			</div>
		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big">大学师生信息交流网</h1>
						<div class="hero">

							<div class="pull-left login-desc-box-l">
								<h4 style="font-family: 微软雅黑;" class="paragraph-header">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随着计算机网络的迅速发展，基于网络的教学、交流已经成为未来的发展方向，网络具有高速快捷、互动性等特点，而且可以实现信息资源的共享性，学校教务系统和网络教学平台的应用，都获得很好的成果，这些都充分展现了教育的发展方向。Web在Internet环境的主导和盛行，大学师生信息交流网站会更加的方便和备受欢迎。在网络上营造一个供师生交流的空间，以减轻教师的教学负荷，增强教学反馈，提高学生的学习兴趣，增强学生的学习兴趣。</h4>
							</div>
							
							<img src="img/demo/iphoneview.png" class="pull-right display-image" alt="" style="width:210px">

						</div>


					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<form id="login-form" class="smart-form client-form">
								<header>
									登陆
								</header>

								<fieldset>
									
									<section>
										<label class="label">账 号</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" name="account">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Please enter account</b></label>
									</section>

									<section>
										<label class="label">密 码</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Enter your password</b> </label>
										<div class="note">
										</div>
									</section>
									<section>
										<label class="label">验证码</label>
										<label class="input"> <i class="icon-append fa fa-check"></i>
											<input type="text" name="checkNum" class="valid"><a onclick="flushImg(this)" href="javascript:void(0)"><img src="/user/getCheckImg" style="margin-top:4px;height:28px"/></a>
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 请输入验证码</b></label>
									</section>
									<section>
										<label class="checkbox">
											<input type="checkbox" id="remember" name="remember" checked="">
											<i></i>记住我</label>
									</section>
								</fieldset>
								<footer>
									<a id="loginA" class="btn btn-primary" href="javascript:login();">登陆</a>
								</footer>
							</form>

						</div>
						
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="js/plugin/pace/pace.min.js"></script>

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');} </script>

		<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="js/smartwidgets/jarvis.widget.min.js"></script>
		
		<!-- EASY PIE CHARTS -->
		<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
		
		<!-- SPARKLINES -->
		<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>
		
		<!-- JQUERY VALIDATE -->
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!-- JQUERY SELECT2 INPUT -->
		<script src="js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
		
		<!-- browser msie issue fix -->
		<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>
		
		<!-- FastClick: For mobile devices -->
		<script src="js/plugin/fastclick/fastclick.js"></script>
		
		<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<script type="text/javascript">
			document.onkeydown=function(event){
				e = event ? event :(window.event ? window.event : null); 
				if(e.keyCode==13){ 
					login();
				} 
			}
			function login(){
				$.ajax({
					url: '/user/login',
					type: 'POST',
					data: $("#login-form").serialize(),
					success: function(data,status){
						if(data){
							window.location.href="/user/index";
						}else{
							$.smallBox({
								title : "提示",
								content : "<i class='fa fa-clock-o'></i> <i>验证码/用户名/密码错误</i>",
								color : "#659265",
								iconSmall : "fa fa-check fa-2x fadeInRight animated",
								timeout : 4000
							});
						}
					}
					
				});
				return false;
			}	
			runAllForms();
			
			$(function() {
				// Validation
				$("#login-form").validate({
					// Rules for form validation
					rules : {
						email : {
							required : true,
							email : true
						},
						password : {
							required : true,
							minlength : 3,
							maxlength : 20
						}
					},

					// Messages for form validation
					messages : {
						account : {
							required : '请输入您的账号',
							account : '请输入您的账号'
						},
						password : {
							required : '请输入您的密码'
						}
					},

					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
				});
				if(localStorage.getItem("account")&&localStorage.getItem("psw")){
					document.getElementById("account").value=localStorage.getItem("account");
					document.getElementById("password").value=localStorage.getItem("psw");
					document.getElementById("remember").checked=true;
				}
			});
			//保存用户名和密码
			function logon(){
				var remember = document.getElementById("remember");
				if(remember.checked){
					var account = document.getElementById("account").value;
					var psw = document.getElementById("password").value;
					localStorage.setItem("account",account);
					localStorage.setItem("psw",psw);
				}else{
					localStorage.removeItem("account");
					localStorage.removeItem("psw");
				}
			}
			function flushImg(btn){
				//点击图片更换验证码
				$(btn).children().attr("src","/user/getCheckImg?timestamp="+new Date().getTime());
			}
		</script>

	</body>
</html>