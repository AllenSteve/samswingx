package org.sam.swing.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.swingx.table.DatePickerCellEditor;
import org.sam.swing.resource.ResourceLoader;
import org.sam.swing.table.JSTable;
import org.sam.swing.table.JSTableBuilder;
import org.sam.swing.table.JSTableColumn;
import org.sam.swing.table.JSTableColumnModel;
import org.sam.swing.table.JSTableModel;
import org.sam.swing.table.defaultImpl.JSTableDefaultBuilderImpl;
import org.sam.swing.table.defaultImpl.JSTableModelDefaultLinster;
import org.sam.swing.table.editor.JSTableCheckboxEditor;
import org.sam.swing.table.editor.JSTableRadioButtonGroupEditor;
import org.sam.swing.table.editor.JSTableSpinnerEditor;
import org.sam.swing.table.renderer.JSTableCheckboxRenderer;
import org.sam.swing.table.renderer.JSTableFormatRenderer;
import org.sam.swing.table.renderer.JSTableRadioButtonGroupRenderer;
import org.sam.swing.table.renderer.JSTableRowNumberRenderer;

/**
 * table表格方法
 * 
 * @author sam
 *
 */
public class JFrameDefaultTableDemo extends JFrame {

	private static final long serialVersionUID = 8818584079585682536L;

