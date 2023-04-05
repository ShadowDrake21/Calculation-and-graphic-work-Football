package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.League;
import java.awt.Color;

public class DlgLeague extends JDialog implements IDlg{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldPresident;
	private JTextField textFieldBudget;
	private JTextField textFieldLevel;
	private JTextField textFieldName;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLeague dialog = new DlgLeague();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLeague() {
		setTitle("League");
		setModal(true);
		setBounds(100, 100, 300, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblName = new JLabel("Name");
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(20);
		}
		{
			JLabel lblPresident = new JLabel("President");
			contentPanel.add(lblPresident);
		}
		{
			textFieldPresident = new JTextField();
			textFieldPresident.setDisabledTextColor(Color.GRAY);
			textFieldPresident.setPreferredSize(new Dimension(240, 20));
			contentPanel.add(textFieldPresident);
			textFieldPresident.setColumns(18);
		}
		{
			JLabel lblBudget = new JLabel("Budget");
			contentPanel.add(lblBudget);
		}
		{
			textFieldBudget = new JTextField();
			textFieldBudget.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldBudget);
			textFieldBudget.setColumns(8);
		}
		{
			JLabel lblLevel = new JLabel("Level");
			contentPanel.add(lblLevel);
		}
		{
			textFieldLevel = new JTextField();
			textFieldLevel.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldLevel);
			textFieldLevel.setColumns(3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void setEditable(boolean b) {
		for(Component c: contentPanel.getComponents()) 
			c.setEnabled(b);
		
		okButton.setVisible(b);
		if(b)
			cancelButton.setText("Cancel");
		else
			cancelButton.setText("Exit");
	}

	@Override
	public void setData(AnyData obj) {
		League leag = (League) obj;
		String name = obj.getName();
		String president = leag.getPresidentName();
		float budget = leag.getBudgetValue();
		int level = leag.getLevel();
		textFieldName.setText(name);
		textFieldPresident.setText(president);
		textFieldBudget.setText(String.valueOf(budget));
		textFieldLevel.setText(String.valueOf(level));
	}

	@Override
	public void clear() {
		for(Component c: contentPanel.getComponents()) {
			if(c instanceof JTextField) {
				((JTextField)c).setText("");
			}
			else if(c instanceof JCheckBox) {
				((JCheckBox)c).setSelected(false);
			}
		}
	}

	@Override
	public AnyData getObject() {
		return object;
	}
	
	private void onOk() {
		String name = textFieldName.getText();
		String president = textFieldPresident.getText();
		String txtBudget = textFieldBudget.getText();
		float budget = Float.parseFloat(txtBudget);
		String txtLevel = textFieldLevel.getText();
		int level = Integer.parseInt(txtLevel);
		
		try {
			object = new League(name, president, level, budget);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "League Dialog Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
