
/**
***********************************************
 @Author : Akram Hannoufa
 @Last Modified: January 20th, 2019
 @Description: One of the base classes for TaskHQ. Bio class holds necessary info for a user's bio in TaskHQ
  
***********************************************
*/
package baseClasses;
import java.util.ArrayList;

public class Bio {

	private int id; //connected to account
	private String skills =""; //holds user's skills
	private int completedJobs=0; //number of jobs user has completed
	private int hoursWorked=0;//number of hours worked by user
	private String description="";//user's self-description
	private String phoneNumber="";//phone number
	
	//getters and setters
	public Bio(int id){

		this.id=id;
	}
	public int getId(){
	return this.id;
	}
	
	
	public String getSkills(){
		return this.skills;
	}
	
	public void setSkills(String skills){
		this.skills=skills;
	}
	
	
	
	public  int getCompletedJobs() {
		return completedJobs;
	}




	public  void setCompletedJobs(int completedJobs) {
		this.completedJobs = completedJobs;
	}




	public  int getHoursWorked() {
		return hoursWorked;
	}




	public  void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}




	public  String getDescription() {
		return description;
	}




	public  void setDescription(String description) {
		this.description = description;
	}




	public  String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	 
	 
	 




	public static void main(String[] args) {
		

	}

}