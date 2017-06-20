package org.sam.swing.table.renderer;

import java.text.DecimalFormat;

import javax.swing.table.DefaultTableCellRenderer;

public class JSTableIntegerRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -725889360642528811L;

	private String pattern = "###,###,###";

	private DecimalFormat decimalFormat;

	private String dataType = "int";

	public JSTableIntegerRenderer(String pattern, String dataType) {
		if (pattern != null) {
			this.pattern = pattern;
		}
		if (dataType != null) {
			if (dataType.equals("int") || dataType.equals("long")) {
				this.dataType = dataType;
			} else {
				throw new IllegalArgumentException("数据类型的枚举值： int, long");
			}
		}
		this.decimalFormat = new DecimalFormat(this.pattern);
	}

	@Override
	protected void setValue(Object value) {
		if (value != null) {
			if (value instanceof Integer || value instanceof Long) {
				this.setText(this.decimalFormat.format(value));
			} else if (value instanceof String) {
				if (((String) value).trim().equals("")) {
					this.setText("0");
				} else {
					if (this.dataType.equals("int")) {
						this.setText(this.decimalFormat.format(Integer.parseInt((String) value)));
					} else if (this.dataType.equals("long")) {
						this.setText(this.decimalFormat.format(Long.parseLong((String) value)));
					}
				}
			}
		} else {
			this.setText("");
		}
	}

}
