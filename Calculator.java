// ICS 4U1
// Calcutor GUI
// Written by: Hammad Rehman
// Written for: Mrs. Ganesan
//Due Date: April 6, 2021
//Submission Date: April 5, 2021
//This program outputs a simple calculator interface. With the calculator, the user is able to perform simple multiplication,
//division, subtraction and addition calculations. The user is only able to do ONE calculation at a time.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener
{

    JButton clear = new JButton ("Clear!"); 
    JPanel panel15 = new JPanel ();
    JButton equals = new JButton ("=");//Creating buttons and panels to store each of the buttons in
    JPanel panel1 = new JPanel ();
    JButton but1 = new JButton ("1");
    JPanel panel2 = new JPanel ();
    JButton but2 = new JButton ("2");
    JPanel panel3 = new JPanel ();
    JButton but3 = new JButton ("3");
    JPanel panel4 = new JPanel ();
    JButton but4 = new JButton ("4");
    JPanel panel5 = new JPanel ();
    JButton but5 = new JButton ("5");
    JPanel panel6 = new JPanel ();
    JButton but6 = new JButton ("6");
    JPanel panel7 = new JPanel ();
    JButton but7 = new JButton ("7");
    JPanel panel8 = new JPanel ();
    JButton but8 = new JButton ("8");
    JPanel panel9 = new JPanel ();
    JButton but9 = new JButton ("9");
    JPanel panel14 = new JPanel ();
    JButton but14 = new JButton ("0");
    JPanel decimal = new JPanel ();
    JButton but15 = new JButton (".");
    JPanel division = new JPanel ();
    JButton but10 = new JButton ("÷");
    JPanel multiplication = new JPanel ();
    JButton but11 = new JButton ("x");
    JPanel addition = new JPanel ();
    JButton but12 = new JButton ("+");
    JPanel subtraction = new JPanel ();
    JButton but13 = new JButton ("-");
    JButton off = new JButton ("OFF");


    JTextField outRes = new JTextField (20); //Outputted Text Field

    JPanel pnLeft = new JPanel (); //These panels will hold the other smaller panels
    JPanel pnRight = new JPanel ();
    JPanel pnMiddle = new JPanel ();
    JPanel pnOperations = new JPanel ();
    JPanel resPanel = new JPanel ();
    JPanel butPanel = new JPanel ();
    public static String display = "", operation = "", temp; //Variables used for calculations
    public static double num1, num2, result;
    public static int dislength;
    public Calculator ()
    {
	clear.setActionCommand ("clear"); //Setting action commands for each button
	equals.setActionCommand ("equals");
	off.setActionCommand ("off");
	setTitle ("Calculator");
	but1.setActionCommand ("1");
	but2.setActionCommand ("2");
	but3.setActionCommand ("3");
	but4.setActionCommand ("4");
	but5.setActionCommand ("5");
	but6.setActionCommand ("6");
	but7.setActionCommand ("7");
	but8.setActionCommand ("8");
	but9.setActionCommand ("9");
	but14.setActionCommand ("0");
	but15.setActionCommand (".");
	but10.setActionCommand ("division");
	but11.setActionCommand ("multiplication");
	but12.setActionCommand ("addition");
	but13.setActionCommand ("subtraction");

	outRes.setEditable (false); //Making the text field uneditible
	butPanel.add (off);
	butPanel.add (clear); //Adding the buttons to their individual panels

	resPanel.add (outRes);
	panel1.add (but1);
	panel2.add (but2);
	panel3.add (but3);
	panel4.add (but4);
	panel5.add (but5);
	panel6.add (but6);
	panel7.add (but7);
	panel8.add (but8);
	panel9.add (but9);
	panel14.add (but14);
	division.add (but10);
	multiplication.add (but11);
	addition.add (but12);
	subtraction.add (but13);
	decimal.add (but15);
	panel15.add (equals);

	// setting a layout manager to output each panel on the y-axis
	pnLeft.setLayout (new BoxLayout (pnLeft, BoxLayout.Y_AXIS));
	pnLeft.add (panel1);
	pnLeft.add (panel4);
	pnLeft.add (panel7); //Adding each of the smaller panels to the larger panel
	pnLeft.add (decimal);


	// setting a layout manager to output each panel on the y-axis
	pnRight.setLayout (new BoxLayout (pnRight, BoxLayout.Y_AXIS));
	pnRight.add (panel3);
	pnRight.add (panel6);
	pnRight.add (panel9);
	pnRight.add (panel15);

	// setting a layout manager to output each panel on the y-axis
	pnMiddle.setLayout (new BoxLayout (pnMiddle, BoxLayout.Y_AXIS));
	pnMiddle.add (panel2);
	pnMiddle.add (panel5);
	pnMiddle.add (panel8);
	pnMiddle.add (panel14);

	// setting a layout manager to output each panel on the y-axis
	pnOperations.setLayout (new BoxLayout (pnOperations, BoxLayout.Y_AXIS));
	pnOperations.add (division);
	pnOperations.add (multiplication);
	pnOperations.add (addition);
	pnOperations.add (subtraction);


	// setting a layout manager to output each panel from top to bottom
	getContentPane ().setLayout (new FlowLayout ());
	getContentPane ().add (resPanel);
	getContentPane ().add (pnLeft);
	getContentPane ().add (pnMiddle);
	getContentPane ().add (pnRight);
	getContentPane ().add (pnOperations);
	getContentPane ().add (butPanel);
	getContentPane ().setBackground (Color.BLACK); //Setting background colour as black
	but1.addActionListener (this); //Adding action listeners to each button
	but2.addActionListener (this);
	but3.addActionListener (this);
	but4.addActionListener (this);
	but5.addActionListener (this);
	but6.addActionListener (this);
	but7.addActionListener (this);
	but8.addActionListener (this);
	but9.addActionListener (this);
	but10.addActionListener (this);
	but11.addActionListener (this);
	but12.addActionListener (this);
	but13.addActionListener (this);
	but14.addActionListener (this);
	clear.addActionListener (this);
	equals.addActionListener (this);
	but15.addActionListener (this);
	off.addActionListener (this);
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //Allowing the user to exit on close
    }


    public void actionPerformed (ActionEvent evt)
    {
	try
	{

	    if (evt.getActionCommand ().equals ("clear")) //If the user presses clear
	    {
		outRes.setText ("");
		display = ""; //Resetting all variables and text fields
		operation = "";
	    }
	    if (evt.getActionCommand ().equals ("off")) //If the user presses OFF
	    {
		System.exit (0);//Calculator shuts down
	    }

	    else if (evt.getActionCommand ().equals ("1")) //The user clicks 1
	    {
		display += "1"; //Display is the running variable that holds all the numbers that the user clicks on
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("2")) //The user clicks 2
	    {
		display += "2";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("3")) //The user clicks 3
	    {
		display += "3";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("4")) //The user clicks 4
	    {
		display += "4";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("5")) //The user clicks 5
	    {
		display += "5";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("6")) //The user clicks 6
	    {
		display += "6";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("7")) //The user clicks 7
	    {
		display += "7";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("8")) //The user clicks 8
	    {
		display += "8";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("9")) //The user clicks 9
	    {
		display += "9";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("0")) //The user clicks 0
	    {
		display += "0";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals (".")) //The user clicks .
	    {
		display += ".";
		outRes.setText (display);
	    }
	    else if (evt.getActionCommand ().equals ("division") || evt.getActionCommand ().equals ("multiplication") || evt.getActionCommand ().equals ("addition") || evt.getActionCommand ().equals ("subtraction"))
	    { //If the user picks an operation button
		num1 = Double.parseDouble (display); //Stores the first number into num1

		if (evt.getActionCommand ().equals ("division")) //User clicks "÷"
		{
		    operation += "÷"; //The operation variable helps determine what the user wants to do with the numbers
		    display += "÷";
		    outRes.setText (display);
		}
		else if (evt.getActionCommand ().equals ("multiplication")) //User clicks "x"
		{
		    operation += "x";
		    display += "x";
		    outRes.setText (display);
		}
		else if (evt.getActionCommand ().equals ("addition")) //User clicks "+"
		{
		    operation += "+";
		    display += "+";
		    outRes.setText (display);
		}
		else if (evt.getActionCommand ().equals ("subtraction")) //User clicks "-"
		{
		    operation += "-";
		    display += "-";
		    outRes.setText (display);
		}
		dislength = display.length (); //Used to determine the second number


	    }
	    else if (evt.getActionCommand ().equals ("equals")) //User wants to perform the calculation, clicks "="
	    {
		temp = display.substring (dislength, display.length ()); //"temp" is a temporary variable that extracts the second number as a String
		num2 = Double.parseDouble (temp); //The second user chosen number
		if (operation.equals ("÷")) //User chose to divide
		{
		    result = num1 / num2;
		    outRes.setText (result + ""); //Outputs the result of the calculations
		}
		else if (operation.equals ("x")) //User chose to multiply
		{
		    result = num1 * num2;
		    outRes.setText (result + "");
		}
		else if (operation.equals ("+")) //User chose to add
		{
		    result = num1 + num2;
		    outRes.setText (result + "");
		}
		else if (operation.equals ("-")) //User chose to substract
		{
		    result = num1 - num2;
		    outRes.setText (result + "");
		}
		operation = ""; //Resets the operation chosen by the user
		display = result + ""; //User can chose to continue with calculations using the resultant number
	    }
	}
	catch (NumberFormatException exc)  //In case the user clicks on more than one operations
	{
	    outRes.setText ("Invalid Input! Press Clear!");
	    operation = "";
	    display = "";
	}
	catch (StringIndexOutOfBoundsException exc)  //If the user uses the decimal button (".") twice on a single number. (Eg: 545.64.9)
	{
	    outRes.setText ("Invalid Input! Press Clear!");
	    operation = "";
	    display = "";
	}

    }



    public static void main (String[] args)
    {
	Calculator calc = new Calculator ();
	calc.setSize (300, 300);
	calc.setVisible (true);
    }
}


