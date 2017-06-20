package org.sam.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * 按钮上的ICON对象
 * @author sam
 *
 */
public class JSButtonIcon implements Icon {

	/**
	 * 默认图标大小
	 */
	public static final int ICON_SIZE = 8;
	
	/**
	 * 图标宽度
	 */
	protected int iconWidth = ICON_SIZE;
	
	/**
	 * 图标高度
	 */
	protected int iconHeight = ICON_SIZE;
	
	/**
	 * 图标颜色
	 */
	protected Color iconColor = Color.black;
	
	/**
	 * 绘制图标的操作
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		
		Color oldColor = g.getColor();

		g.setColor(iconColor);
		g.fillOval(x, y, iconWidth, iconHeight);
		g.setColor(oldColor);

	}

	/**
	 * 图标宽度
	 */
	@Override
	public int getIconWidth() {
		return iconWidth;
	}

	/**
	 * 图标高度
	 */
	@Override
	public int getIconHeight() {
		return iconHeight;
	}

	/**
	 * 图标颜色
	 * @return
	 */
	public Color getIconColor() {
		return iconColor;
	}

	/**
	 * 图标颜色
	 * @param iconColor
	 */
	public void setIconColor(Color iconColor) {
		this.iconColor = iconColor;
	}
	
}
