package com.pratiques.math;

public class TestCarte {

private static final int		CARD_FORMAT_UNDEFINE = 0; 
private static final int	    CARD_FORMAT_26BITS = 26; 
private static final int	    CARD_FORMAT_35BITS = 35; 
private static final int	    CARD_FORMAT_44BITS = 4; 
private static long u64Data;
private static int u8DataIndex;
private poCardInfoTy poCardInfo; 

	public static void run() {
	 printf("Test cartes 35bits ...\n\n"); 	
	 TestCarte t1 = new TestCarte(); 
//	 t1.u64Data = 0x00ffa4473aL;  
	 t1.u64Data = 0b00011111111101001000100011100111010L;  
	 t1.u8DataIndex = 35;  
	 t1.poCardInfo = new poCardInfoTy(); 
	 test(t1); 

	 t1.u64Data = 0b01011111111101001000100011100111010L;  
	 test(t1); 

	 t1.u64Data = 0b00011111111101001000100011100111011L;  
	 test(t1); 
	 
	 t1.u64Data = 0b10011111111101001000100011100111010L;  
	 test(t1); 
	 
     printf("-------------------------------------"); 
	}


	private static void test(TestCarte t1) {
     printf("-------------------------------------"); 
		 boolean b1 = t1.CardFormat(t1.poCardInfo, t1.u8DataIndex); 
		 boolean b2 = t1.CardParity(t1.poCardInfo, t1.u64Data); 
		 boolean b3 = t1.CardCreate(t1.poCardInfo, t1.u64Data); 
		 printf(" " + b1 + " " + b2 + " " + b3 + " data= " + t1.u64Data);
	}
	

public boolean CardFormat(poCardInfoTy poCardInfo, int u8BitCounter)
	{
	   switch(u8BitCounter)
	   {
	      case CARD_FORMAT_26BITS:
	      
	         poCardInfo.eCardFormat = CARD_FORMAT_26BITS;
	         return true;
	      case (CARD_FORMAT_35BITS):
	      
	         poCardInfo.eCardFormat = CARD_FORMAT_35BITS;
	         return true;
	      
	      case (CARD_FORMAT_44BITS):
	      
	         poCardInfo.eCardFormat = CARD_FORMAT_44BITS;
	         return true;
	      
	      default:
	      
	         System.out.println("[CARD] Format error");
	         poCardInfo.eCardFormat = CARD_FORMAT_UNDEFINE;
	         return true;
	      
	   }
	}
public boolean CardParity(poCardInfoTy poCardInfo, long u64Data)
{
   int u8Index = 0;
   int u8Parity = 0;

   switch(poCardInfo.eCardFormat)
   {
      case (CARD_FORMAT_26BITS):

         for(u8Index = 0; u8Index < 13; u8Index++)
         {
            u8Parity += (u64Data & 0x1); 
            u64Data >>= 1;
         }
         if(u8Parity % 2 == 0)
         {
            System.out.println("[CARD] Parity error 26bits 1");
            return false;
         }
         u8Parity = 0;
         for(u8Index = 13; u8Index < 26; u8Index++)
         {
            u8Parity += (u64Data & 0x1); 
            u64Data >>= 1;
         }
         if(u8Parity % 2 != 0)
         {
            System.out.println("[CARD] Parity error 26bits 2\n\r");
            return false;
         }
         return true;

      case (CARD_FORMAT_35BITS):
    	  long mask1 = 0b01110110110110110110110110110110110L; 
          long mask2 = 0b01101101101101101101101101101101101L;  

         int parity = getParity(u64Data & mask1, 35); 
         if(parity % 2 != 0)
         {
            System.out.println("[CARD] Parity error 35bits case 1 parity= " + parity);
            return false;
         }

         parity = getParity(u64Data & mask2, 35); 
         if(parity % 2 == 0)
         {
            System.out.println("[CARD] Parity error 35bits case 2 parity= " + parity);
            return false;
         }

         parity = getParity(u64Data, 35); 
         if(parity % 2 == 0)
         {
            System.out.println("[CARD] Parity error 35bits case 3 parity= " + parity);
            return false;
         }
 
         return true;

      case CARD_FORMAT_44BITS:
          //With Wiegand 44, we have 40 bits of data representing facility and card number...
          // and 4 bits of LRC... where LRC is XOR on all other 4 bits values in the 40 first bits (MSBs)
          int rxLrc = GETDATADIGIT(0);
          u8Parity = GETDATADIGIT(1);
          for(u8Index = 2; u8Index < 11; u8Index++)
          {
        	  u8Parity ^= GETDATADIGIT(u8Index);
          }
          if(u8Parity != rxLrc)
          {
//              printf("[CARD] Parity error 44 bits! rxLrc 0x%1X computedLrc 0x%1X data 0x%03x%8lx!\n" + rxLrc, u8Parity, (UINT16)(u64Data>>32), (UINT32)u64Data);
              printf("[CARD] Parity error 44 bits!");  
              return false;
          }
          return true;
      default:
         printf("[CARD] Parity error unknown format!\n\r");
         return false;
   }
}



public boolean CardCreate(poCardInfoTy poCardInfo, long u64Data)
{
   switch(poCardInfo.eCardFormat)
   {
      case (CARD_FORMAT_26BITS):
      
         // Keep bits from 1 to 16
         poCardInfo.u32CardNumber = ((u64Data >> 1) & 0xFFFF);
         // Keep bits from 17 to 24
         poCardInfo.u16FacilityCode = ((u64Data >> 17) & 0xFF);
         return true;

      case (CARD_FORMAT_35BITS):

         // Keep bits from 2 to 13
         poCardInfo.u16FacilityCode = ((u64Data >> 2) & 0x1FFF);
         // Keep bits from 14 to 34
         poCardInfo.u32CardNumber = ((u64Data >> 14) & 0xFFFFF);
         return true;

      case CARD_FORMAT_44BITS:
      
          int u32Tmp = 0;

          //If we get here, seems that LRC checked out fine...
          // so we have 4 bits of LRC in LSbs ...
          // then, 28 bits for card number
          // then, 12 bits for the facility...
          // Geothentic had issues with this implementation... seems that prior terminals
          // would send data in binary format with entered decimal value...
          // With the terminal at hand, seems that they are getting digit by digit (HEX) for mat
          // So we need to convert HEX digits to a binary value as if they were decimal digits...
          //
          // first, remove the LRC 
          u64Data = u64Data >> 4;
          
          u32Tmp = (int)(u64Data & 0x000000000FFFFFFF);
          if(!cardConvertHexValueToDecimal(u32Tmp))
              return false;

          //if we get here, we have a valid card number... !
          poCardInfo.u32CardNumber = u32Tmp;
          
          //now get the hex value for the facility code and convert...
          u32Tmp = (int)((u64Data >> 28) & 0x0000000000000FFF);
          if(!cardConvertHexValueToDecimal(u32Tmp))
              return false;
          
          poCardInfo.u16FacilityCode = (int)u32Tmp;
          return true;
      default:
         return true;
   }
}

private int getParity(long data, int size) {
 int u8Parity = 0; 	
    for(int u8Index = 0; u8Index < size; u8Index++)
    {
       u8Parity += (data & 0x1); 
       data >>= 1;
    }
	return u8Parity; 
}
private boolean cardConvertHexValueToDecimal(int u32Tmp) {
	// TODO Auto-generated method stub
	return false;
}

private static void printf(String string) {
 System.out.println(string);	
}

private int GETDATADIGIT(int digit) {

	return (int)(((int)(u64Data & ((int)0x0F << (4*digit))) >> (4*digit)) & 0x0F);
}
}
