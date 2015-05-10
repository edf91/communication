package org.lhx.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.lhx.dao.BaseDao;
import org.lhx.service.BaseService;
/**
 * 基础service，其他service继承该类
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{
	private BaseDao<T> baseDao;
	
	private Class<T> clazz;
	/**
	 * 注入dao，通过set方法注入实际的dao
	 */
	@Resource
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	@SuppressWarnings("unchecked")
	public BaseServiceImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	/**
	 * 查询实体的所有数据
	 */
	public List<T> findAll(){
		return baseDao.findByHQL("FROM "+ clazz.getSimpleName());
	}
	public void save(T t) {
		baseDao.save(t);
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public void delete(T t) {
		baseDao.delete(t);
	}

	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}

	public void batchByHQL(String hql, Object... obj) {
		baseDao.batchByHQL(hql, obj);
	}

	public T load(String id) {
		return baseDao.load(id);
	}

	public T get(String id) {
		return baseDao.get(id);
	}

	public List<T> findByHQL(String hql, Object... obj) {
		return baseDao.findByHQL(hql, obj);
	}

	public Object uniqueResultByHQL(String hql, Object... obj) {
		return baseDao.uniqueResultByHQL(hql, obj);
	}

}
