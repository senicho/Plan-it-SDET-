package Challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Person {
	
	String name;
	LocalDate dOB;
	String nationality;
	
	public Person(String name, Date date, String nationality) {
		super();
		this.name=name;
		this.dOB = date.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		this.nationality = nationality;
	}
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getdOB() {
		return dOB;
	}
	public void setdOB(LocalDate dOB) {
		this.dOB = dOB;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

}
