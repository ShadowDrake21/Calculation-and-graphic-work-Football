package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.Club;
import model.League;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgClub extends JDialog implements IDlg{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldCoach;
	private JTextField textFieldPosition;
	private JTextField textFieldBudget;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgClub dialog = new DlgClub();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgClub() {
		setModal(true);
		setTitle("Club");
		setBounds(100, 100, 300, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			JLabel lblCoach = new JLabel("Coach");
			contentPanel.add(lblCoach);
		}
		{
			textFieldCoach = new JTextField();
			textFieldCoach.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldCoach);
			textFieldCoach.setColumns(20);
		}
		{
			JLabel lblNewLabel = new JLabel("Budget");
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldBudget = new JTextField();
			textFieldBudget.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldBudget);
			textFieldBudget.setColumns(8);
		}
		{
			JLabel lblPosition = new JLabel("Position");
			contentPanel.add(lblPosition);
		}
		{
			textFieldPosition = new JTextField();
			textFieldPosition.setDisabledTextColor(Color.GRAY);
			contentPanel.add(textFieldPosition);
			textFieldPosition.setColumns(3);
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
		Club club = (Club) obj;
		String name = obj.getName();
		String coach = club.getCoachName();
		float budget = club.getBudgetValue();
		int position = club.getChampionshipPos();
		textFieldName.setText(name);
		textFieldCoach.setText(coach);
		textFieldBudget.setText(String.valueOf(budget));
		textFieldPosition.setText(String.valueOf(position));
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
		String coach = textFieldCoach.getText();
		String txtBudget = textFieldBudget.getText();
		float budget = Float.parseFloat(txtBudget);
		String txtPosition = textFieldPosition.getText();
		int position = Integer.parseInt(txtPosition);
		
		try {
			object = new Club(name, coach, position, budget);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Club Dialog Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
