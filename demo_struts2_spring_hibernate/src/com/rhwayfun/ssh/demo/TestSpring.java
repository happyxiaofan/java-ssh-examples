package com.rhwayfun.ssh.demo;


public class TestSpring {

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
	
	public void execute(){
		System.out.println("Hello," + getMessage());
	}
}
