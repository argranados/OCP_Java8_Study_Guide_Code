package com.ocp8.AdvClassDesign_cap2;

public class Oceanographer {

	
	
	
	public void checkSound( LivesInOcean animal) { 
			animal.makeSound(); 
	} 
		
	public static void main( String[] args) { 
			Oceanographer o = new Oceanographer(); 			
			o.checkSound( new Dolphin()); 
			o.checkSound( new Whale()); 
	}
		
}

 interface LivesInOcean { 
	public void makeSound(); 
 }
 
 class Dolphin implements LivesInOcean { 
		public void makeSound() { 
			System.out.println(" whistle"); 
		} 
	} 
	
	class Whale implements LivesInOcean { 
	 
		public void makeSound() { 
			System.out.println(" sing"); 
			}
	} 

