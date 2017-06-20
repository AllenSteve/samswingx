package org.sam.swing.table.renderer;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableCellRenderer;

public class JSTableDateRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8710870669535410776L;

	private SimpleDateFormat format;
	
	private String pattern = "yyyy-MM-dd";

	public SimpleDateFormat getFormat() {
		return format;
	}

	public JSTableDateRenderer(String pattern) {
		if (pattern != null) {
			if (pattern.equals("yyyy-MM-dd") || pattern.equals("yyyy/MM/dd")) {
				this.pattern = pattern;
			} else {
				throw new IllegalArgumentException("掩码格式枚举值：yyyy-MM-dd, yyyy/MM/dd");
			}
		}
		
		this.format = new SimpleDateFormat(this.pattern);
	}

	@Override
	protected void setValue(Object value) {
		if (value != null) {
			if (value instanceof Date) {
				setText(this.format.format(value));
			} else {
				String str = (String) value;
				if (str.trim().equals("") || str.equals("0000-00-00") || str.equals("0000/00/00")) {
					setText("null");
				} else {
					if (str.length() == 10) {
						setText(str);
					}
				}
			}
		} else {
			setText("");
		}
	}
}