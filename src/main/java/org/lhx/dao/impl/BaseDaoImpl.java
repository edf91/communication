package org.lhx.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lhx.dao.BaseDao;
/**
 * 所有dao都继承该dao
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource
	private SessionFactory sf;
	
	/**
	 * T的具体类型
	 */
	private Class<T> clazz;
	/**
	 * 初始化该类时，获取T的具体类型
	 */
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	/**
	 * 获取session
	 * @return
	 */
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void save(T t) {
		getSession().save(t);
	}

	public void update(T t) {
		getSession().update(t);
	}

	public void delete(T t) {
		getSession().delete(t);
	}

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	public void batchByHQL(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		query.executeUpdate();
	}

	public T load(String id) {
		return (T) getSession().load(clazz, id);
	}

	public T get(String id) {
		return (T) getSession().get(clazz, id);
	}

	public List<T> findByHQL(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	public Object uniqueResultByHQL(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.uniqueResult();
	}

}
