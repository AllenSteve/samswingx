package org.sam.swing.table.editor;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.sam.swing.table.JSTableColumn;

public class JSTableNumberEditor extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1135721205404693525L;

	private String dataType = "double";

	private JTextField textField;

	private JSTableColumn tableColumn;

	public JSTableNumberEditor(JTextField textField, JSTableColumn tableColumn, String dataType) {
		super(textField);
		if (dataType != null) {
			if (dataType.equals("double") || dataType.equals("float")) {
				this.dataType = dataType;
			} else {
				throw new IllegalArgumentException("数据类型的枚举值： double, float");
			}
		}
		this.textField = textField;
		this.tableColumn = tableColumn;
	}
	
	@Override
	public boolean stopCellEditing() {
		String str = getCellEditorValue().toString();
		
		if (str.trim().equals("")) {
			if (tableColumn.getCanBeNull()) {
				return super.stopCellEditing();
			} else {
				JOptionPane.showMessageDialog(null, "输入格式有错，请重新输入");
				textField.setText("");
				return false;
			}
		}

		boolean isValid = true;
		if (this.dataType.equals("double")) {
			try {
				Double.parseDouble(str);
			} catch (NumberFormatException e) {
				isValid = false;
			}
		} else if (this.dataType.equals("float")) {
			try {
				Float.parseFloat(str);
			} catch (NumberFormatException e) {
				isValid = false;
			}
		}
		if (!isValid) {
			JOptionPane.showMessageDialog(null, "输入格式有错，请重新输入");
			textField.setText("");
			return false;
		}
		return super.stopCellEditing();
	}

}
