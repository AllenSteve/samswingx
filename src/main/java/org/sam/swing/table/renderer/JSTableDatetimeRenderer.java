package org.sam.swing.table.renderer;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableCellRenderer;

public class JSTableDatetimeRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2790112241649943382L;

	private SimpleDateFormat format;

	private String pattern = "yyyy-MM-dd HH:mm:ss";

	public SimpleDateFormat getFormat() {
		return format;
	}

	public JSTableDatetimeRenderer(String pattern) {
		if (pattern != null) {
			if (pattern.equals("yyyy-MM-dd HH:mm:ss") || pattern.equals("yyyy-MM-dd-HH-mm-ss")
					|| pattern.equals("yyyy/MM/dd HH:mm:ss")) {
				this.pattern = pattern;
			} else {
				throw new IllegalArgumentException(
						"掩码格式枚举值：yyyy-MM-dd HH:mm:ss, yyyy-MM-dd-HH-mm-ss, yyyy/MM/dd HH:mm:ss");
			}
		}

		this.format = new SimpleDateFormat(this.pattern);
	}

	@Override
	protected void setValue(Object value) {
		if (value != null) {
			if (value instanceof Date) {
				setText(format.format(value));
			} else {
				String str = (String) value;
				if (str.trim().equals("") || str.equals("0000-00-00 00:00:00") || str.equals("0000-00-00-00-00-00")
						|| str.equals("0000/00/00 00:00:00")) {
					setText("null");
				} else {
					if (str.length() == 19) {
						setText(str);
					}
				}
			}
		} else {
			setText("0000-00-00 00:00:00");
		}
	}
}