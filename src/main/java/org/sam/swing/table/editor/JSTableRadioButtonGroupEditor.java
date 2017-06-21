package org.sam.swing.table.editor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.EventObject;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeCellEditor;

import org.sam.swing.JSRadiobuttonGroup;

public class JSTableRadiobuttonGroupEditor extends AbstractCellEditor implements TableCellEditor, TreeCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 263310385939006964L;

	protected JComponent editorComponent;

	protected EditorDelegate delegate;

	protected int clickCountToStart = 1;

	public JSTableRadiobuttonGroupEditor(Map<Object, String> map, Object defaultValue) {
		if (map == null)
			throw new IllegalArgumentException();
		editorComponent = new JSRadiobuttonGroup(map, defaultValue);
		delegate = new EditorDelegate() {
			@Override
			public void setValue(Object value) {
				super.setValue(value);
			}

			@Override
			public Object getCellEditorValue() {
				return ((JSRadiobuttonGroup) editorComponent).getSelectedValue();
			}
		};
	}

	public Component getComponent() {
		return editorComponent;
	}

	public void setClickCountToStart(int count) {
		clickCountToStart = count;
	}

	public int getClickCountToStart() {
		return clickCountToStart;
	}

	public Object getCellEditorValue() {
		return delegate.getCellEditorValue();
	}

	public boolean isCellEditable(EventObject anEvent) {
		return delegate.isCellEditable(anEvent);
	}

	public boolean shouldSelectCell(EventObject anEvent) {
		return delegate.shouldSelectCell(anEvent);
	}

	public boolean stopCellEditing() {
		if (((JSRadiobuttonGroup) editorComponent).getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "请选择单选按钮");
			return false;
		}
		return delegate.stopCellEditing();
	}

	public void cancelCellEditing() {
		delegate.cancelCellEditing();
	}

	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, false);

		delegate.setValue(stringValue);
		return editorComponent;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		delegate.setValue(value);
		if (editorComponent instanceof JCheckBox) {
			// in order to avoid a "flashing" effect when clicking a checkbox
			// in a table, it is important for the editor to have as a border
			// the same border that the renderer has, and have as the background
			// the same color as the renderer has. This is primarily only
			// needed for JCheckBox since this editor doesn't fill all the
			// visual space of the table cell, unlike a text field.
			TableCellRenderer renderer = table.getCellRenderer(row, column);
			Component c = renderer.getTableCellRendererComponent(table, value, isSelected, true, row, column);
			if (c != null) {
				editorComponent.setOpaque(true);
				editorComponent.setBackground(c.getBackground());
				if (c instanceof JComponent) {
					editorComponent.setBorder(((JComponent) c).getBorder());
				}
			} else {
				editorComponent.setOpaque(false);
			}
		} else if (editorComponent instanceof JSRadiobuttonGroup) {
			((JSRadiobuttonGroup) editorComponent).setSelectedValue(value);
		}
		return editorComponent;
	}

	//
	// Protected EditorDelegate class
	//

	/**
	 * The protected <code>EditorDelegate</code> class.
	 */
	protected class EditorDelegate implements ActionListener, ItemListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -9163652875049976071L;
		
		/** The value of this cell. */
		protected Object value;

		/**
		 * Returns the value of this cell.
		 * 
		 * @return the value of this cell
		 */
		public Object getCellEditorValue() {
			return value;
		}

		/**
		 * Sets the value of this cell.
		 * 
		 * @param value
		 *            the new value of this cell
		 */
		public void setValue(Object value) {
			this.value = value;
		}

		/**
		 * Returns true if <code>anEvent</code> is <b>not</b> a
		 * <code>MouseEvent</code>. Otherwise, it returns true if the necessary
		 * number of clicks have occurred, and returns false otherwise.
		 *
		 * @param anEvent
		 *            the event
		 * @return true if cell is ready for editing, false otherwise
		 * @see #setClickCountToStart
		 * @see #shouldSelectCell
		 */
		public boolean isCellEditable(EventObject anEvent) {
			if (anEvent instanceof MouseEvent) {
				return ((MouseEvent) anEvent).getClickCount() >= clickCountToStart;
			}
			return true;
		}

		/**
		 * Returns true to indicate that the editing cell may be selected.
		 *
		 * @param anEvent
		 *            the event
		 * @return true
		 * @see #isCellEditable
		 */
		public boolean shouldSelectCell(EventObject anEvent) {
			return true;
		}

		/**
		 * Returns true to indicate that editing has begun.
		 *
		 * @param anEvent
		 *            the event
		 */
		public boolean startCellEditing(EventObject anEvent) {
			return true;
		}

		/**
		 * Stops editing and returns true to indicate that editing has stopped.
		 * This method calls <code>fireEditingStopped</code>.
		 *
		 * @return true
		 */
		public boolean stopCellEditing() {
			fireEditingStopped();
			return true;
		}

		/**
		 * Cancels editing. This method calls <code>fireEditingCanceled</code>.
		 */
		public void cancelCellEditing() {
			fireEditingCanceled();
		}

		/**
		 * When an action is performed, editing is ended.
		 * 
		 * @param e
		 *            the action event
		 * @see #stopCellEditing
		 */
		public void actionPerformed(ActionEvent e) {
			JSTableRadiobuttonGroupEditor.this.stopCellEditing();
		}

		/**
		 * When an item's state changes, editing is ended.
		 * 
		 * @param e
		 *            the action event
		 * @see #stopCellEditing
		 */
		public void itemStateChanged(ItemEvent e) {
			JSTableRadiobuttonGroupEditor.this.stopCellEditing();
		}
	}

} // End of class JCellEditor
