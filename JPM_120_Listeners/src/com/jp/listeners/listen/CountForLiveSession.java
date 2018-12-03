package com.jp.listeners.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CountForLiveSession implements HttpSessionListener {

    
    public CountForLiveSession() {
        System.out.println("Listener Created");
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Session Created");
    	
    	//Cart cart = new Cart(); When this object is created we can register it on the setAttribute method
    	HttpSession session = arg0.getSession();
    	//session.setAttribute("cart", cart);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Listener Destroyed");
    }
	
}