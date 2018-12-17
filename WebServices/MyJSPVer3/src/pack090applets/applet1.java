package pack090applets;

import java.awt.Graphics;
import java.applet.Applet;
//<APPLET CODE='applet1.class' WIDTH = 100 HEIGHT = 100
//CODEBASE='E:\D. Chandra\Java\D.Chandra New\ClassroomExercises\bin'/>
//</APPLET>

public class applet1 extends Applet 
	{	//String param1=getParameter("param");
		// \D. Chandra\Java\D.Chandra New\ClassroomExercises\classes
		public void paint(Graphics g)
			{	g.drawString("Hello World", 10, 30);
			}
	}