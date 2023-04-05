package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.Amplua;
import model.AnyData;
import java.awt.Color;

public class DlgAmplua extends JDialog implements IDlg{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JCheckBox chckbxKeyPosition;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldMainAttribute;
	
	private AnyData object;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAmplua dialog = new DlgAmplua();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAmplua() {
		setModal(true);
		setTitle("Amplua");
		setBounds(100, 100, 300, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textFieldName = new JTextField();
			textFieldName.setDisabledTextColor(Color.GRAY);
			textFieldName.setColumns(10);
		}
		{
			chckbxKeyPosition = new JCheckBox("Key position");
		}
		
		JLabel lblName = new JLabel("Name");
		
		textFieldMainAttribute = new JTextField();
		textFieldMainAttribute.setDisabledTextColor(Color.GRAY);
		textFieldMainAttribute.setColumns(10);
		
		JLabel lblMainAttribute = new JLabel("Main attribute");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxKeyPosition)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMainAttribute)
								.addComponent(textFieldMainAttribute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblMainAttribute))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMainAttribute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxKeyPosition)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
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
		Amplua amp = (Amplua) obj;
		String name = obj.getName();
		String mainAttribute = amp.getMainAttribute();
		boolean keyPosition = amp.isKeyPosition();
		textFieldName.setText(name);
		textFieldMainAttribute.setText(mainAttribute);
		chckbxKeyPosition.setSelected(keyPosition);
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
		String mainAttribute = textFieldMainAttribute.getText();
		boolean keyPosition = chckbxKeyPosition.isSelected();
		
		try {
			object = new Amplua(name, mainAttribute, keyPosition);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Amplua Dialog Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}
	
	private void onCancel() {
		object = null;
		setVisible(false);
	}
}
