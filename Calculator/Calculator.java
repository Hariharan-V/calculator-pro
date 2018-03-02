package Calculator;

/* GUI for a simple calculator
 * @author Hariharan Vijayachandran & Zion Fung
 * @since 20161203
 * 
 * Uses GridBagLayout
 * 
 * I pledge my honor that I have abided by the Stevens Honor System
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
	
	/* Adds the components to the specified pane
	 * Initializes all constraints and buttons and adds all of the action listeners
	 * @param pane the pane to add the components to
	 * 
	 */
	private static void addComponents(Container pane)
	{
		//Initializes all of the buttons
		final int fontSize = 24;
		JLabel input = new JLabel();
		JButton squareRoot = new JButton("^(1/2)");
		JButton square = new JButton("^2");
		JButton clear = new JButton("C");
		JButton backspace = new JButton("<--");
		JButton divide = new JButton("/");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton multiply = new JButton("*");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton subtract = new JButton("-");
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton add = new JButton("+");
		JButton plusMinus = new JButton("+/-");
		JButton zero = new JButton("0");
		JButton decimal = new JButton(".");
		JButton equals = new JButton("=");
		JButton openParen = new JButton("(");
		JButton closeParen = new JButton(")");
		JButton exponent = new JButton("^");
		
		//Creates all of the constraints
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setBorder(BorderFactory.createLineBorder(Color.black));
		input.setPreferredSize(new Dimension(pane.getWidth(), 50));
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();	
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		c.gridheight = 2;
		c.weightx = 1;
		pane.add(input, c);
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(exponent, c);
		c.gridx = 1;
		c.gridy = 2;
		pane.add(openParen ,c);
		c.gridx = 2;
		c.gridy = 2;
		pane.add(closeParen,c);
		c.gridx = 3;
		c.gridy = 2;
		pane.add(squareRoot,c);
		c.gridx = 0;
		c.gridy = 3;
		pane.add(square, c);
		c.gridx = 1;
		c.gridy = 3;
	    pane.add(clear, c);
	    c.gridx = 2;
	    c.gridy = 3;
	    pane.add(backspace, c);
	    c.gridx = 3;
	    c.gridy = 3;
	    pane.add(divide, c);
	    c.gridx = 0;
	    c.gridy = 4;
	    pane.add(seven, c);
	    c.gridx = 1;
	    c.gridy = 4;
	    pane.add(eight, c);
	    c.gridx = 2;
	    c.gridy = 4;
	    pane.add(nine, c);
	    c.gridx = 3;
	    c.gridy = 4;
	    pane.add(multiply, c);
	    c.gridx = 0;
	    c.gridy = 5;
	    pane.add(four, c);
	    c.gridx = 1;
	    c.gridy = 5;
	    pane.add(five, c);
	    c.gridx = 2;
	    c.gridy = 5;
	    pane.add(six, c);
	    c.gridx = 3;
	    c.gridy = 5;
	    pane.add(subtract, c);
	    c.gridx = 0;
	    c.gridy = 6;
	    pane.add(one, c);
	    c.gridx = 1;
	    c.gridy = 6;
	    pane.add(two, c);
	    c.gridx = 2;
	    c.gridy = 6;
	    pane.add(three, c);
	    c.gridx = 3;
	    c.gridy = 6;
	    pane.add(add, c);
	    c.gridx = 0;
	    c.gridy = 7;
	    pane.add(plusMinus, c);
	    c.gridx = 1;
	    c.gridy = 7;
	    pane.add(zero, c);
	    c.gridx = 2;
	    c.gridy = 7;
	    pane.add(decimal, c);
	    c.gridx = 3;
	    c.gridy = 7;
	    pane.add(equals, c);	
	    
	    //Changes the font size of the labels
	    squareRoot.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    square.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    clear.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    backspace.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    divide.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    seven.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    eight.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    nine.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    multiply.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    four.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    five.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    six.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    subtract.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    one.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    two.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    three.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    add.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    plusMinus.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    zero.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    decimal.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    equals.setFont(new Font("Arial", Font.PLAIN, fontSize));
	    
	    //Adds all of the action listeners
	    exponent.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "^");
		    }
		});
	    closeParen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + ")");
		    }
		});
	    openParen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "(");
		    }
		});
	    squareRoot.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "^(1/2)");
		    }
		});	
	    square.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "^2");
		    }
		});	
	    clear.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText("");
		    }
		});	
	    backspace.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	String before = input.getText();
		    	if(!before.equals(""))
		    	{
		    		input.setText(before.substring(0, before.length() - 1));
		    	}
		    }
		});	
	    divide.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "/");
		    }
		});	
	    seven.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "7");
		    }
		});	
	    eight.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "8");
		    }
		});	
	    nine.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "9");
		    }
		});	
	    multiply.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "*");
		    }
		});	
	    four.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "4");
		    }
		});	
	    five.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "5");
		    }
		});	
	    six.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "6");
		    }
		});	
	    subtract.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "-");
		    }
		});	
	    one.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "1");
		    }
		});	
	    two.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "2");
		    }
		});	
	    three.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "3");
		    }
		});	
	    add.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "+");
		    }
		});	
	    plusMinus.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	if(input.getText().equals(""))
		    	{
		    		return;
		    	}
		    	if(input.getText().substring(0, 1).equals("-"))
		    	{
		    		input.setText(input.getText().substring(1));
		    	}
		    	else
		    	{
		    		input.setText("-" + input.getText());
		    	}
		    }
		});	
	    zero.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + "0");
		    }
		});	
	    decimal.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	input.setText(input.getText() + ".");
		    }
		});	
	    equals.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	try
		    	{
			    	double result = evaluate.evaluateexpression(input.getText());
			    	input.setText("" + result);
		    	}
		    	catch(Exception e) // If the calculation throws an error, it will be caught and an appropriate message will be created
		    	{
		    		String message = e.getMessage();
		    		if(message.equals("div by 0"))
		    		{
		    			input.setText("Divide by zero");
		    		}
		    		else
		    		{
		    			input.setText("Incorrect syntax");
		    		}
		    	}
		    }
		});	
	}
	
	// Method that creates the GUI
	private static void createGUI()
	{
		Calculator calc = new Calculator();
		addComponents(calc.getContentPane());
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setVisible(true);
		calc.setResizable(false);
		calc.pack();
	}
	
	// Constructor that names the gui "calculator"
	public Calculator()
	{
		super("Calculator");
	}
	
	//Calls the createGUI method, creating the GUI in the edt
	public static void main(String [] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        createGUI();
		    }
		});
	}
}
