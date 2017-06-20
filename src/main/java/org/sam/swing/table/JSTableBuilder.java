package org.sam.swing.table;

/**
 * 表格生成器对象
 * @author sam
 *
 */
public interface JSTableBuilder<E extends Object> {
	
	/**
	 * 构建columnModel
	 * @return
	 * @throws Exception 抛出一切之异常
	 */
	public JSTableColumnModel buildTableColumnModel() throws Exception;
	
	/**
	 * 创建tablemodel的方法
	 * @return
	 * @throws Exception
	 */
	public JSTableModel<E> buildTableModel() throws Exception;

}
