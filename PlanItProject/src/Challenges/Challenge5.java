package Challenges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Challenge5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create the original list
		List<Person> personList= createPersons();
		
		 System.out.println("***** The orginal List ********");
		// display the original list
		displayPersonInfo(personList);
		
		//Alter the original list and remove duplicates
		personList=RemoveDuplicate(personList);
		System.out.println("------ The Altered List -------");
		// display the altered list
		displayPersonInfo(personList);
		
	
		//Calculate the average age
		int avgAge= calculateAverageAge(personList);
			System.out.println("The average age " +avgAge);
			
		// Create the original list
		List<Person> personYoungerList= PeopleYounger(personList, 33);
		System.out.println("------ People with age less than 33 -------");
		// display the altered list
		displayPersonInfo(personYoungerList);
		//Obtain a list of unique countries
		
		getDistinctNationality(personList);
				
	}
	
	//Create Person List with duplication
	public static List<Person>  createPersons()
	{
		List<Person> personList= new ArrayList<Person>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
		try {
			personList.add(new Person("John", formatter.parse("12/01/1988"),"Australian" ));
			personList.add(new Person("Abebe", formatter.parse("11/02/1986"),"Ethiopian" ));
			personList.add(new Person("John", formatter.parse("12/03/1984"),"Australian" ));
			personList.add(new Person("John", formatter.parse("12/04/1984"),"Australian" ));
			personList.add(new Person("Selam", formatter.parse("12/12/1982"),"Ethiopian" ));
			personList.add(new Person("Kevin", formatter.parse("01/08/1980"),"British" ));
			personList.add(new Person("David", formatter.parse("03/12/1980"),"British" ));
			personList.add(new Person("Solomon", formatter.parse("03/09/1990"),"Ghana" ));
			personList.add(new Person("Britiniy", formatter.parse("06/12/1988"),"Canadian" ));
			personList.add(new Person("Erika", formatter.parse("09/12/1988"),"Canadian" ));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personList;
			
	}
	

	//Alter the original list and remove duplicates
	public static List<Person> RemoveDuplicate(List<Person> personList)
	{
		 List<Person> newPersonList;
		 Map<String, Person> personMap = new LinkedHashMap<String, Person>();
		 
		// 
		 for( Person p:personList)
		 {
			// add only distinct names
			 if(!personMap.containsKey (p.getName()))
			 {
				 personMap.put(p.getName(), p);
			 }
		 }
		 
		 // the Altered list 
		 newPersonList = new ArrayList<Person>(personMap.values());
	     return newPersonList; // return the altered list
	}
	
	// display person list
	public static void displayPersonInfo(List<Person> personList)
	{
		 for( Person p:personList)
		 {
			 System.out.println(p.getName() + "  "+p.getdOB()+"  "+p.getNationality());	
			 
		 }
	}
	
	// Calculate the average age
	public static  int calculateAverageAge(List<Person> personList)
	{
		LocalDate curDate = LocalDate.now();  
		int averageAge=0;
		int sum=0;
		int size=personList.size();
		// 
		for( Person p:personList)
		 {
			sum=sum+Period.between(p.dOB, curDate).getYears();// obtain age
			//System.out.println(Period.between(p.dOB, curDate).getYears());
		 }
		
		// calculate average age
		 averageAge=sum/size;
		 
	 return averageAge;	
	}
	
		
	// Find all the people with age less than N
	public static  List<Person> PeopleYounger(List<Person> personList, int n)
	{
		LocalDate curDate = LocalDate.now();  
		int age=0;
		List<Person> newPersonList= new ArrayList<Person>();
		// 
		for( Person p:personList)
		 {
			age=Period.between(p.dOB, curDate).getYears();// 
			if(age<n) // add people with age less than N
			{
				newPersonList.add(p);
			}

		 }					
		
		 
	 return newPersonList;	
	}
				
	
	// display  list of unique countries/Nationality
	public static void getDistinctNationality(List<Person> personList)
	{
		 // get distinct nationalities for the list of people
		 List<String> distinctNationality= personList.stream()
                 .map( e -> e.getNationality() )
                 .distinct()
                 .collect(Collectors.toList());
		
			 System.out.println(" ###### Distinct NAtionalities ######");
			  System.out.println(distinctNationality);	
			
	}
}
