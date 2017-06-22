package org.sam.swing.table.editor;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

/**
 * 带有多种值类型的checkbox工具
 * @author sam
 *
 */
public class JSTableCheckboxEditor extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 545401568684102849L;
	
	/**
	 * 不带参数的构造函数
	 */
	public JSTableCheckboxEditor()
	{
		this(new JCheckBox());
	}

	/**
	 * 带参数的构造函数
	 * @param checkBox
	 */
	public JSTableCheckboxEditor(JCheckBox checkBox) {
		super(checkBox);
		checkBox.removeActionListener(this.delegate);
		delegate = new EditorDelegate() {
			private static final long serialVersionUID = 1L;

			public void setValue(Object value) {

				if (value instanceof Integer) {
					checkBox.setSelected(Integer.valueOf(1).equals(value));
				} else if (value instanceof Boolean) {
					checkBox.setSelected((Boolean) value);
				} else if (value instanceof String) {
					checkBox.setSelected("true".equals(value));
				} else if (value instanceof Character) {
					checkBox.setSelected(Character.valueOf('t').equals(value));
				}
			}

			public Object getCellEditorValue() {
				return Boolean.valueOf(checkBox.isSelected());
			}
		};
		
		checkBox.addActionListener(delegate);
	}

}
