package org.sam.swing.table.defaultImpl;

import java.util.List;

import org.sam.swing.table.JSTableModel;
import org.sam.swing.table.JSTableModelAdapter;
import org.sam.swing.table.JSTableModelEvent;

/**
 * 默认的系统实现
 * @author sam
 *
 * @param <E>
 */
public class JSTableModelDefaultLinster<E> extends JSTableModelAdapter<List<E>> {
	
	/**
	 * 当前的tablemodel对象
	 */
	private JSTableModel<List<E>> tableModel;
	
	/**
	 * 当前的tablemodel
	 * @return
	 */
	public JSTableModel<List<E>> getTableModel() {
		return tableModel;
	}

	/**
	 * 当前的操作tabelmodel对象
	 * @param tableModel
	 */
	public void setTableModel(JSTableModel<List<E>> tableModel) {
		this.tableModel = tableModel;
	}

	/**
	 * 带有构造函数的tableModel
	 * @param tableModel
	 */
	public JSTableModelDefaultLinster(JSTableModel<List<E>> tableModel)
	{
		super();
		this.setTableModel(tableModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforRetrieve(JSTableModelEvent event) throws Exception {
		tableModel.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterRetrieve(JSTableModelEvent event) throws Exception {
		System.out.println("加载数据成功,总行数为:" + tableModel.getRowCount());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforeUpdate(JSTableModelEvent event) throws Exception {
		List<E> creates = this.tableModel.getCreates();
		creates.forEach( n -> System.out.println("需要新增的实体对象:" + n.toString()));
		
		List<E> updates = this.tableModel.getModified();
		updates.forEach( n -> System.out.println("需要更新的实体对象:" + n.toString()));
		
		List<E> deletes = this.tableModel.getDeletes();
		deletes.forEach( n -> System.out.println("需要更新的实体对象:" + n.toString()));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(JSTableModelEvent event) throws Exception {
		System.out.println("这里是更新到数据库的操作");
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void atfterUpdate(JSTableModelEvent event) throws Exception {
		tableModel.resetUpdate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforDelete(JSTableModelEvent event) throws Exception {
		System.out.println("这里可以写一些校验的代码，如果想取消删除，设置event.setCancel(true)");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterDelete(JSTableModelEvent event) throws Exception {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforeAppend(JSTableModelEvent event) throws Exception {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void aftterAppend(JSTableModelEvent event) throws Exception {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforeInsert(JSTableModelEvent event) throws Exception {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void aftterInsert(JSTableModelEvent event) throws Exception {
	}
}
