package com.pratiques.ftdi;


import java.util.List; 

public class TestFtdi {

	
	public static void run() {
		
		
		
		try {
			List<FTDevice> fTDevices;
			fTDevices = FTDevice.getDevices();
			for (FTDevice fTDevice : fTDevices) {

				System.out.println("fTDevice:" + fTDevice);
				System.out.println("fTDevice.DevType:" + fTDevice.getDevType());
				System.out.println("fTDevice.DevID:" + fTDevice.getDevID());
				System.out.println("fTDevice.DevLocationID:" + fTDevice.getDevLocationID());
				
				fTDevice.open();
				fTDevice.setBaudRate(9600);
				fTDevice.setDataCharacteristics(WordLength.BITS_8, StopBits.STOP_BITS_1, Parity.PARITY_NONE);
				fTDevice.setTimeouts(1000, 1000);

				fTDevice.setBitMode((byte)0xFF, BitModes.BITMODE_SYNC_BITBANG);
				
				// Set true (energised) or false (not energised) for each relay (1 to 4)
				boolean relayStates[] = { true, true, true, true };
				
				int value = 0;
				for (int i=0; i < relayStates.length; i++) {
					if (relayStates[i]) value += (1 << i);
				}
				fTDevice.write(value);
				
				fTDevice.close();
			}

		} catch (FTD2XXException ex) {
	//		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	} 
}
