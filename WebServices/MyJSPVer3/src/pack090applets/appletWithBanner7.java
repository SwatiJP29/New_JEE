package pack090applets;


/*	 
 <APPLET CODE="appletWithBanner7.class" WIDTH=600 HEIGHT=400>
	<PARAM NAME=message VALUE = "Parameterized Moving Banner">
 </APPLET>
*/


import java.applet.*;
import java.awt.*;
public class appletWithBanner7 extends Applet implements Runnable
	{	public static String str;
		Thread t = null;
		public static boolean stopFlag;
		
		public void init()
			{	setBackground(Color.cyan);
				setForeground(Color.red);
				str=getParameter("message");
				if (str==null)
					str= "Simple Moving Banner ";
				System.out.println(str);
			}
		public void start()
			{	t=new Thread(this);
				stopFlag=false;
				t.start();
			}
		public void stop()
			{	stopFlag=true;
				t=null;
			}
		public void paint(Graphics g)
			{	g.drawString(str, 50, 30);	}
		public void run()
			{	char ch;
				for(;!stopFlag;)
					{	try{	repaint();
								Thread.sleep(250);
								ch=str.charAt(0);
								str=str.substring(1, str.length());
								str+=ch;
							}
						catch(InterruptedException e)
							{}
					}
				System.out.println("Thread ends.");
			}
	}