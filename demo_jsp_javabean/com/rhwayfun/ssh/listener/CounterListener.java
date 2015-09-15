package com.rhwayfun.ssh.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterListener implements HttpSessionListener {

	public static int count = 0;
	
	public void sessionCreated(HttpSessionEvent se) {
		count++;
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		if(count > 0)
			count--;
	}
	
	public static int getCount(){
		return count;
	}
}
