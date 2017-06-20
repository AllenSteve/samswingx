package org.sam.swing.table;

import java.text.ParseException;
import java.util.EventListener;

/**
 * tablemodle操作的事件对象
 * 
 * @author sam
 *
 */
public interface JSTableModelLinster<E> extends EventListener {
	
	/**
	 * 在加载数据前执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             抛出一切之错误
	 */
	public void beforRetrieve(JSTableModelEvent event) throws Exception;

	/**
	 * 加载数据的操作
	 * 
	 * @return 加载完成后的数据
	 * @throws Exception
	 *             抛出一切可以抛出的异常
	 */
	public E onRetrieve() throws Exception;

	/**
	 * 加载完成后执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 */
	public void afterRetrieve(JSTableModelEvent event) throws Exception;

	/**
	 * 在更新前执行的操作，比如收集要处理的数据等
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 */
	public void beforeUpdate(JSTableModelEvent event) throws Exception;

	/**
	 * update时候执行的操作
	 * 
	 * @param event
	 * @return true成功 false 失败
	 * @throws Exception
	 */
	public boolean update(JSTableModelEvent event) throws Exception;

	/**
	 * 当保存成功后的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             比如清理数据等操作
	 */
	public void atfterUpdate(JSTableModelEvent event) throws Exception;

	/**
	 * 在删除执行执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             抛出一切可以抛出的异常
	 */
	public void beforDelete(JSTableModelEvent event) throws Exception;

	/**
	 * 删除成功后执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             抛出一切可以抛出的异常
	 */
	public void afterDelete(JSTableModelEvent event) throws Exception;

	/**
	 * 在追加数据行前执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             抛出一切之异常
	 */
	public void beforeAppend(JSTableModelEvent event) throws Exception;

	/**
	 * 插入成功后执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 */
	public void aftterAppend(JSTableModelEvent event) throws Exception;

	/**
	 * 在追加数据行前执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 *             抛出一切之异常
	 */
	public void beforeInsert(JSTableModelEvent event) throws Exception;


	/**
	 * 插入成功后执行的操作
	 * 
	 * @param event
	 *            事件对象
	 * @throws Exception
	 */
	public void aftterInsert(JSTableModelEvent event) throws Exception;
	
	/**
	 * 转换数据的方法
	 * @param col
	 * @param value
	 * @param targetCls 目标的类类型
	 * @throws ParseException 转换异常抛出
	 * @return
	 */
	public Object getDataTranstor(JSTableColumn col , Object value , Class<?> targetCls) throws ParseException;
}
