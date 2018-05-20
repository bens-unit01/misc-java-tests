package com.pratiques.kata;

import com.pratiques.lecture.TestBufferedReader;
import com.pratiques.lecture.TestScanner;
import com.pratiques.lecture.TestConsole; 
import com.pratiques.observer1.Observer1Test;
import com.pratiques.observer2.Observer2Test;
import com.pratiques.factory.TestFactory;
import com.pratiques.ftdi.TestFtdi;
import com.pratiques.regex.TestRegex01;
import com.pratiques.files.TestFiles01;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "App started " );
//        Observer1Test.run(); 
//        Observer2Test.run(); 
//        TestBufferedReader.run(); 
//        TestScanner.run(); 
//        TestConsole.run(); //ne marche pas sous-windows,  System.console retourne null  
//          TestFactory.run(); 
//        TestRegex01.run(); 
        TestFtdi.run();  // ne marche pas encore 
//        TestFiles01.run();  // ne marche pas encore 
        System.exit(0);
    }
}
