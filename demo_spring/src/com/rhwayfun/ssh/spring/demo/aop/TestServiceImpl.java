package com.rhwayfun.ssh.spring.demo.aop;

public class TestServiceImpl implements TestService,TestService2 {

	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello," + name);
	}

	public void sayBye() {
		System.out.println("Bye," + name);
//		int i = 9/0;
	}

}
