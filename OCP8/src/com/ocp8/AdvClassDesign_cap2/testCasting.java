package com.ocp8.AdvClassDesign_cap2;

public class testCasting {
 
		public static void main( String[] args) { 
			new testCasting().test();
		}
		
		public void test() {
			Rodent rodent = new Rodent(); //debe ser new Capybara();

//			Capybara capybara = (Capybara) rodent;// Throws ClassCastException at// runtime
			
			if( rodent instanceof Capybara) { 
				Capybara capybara = (Capybara) rodent; 
			}
			

		}
		
}

class Capybara extends Rodent {}

class Rodent {}
