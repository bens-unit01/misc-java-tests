package com.pratiques.threads;

import com.pratiques.date.TimeHelper;

public class Module {
	private int timeout;
	private static int index = 0; 
	private int id; 

	public Module() {
		super();
		index++; 
		id = index; 
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void testGps() {

		int counter = 0;
		while (counter < timeout) {
			TimeHelper.delayMilliseconds(200);
			counter++; 
		}
		System.out.println("------ fin module " + id); 
	}

}
