package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldOuterRadius;
	private JTextField textFieldInnerRadius;
	private Donut donut = null;
	private Color edgeColor;
	private Color fillColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setTitle("Donut");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 222, 179));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDialogName = new JLabel("DONUT");
			lblDialogName.setFont(new Font("Castellar", Font.BOLD, 15));
			GridBagConstraints gbc_lblDialogName = new GridBagConstraints();
			gbc_lblDialogName.gridwidth = 3;
			gbc_lblDialogName.insets = new Insets(0, 0, 5, 0);
			gbc_lblDialogName.gridx = 0;
			gbc_lblDialogName.gridy = 0;
			contentPanel.add(lblDialogName, gbc_lblDialogName);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblXcoord = new JLabel("x coordinate center :");
			lblXcoord.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblXcoord = new GridBagConstraints();
			gbc_lblXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoord.anchor = GridBagConstraints.WEST;
			gbc_lblXcoord.gridx = 0;
			gbc_lblXcoord.gridy = 2;
			contentPanel.add(lblXcoord, gbc_lblXcoord);
		}
		{
			textFieldX = new JTextField();
			textFieldX.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 1;
			gbc_textFieldX.gridy = 2;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYcoord = new JLabel("y coordinate center :");
			lblYcoord.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblYcoord = new GridBagConstraints();
			gbc_lblYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoord.anchor = GridBagConstraints.WEST;
			gbc_lblYcoord.gridx = 0;
			gbc_lblYcoord.gridy = 3;
			contentPanel.add(lblYcoord, gbc_lblYcoord);
		}
		{
			textFieldY = new JTextField();
			textFieldY.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("outer radius :");
			lblOuterRadius.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 0;
			gbc_lblOuterRadius.gridy = 5;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			textFieldOuterRadius = new JTextField();
			textFieldOuterRadius.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldOuterRadius = new GridBagConstraints();
			gbc_textFieldOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldOuterRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOuterRadius.gridx = 1;
			gbc_textFieldOuterRadius.gridy = 5;
			contentPanel.add(textFieldOuterRadius, gbc_textFieldOuterRadius);
			textFieldOuterRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Set inner radius :");
			lblInnerRadius.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 6;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInnerRadius = new JTextField();
			textFieldInnerRadius.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldInnerRadius = new GridBagConstraints();
			gbc_textFieldInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInnerRadius.gridx = 1;
			gbc_textFieldInnerRadius.gridy = 6;
			contentPanel.add(textFieldInnerRadius, gbc_textFieldInnerRadius);
			textFieldInnerRadius.setColumns(10);
		}
		{
			{
				JButton btnEdgeColor = new JButton("Edge color");
				GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
				gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnEdgeColor.gridx = 0;
				gbc_btnEdgeColor.gridy = 7;
				contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
				btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				JButton btnFillColor = new JButton("Fill color");
				GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
				gbc_btnFillColor.insets = new Insets(0, 0, 0, 5);
				gbc_btnFillColor.gridx = 0;
				gbc_btnFillColor.gridy = 8;
				contentPanel.add(btnFillColor, gbc_btnFillColor);
				btnFillColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnFillColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						fillColor = JColorChooser.showDialog(null, "Choose fill color", edgeColor);
						if (fillColor == null) {
							fillColor = Color.BLACK;
						}
					}
				});
				btnEdgeColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						edgeColor = JColorChooser.showDialog(null, "Choose edge color", Color.BLACK);
						if (edgeColor == null) {
							edgeColor = Color.BLACK;
						}
					}
				});
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 127, 80));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());

							int outerRadius = Integer.parseInt(textFieldOuterRadius.getText());
							int innerRadius = Integer.parseInt(textFieldInnerRadius.getText());

							if (x < 0 || y < 0) {
								JOptionPane.showMessageDialog(null, "Coordinate values must be positive!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							if (outerRadius < 0 || innerRadius < 0) {
								JOptionPane.showMessageDialog(null, "Values for radiuses must be positive!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							if (innerRadius > outerRadius) {
								JOptionPane.showMessageDialog(null,
										"Value for inner radius must be greater than outer radius!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							donut = new Donut(new Point(x, y), outerRadius, innerRadius, edgeColor, fillColor);
							dispose();

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Invalid data type", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut d) {
		setPoint(d.getCenter());
		setColors(d.getColor(), d.getFillColor());
		textFieldOuterRadius.setText("" + d.getRadius());
		textFieldInnerRadius.setText("" + d.getInnerRadius());

	}

	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
	}

}
