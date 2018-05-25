package com.pratiques.threads;

public class SecondaryTask {

    private Object sync; 
    
	public Object getSync() {
		return sync;
	}

	public void setSync(Object sync) {
		this.sync = sync;
	}

	public void task01() {
	
	new Thread(() -> {
				System.out.println("--  task 1");
	}); 	
	
	}
	
	public void task02() {
		
				System.out.println("--  task 2");
	
	}

}
