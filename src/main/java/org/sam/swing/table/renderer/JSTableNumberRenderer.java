package org.sam.swing.table.renderer;

import java.text.DecimalFormat;

import javax.swing.table.DefaultTableCellRenderer;

public class JSTableNumberRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 63983462543660902L;

	private String pattern = "###,###,##0.00";

	private DecimalFormat decimalFormat;
	
	private String dataType = "double";

	public JSTableNumberRenderer(String pattern, String dataType) {
		if (pattern != null) {
			this.pattern = pattern;
		}
		if (dataType != null) {
			if (dataType.equals("double") || dataType.equals("float")) {
				this.dataType = dataType;
			} else {
				throw new IllegalArgumentException("浮点类型的枚举值： double, float");
			}
		}
		this.decimalFormat = new DecimalFormat(this.pattern);
	}
	
	@Override
	protected void setValue(Object value) {
		if (value != null) {
			if (value instanceof Double || value instanceof Float) {
				this.setText(this.decimalFormat.format(value));
			} else if (value instanceof String) {
				if (((String) value).trim().equals("")) {
					this.setText("0");
				} else {
					if (this.dataType.equals("double")) {
						this.setText(this.decimalFormat.format(Double.parseDouble((String) value)));
					} else if (this.dataType.equals("float")) {
						this.setText(this.decimalFormat.format(Float.parseFloat((String) value)));
					}
				}
			}
		} else {
			this.setText("");
		}
	}

}
