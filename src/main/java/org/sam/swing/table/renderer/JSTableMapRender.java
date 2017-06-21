package org.sam.swing.table.renderer;

import java.awt.Component;
import java.io.Serializable;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class JSTableMapComboBoxRender<T,V> extends DefaultTableCellRenderer implements TableCellRenderer,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4431452687038719128L;
	
	/**
	 * 当前绑定值
	 */
	private Object value;
	
	/**
	 * 当前的绑定值
	 * @return
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 当前的绑定值
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/*
	 * 当前的显示值
	 */
	private Map<T,V> datas;

	/**
	 * 数据
	 * @param datas
	 */
	public JSTableMapComboBoxRender(Map<T,V> datas) {
		this.datas = datas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		this.setValue((V)value);
		if (value != null) {
			try {
				this.setText(this.datas.get(value).toString());
			} catch (Exception e) {
				e.printStackTrace();
				this.setText("");
			}
		} else {
			this.setText("");
		}
		
		if (isSelected) {
			this.setForeground(table.getSelectionForeground());
			this.setBackground(table.getSelectionBackground());
		} else {
			this.setForeground(table.getForeground());
			this.setBackground(table.getBackground());
		}
		
		return this;
	}

}
