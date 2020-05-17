//**********************************************//
//* Author: 1811286                            *//
//* Week: 11                                   *//
//* Description: Element 011, Hotel management *//
//* app, main body.                            *//
//*                                            *//
//* Date: 01/05/2020                           *//
//*                                            *//
//**********************************************//

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class HotelApp extends JFrame implements ActionListener
{
	//public variables to be called throughout the code
    public BorderLayout bookingBorderLayout0; 
    public FlowLayout bookingFlowLayout0;  
    public BorderLayout bookingBorderLayout2; 
    public FlowLayout bookingFlowLayout1;      
	
	public JPanel panel_booking1; 
	public JPanel panel_booking0;
	public JPanel panel_booking2;
	public JPanel DisplayPanel;
	
	public JLabel AptSelectLabel;
	public JLabel firstNameLabel;
	public JLabel lastNameLabel;
	public JLabel maxGuestLabel;
	public JLabel bookingCateringLabel;
	public JLabel StartDateLabel;
	public JLabel EndDateLabel;
	public JLabel clientMenuOptionsLabel;
	public JLabel managerMenuOptionsLabel;
	
	public JTextField AptSelectionTextField;
	public JTextField FirstNameTextField;
	public JTextField LastNameTextField;	 
	public JTextField MaxGuestsTextField;
	public JTextField CateringBookingTextField;
	public JTextField StartDateTextField;
	public JTextField EndDateTextField;
	public JTextField clientMenuOptionsTextField;
	public JTextField managerMenuOptionsTextField;
	
	public JFrame bookingWindow;
	public JFrame DisplayFrame;
	
	public JScrollPane DisplayScrollPanel;
	
	public JButton BookingButton;	

	public Font aClientFont;
	public Font aManagerFont;
	
	public String LoginOptionNumber = "";
	public String UsernameText = "";
	public String PasswordText = "";
	public String aClientBookingAptName = "";
	public String aClientBookingFirstName = "";
	public String aClientBookingLastName = "";
	public String aClientBookingMaxGuests = "";
	public String aClientBookingStartDate = "";
	public String aClientBookingEndDate = "";
	public String aClientBookingCatering = "";
	
	public XMLBooker XMLBooker;
	
	public String[][] ApartmentsData = new String[10][9];
	public String column[]={"Apartment ID","Apartment Name", "Price per Night","Start Date", "End Date", "Max Guests", "Number Beds", "Number Baths", "Living Room"};
	
	public File inputFile;
	public DocumentBuilder dBuilder;
	public DocumentBuilderFactory dbFactory;
	public Document aBookingDoc;
	public Document writeDoc;
	
	//Client Login Details Username & password
	public String[][] clientLoginDetails = {{"John", "123"},{"Mike", "123"},{"Sid", "123"},{"Jill", "123"},{"Rose", "123"}};
	public String tempClientUsername = "";
	public String tempClientPassword = "";
	
	//Manager Login Details User & Pass
	public String[][] managerLoginDetails = {{"Manager", "321"},{"Admin", "321"},{"PrivUser", "321"},{"Man4g3r", "321"},{"Owner", "321"}};
	public String managerUsername = "";
	public String tempManagerPassword = "";
	
	public int loginCounter = 0;
	
	public boolean login = false;
	public boolean clientMenuDisplayed = false;
	public boolean clientBookingWriteReady = false;
	
	public final FlowLayout flowLayout0;
	public final BorderLayout borderLayout0;
	public final FlowLayout flowLayout3;
	public final BorderLayout borderLayout1;
	public final BorderLayout borderLayout2;
	
	public final JTextField LoginTextField;
	public final JTextField UsernameTextField;
	public final JTextField PasswordTextField;
	
	public final JLabel LoginLabel;
	public final JLabel UsernameLabel;
	public final JLabel PasswordLabel;
	public final JPanel panel0;
	public final JPanel panel1;
	public final JPanel panel2;
	public final JPanel panel3;
	//End of variables
	
  	public HotelApp()
  	{
  		super("Login Window");              //Name of the login window
  		flowLayout0 = new FlowLayout();
  		borderLayout0 = new BorderLayout();
  		borderLayout0.setHgap(12);
  		borderLayout0.setVgap(12);
  		flowLayout3 = new FlowLayout();
  		borderLayout1 = new BorderLayout();
  		borderLayout2 = new BorderLayout();
            
  												//Login options
  		LoginLabel = new JLabel("Login Options (Enter '1' for Client, and '2' for Manager)");
  		LoginTextField = new JTextField();
  		LoginTextField.addActionListener(this);
            	  
  		setLayout(flowLayout0);          
  		panel0 = new JPanel();
  		panel1 = new JPanel();
  		panel2 = new JPanel();
  		panel3 = new JPanel();

  		panel0.setLayout(borderLayout0);    
  		panel0.setVisible(true);
  		this.add(panel0);    
  		panel1.setLayout(borderLayout1);    
  		panel1.setVisible(true);
  		panel2.setLayout(borderLayout2);
  		panel2.setVisible(true);
  		panel0.add(panel1, BorderLayout.EAST);
  		this.add(panel0);   
  		panel0.add(panel2, BorderLayout.WEST);
  		this.add(panel0);
                  
  		panel3.setLayout(flowLayout3);
  		panel3.setVisible(true);
  		panel0.add(panel3, BorderLayout.SOUTH);                  
  		this.add(panel0);   
                  
  		LoginLabel.setVisible(true);
  		panel2.add(LoginLabel, BorderLayout.NORTH);
  		panel2.setVisible(true);
  		panel0.add(panel2, BorderLayout.WEST);
  		this.add(panel0);                
  		
  		LoginTextField.setVisible(true);
  		LoginTextField.setSize(120, 120);
  		panel1.add(LoginTextField, BorderLayout.NORTH);
  		panel0.add(panel1, BorderLayout.EAST);
  		panel1.setVisible(true);
  		this.add(panel0);
                  
  		UsernameLabel = new JLabel("Username: ");
  		UsernameTextField = new JTextField(50);
  		UsernameTextField.addActionListener(this);
  		UsernameLabel.setVisible(true);
  		
  		panel2.add(UsernameLabel, BorderLayout.CENTER);
        panel2.setVisible(true);
        panel0.add(panel2, BorderLayout.WEST);
        this.add(panel0);
        UsernameTextField.setSize(100, 100);
        UsernameTextField.setVisible(true);
        
        panel1.add(UsernameTextField, BorderLayout.CENTER);
        panel1.setVisible(true);
        panel0.add(panel1, BorderLayout.EAST);
        this.add(panel0);
                      
        PasswordLabel = new JLabel("Password: ");
        PasswordTextField = new JTextField(50);
        PasswordTextField.addActionListener(this);
                  
        PasswordLabel.setVisible(true);
        panel2.add(PasswordLabel, BorderLayout.SOUTH);
        panel2.setVisible(true);
        panel0.add(panel2, BorderLayout.WEST);
        this.add(panel0);
                  
        PasswordTextField.setSize(100, 100);
        PasswordTextField.setVisible(true);
        panel1.add(PasswordTextField, BorderLayout.SOUTH);
        panel1.setVisible(true);
        panel0.add(panel1, BorderLayout.EAST);
        this.add(panel0);
        
        AptSelectLabel = new JLabel("Apartment");
  		AptSelectionTextField = new JTextField(15);
  		AptSelectionTextField.addActionListener(this);
  		
  		firstNameLabel = new JLabel("First Name");
   		FirstNameTextField = new JTextField(15);
   		FirstNameTextField.addActionListener(this);
   		
   		lastNameLabel = new JLabel("Last Name");
   		LastNameTextField = new JTextField(15);
   		LastNameTextField.addActionListener(this);
   		
   		maxGuestLabel = new JLabel("Max Guests");
   		MaxGuestsTextField = new JTextField(15);
   		MaxGuestsTextField.addActionListener(this);
   		
   		StartDateLabel = new JLabel("Start Date");
   		StartDateTextField = new JTextField(15);
   		StartDateTextField.addActionListener(this);
   		
   		EndDateLabel = new JLabel("End Date");
   		EndDateTextField = new JTextField(15);
   		EndDateTextField.addActionListener(this);
   		
   		bookingCateringLabel = new JLabel("Catering Required");
   		CateringBookingTextField = new JTextField(15);
   		CateringBookingTextField.addActionListener(this);           
   		
   		DisplayFrame = new JFrame();
   		DisplayPanel = new JPanel();         
  	} 

    public void actionPerformed(ActionEvent event)
    {
    	LoginOptionNumber = LoginTextField.getText();
    	System.out.println(LoginOptionNumber);     		// Debugging message
    	
    	UsernameText = UsernameTextField.getText();
      	System.out.println(UsernameText);     			// Debugging message
    	
    	PasswordText = PasswordTextField.getText();
    	System.out.println(PasswordText);     			// Debugging message
    	
		while (login == false)
		{
			for(int i = 0; i<2; i++)
	    	{
				tempClientUsername = clientLoginDetails[i][0];
				tempClientPassword = clientLoginDetails[i][1];
				
				managerUsername = managerLoginDetails[i][0];
				tempManagerPassword = managerLoginDetails[i][1];
				
				if ((new String(UsernameText).equals(tempClientUsername)) & new String(PasswordText).equals(tempClientPassword) & new String(LoginOptionNumber).equals("1"))
				{
					System.out.println("Client Login Successful!");
					JOptionPane.showMessageDialog(null,"Client Login Successful");
					login = true;
						
					//Client Options menu
	    			StringBuilder buff = new StringBuilder();
			        buff.append("<html><table>");
			        buff.append(String.format("<tr><td align='left'>%s</td>"+ "</tr>", "Please Proceed With One Of The Options"));                     
			        buff.append(String.format("<tr><td align='left'>%s</td>" + "</tr>", "Type '1' For New booking"));
			        buff.append(String.format("<tr><td align='left'>%s</td>" + "</tr>", "Type '2' To Manage Your Booking"));
			        buff.append("</table></html>");
	             
			        aClientFont = new Font("Ariel", Font.PLAIN, 18);
			       			            
			        clientMenuOptionsLabel= new JLabel(buff.toString());    
			        clientMenuOptionsLabel.setFont(aClientFont);
			        panel3.add(clientMenuOptionsLabel, BorderLayout.NORTH);
			  		panel3.setVisible(true);
			  		panel0.add(panel3, BorderLayout.SOUTH);
			  		panel0.revalidate();
			  		panel0.repaint();
			  		this.add(panel0);
			  		
			  		clientMenuOptionsTextField = new JTextField(50);
			    	clientMenuOptionsTextField.addActionListener(this);
			    	panel3.add(clientMenuOptionsTextField, BorderLayout.SOUTH);
			  		panel3.setVisible(true);
			        panel0.add(panel3, BorderLayout.SOUTH);
			        panel0.revalidate();
			      	panel0.repaint();
			        this.add(panel0);			        
			        
			        clientMenuDisplayed = true;
			        
				}//end of if statement
				else if ((new String(UsernameText).equals(managerUsername)) & new String(PasswordText).equals(tempManagerPassword) & new String(LoginOptionNumber).equals("2"))
				{
					System.out.println("Manager Logged In");
					JOptionPane.showMessageDialog(null,"Manager Logged In");
					login = true;
					loginCounter = 3;
	
	
					//Client Options menu
	    			StringBuilder manager = new StringBuilder();
	    			manager.append("<html><table>");
	    			manager.append(String.format("<tr><td align='left'>%s</td>"+ "</tr>", "MANAGER OPTIONS"));                     
	    			manager.append(String.format("<tr><td align='left'>%s</td>" + "</tr>", "1. View ALL Bookings"));
	    			manager.append(String.format("<tr><td align='left'>%s</td>" + "</tr>", "2. Manage a Booking"));
	    			manager.append(String.format("<tr><td align='left'>%s</td>" + "</tr>", "3. EXIT"));
	    			manager.append("</table></html>");
	             
			        aManagerFont = new Font("Arial", Font.PLAIN, 18);
			       			            
			        managerMenuOptionsLabel= new JLabel(manager.toString());    
			        managerMenuOptionsLabel.setFont(aManagerFont);
			        panel3.add(managerMenuOptionsLabel, BorderLayout.NORTH);
			  		panel3.setVisible(true);
			  		panel0.add(panel3, BorderLayout.SOUTH);
			  		panel0.revalidate();
			  		panel0.repaint();
			  		this.add(panel0);
			  		
			  		managerMenuOptionsTextField = new JTextField(50);
			    	managerMenuOptionsTextField.addActionListener(this);
			    	panel3.add(managerMenuOptionsTextField, BorderLayout.SOUTH);
			  		panel3.setVisible(true);
			        panel0.add(panel3, BorderLayout.SOUTH);
			        panel0.revalidate();
			      	panel0.repaint();
			        this.add(panel0);
				}
				else
		        {
					if ((loginCounter==0) & (login==false)) //If credentials are not found it this if statement will execute.
					{
						loginCounter = loginCounter + 1;

					}
		        	
		        }//end else statement
	    	}//end for loop
		}//end while loop
		
		if(clientMenuDisplayed==true)
		{
			if (new String(clientMenuOptionsTextField.getText()).equals("1"))
			{
				System.out.println("Client Booking"); // Debugging message
	      
	      		// New Booking Window
				bookingWindow = new JFrame("Create New Booking");	
				bookingWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bookingWindow.setSize(1920, 1080);
				bookingWindow.setVisible(true);		
															//Booking Options
				bookingFlowLayout0 = new FlowLayout();
				bookingBorderLayout0 = new BorderLayout(); // booking panel
				bookingBorderLayout2 = new BorderLayout(); // booking panel
				bookingFlowLayout1 = new FlowLayout();
		      
		  		bookingWindow.setLayout(bookingFlowLayout0);     
		  		
		  		panel_booking0 = new JPanel();
		  		panel_booking1 = new JPanel();        
		  		panel_booking2 = new JPanel();
		                  
		  		panel_booking0.setLayout(bookingBorderLayout0);
		  		bookingWindow.add(panel_booking0);
		  		
		  		panel_booking1.setLayout(bookingBorderLayout2);    
		  		panel_booking1.setVisible(true);
		  		panel_booking0.add(panel_booking1, BorderLayout.NORTH);    
		  		bookingWindow.add(panel_booking0);
		  		
		  		panel_booking2.setLayout(bookingFlowLayout1);    
		  		bookingFlowLayout1.setAlignment(FlowLayout.CENTER);
		  		panel_booking2.setVisible(true);
		  		panel_booking0.add(panel_booking2, BorderLayout.SOUTH);
		  		bookingWindow.add(panel_booking0);
		  				  		
		  		
		  		clientBookingWriteReady = true;  		
		  		
			}
	    }
		
		if (clientBookingWriteReady==true) //if client goes to booking screen the following will enable
		{
			
	  		AptSelectLabel.setVisible(true); //label for apartment select
	  		panel_booking2.add(AptSelectLabel, BorderLayout.NORTH);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		AptSelectionTextField.setSize(15, 15); //label customisations
	  		AptSelectionTextField.setVisible(true);
	  		panel_booking2.add(AptSelectionTextField, BorderLayout.CENTER);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
	  		
	  		firstNameLabel.setVisible(true); //label for first name
	  		panel_booking2.add(firstNameLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		FirstNameTextField.setSize(20, 15); //customisations for label
	  		FirstNameTextField.setVisible(true);
	  		panel_booking2.add(FirstNameTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
	  		
	  		lastNameLabel.setVisible(true); //label for last name
	  		panel_booking2.add(lastNameLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		LastNameTextField.setSize(15, 15); //customisations for label
	  		LastNameTextField.setVisible(true);
	  		panel_booking2.add(LastNameTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
	  			    			  		
	  		maxGuestLabel.setVisible(true); //label for max guests
	  		panel_booking2.add(maxGuestLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		MaxGuestsTextField.setSize(15, 15); //customisations for label
	  		MaxGuestsTextField.setVisible(true);
	  		panel_booking2.add(MaxGuestsTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);

	  		StartDateLabel.setVisible(true); // booking selection start date
	  		panel_booking2.add(StartDateLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		StartDateTextField.setSize(15, 15); //customisations for start date
	  		StartDateTextField.setVisible(true);
	  		panel_booking2.add(StartDateTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
	  		
	  		EndDateLabel.setVisible(true);	//booking selection end date
	  		panel_booking2.add(EndDateLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		EndDateTextField.setSize(20, 15); //customisations for end date
	  		EndDateTextField.setVisible(true);
	  		panel_booking2.add(EndDateTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
	  		
	  		bookingCateringLabel.setVisible(true); //booking section catering
	  		panel_booking2.add(bookingCateringLabel);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH); 
	  		bookingWindow.add(panel_booking0);	    			                  
	                  
	  		CateringBookingTextField.setSize(15, 15); //customisations for catering
	  		CateringBookingTextField.setVisible(true);
	  		panel_booking2.add(CateringBookingTextField);
	  		panel_booking2.setVisible(true);
	  		panel_booking0.add(panel_booking2, BorderLayout.NORTH);
	  		bookingWindow.add(panel_booking0);
		
	  		BookingButton = new JButton("Confirm Booking"); //Booking button
	  		BookingButton.addActionListener(this);
	  		BookingButton.setActionCommand("booking");
	  		BookingButton.setVisible(true);
		  	panel_booking2.add(BookingButton);
		  	panel_booking2.setVisible(true);
		  	panel_booking0.add(panel_booking2, BorderLayout.NORTH);
		  	bookingWindow.add(panel_booking0);
		  		

	  		if ("booking".equals(event.getActionCommand())) 				//if statement for client booking
	  		{
				aClientBookingAptName = AptSelectionTextField.getText();
		  		aClientBookingFirstName = FirstNameTextField.getText();
		  		aClientBookingLastName = LastNameTextField.getText();
		  		aClientBookingMaxGuests = MaxGuestsTextField.getText();
		  		aClientBookingStartDate = StartDateTextField.getText();
		  		aClientBookingEndDate = EndDateTextField.getText();
		  		aClientBookingCatering = CateringBookingTextField.getText();
		  		
		  		writeDoc = XMLBooker.serverConnection(); //calling XML writer
		  		
		  		XMLBooker.bookingWriter(writeDoc, "C:\\Users\\Kieron\\eclipse-workspace\\Hotel App\\Bookings.xml", 
		  				aClientBookingAptName, aClientBookingFirstName, aClientBookingLastName, aClientBookingMaxGuests, aClientBookingStartDate, aClientBookingEndDate, aClientBookingCatering);  				
	  		}
		}
    }//end of the method	
}//end of the main class
    				
	