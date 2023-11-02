package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PaintDrawingApp extends JFrame {

	private JPanel contentPane;
	private Point startPoint = null;

	private Color edgeColor = Color.black;
	private Color fillColor = Color.white;

	// button group in which can be selected only one button
	private ButtonGroup btngroupShape = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintDrawingApp frame = new PaintDrawingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaintDrawingApp() {
		setTitle("Nevena Saponja IT42/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		PnlDrawing pnlDrawing = new PnlDrawing();

		pnlDrawing.setBackground(new Color(255, 239, 213));
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		GridBagLayout gbl_pnlDrawing = new GridBagLayout();
		gbl_pnlDrawing.columnWidths = new int[]{160, 59, 59, 55, 63, 77, 61, 51, 0};
		gbl_pnlDrawing.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0, 0};
	    gbl_pnlDrawing.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDrawing.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDrawing.setLayout(gbl_pnlDrawing);
																																				
	    JLabel lblNewLabel = new JLabel("DRAWING");
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		pnlDrawing.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SHAPES:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(255, 239, 213));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		pnlDrawing.add(lblNewLabel_1, gbc_lblNewLabel_1);
															
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
	    tglbtnDonut.setBackground(new Color(210, 105, 30));
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDonut.gridx = 0;
		gbc_tglbtnDonut.gridy = 2;
		pnlDrawing.add(tglbtnDonut, gbc_tglbtnDonut);
		btngroupShape.add(tglbtnDonut); // ubacen oblik u grupu
																
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setBackground(new Color(240, 128, 128));
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 0;
	    gbc_tglbtnCircle.gridy = 3;
		pnlDrawing.add(tglbtnCircle, gbc_tglbtnCircle);
	    btngroupShape.add(tglbtnCircle);
																												
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setBackground(new Color(210, 105, 30));
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 0;
	    gbc_tglbtnPoint.gridy = 4;
		pnlDrawing.add(tglbtnPoint, gbc_tglbtnPoint);
		tglbtnPoint.setSelected(true);
		tglbtnPoint.setHorizontalAlignment(SwingConstants.LEFT);
		btngroupShape.add(tglbtnPoint);
																										
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setBackground(new Color(240, 128, 128));
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 0;
	    gbc_tglbtnRectangle.gridy = 5;
		pnlDrawing.add(tglbtnRectangle, gbc_tglbtnRectangle);
		btngroupShape.add(tglbtnRectangle);
																								
		JToggleButton tglbtnLine = new JToggleButton("Line");
	    tglbtnLine.setBackground(new Color(210, 105, 30));
	    GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.anchor = GridBagConstraints.NORTH;
	    gbc_tglbtnLine.gridx = 0;
		gbc_tglbtnLine.gridy = 6;
		pnlDrawing.add(tglbtnLine, gbc_tglbtnLine);
		btngroupShape.add(tglbtnLine);
		
		JLabel lblNewLabel_2 = new JLabel("DO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		pnlDrawing.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 2;
		gbc_tglbtnSelect.gridy = 6;
		pnlDrawing.add(tglbtnSelect, gbc_tglbtnSelect);
		btngroupShape.add(tglbtnSelect);
		
				// Modifying
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 3;
		gbc_btnModify.gridy = 6;
		
		pnlDrawing.add(btnModify, gbc_btnModify);
		
		
		btnModify.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		 int i = pnlDrawing.getSelected();
		 if (i == -1) {
		  JOptionPane.showMessageDialog(null, "Select an object first", "Error", JOptionPane.ERROR_MESSAGE);
			return; 
		}

		Shape shape = pnlDrawing.getShape(i);
		  if (shape instanceof Point) {
			DlgPoint dlgPoint = new DlgPoint();
		    dlgPoint.setPoint((Point) shape);
			dlgPoint.setVisible(true);
			if (dlgPoint.getPoint() != null) {
				((Point) shape).setX(dlgPoint.getPoint().getX());
			    ((Point) shape).setY(dlgPoint.getPoint().getY());
	
			shape.setColor(dlgPoint.getPoint().getColor());
					}
		}

		else if (shape instanceof Line) {
			DlgLine dlgLine = new DlgLine();
			dlgLine.setLine(((Line) shape).getStartPoint(), ((Line) shape).getEndPoint());
			dlgLine.setVisible(true);
			Line line = dlgLine.getLine();

		if (line != null) {
			((Line) shape).setStartPoint(line.getStartPoint());
			((Line) shape).setEndPoint(line.getEndPoint());
			shape.setColor(line.getColor());
		}
	}

		else if (shape instanceof Rectangle) {
		   DlgRectangle dlgRectangle = new DlgRectangle();
		   dlgRectangle.setRectangle((Rectangle) shape); 
		   dlgRectangle.setVisible(true);
		   Rectangle rect = dlgRectangle.getRectangle();

		if (rect != null) {
		  ((Rectangle) shape).setUpperLeftPoint(rect.getUpperLeftPoint());
		  ((Rectangle) shape).setWidth(rect.getWidth());
		  ((Rectangle) shape).setHeight(rect.getHeight());
		  shape.setColor(rect.getColor());
		  ((Rectangle) shape).setFillColor(rect.getFillColor());
			}
		}

	// check for donut first because donut is also a circle
		else if (shape instanceof Donut) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setDonut((Donut) shape);
		    dlgDonut.setVisible(true);
			Donut donut = dlgDonut.getDonut();

		if (donut != null) {
		  ((Donut) shape).setCenter(donut.getCenter());
		  ((Donut) shape).setRadius(donut.getRadius());
          ((Donut) shape).setInnerRadius(donut.getInnerRadius());
		  shape.setColor(donut.getColor());
		  ((Donut) shape).setFillColor(donut.getFillColor());
			}
		}

		else if (shape instanceof Circle) {
		  DlgCircle dlgCircle = new DlgCircle();
		  dlgCircle.setCircle((Circle) shape);
		  dlgCircle.setVisible(true);
		  Circle circle = dlgCircle.getCircle();

		if (circle != null) {
		  ((Circle) shape).setCenter(circle.getCenter());
		  ((Circle) shape).setRadius(circle.getRadius());
	
		  shape.setColor(circle.getColor());
		  ((Circle) shape).setFillColor(circle.getFillColor());
		}
	}

		pnlDrawing.repaint();
		}
	});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 6;
		pnlDrawing.add(btnDelete, gbc_btnDelete);
		
		//Delete
		
		btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		  if (!pnlDrawing.isEmpty()) {
				if (JOptionPane.showConfirmDialog(null, "Do you really want to delete selected object?", "Yes",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				 pnlDrawing.remove(pnlDrawing.getSelected());
			}
		}
	}
});

		JPanel tlgbButtonPanel = new JPanel();
		contentPane.add(tlgbButtonPanel, BorderLayout.NORTH);
		tlgbButtonPanel.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));

		// mouse listener

		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Point clickPosition = new Point(e.getX(), e.getY());

				pnlDrawing.deselectAll();

				if (tglbtnSelect.isSelected()) {
					pnlDrawing.select(clickPosition);
					return;
				}

				if (tglbtnCircle.isSelected()) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(clickPosition);
					dlgCircle.setColors(edgeColor, fillColor);
					dlgCircle.setVisible(true);

					if (dlgCircle.getCircle() != null) {
						pnlDrawing.addShape(dlgCircle.getCircle());
					}

					return;
				}

				if (tglbtnDonut.isSelected()) {
					DlgDonut dlgDonut = new DlgDonut(); // a new instance of the rectangle dialog class
					dlgDonut.setPoint(clickPosition);
					dlgDonut.setColors(edgeColor, fillColor);
					dlgDonut.setVisible(true);

					if (dlgDonut.getDonut() != null) {
						pnlDrawing.addShape(dlgDonut.getDonut());
					}
					return;
				}

				if (tglbtnRectangle.isSelected()) {
					DlgRectangle dlgRectangle = new DlgRectangle(); //a new instance of the rectangle dialog class
					dlgRectangle.setPoint(clickPosition);
					dlgRectangle.setColors(edgeColor, fillColor);
					dlgRectangle.setVisible(true);

					if (dlgRectangle.getRectangle() != null) {
						pnlDrawing.addShape(dlgRectangle.getRectangle());
					}
					return;
				}

				if (tglbtnPoint.isSelected()) {
					DlgPoint dlgPoint = new DlgPoint(); // a new instance of the rectangle dialog class
					dlgPoint.setPoint(clickPosition);
					dlgPoint.setColor(edgeColor);
					dlgPoint.setVisible(true);

					if (dlgPoint.getPoint() != null) {
						pnlDrawing.addShape(dlgPoint.getPoint());
					}
					return;
				}

				if (tglbtnLine.isSelected()) {
					if (startPoint != null) {
						DlgLine dlgLine = new DlgLine();
						dlgLine.setLine(startPoint, clickPosition);
						dlgLine.setColor(edgeColor);
						dlgLine.setVisible(true);

						if (dlgLine.getLine() != null) {
							pnlDrawing.addShape(dlgLine.getLine());
						}
						startPoint = null;
						return;
					} else {
						startPoint = clickPosition;
						return;
					}
				}
			}

		});
	}

}
