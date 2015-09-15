package com.rhwayfun.ssh.spring.demo;


public class HelloWorld {

	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(String message){
		return "Hello" + getMessage();
	}
}
