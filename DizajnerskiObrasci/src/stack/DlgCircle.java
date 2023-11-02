package stack;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.CardLayout;


import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField X;
	private JTextField Y;
	private JTextField Radius;
	private Circle circle = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setResizable(false);
		setTitle("Circle");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("x coordinate");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			X = new JTextField();
			GridBagConstraints gbc_X = new GridBagConstraints();
			gbc_X.insets = new Insets(0, 0, 5, 0);
			gbc_X.fill = GridBagConstraints.HORIZONTAL;
			gbc_X.gridx = 1;
			gbc_X.gridy = 0;
			contentPanel.add(X, gbc_X);
			X.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("y coordinate");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			Y = new JTextField();
			GridBagConstraints gbc_Y = new GridBagConstraints();
			gbc_Y.insets = new Insets(0, 0, 5, 0);
			gbc_Y.fill = GridBagConstraints.HORIZONTAL;
			gbc_Y.gridx = 1;
			gbc_Y.gridy = 2;
			contentPanel.add(Y, gbc_Y);
			Y.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("radius");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 4;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			Radius = new JTextField();
			GridBagConstraints gbc_Radius = new GridBagConstraints();
			gbc_Radius.fill = GridBagConstraints.HORIZONTAL;
			gbc_Radius.gridx = 1;
			gbc_Radius.gridy = 4;
			contentPanel.add(Radius, gbc_Radius);
			Radius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(X.getText());
							int y = Integer.parseInt(Y.getText());
							int radius = Integer.parseInt(Radius.getText());
							
							if(x <= 0 || y <= 0 || radius <= 0 ) {
								JOptionPane.showMessageDialog(null, "Values must be positive!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							circle = new Circle(new Point (x,y), radius);
							dispose();
							
							
						}catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Invalid data type", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Circle getCircle() {
		return this.circle;
	}
	public void setCircle(Circle c) {
		X.setText("" + c.getCenter().getX());
		Y.setText("" + c.getCenter().getY());
		Radius.setText("" + c.getRadius());

	}

}
