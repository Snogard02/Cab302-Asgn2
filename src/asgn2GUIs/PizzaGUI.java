package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.io.File; 
import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private PizzaRestaurant restaurant;
	
	private JPanel pnlBase;
	private JButton btnLoad;
	private JButton btnReset;
	private JButton btnInfo;
	private JButton btnCalc;
	private JPanel pnlBtn;
	private JTextArea pizzaDisplay; 
	private JTextArea customerDisplay; 
	private JScrollPane scrollDisplay;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		super(title);
	}
	/**
	 * Creates the GUI
	 */
	private void createGUI() {
		setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    pnlBase = createPanel(Color.WHITE);
	    pnlBtn = createPanel(Color.LIGHT_GRAY);

	    
	    btnLoad = createButton("Load");
	    btnReset = createButton("Reset");
	    btnInfo = createButton("Display Information");
	    btnCalc = createButton("Display Calculation");
	    
	    pizzaDisplay = createTextArea();
	    customerDisplay = createTextArea();
	    
	    scrollDisplay = createScroll(pnlBase);
	    
	    pnlBase.setLayout(new GridLayout(0,2));
	    pnlBase.add(pizzaDisplay);
	    pnlBase.add(customerDisplay);
	    
	    layoutButtonPanel(); 
	    btnCalc.setEnabled(false);
		btnInfo.setEnabled(false);
		restaurant = new PizzaRestaurant();
		
	    this.getContentPane().add(scrollDisplay,BorderLayout.CENTER);
	    this.getContentPane().add(pnlBtn,BorderLayout.NORTH);
	    
	    repaint(); 
	    this.setVisible(true);
	}
	/**
	 * 
	 * @param Color of the panel
	 * @return A JPanel object of desired color
	 */
	private JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return jp;
	}
	/**
	 * 
	 * @param The string displayed on the button
	 * @return A JButton object with desired label
	 */
	private JButton createButton(String str) {
		JButton jb = new JButton(str); 
		jb.addActionListener(this);
		return jb; 
	}
	/**
	 * 
	 * @return Jtext area
	 */
	private JTextArea createTextArea() {
		JTextArea jta = new JTextArea(); 
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		return jta;
	}
	
	/**
	 * 
	 * @param A JPanel object, to be contained withing the JScrollPane
	 * @return A JScrollPane object
	 */
	private JScrollPane createScroll(JPanel jp){
		JScrollPane jsp = new JScrollPane(jp);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return jsp;
	}
	/**
	 * Setups a grid and adds all of the button objects to the north border panel
	 */
	private void layoutButtonPanel() {
		GridBagLayout layout = new GridBagLayout();
	    pnlBtn.setLayout(layout);
	    
	    //add components to grid
	    GridBagConstraints constraints = new GridBagConstraints(); 
	    
	    //Defaults
	    constraints.fill = GridBagConstraints.NONE;
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 100;
	    constraints.weighty = 100;
	    
	    addToPanel(pnlBtn, btnLoad,constraints,	 0,0,1,1); 
	    addToPanel(pnlBtn, btnReset,constraints,1,0,1,1); 
	    addToPanel(pnlBtn, btnInfo,constraints,  2,0,1,1); 
	    addToPanel(pnlBtn, btnCalc,constraints,3,0,1,1); 	
	}
	
	/**
     * 
     * A convenience method to add a component to given grid bag
     * layout locations. Code due to Cay Horstmann 
     *
     * @param c the component to add
     * @param constraints the grid bag constraints to use
     * @param x the x grid position
     * @param y the y grid position
     * @param w the grid width
     * @param h the grid height
     */
	private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints, int x, int y, int w, int h) {  
	      constraints.gridx = x;
	      constraints.gridy = y;
	      constraints.gridwidth = w;
	      constraints.gridheight = h;
	      jp.add(c, constraints);
	}

	@Override
	public void run() {
		createGUI();
	}
	
	public static void main(String[] args) {
	    JFrame.setDefaultLookAndFeelDecorated(false);
	}
	String line;
	Pizza currentPizza;
	@Override
	public void actionPerformed(ActionEvent e) {
		//Get event source 
		Object src=e.getSource(); 
		try {
  		//On clicking the Load button
		if (src== btnLoad){
			JButton btn = ((JButton) src);
			//Use JFileChooser to allow user to select Log file to open
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(btn);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String filename = selectedFile.getAbsolutePath();
				//Process Log file
				restaurant.processLog(filename);
				pizzaDisplay.setText(filename+ " Loaded");
				customerDisplay.setText(filename+ " Loaded");
				//If Processing complete, enable to Information and Calculation buttons
				btnCalc.setEnabled(true);
				btnInfo.setEnabled(true);
					
			}
		//On clicking the Reset button
		} else if (src==btnReset) {
			restaurant.resetDetails();
			pizzaDisplay.setText("");
			customerDisplay.setText("");
			btnCalc.setEnabled(false);
			btnInfo.setEnabled(false);
		//On clicking the Calculation button
		} else if (src==btnCalc) {
			pizzaDisplay.setText(String.format("Total profits: $%.2f",restaurant.getTotalProfit()));
			customerDisplay.setText(String.format("Total distance: %.2f Km",restaurant.getTotalDeliveryDistance()));
		//On clicking the Information button
		} else if (src==btnInfo) {
			pizzaDisplay.setText(String.format("Pizza\n%-12s %-4s %-7s %-7s %-7s","Type","Qty","Price"," Cost","  Profit\n"));
			customerDisplay.setText(String.format("Customers\n%-12s %-10s %-8s %-4s %-4s","Name","Number","Type","Loc","Dist\n"));
			
				for(int i = 0;i < restaurant.getNumPizzaOrders(); i++){
							currentPizza = restaurant.getPizzaByIndex(i);
							line = String.format("%-12s %-4d $%-7.2f $%-7.2f $%-7.2f", currentPizza.getPizzaType(),currentPizza.getQuantity(), 
									currentPizza.getOrderPrice(),currentPizza.getOrderCost(), 
									currentPizza.getOrderProfit());
							pizzaDisplay.append(line + "\n");
				}
			
		} //Catch and Display the exceptions as Error Message to the user
		} catch (CustomerException | PizzaException | LogHandlerException e1) {
			
			JOptionPane.showMessageDialog(this,e1.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
		}
	}

}
