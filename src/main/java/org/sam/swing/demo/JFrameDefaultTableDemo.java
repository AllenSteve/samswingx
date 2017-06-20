package org.sam.swing.demo;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.sam.swing.table.JSTable;
import org.sam.swing.table.JSTableBuilder;
import org.sam.swing.table.JSTableColumn;
import org.sam.swing.table.JSTableColumnModel;
import org.sam.swing.table.JSTableModel;
import org.sam.swing.table.JSTableModelAdapter;
import org.sam.swing.table.JSTableModelEvent;
import org.sam.swing.table.defaultImpl.JSTableDefaultBuilderImpl;

/**
 * table表格方法
 * @author sam
 *
 */
public class JFrameDefaultTableDemo extends JFrame {

	private static final long serialVersionUID = 8818584079585682536L;
	
	/**
	 *
	 */
	public JFrameDefaultTableDemo()
	{
		super();
		initCompents();
	}
	
	/**
	 * 当前的table
	 */
	private JSTable table;
	
	/**
	 * tablemodel
	 */
	private JSTableModel<List<TestEntity>> tableModel;
	
	/**
	 * colmodel
	 */
	private JSTableColumnModel colModel;
	
	/**
	 * 初始化控件的操作
	 */
	/**
	 * 
	 */
	protected void initCompents()
	{
		JPanel panel = new JPanel(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSTableColumn col0 = new JSTableColumn();
		col0.setIdentifier("code");
		col0.setTitle("代码");
		col0.setHeaderValue("代码");
		col0.setModelIndex(0);
		col0.setEditable(true);
		
		try
		{
			JSTableBuilder<List<TestEntity>> builder = new JSTableDefaultBuilderImpl<>(TestEntity.class , col0);
			colModel = builder.buildTableColumnModel();
			tableModel = builder.buildTableModel();
			table = new JSTable(tableModel , colModel);
			
			tableModel.setTableModelLinster(new JSTableModelAdapter<List<TestEntity>>(){
				
				/**
				 * 加载数据的方法
				 */
				public List<TestEntity> onRetrieve() throws Exception {
					
					List<TestEntity> result = new LinkedList<>();
					for(int i = 0 ; i < 1000 ; i++)
					{
						TestEntity entity = new TestEntity();
						entity.setId(i);
						entity.setCode("" + i);
						entity.setName("name:" + i);
						
						result.add(entity);
					}
					return result;
				}
				
			});
			
			panel.add(new JScrollPane( table ), BorderLayout.CENTER);
			this.add(panel, BorderLayout.CENTER);
			tableModel.retrieve();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
