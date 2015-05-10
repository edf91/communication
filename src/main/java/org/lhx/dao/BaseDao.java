package org.lhx.dao;

import java.util.List;

/**
 * 所有dao的基类
 */
public interface BaseDao<T> {
	/**
	 * 写操作
	 */
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public void saveOrUpdate(T t);
	public void batchByHQL(String hql,Object...obj);
	
	/**
	 * 读操作
	 */
	public T load(String id);
	public T get(String id);
	public List<T> findByHQL(String hql,Object ... obj);
	public Object uniqueResultByHQL(String hql,Object...obj);
}
