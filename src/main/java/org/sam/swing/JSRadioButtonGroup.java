package org.sam.swing;

import java.awt.FlowLayout;
import java.util.Enumeration;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 单选按钮组控件
 * @author sam
 *
 */
public class JSRadiobuttonGroup extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8010360604117681612L;

	/**
	 * 组对象
	 */
	private ButtonGroup buttons;

	/**
	 * 数据
	 */
	private Map<Object, String> map;
	
	/**
	 * 选中数据
	 */
	private Object selectedValue;

	/**
	 * 单选按钮组对象
	 * @param map 数据字典列表 <值，显示文本>
	 * @param selectedValue 当前选中的值
	 */
	public JSRadiobuttonGroup(Map<Object, String> map, Object selectedValue) {
		
		if (map == null || map.size() == 0)
			throw new IllegalArgumentException();
		if (selectedValue != null && !(map.containsKey(selectedValue)))
			throw new IllegalArgumentException();

		this.map = map;
		this.selectedValue = selectedValue;
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBackground(null);
		buttons = new ButtonGroup();
		for (Object obj : map.keySet()) {
			JRadioButton button = new JRadioButton(map.get(obj));
			button.setBackground(null);
			if (selectedValue != null) {
				if (obj.toString().equals(selectedValue.toString())) {
					button.setSelected(true);
				}
			}
			buttons.add(button);
			this.add(button);
		}
	}

	/**
	 * 获取显示文本
	 * @param label
	 */
	private void setSelectedLabel(String label) {
		if (label != null) {
			for (Enumeration<AbstractButton> e = buttons.getElements(); e.hasMoreElements();) {
				JRadioButton button = (JRadioButton) e.nextElement();
				if (label.equals(button.getText())) {
					buttons.setSelected(button.getModel(), true);
				}
			}
		}
	}

	/**
	 * 获取显示文本
	 * @return
	 */
	public String getSelectedLabel() {
		for (Enumeration<AbstractButton> e = buttons.getElements(); e.hasMoreElements();) {
			JRadioButton button = (JRadioButton) e.nextElement();
			if (button.getModel().isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	/**
	 * 设置选择值
	 * @param value
	 */
	public void setSelectedValue(Object value) {
		if (value == null) {
			if (this.selectedValue != null) {
				String selectedLabel = map.get(selectedValue);
				this.setSelectedLabel(selectedLabel);
			} else {
				buttons.clearSelection();
			}
		} else {
			String selectedLabel = map.get(value);
			this.setSelectedLabel(selectedLabel);
		}
	}

	/**
	 * 获取选择值
	 * @return
	 */
	public Object getSelectedValue() {
		for (Enumeration<AbstractButton> e = buttons.getElements(); e.hasMoreElements();) {
			JRadioButton button = (JRadioButton) e.nextElement();
			if (button.getModel().isSelected()) {
				for (Object obj : map.keySet()) {
					if (map.get(obj).equals(button.getText())) {
						return obj;
					}
				}
			}
		}
		return null;
	}

}
