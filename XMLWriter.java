//**********************************************//
//* Author: 1811286                            *//
//* Week: 11                                   *//
//* Description: Element 011, Hotel management *//
//* app, XMLWriter                             *//
//*                                            *//
//* Date: 01/05/2020                           *//
//*                                            *//
//**********************************************//

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class XMLWriter 
{
	public DocumentBuilderFactory dbFactory; //
	public DocumentBuilder dBuilder;
	public Document doc;
	
	public Document serverConnection()
	{
		try
	    {
	        dbFactory = DocumentBuilderFactory.newInstance();
	        dBuilder = dbFactory.newDocumentBuilder();
	        doc = dBuilder.newDocument();
	    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return doc;
	}
}