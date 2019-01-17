import java.util.ArrayList;

public class Bio {

	private int id;
	private String skills ="";
	private int completedJobs=0;
	private int hoursWorked=0;
	private String description="";
	private String phoneNumber="";
	
	
	Bio(int id){

		this.id=id;
	}
	int getId(){
	return this.id;
	}
	
	
	String getSkills(){
		return this.skills;
	}
	
	void setSkills(String skills){
		this.skills=skills;
	}
	
	
	
	 int getCompletedJobs() {
		return completedJobs;
	}




	 void setCompletedJobs(int completedJobs) {
		this.completedJobs = completedJobs;
	}




	 int getHoursWorked() {
		return hoursWorked;
	}




	 void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}




	 String getDescription() {
		return description;
	}




	 void setDescription(String description) {
		this.description = description;
	}




	 String getPhoneNumber() {
		return phoneNumber;
	}




	 void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	 
	 
	 




	public static void main(String[] args) {
		

	}

}
