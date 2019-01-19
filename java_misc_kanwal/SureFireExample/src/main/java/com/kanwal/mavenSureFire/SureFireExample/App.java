package com.kanwal.mavenSureFire.SureFireExample;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main (String[] args) {
	        
	        // creating UUID      
	        UUID uid = UUID.nameUUIDFromBytes("/var/www/example.com/html/index.php".getBytes());     
	             
	        // checking UUID value
	        System.out.println("UUID value is: "+uid);    
	    }
	    
	    public Integer add(Integer n1, Integer n2) {
	        return n1 + n2;
	    }

}
