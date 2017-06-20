package org.sam.swing.table.editor;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

public class JSTableCheckboxEditor extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 545401568684102849L;

	public JSTableCheckboxEditor(JCheckBox checkBox) {
		super(checkBox);
		checkBox.removeActionListener(this.delegate);
		delegate = new EditorDelegate() {
			private static final long serialVersionUID = 1L;

			public void setValue(Object value) {
				boolean selected = false;
				if (value instanceof Boolean) {
					selected = ((Boolean) value).booleanValue();
				} else if (value instanceof String) {
					selected = value.equals("true");
				} else if (value instanceof Integer) {
					selected = Integer.valueOf(1).equals(value) ? true : false;
				} else {
					selected = false;
				}
				checkBox.setSelected(selected);
			}

			public Object getCellEditorValue() {
				return Boolean.valueOf(checkBox.isSelected());
			}
		};
		checkBox.addActionListener(delegate);
	}

}
