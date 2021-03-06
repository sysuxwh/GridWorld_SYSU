import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator extends JFrame{

	public Calculator() {

	JPanel panel;
	JTextField result, op, equalText, a, b;
	JButton add, sub, mul, div, equal;

	// Size
	setBounds(300, 200, 400, 200);		
	// Title
	setTitle("XW_Calculator");			

	// expression 
	a = new JTextField(15);
	a.setHorizontalAlignment(JTextField.CENTER);

	op = new JTextField();
	op.setEditable(false);
	op.setHorizontalAlignment(JTextField.CENTER);

	b = new JTextField(15);
	b.setHorizontalAlignment(JTextField.CENTER);

	equalText = new JTextField();
	equalText.setEditable(false);
	equalText.setText("=");
	equalText.setHorizontalAlignment(JTextField.CENTER);

	result = new JTextField(15);
	result.setHorizontalAlignment(JTextField.CENTER);
	result.setEditable(false);

	// op button
	add = new JButton("+");
	sub = new JButton("-");
	mul = new JButton("*");
	div = new JButton("/");
	equal = new JButton("=");

	// set panel
	panel = new JPanel();
	panel.setLayout(new GridLayout(2,5));

	panel.add(a);  
        panel.add(op);  
        panel.add(b);  
        panel.add(equalText);
        panel.add(result);
		panel.add(add);  
        panel.add(sub);  
        panel.add(mul);  
        panel.add(div);
        panel.add(equal);

        add(panel);

        setOp(add, op);  
        setOp(sub, op);  
        setOp(mul, op);  
        setOp(div, op);

        // ensure read only digit 0 to 9 and '.' 
        a.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char ch = e.getKeyChar();                 
                if(ch!='.' && (ch<'0'|| ch>'9')) 
                {
                	e.consume();   
                }
            }  
        });   

        b.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char ch = e.getKeyChar();                 
                if(ch!='.' && (ch<'0'|| ch>'9')) 
                {
                	e.consume();  
                }
            }  
        });  

        // calculate
        equal.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent arg) {
	        	double num1 = Double.parseDouble(a.getText().trim());
	        	double num2 = Double.parseDouble(b.getText().trim());

	        	String operator = op.getText();
	        	if (operator.equals("")) {
        			return;
        		}
	        	
	        	if (operator.equals("/")) {
        			if (num2 == 0.0) {
        				result.setText("NAN");
        			}
        			else {
        				result.setText(String.valueOf(num1/num2));
        			}
        		}
	        	else {
	        		double res = 0.00;
	        		if (operator.equals("+")) {
	        			res = num1 + num2;
	        		}
		        	else if (operator.equals("-")) {
		        		res = num1 - num2;
		        	}
		        	else if (operator.equals("*")) {
		        		res = num1 * num2;
		        	}
	        		result.setText(String.valueOf(res));
	    		}
			}
		});	
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public final void setOp(JButton button, JTextField target){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				target.setText(button.getText());
			}
		});		
	}

	public static void main(String[] args) {
		new Calculator();
	}
} 




