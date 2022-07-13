package Challenges;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Challenge2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan= new Scanner (System.in);// create scanner object 
		
		System.out.println("Enter the string ");
		
		String strInput= scan.nextLine();// read user input
		
		scan.close(); // close scanner object
		
		if(!strInput.isEmpty())
		{
			char ch= highestOccur(strInput);		
			System.out.println(ch + " has the highest number of occurrences");
		}

	}
	// find the character that has the highest number of occurrences
	public static char highestOccur(String strInput)
	{
		int count=0;
		int countPrev=0;
		int indx=0; 
		
		// convert string to char array
		char charArray[]= strInput.toCharArray();
		
		
		for(int i=0;i<charArray.length;i++)
		{
			count=0;
			for(int j=0;j<charArray.length;j++)
			{
				if(charArray[i]==charArray[j])
				{
					count=count+1;
					if(count>countPrev) // check no of occurrence to the previous 
					{
						indx=i;
					}
				}
				else
				{
					if(count>countPrev)
					{
						countPrev=count;
						indx=i;
					}
				}
					
			}
		}
		
		return charArray[indx];
	}
}
