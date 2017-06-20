package org.sam.swing.table.defaultImpl;

import java.util.List;

import org.sam.swing.table.JSTableBuilder;
import org.sam.swing.table.JSTableColumn;
import org.sam.swing.table.JSTableColumnModel;
import org.sam.swing.table.JSTableModel;

/**
 * 默认的tablemodel和columnmodel实现
 * @author sam
 *
 * @param <E>
 */
public class JSDefaultTableBuilderImpl<E> implements JSTableBuilder<List<E>> {

	/**
	 * 当前的column列表
	 */
	private JSTableColumn[] columns;
	
	private Class<E> cls;
	
	/**
	 * 当前操作的column列表
	 * @return
	 */
	public JSTableColumn[] getColumns() {
		return columns;
	}

	/**
	 * 当前操作的column列表
	 * @param columns
	 */
	public void setColumns(JSTableColumn[] columns) {
		this.columns = columns;
		
	}

	/**
	 * 带有列信息的构造函数
	 * @param cols
	 */
	public JSDefaultTableBuilderImpl(Class<E> cls,JSTableColumn... cols)
	{
		this.columns = cols;
		this.cls = cls;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSTableColumnModel buildTableColumnModel() throws Exception {
		JSTableColumnModel colModel = new JSTableColumnModel();

		if (this.columns == null || this.columns.length <= 0)
			throw new Exception("no columns");

		int i = 0;
		for (JSTableColumn col : this.columns) {
			if (col.getModelIndex() < 0)
			{
				col.setModelIndex(i);
			}
			colModel.addColumn(col);
			i++;
		}

		return colModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSTableModel<List<E>> buildTableModel() throws Exception {
		JSTableDefaultModel<E> tabModel = new JSTableDefaultModel<>(cls);

		if (this.columns == null || this.columns.length <= 0)
			throw new Exception("no columns");

		for (JSTableColumn col : this.columns) {
			tabModel.addColumn(col);
		}

		// 生成原始数据的列
		if (tabModel.findColumn(JSTableColumn.COLUMN_ORIGINAL) < 0) {
			JSTableColumn column = new JSTableColumn();
			column.setTitle(JSTableColumn.COLUMN_ORIGINAL);
			column.setHeaderValue(JSTableColumn.COLUMN_ORIGINAL);
			tabModel.addColumn(column);
		}

		return tabModel;
	}

}
