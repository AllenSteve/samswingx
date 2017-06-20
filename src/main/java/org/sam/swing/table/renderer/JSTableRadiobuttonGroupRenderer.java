package org.sam.swing.table.renderer;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;

import javax.swing.CellRendererPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.sam.swing.JSRadiobuttonGroup;


/**
 * 单选组对象
 * 
 * @author sam
 *
 */
public class JSTableRadiobuttonGroupRenderer extends CellRendererPane implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4045115531523620178L;

	/**
	 * 单选控件组
	 */
	private JSRadiobuttonGroup radiobuttons;

	/**
	 * 未选中的时候背景颜色
	 */
	private Color unselectedForeground;

	/**
	 * 选中的时候背景颜色
	 */
	private Color unselectedBackground;

	/**
	 * 绑定的数据字典
	 */
	private Map<Object, String> map;
	
	/**
	 * 绑定的数据字典
	 * @return
	 */
	public Map<Object, String> getMap() {
		return map;
	}

	/**
	 * 绑定的数据字典
	 * @param map
	 */
	public void setMap(Map<Object, String> map) {
		this.map = map;
	}

	/**
	 * Overrides <code>JComponent.setForeground</code> to assign the
	 * unselected-foreground color to the specified color.
	 *
	 * @param c
	 *            set the foreground color to this value
	 */
	@Override
	public void setForeground(Color c) {
		super.setForeground(c);
		unselectedForeground = c;
	}

	/**
	 * Overrides <code>JComponent.setBackground</code> to assign the
	 * unselected-background color to the specified color.
	 *
	 * @param c
	 *            set the background color to this value
	 */
	@Override
	public void setBackground(Color c) {
		super.setBackground(c);
		unselectedBackground = c;
	}

	/**
	 * 单选组对象
	 * 
	 * @param map
	 *            数据字典
	 * @param defaultValue
	 *            默认值
	 */
	public JSTableRadiobuttonGroupRenderer(Map<Object, String> map, Object defaultValue) {
		if (map == null)
			throw new IllegalArgumentException();
		this.map = map;
		this.radiobuttons = new JSRadiobuttonGroup(map, defaultValue);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		radiobuttons.setSelectedValue(value);

		JTable.DropLocation dropLocation = table.getDropLocation();
		if (dropLocation != null && !dropLocation.isInsertRow() && !dropLocation.isInsertColumn()
				&& dropLocation.getRow() == row && dropLocation.getColumn() == column) {

			isSelected = true;
		}

		if (isSelected) {
			super.setForeground(table.getSelectionForeground());
			super.setBackground(table.getSelectionBackground());
			this.radiobuttons.setForeground(table.getSelectionForeground());
			this.radiobuttons.setBackground(table.getSelectionBackground());
		} else {
			Color background = unselectedBackground != null ? unselectedBackground : table.getBackground();
			super.setForeground(unselectedForeground != null ? unselectedForeground : table.getForeground());
			super.setBackground(background);
			this.radiobuttons.setForeground(this.getForeground());
			this.radiobuttons.setBackground(this.getBackground());
		}
		
		return radiobuttons;
	}
    
}
