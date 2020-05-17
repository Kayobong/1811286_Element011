//**********************************************//
//* Author: 1811286                            *//
//* Week: 11                                   *//
//* Description: Element 011, Hotel management *//
//* app, final draft.                          *//
//*                                            *//
//* Date: 01/05/2020                           *//
//*                                            *//
//**********************************************//

import javax.swing.JFrame;
public class LaunchApp //class for app
{
	private static HotelApp HTLAPP; //links to code source
           public static void main(String[] args)
               {
                 HTLAPP = new HotelApp();
                 HTLAPP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes operation
             	 HTLAPP.setSize(1000, 400); //size of the window opened
             	 HTLAPP.setVisible(true); //visibility of the app
               }

}