	/**
	 *
	 */
	public JFrameDefaultTableDemo() {
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
	protected void initCompents() {
		JPanel panel = new JPanel(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
		renderC.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		DefaultTableCellRenderer renderR = new DefaultTableCellRenderer();
		renderR.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		JSTableColumn col0 = new JSTableColumn();
		col0.setIdentifier("");
		col0.setTitle("#");
		col0.setHeaderValue("#");
		col0.setModelIndex(0);
		col0.setEditable(false);
		col0.setMaxWidth(30);
		JSTableRowNumberRenderer rownNumRender = new JSTableRowNumberRenderer();
		rownNumRender.setHorizontalAlignment(JSTableRowNumberRenderer.CENTER);
		col0.setCellRenderer(rownNumRender); // 行号渲染器

		// 系统默认的渲染器和编辑器
		JSTableColumn col1 = new JSTableColumn();
		col1.setIdentifier("code"); // 对应的实体字段
		col1.setTitle("代码");
		col1.setHeaderValue("代码");
		col1.setModelIndex(1); // 这个必须逐次增加
		col1.setWidth(75);
		col1.setMinWidth(25);
		col1.setDefaultValue("");

		// 系统默认的渲染器和编辑器
		JSTableColumn col2 = new JSTableColumn();
		col2.setIdentifier("name");
		col2.setTitle("姓名");
		col2.setHeaderValue("姓名");
		col2.setModelIndex(2);
		col2.setWidth(75);
		col2.setMinWidth(25);
		col2.setDefaultValue("");

		// 因为这个字段是存的字符串，演示一下原生的控件的效果
		JSTableColumn col3 = new JSTableColumn();
		col3.setIdentifier("gender");
		col3.setTitle("性别");
		col3.setHeaderValue("性别");
		col3.setModelIndex(3);
		col3.setWidth(75);
		col3.setMinWidth(25);
		col3.setDefaultValue("男");
		JComboBox<String> cbGender = new JComboBox<>(new String[] { "男", "女" });
		DefaultCellEditor editorGender = new DefaultCellEditor(cbGender);
		col3.setCellRenderer(renderC); // 居中显示
		col3.setCellEditor(editorGender); // 普通的下拉列表框
		
		//以下是数字微调控件的示例
		JSTableColumn col4 = new JSTableColumn();
		col4.setIdentifier("age");
		col4.setTitle("年龄");
		col4.setHeaderValue("年龄");
		col4.setModelIndex(4);
		col4.setWidth(25);
		col4.setMinWidth(25);
		col4.setDefaultValue(1);
		col4.setCellRenderer(renderR); // 右侧显示
		//带有范围限定的
		col4.setCellEditor(new JSTableSpinnerEditor(new JSpinner(new SpinnerNumberModel(1, 1, 255, 1))));
		
		//日期下拉控件
		JSTableColumn col5 = new JSTableColumn();
		col5.setIdentifier("birthday");
		col5.setTitle("生日");
		col5.setHeaderValue("生日");
		col5.setModelIndex(5);
		col5.setWidth(85);
		col5.setMinWidth(85);
		col5.setDefaultValue(null);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		col5.setCellRenderer(new JSTableFormatRenderer(dateFormat , "0000-00-00"));
		col5.setCellEditor(new DatePickerCellEditor(dateFormat));
		
		//单选按钮
		JSTableColumn col6 = new JSTableColumn();
		col6.setIdentifier("role");
		col6.setTitle("角色");
		col6.setHeaderValue("角色");
		col6.setModelIndex(6);
		col6.setWidth(175);
		col6.setMinWidth(175);
		col6.setDefaultValue(1);
		
		Map<Integer,String> roles = new LinkedHashMap<>();
		roles.put(0, "管理员");
		roles.put(1, "经理");
		roles.put(2, "员工");
		
		col6.setCellRenderer(new JSTableRadioButtonGroupRenderer<Integer,String>(roles));
		col6.setCellEditor(new JSTableRadioButtonGroupEditor<Integer,String>(roles));
		
		JSTableColumn col7 = new JSTableColumn();
		col7.setIdentifier("onDuty");
		col7.setTitle("在职状态");
		col7.setHeaderValue("在职状态");
		col7.setModelIndex(7);
		col7.setWidth(15);
		col7.setMinWidth(15);
		col7.setDefaultValue(false);
		JSTableCheckboxRenderer jsTableCheckboxRenderer = new JSTableCheckboxRenderer();
		jsTableCheckboxRenderer.setHorizontalAlignment(JSTableCheckboxRenderer.CENTER);
		col7.setCellRenderer(jsTableCheckboxRenderer);
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setHorizontalAlignment(JCheckBox.CENTER);
		col7.setCellEditor(new JSTableCheckboxEditor(jCheckBox));

		try {
			JSTableBuilder<List<TestEntity>> builder = new JSTableDefaultBuilderImpl<>(TestEntity.class, col0, col1,
					col2, col3,col4,col5,col6,col7);
			colModel = builder.buildTableColumnModel();
			tableModel = builder.buildTableModel();
			table = new JSTable(tableModel, colModel);

			tableModel.setTableModelLinster(new JSTableModelDefaultLinster<TestEntity>(tableModel) {
				/**
				 * 加载数据的方法
				 */
				public List<TestEntity> onRetrieve() throws Exception {

					List<TestEntity> result = new LinkedList<>();
					for (int i = 0; i < 1000; i++) {
						TestEntity entity = new TestEntity();
						entity.setId(i);
						entity.setCode("" + i);
						entity.setName("name:" + i);
						entity.setGender(i % 3 == 0 ? "男" : (i % 2 == 1 ? "女" : null));
						entity.setAge((i + 1) % 255);
						entity.setRole(i % 3 == 0 ? 0 : (i % 2 == 1 ? 1 : 2));
						entity.setOnDuty(i % 2 == 0);
						result.add(entity);
					}
					return result;
				}
			});

			panel.add(new JScrollPane(table), BorderLayout.CENTER);
			this.add(panel, BorderLayout.CENTER);

			// 加载数据
			tableModel.retrieve();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 加个工具条
		// 以下是测试表格显示风格的操作
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnRefresh = new JButton("刷新",
				new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_RETRIEVE)));
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tableModel.retrieve();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		toolBar.add(btnRefresh);

		JButton btnEditor = new JButton("编辑", new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_MODIFY)));
		btnEditor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.readOnly();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		toolBar.add(btnEditor);
		JButton btnAdd = new JButton("新增", new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_NEW)));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.append();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		toolBar.add(btnAdd);

		JButton btnDel = new JButton("删除", new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_DELETE)));
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.delete();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		toolBar.add(btnDel);

		JButton btnSave = new JButton("保存", new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_SAVE)));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.update();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "保存失败\r\n出错信息为：\r\n" + ex.getMessage());
				}
			}
		});
		toolBar.add(btnSave);
	}

}
