package PPS_related_codes.LinkedList;

import java.util.Scanner;



public class Recursion1{
	
	// A recursive method that takes an integer and returns the summation  
	// of all numbers from 1 to that number.
	// For example, if the number is 8, then the method would calculate 
	// and return 36, which is (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8). 
	public static int sumNumbers(int n)
	{
		if(n <= 0)
		{
			System.out.println("You must enter an integer larger than 0." +
					" Method will return \"0\" as an indication of no calculations.");
			return 0;
		}
		
		int total = 0;
		// Simple Case (Basic Step)
		if(n == 1 )				
		{						
			total += 1;
			return total;
		}
		else
		{
			// Call myself (that same method) to calculate the total for up to n-1 then add n
			total = n + sumNumbers(n-1);
			return total;
		}
	}
  
	
	public static void main(String[] args)
  {
    	 
    	 Scanner kb = new Scanner (System.in);
    	 int i, result;
    	 
    	 System.out.print("Please enter an integer > 0 to display all integers from 1 to that number: ");
    	 i = kb.nextInt();
    	 
    	 // Call the recursive method to calculate the summation of the numbers 
    	 result = sumNumbers(i);
    	 
    	 if (result != 0)	// Calculations were made
    		 System.out.println("\nThe summation of all numbers from 1 to " + i + " is: " + result);
         kb.close();
 }
}


// import java.util.Scanner;



// public class Recursion3{
	
// 	// A recursive method that takes an integer and displays 
// 	// all previous numbers from 1 to that number.
// 	// For example, if the number is 14, then the program should display 
// 	// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
// 	public static void displayNumbers(int n)
// 	{
// 		if(n <= 0)
// 		{
// 			System.out.println("You must enter an integer larger than 0." +
// 					" Method will return.");
// 			return;
// 		}
		
// 		// Simple Case (Basic Step)
// 		if(n == 1 )				
// 		{						
// 			System.out.print(" " + n + " ");
// 		}
// 		else
// 		{
// 			// Call myself (that same method) to display the numbers up to n-1
// 			displayNumbers(n-1);
// 			// Then display n
// 			System.out.print(" " + n + " ");
// 		}
// 	}
  
	
// 	public static void main(String[] args)
//   {
    	 
//     	 Scanner kb = new Scanner (System.in);
//     	 int i;
    	 
//     	 System.out.print("Please enter an integer > 0 to display all integers from 1 to that number: ");
//     	 i = kb.nextInt();
    	 
//     	 // Call the recursive method to display the numbers 
//     	 displayNumbers(i);
    	 
//          System.out.println("\nThanks for using our recursive method. ");
//          kb.close();
//  }
// }