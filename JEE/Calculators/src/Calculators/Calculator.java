package Calculators;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private JButton button;
	private JRadioButton rdbtnOn;
	private JRadioButton rdbtnNewRadioButton;
	private JButton btnC;
	private JButton btnNewButton;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	
	JLabel label;
	private int calculation;
	private double num;
	private double ans;
	
	
private void ini() {

}
	
	
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 213, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(6, 37, 178, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		rdbtnOn = new JRadioButton("On");
		rdbtnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable();
				
			}
		});
		rdbtnOn.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnOn.setBounds(0, 82, 48, 22);
		contentPane.add(rdbtnOn);
		bg.add(rdbtnOn);
		
		rdbtnNewRadioButton = new JRadioButton("Off");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disable();
				
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton.setBounds(0, 106, 48, 22);
		contentPane.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton);
	
		
		btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = textField.getText().length();
				int number = textField.getText().length() - 1;
				String store;
				if(length > 0) {
					StringBuilder back = new StringBuilder(textField.getText());
					back.deleteCharAt(number);
					store = back.toString();
					textField.setText(store);
				}

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(51, 86, 42, 42);
		contentPane.add(btnNewButton);
		
		btnC = new JButton("c");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnC.setBounds(96, 86, 42, 42);
		contentPane.add(btnC);
		
		button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             num = Double.parseDouble(textField.getText());
             calculation= 1;
             textField.setText("");
             label.setText(num + "+");
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(142, 86, 42, 42);
		contentPane.add(button);
		
		button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num = Double.parseDouble(textField.getText());
	             calculation= 2;
	             textField.setText("");
	             label.setText(num + "-");			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBounds(142, 130, 42, 42);
		contentPane.add(button_1);
		
		button_2 = new JButton("*");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num = Double.parseDouble(textField.getText());
	             calculation= 3;
	             textField.setText("");
	             label.setText(num + "*");			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setBounds(142, 175, 42, 42);
		contentPane.add(button_2);
		
		button_3 = new JButton("/");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num = Double.parseDouble(textField.getText());
	             calculation= 4;
	             textField.setText("");
	             label.setText(num + "/");			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(142, 219, 42, 42);
		contentPane.add(button_3);
		
		button_4 = new JButton("9");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "9");
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 12));
		button_4.setBounds(96, 130, 42, 42);
		contentPane.add(button_4);
		
		button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "6");
			}
		});
		button_5.setFont(new Font("Dialog", Font.BOLD, 12));
		button_5.setBounds(96, 175, 42, 42);
		contentPane.add(button_5);
		
		button_6 = new JButton("3");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "3");
			}
		});
		button_6.setFont(new Font("Dialog", Font.BOLD, 12));
		button_6.setBounds(96, 219, 42, 42);
		contentPane.add(button_6);
		
		button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "8");
			}
		});
		button_7.setFont(new Font("Dialog", Font.BOLD, 12));
		button_7.setBounds(51, 130, 42, 42);
		contentPane.add(button_7);
		
		button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "5");
			}
		});
		button_8.setFont(new Font("Dialog", Font.BOLD, 12));
		button_8.setBounds(51, 175, 42, 42);
		contentPane.add(button_8);
		
		button_9 = new JButton("2");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "2");
			}
		});
		button_9.setFont(new Font("Dialog", Font.BOLD, 12));
		button_9.setBounds(51, 219, 42, 42);
		contentPane.add(button_9);
		
		button_10 = new JButton("7");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "7");
			}
		});
		button_10.setFont(new Font("Dialog", Font.BOLD, 12));
		button_10.setBounds(6, 130, 42, 42);
		contentPane.add(button_10);
		
		button_11 = new JButton("4");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "4");
			}
		});
		button_11.setFont(new Font("Dialog", Font.BOLD, 12));
		button_11.setBounds(6, 175, 42, 42);
		contentPane.add(button_11);
		
		button_12 = new JButton("1");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "1");
			}
		});
		button_12.setFont(new Font("Dialog", Font.BOLD, 12));
		button_12.setBounds(6, 219, 42, 42);
		contentPane.add(button_12);
		
		button_13 = new JButton("0");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ "0");
			}
		});
		button_13.setFont(new Font("Dialog", Font.BOLD, 12));
		button_13.setBounds(6, 264, 42, 42);
		contentPane.add(button_13);
		
		button_14 = new JButton(".");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+ ".");
			}
		});
		button_14.setFont(new Font("Tahoma", Font.BOLD, 22));
		button_14.setBounds(51, 264, 42, 42);
		contentPane.add(button_14);
		
		button_15 = new JButton("=");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             math_opration();
             label.setText("");
			}
		});
		button_15.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_15.setBounds(96, 264, 88, 42);
		contentPane.add(button_15);
		
		rdbtnOn.setEnabled(false);
		rdbtnOn.setSelected(true);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBackground(Color.WHITE);
		label.setBounds(83, 16, 100, 20);
		contentPane.add(label);

	}
	public void disable() {
		textField.setEnabled(false);
	    button.setEnabled(false);
		rdbtnOn.setEnabled(true);
		rdbtnNewRadioButton.setEnabled(false);
        btnC.setEnabled(false);
		btnNewButton.setEnabled(false);
		button_1.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		button_4.setEnabled(false);
		button_5.setEnabled(false);
		button_6.setEnabled(false);
		button_7.setEnabled(false);
		button_8.setEnabled(false);
		button_9.setEnabled(false);
		button_10.setEnabled(false);
		button_11.setEnabled(false);
		button_12.setEnabled(false);
		button_13.setEnabled(false);
		button_14.setEnabled(false);
		button_15.setEnabled(false);
		textField.setText("");

	}
	public void enable() {
		textField.setEnabled(true);
	    button.setEnabled(true);
		rdbtnOn.setEnabled(false);
		rdbtnNewRadioButton.setEnabled(true);
        btnC.setEnabled(true);;
		btnNewButton.setEnabled(true);
		button_1.setEnabled(true);
		button_2.setEnabled(true);
		button_3.setEnabled(true);
		button_4.setEnabled(true);
		button_5.setEnabled(true);
		button_6.setEnabled(true);
		button_7.setEnabled(true);
		button_8.setEnabled(true);
		button_9.setEnabled(true);
		button_10.setEnabled(true);
		button_11.setEnabled(true);
		button_12.setEnabled(true);
		button_13.setEnabled(true);
		button_14.setEnabled(true);
		button_15.setEnabled(true);
	}
	public void math_opration() {
		switch(calculation)
	{     
		case 1: // Addition
			ans = num + Double.parseDouble(textField.getText());
			textField.setText(Double.toString(ans));
			break;
			
		case 2: // sustraction
			ans = num - Double.parseDouble(textField.getText());
			textField.setText(Double.toString(ans));
			break;
			
		case 3: // Multiplication
			ans = num * Double.parseDouble(textField.getText());
			textField.setText(Double.toString(ans));
			break;
			
		case 4: // Divition
			ans = num / Double.parseDouble(textField.getText());
			textField.setText(Double.toString(ans));
			break;
	}
		
		
		
	}
}
