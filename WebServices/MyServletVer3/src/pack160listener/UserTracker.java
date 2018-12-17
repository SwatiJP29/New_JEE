package pack160listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserTracker implements HttpSessionListener
	{	public static int users=0;
		public void sessionCreated(HttpSessionEvent arg0)
			{	users++;
				System.out.println("Session Created.");
			}

		public void sessionDestroyed(HttpSessionEvent arg0)
			{	users--;
			}
		
		public static int getUsers()
			{	return users;	}
	}
