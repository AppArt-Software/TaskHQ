package baseClasses;
import java.util.ArrayList;

public class Bio {

	private int id;
	private String skills ="";
	private int completedJobs=0;
	private int hoursWorked=0;
	private String description="";
	private String phoneNumber="";
	
	
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
