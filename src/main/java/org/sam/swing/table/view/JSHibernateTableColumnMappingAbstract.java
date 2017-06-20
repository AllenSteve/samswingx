package org.sam.swing.table.view;


/**
 * hibernate的类映射实现
 * @author sam
 * @see JSTableHeightLimitColumnMapping
 *
 */
public abstract class JSHibernateTableColumnMappingAbstract extends JSTableColumnMappingAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9101273333380577519L;
	
	/**
	 * 当前的数据库连接名
	 */
	private String dbName;
	
	/**
	 * 当前的数据库连接名
	 * @return
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 当前的数据库连接名
	 * @param dbName
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * 具体的hibernate实现
	 * @param dao dao实现
	 * @param cls 实体类型
	 * @param dbName 当前数据库
	 */
	public JSHibernateTableColumnMappingAbstract(Class<?> cls)
	{
		super();
		this.setEntityCls(cls);
		this.initCols();
	}
}
