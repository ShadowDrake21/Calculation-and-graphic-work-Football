package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.AnyData;
import model.Footballer;

public class DlgFootballer extends JDialog implements IDlg{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPosition;
	private JTextField textFieldBirthday;
	private JTextField textFieldNationality;
	private JTextField textFieldTransfer;
	private JButton okButton;
	private JButton cancelButton;
	
	private AnyData object;
	private JCheckBox chckbxCaptain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgFootballer dialog = new DlgFootballer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgFootballer() {
		setModal(true);
		setTitle("Footballer");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{116, 20, 115, 0};
		gbl_contentPanel.rowHeights = new int[]{16, 20, 16, 20, 24, 24, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			JLabel lblPosition = new JLabel("Position");
			GridBagConstraints gbc_lblPosition = new GridBagConstraints();
			gbc_lblPosition.anchor = GridBagConstraints.WEST;
			gbc_lblPosition.insets = new Insets(0, 0, 5, 0);
			gbc_lblPosition.gridx = 2;
			gbc_lblPosition.gridy = 0;
			contentPanel.add(lblPosition, gbc_lblPosition);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setDisabledTextColor(Color.GRAY);
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldName.gridx = 0;
			gbc_textFieldName.gridy = 1;
			contentPanel.add(textFieldName, gbc_textFieldName);
			textFieldName.setColumns(18);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.anchor = GridBagConstraints.SOUTHWEST;
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 1;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			textFieldPosition = new JTextField();
			textFieldPosition.setDisabledTextColor(Color.GRAY);
			GridBagConstraints gbc_textFieldPosition = new GridBagConstraints();
			gbc_textFieldPosition.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPosition.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPosition.gridx = 2;
			gbc_textFieldPosition.gridy = 1;
			contentPanel.add(textFieldPosition, gbc_textFieldPosition);
			textFieldPosition.setColumns(10);
		}
		{
			JLabel lblNationality = new JLabel("Nationality");
			GridBagConstraints gbc_lblNationality = new GridBagConstraints();
			gbc_lblNationality.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNationality.insets = new Insets(0, 0, 5, 5);
			gbc_lblNationality.gridx = 0;
			gbc_lblNationality.gridy = 2;
			contentPanel.add(lblNationality, gbc_lblNationality);
		}
		{
			JLabel lblTransferValue = new JLabel("Transfer value");
			GridBagConstraints gbc_lblTransferValue = new GridBagConstraints();
			gbc_lblTransferValue.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblTransferValue.insets = new Insets(0, 0, 5, 0);
			gbc_lblTransferValue.gridx = 2;
			gbc_lblTransferValue.gridy = 2;
			contentPanel.add(lblTransferValue, gbc_lblTransferValue);
		}
		{
			textFieldNationality = new JTextField();
			textFieldNationality.setDisabledTextColor(Color.GRAY);
			GridBagConstraints gbc_textFieldNationality = new GridBagConstraints();
			gbc_textFieldNationality.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNationality.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNationality.gridx = 0;
			gbc_textFieldNationality.gridy = 3;
			contentPanel.add(textFieldNationality, gbc_textFieldNationality);
			textFieldNationality.setColumns(8);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.anchor = GridBagConstraints.SOUTHWEST;
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 1;
			gbc_horizontalStrut.gridy = 3;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			textFieldTransfer = new JTextField();
			textFieldTransfer.setDisabledTextColor(Color.GRAY);
			GridBagConstraints gbc_textFieldTransfer = new GridBagConstraints();
			gbc_textFieldTransfer.fill = GridBagConstraints.BOTH;
			gbc_textFieldTransfer.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldTransfer.gridx = 2;
			gbc_textFieldTransfer.gridy = 3;
			contentPanel.add(textFieldTransfer, gbc_textFieldTransfer);
			textFieldTransfer.setColumns(10);
		}
		{
			JLabel lblBirthday = new JLabel("Birthday");
			GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
			gbc_lblBirthday.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
			gbc_lblBirthday.gridx = 0;
			gbc_lblBirthday.gridy = 4;
			contentPanel.add(lblBirthday, gbc_lblBirthday);
		}
		{
			chckbxCaptain = new JCheckBox("Team captain");
			GridBagConstraints gbc_chckbxCaptain = new GridBagConstraints();
			gbc_chckbxCaptain.anchor = GridBagConstraints.NORTHWEST;
			gbc_chckbxCaptain.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxCaptain.gridx = 2;
			gbc_chckbxCaptain.gridy = 4;
			contentPanel.add(chckbxCaptain, gbc_chckbxCaptain);
		}
		{
			textFieldBirthday = new JTextField();
			textFieldBirthday.setDisabledTextColor(Color.GRAY);
			textFieldBirthday.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldBirthday.setText("yyyy-MM-dd");
			GridBagConstraints gbc_textFieldBirthday = new GridBagConstraints();
			gbc_textFieldBirthday.fill = GridBagConstraints.BOTH;
			gbc_textFieldBirthday.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldBirthday.gridx = 0;
			gbc_textFieldBirthday.gridy = 5;
			contentPanel.add(textFieldBirthday, gbc_textFieldBirthday);
			textFieldBirthday.setColumns(8);
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
		Footballer footballer = (Footballer) obj;
		String name = obj.getName();
		String position = footballer.getPosition();
		LocalDate birthDay = footballer.getBirthday();
		String nationality = footballer.getNationality();
		float transferValue = footballer.getTransferValue();
		boolean isCaptain = footballer.isOneFromFourCaptains();
		
		textFieldName.setText(name);
		textFieldPosition.setText(position);
		textFieldBirthday.setText(birthDay.toString());
		textFieldNationality.setText(nationality);
		textFieldTransfer.setText(String.valueOf(transferValue));
		chckbxCaptain.setSelected(isCaptain);
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
		String position = textFieldPosition.getText();
		String nationality = textFieldNationality.getText();
		float transferValue = Float.parseFloat(textFieldTransfer.getText());
		boolean isCaptain = chckbxCaptain.isSelected();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthday = null;
		try {
			birthday = LocalDate.from(dtf.parse(textFieldBirthday.getText()));
			object = new Footballer(name, position, birthday, nationality, transferValue, isCaptain);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "\nDate pattern is YYYY-MM-DD", "Footballer Dialog Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
