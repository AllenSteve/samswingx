package org.sam.swing.table.renderer;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.sam.swing.JSComboBox;


public class JSTableComboboxRenderer<T, V> extends JSComboBox<T,V> implements TableCellRenderer, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4772288001817434965L;

	public JSTableComboboxRenderer(T[] items, V[] datas) {
		super(items, datas);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		this.setSelectedValue((V) value);

//		if (isSelected) {
//			this.setForeground(table.getSelectionForeground());
//			this.setBackground(table.getSelectionBackground());
//		} else {
//			this.setForeground(table.getForeground());
//			this.setBackground(table.getBackground());
//		}
		
		return this;
	}

}
