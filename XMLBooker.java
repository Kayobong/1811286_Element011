//**********************************************//
//* Author: 1811286                            *//
//* Week: 11                                   *//
//* Description: Element 011, Hotel management *//
//* app, XML booker                            *//
//*                                            *//
//* Date: 01/05/2020                           *//
//*                                            *//
//**********************************************//

import javax.swing.JOptionPane;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;


public class XMLBooker extends XMLWriter
{
	public Element rootElement; 
	public Element initialBooking;
	public Element aptName;
	public Attr attr;
	public Element FirstName; 
	public Element LastName;
	public Element maxGuests0;
	public Element startDate;
	public Element endDate;
	public Element catering;
	public TransformerFactory transformerFactory;
	public Transformer transformer;
	public DOMSource source;
	public StreamResult result;
	public  StreamResult consoleResult;
	public int SecID = 101;
    	
	
	public void bookingWriter(Document doc, String filenameToWrite, String clientApartmentName, String clientFirstName, String clientLastName, String maxGuests,
			String bookingStartDate, String bookingEndDate, String bookingCatering)
	{
		try
		{														//Initial element of the XML
	        rootElement = doc.createElement("bookings");
	        doc.appendChild(rootElement);
			 
																// booking element
	        initialBooking = doc.createElement("clientbooking");
	        rootElement.appendChild(initialBooking);
			
	        attr = doc.createAttribute("ID");
	        
	        SecID = SecID + 1;	        						//creating a secure ID
	        attr.setValue(Integer.toString(SecID));	        
	        JOptionPane.showMessageDialog(null, "Your booking ID is:  " + SecID);
	        
	        initialBooking.setAttributeNode(attr);
	       
	       														// booking element
	        aptName = doc.createElement("apartmentname");
	        aptName.appendChild(doc.createTextNode(clientApartmentName));
	        initialBooking.appendChild(aptName); 
			
																// booking element
	        FirstName = doc.createElement("firstname");
	        FirstName.appendChild(doc.createTextNode(clientFirstName));
	        initialBooking.appendChild(FirstName); 
		 
																// booking element
			LastName = doc.createElement("lastname");
	        LastName.appendChild(doc.createTextNode(clientLastName));
	        initialBooking.appendChild(LastName); 
			
																// booking element
			maxGuests0 = doc.createElement("numberguests");
	        maxGuests0.appendChild(doc.createTextNode(maxGuests));
	        initialBooking.appendChild(maxGuests0); 
			
																// booking element
			startDate = doc.createElement("startdate");
	        startDate.appendChild(doc.createTextNode(bookingStartDate));
	        initialBooking.appendChild(startDate); 
			
																// booking element
			endDate = doc.createElement("enddate");
			endDate.appendChild(doc.createTextNode(bookingEndDate));
			initialBooking.appendChild(endDate);
		
																// booking element
			catering = doc.createElement("catering");
			catering.appendChild(doc.createTextNode(bookingCatering));
			initialBooking.appendChild(catering);
	
																// produce the values onto an xml file
	        transformerFactory = TransformerFactory.newInstance();
	        transformer = transformerFactory.newTransformer();
			
	        source = new DOMSource(doc);
	       
			result = new StreamResult(new File(filenameToWrite));
	        transformer.transform(source, result);
		}
        catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}