package com.pratiques.math;

public class TestLimitVitesse {

	int i32MaxSpeed = 20, i32MinSpeed = 0; 
	int speedSum = 0; 
	boolean  bisNewPing = false;
	boolean  isSmooting = true;  // mettre à false si on veut les vitesse brutes 
	
//    static int data[] = {10 , 15, 20, 30, 27, 28, 33, 38, 42, 55, 58, 60, 61, 65, 62, 55, 52, 48, 45, 40 }; 
//    static int data[] = {4 , 7, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 15, 29, 39, 40 }; 
//    static int data[] =  {23, 41, 4, 0, 0, 18, 39, 40, 43, 43, 35, 36, 7, 5, 3, 7, 40, 26, 15, 4, 0 }; // module :Aspundth - 19 nov - lignes 84 - 105 
//static int data[] =  {0, 12, 31, 2, 38, 42, 43, 17, 16, 16, 32, 25, 27, 14, 16, 16, 0, 0, 0, 0, 0, 1, 5, 10, 1, 13, 13, 14, 0, 38};  // module :Aspundth - 4 dec - lignes 11 - 40 
static int data[] =  { 0, 
	    6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9,	
		10, 24, 23, 15, 20, 12, 0, 12, 31, 2, 
		2, 5, 8, 8, 9, 13, 17, 20, 20,
		38, 42,  
		43, 40, 35, 30, 20, 19, 19, 18, 16, 14, 12, 10, 10, 10, 8, 7, 6, 6,   
		17, 16, 16, 32, 25, 27, 14, 16, 16, 0, 0, 0, 1, 5, 10, 1, 13, 13, 14, 0, 38};  // module :Aspundth - 4 dec - lignes 11 - 40 en ajoutant des valeurs intermediaires 


	public static void run() {
	System.out.println("test begin ...");
	System.out.println("________________________________________________________________________________");
	System.out.println("|\tindex\t|    raw-speed\t|smoothed-speed |speed min/max | trigger event|");
	System.out.println("________________________________________________________________________________");

	
	TestLimitVitesse test = new TestLimitVitesse(); 	
	test.i32MaxSpeed = 80; 
	test.i32MinSpeed = 60; 
		for(int i = 0; i < data.length; i++) {
			test.refresh2(data[i], i); 
		}
		
		
	System.out.println("________________________________________________________________________________");
	System.out.println("test end ...");

	}

	
    public void refresh2(int u32Speed, int index) {	
       int calculatedSpeed = 0;     

      if(isSmooting) {
    	  int old_speed = speedSum; 
      speedSum = speedSum + u32Speed - (speedSum >> 2); 
      calculatedSpeed = (speedSum >> 2); 
      } else {
    	  
      calculatedSpeed = u32Speed;  // enl 
      }

	  if(calculatedSpeed >= i32MaxSpeed ){
		  if(i32MaxSpeed < 80)
		  {
			  i32MinSpeed = i32MaxSpeed - 10;
			  i32MaxSpeed += 20;
			  bisNewPing = true;
		  }
	  }
	  else
	  {
		  if(calculatedSpeed < i32MinSpeed)
		  {
			  i32MaxSpeed -= 20;
			  i32MinSpeed = i32MaxSpeed - 30;
			  bisNewPing = true;
		  }
	  }

	  i32MinSpeed = (i32MinSpeed < 50)? 50 : i32MinSpeed;
	  i32MaxSpeed = (i32MaxSpeed < 80)? 80 : i32MaxSpeed;

	  if(bisNewPing)
	  {
//          un ping sera généré ici 
          bisNewPing = false;
          System.out.println("|\t " + index + "\t|\t " + u32Speed + "\t|\t " + calculatedSpeed + "\t|\t" + i32MinSpeed +" - " + i32MaxSpeed + "\t|\t*\t|");

	  }
	  else
	  {
          System.out.println("|\t " + index + "\t|\t " + u32Speed + "\t|\t " + calculatedSpeed + "\t|\t" + i32MinSpeed +" - " + i32MaxSpeed + "\t|\t \t|");
	  }
	  
    }
    public void refresh(int u32Speed, int index) {	

      int calculatedSpeed = 0;     

      if(isSmooting) {
    	  int old_speed = speedSum; 
      speedSum = speedSum + u32Speed - (speedSum >> 2); 
      calculatedSpeed = (speedSum >> 2); 
      } else {
    	  
      calculatedSpeed = u32Speed;  // enl 
      }

	  if(calculatedSpeed >= i32MaxSpeed ){
		  if(i32MaxSpeed < 80)
		  {
			  i32MinSpeed = i32MaxSpeed - 10;
			  i32MaxSpeed += 20;
			  bisNewPing = true;
		  }
	  }
	  else
	  {
		  if(calculatedSpeed < i32MinSpeed)
		  {
			  i32MaxSpeed -= 20;
			  i32MinSpeed = i32MaxSpeed - 30;
			  bisNewPing = true;
		  }
	  }

	  i32MinSpeed = (i32MinSpeed < 0)? 0 : i32MinSpeed;
	  i32MaxSpeed = (i32MaxSpeed < 20)? 20 : i32MaxSpeed;

	  if(bisNewPing)
	  {
//          un ping sera généré ici 
          bisNewPing = false;
          System.out.println("|\t " + index + "\t|\t " + u32Speed + "\t|\t " + calculatedSpeed + "\t|\t" + i32MinSpeed +" - " + i32MaxSpeed + "\t|\t*\t|");

	  }
	  else
	  {
          System.out.println("|\t " + index + "\t|\t " + u32Speed + "\t|\t " + calculatedSpeed + "\t|\t" + i32MinSpeed +" - " + i32MaxSpeed + "\t|\t \t|");
	  }
	  

    }

}
