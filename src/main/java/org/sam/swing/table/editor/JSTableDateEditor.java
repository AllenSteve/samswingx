package org.sam.swing.table.editor;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.sam.swing.table.JSTableColumn;


public class JSTableDateEditor extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7835763834435122893L;
	
	private JTextField textField;

	private JSTableColumn tableColumn;

	private SimpleDateFormat format;

	private String pattern = "yyyy-MM-dd";

	public JSTableDateEditor(JTextField textField, JSTableColumn tableColumn, String pattern) {
		super(textField);
		if (pattern != null) {
			if (pattern.equals("yyyy-MM-dd") || pattern.equals("yyyy/MM/dd")) {
				this.pattern = pattern;
			} else {
				throw new IllegalArgumentException("掩码格式枚举值：yyyy-MM-dd, yyyy/MM/dd");
			}
		}
		this.textField = textField;
		this.tableColumn = tableColumn;
		this.format = new SimpleDateFormat(this.pattern);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value instanceof Date) {
			String str = format.format(value);
			delegate.setValue(str);
		} else if (value instanceof String) {
			delegate.setValue(value);
		}
		return editorComponent;
	}

	@Override
	public boolean stopCellEditing() {
		String str = getCellEditorValue().toString();
		if (str.trim().equals("") || str.equals("0000-00-00") || str.equals("0000/00/00")) {
			if (tableColumn.getCanBeNull()) {
				return super.stopCellEditing();
			} else {
				JOptionPane.showMessageDialog(null, "输入格式有错，请重新输入");
				textField.setText("");
				return false;
			}
		}
		String eL = "";
		if (pattern.equals("yyyy-MM-dd")) {
			eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		} else if (pattern.equals("yyyy/MM/dd")) {
			eL = "[0-9]{4}/[0-9]{2}/[0-9]{2}";
		}
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(str);
		boolean dateFlag = m.matches();
		if (!dateFlag) {
			JOptionPane.showMessageDialog(null, "输入格式有错，请重新输入");
			textField.setText("");
			return false;
		}
		return super.stopCellEditing();
	}
}
