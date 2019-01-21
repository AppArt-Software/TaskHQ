/**
***********************************************
 @Author : Akram Hannoufa
 @Last Modified: January 20th, 2019
 @Description: One of the base classes for TaskHQ. Task class holds necessary info for a Task in TaskHQ
  
***********************************************
*/
package baseClasses;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Task {
	private String title; //title of task
	private static int id; //added by server
	private Account author; //author of task
	private double wage;//if pay ==0, volunteer, holds pay
	private String skillsRequired; //skills required for task
	private String start; //start date and time
	private String end; //end date and time
	private String location; //location of task
	private String description; //description of task
	private TaskStatus status; //TaskStatus of task
	private String appOrPerson; //holds whether task will be paid in cash (person) or through app
	
	//constructor
	public Task(String title, Account author, double wage, String start, String end, String location, String description, String appOrPerson, String skillsRequired){
		
		this.skillsRequired=skillsRequired;
		this.title=title;
		this.author=author;
		this.wage=wage;
		this.start=start;
		this.end=end;
		this.appOrPerson=appOrPerson;
		this.location=location;
		this.description=description;
		
	}
	
	//getters
	public int getId(){
		return this.id;
	}
	public Account getAuthour(){
		return this.author;
	}
	public double getWage(){
		return this.wage;
	}
	public String getStart(){
	return this.start;
}
	public String getEnd(){
	return this.end;
}
	
	
	public String getTitle(){
		return this.title;
	}

	
	public String getLocation(){
		return this.getLocation();
	}
	public String getDescription(){
		return this.description;
	}
	public TaskStatus getTaskStatus(){
		return this.status;
	}
	public String getAppOrPerson(){
		return this.appOrPerson;
	}
	public String getSkillsRequired(){
		return this.skillsRequired;
	}
	
	//setters
	
	public void setWage(double wage){
		this.wage=wage;
	}

	public void setStart(String start){
		this.start=start;
	}
	public void setEndTime(String end){
		this.end=end;
	}

	public void setLocation(String location){
		this.location=location;
	}
	public void setDescription(String desc){
		this.description=desc;
	}
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setAppOrPerson(String appOrPerson){
		this.appOrPerson=appOrPerson;
	}
	public void setSkillsRequired(String skillsRequired){
		this.skillsRequired=skillsRequired;
	}
	public void setTaskStatus(TaskStatus status){
		this.status=status;
	}
	
	/**
	 * January 20th, 2019 createTask: Sends data to server to create a task 
	 * 
	 * @param gets from Task object, (Strings: author, wage, start, end, skills, location, description, title, appOrPerson)
	 * @return none
	 * @dependencies URL, bufferedWriter, OutputStream, InputStream
	 * 
	 */
	public void createTask(){
		
		//parameters from  Task object
		String newAuthor = author.getUsername();;
		String newWage = Double.toString(wage);
		String newStart=start;
		String newEnd = end;
		String newSkillsRequired=skillsRequired;
		String newLocation = location;
		String newDescription = description;
		String newTitle = title;
		String newAppOrPerson = checkPaymentMethod(appOrPerson); //returns 0 for cash, 1 for through app
		
		URL URLcreateAccount;
		try {
			URLcreateAccount = new URL("http://104.196.62.218/CreateTask.php"); //create url
			HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
			//open connection
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			OutputStream outputStream = httpUrlConnection.getOutputStream(); //output stream
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   //format strings to be sent
			String data_string = URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(newAuthor, "UTF-8") + "&" +
			           URLEncoder.encode("pay", "UTF-8") + "=" + URLEncoder.encode(newWage, "UTF-8")+ "&" +
					   URLEncoder.encode("skillsRequired", "UTF-8") + "=" + URLEncoder.encode(newSkillsRequired, "UTF-8")+ "&" +
					   URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(newLocation, "UTF-8")+ "&" +
					   URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(newDescription, "UTF-8")+ "&" +
					   URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(newTitle, "UTF-8")+ "&" +
					   URLEncoder.encode("paymentType", "UTF-8") + "=" + URLEncoder.encode(newAppOrPerson, "UTF-8")+ "&" +
					   URLEncoder.encode("start", "UTF-8") + "=" + URLEncoder.encode(newStart, "UTF-8")+ "&" +
					   URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(newEnd, "UTF-8");

			   bufferedWriter.write(data_string); //write data
			   bufferedWriter.flush();
			   bufferedWriter.close(); //close streama and writer
			   outputStream.close();
			
			   InputStream inputStream = httpUrlConnection.getInputStream();
			  
			   inputStream.close();
			   httpUrlConnection.disconnect(); //disconnect from server
			  

		} catch (MalformedURLException e) {
		
			
			e.printStackTrace();
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
	}
	/**
	 * January 20th, 2019 getTaskDetails: Gets details on speciifed task
	 * 
	 * @param int id
	 * @return String returnString
	 * @dependencies URL, bufferedWriter, OutputStream, InputStream
	 * 
	 */
	public static String getTaskDetails(int id){
		String newId = Integer.toString(id); //id specific to task
		String JSON_STRING;
		String returnString=""; //holds data to be returned
		try {
			   URL url = new URL("http://104.196.62.218/GetTaskDetails.php"); //url
			   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			   //open connection
			   httpUrlConnection.setRequestMethod("POST");
			   httpUrlConnection.setDoOutput(true);
			   OutputStream outputStream = httpUrlConnection.getOutputStream();
			   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   //format parameter being sent to server 
			   String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(newId, "UTF-8");
			   bufferedWriter.write(data_string); //write date
			   bufferedWriter.flush();
			   bufferedWriter.close(); //close writer

			   //Getting data
			   InputStream inputStream = httpUrlConnection.getInputStream();
			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
			   StringBuilder stringBuilder = new StringBuilder();

			   while ((JSON_STRING = bufferedReader.readLine()) != null) {
				   //build returned data to string
			       stringBuilder.append(JSON_STRING + "\n");
			   }

			   bufferedReader.close(); 
			   inputStream.close();//close stream
			   httpUrlConnection.disconnect(); //disconnect from server
			   returnString=stringBuilder.toString().trim(); //trim string built
			
			   System.out.println("Task details " + returnString);
			}
		
		 catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			} 
		 return returnString; //return string built

	}
	/**
	 * January 20th, 2019 getTasks: Gets all tasks on TaskHQ server
	 * 
	 * @param none
	 * @return String returnString
	 * @dependencies URL, bufferedWriter, OutputStream
	 * 
	 */
	public static String getTasks(){
		
			String JSON_STRING;
			String returnString=""; //holds data returned
			try {
				   URL url = new URL("http://104.196.62.218/GetTasks.php"); //url 
				   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
				   //open connection
				   httpUrlConnection.setRequestMethod("POST");
				   httpUrlConnection.setDoOutput(true);
				   OutputStream outputStream = httpUrlConnection.getOutputStream();
				   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
				  
				   bufferedWriter.flush();
				   bufferedWriter.close();

				   
				   InputStream inputStream = httpUrlConnection.getInputStream(); //input stream
				   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
				   StringBuilder stringBuilder = new StringBuilder(); 
				   //builds string with data being read in

				   while ((JSON_STRING = bufferedReader.readLine()) != null) {

				       stringBuilder.append(JSON_STRING + "\n");
				   }

				   bufferedReader.close();
				   inputStream.close(); //close input stream
				   httpUrlConnection.disconnect(); //disconnect from server
				   returnString=stringBuilder.toString().trim(); //trim string returned
				

				}
			
			 catch (MalformedURLException e) {
				 
				   e.printStackTrace();
				} catch (IOException e) {
					
				   e.printStackTrace();
				}
			 return returnString; //return string built
	 }
	/**
	 * January 20th, 2019 updateTaskStatus: updates a task's details/status on server
	 * 
	 * @param gets from Task object (int id, booleans: posted, pickedUp, accepted, completed
	 * @return none
	 * @dependencies URL, bufferedWriter, OutputStream
	 * 
	 */
	public static void updateTaskStatus(int id, boolean posted, boolean pickedUp, boolean accepted, boolean completed){
		 //parameters from task object 
		String newId = Integer.toString(id);
		//booleans return 0 for true, 1 for false, send as string
		 String newPosted= checkIfTrue(posted); 
		 String newPickedUp = checkIfTrue(pickedUp);
		 String newAccepted = checkIfTrue(accepted);
		 String newCompleted = checkIfTrue(completed);
		 
		 URL URLcreateAccount;
			try {
				URLcreateAccount = new URL("http://104.196.62.218/UpdateTaskStatus.php"); //url
				HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
				//open connection
				httpUrlConnection.setRequestMethod("POST");
				httpUrlConnection.setDoOutput(true);
				OutputStream outputStream = httpUrlConnection.getOutputStream();
				
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
				//format data to be sent, encode   
				String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(newId, "UTF-8") + "&" +
				           URLEncoder.encode("posted", "UTF-8") + "=" + URLEncoder.encode(newPosted, "UTF-8")+ "&" +
						   URLEncoder.encode("pickedUp", "UTF-8") + "=" + URLEncoder.encode(newPickedUp, "UTF-8")+ "&" +
						   URLEncoder.encode("accepted", "UTF-8") + "=" + URLEncoder.encode(newAccepted, "UTF-8")+ "&" +
						   URLEncoder.encode("completed", "UTF-8") + "=" + URLEncoder.encode(newCompleted, "UTF-8");

				   bufferedWriter.write(data_string); //write data to server
				   bufferedWriter.flush();
				   bufferedWriter.close(); //close writer
				   outputStream.close();

				   InputStream inputStream = httpUrlConnection.getInputStream();
				  
				   inputStream.close();
				   httpUrlConnection.disconnect(); //disconnect from server
				  

			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	 }
	/**
	 * January 20th, 2019 checkIfTrue: checks values of a boolean, returns corresponding int as string
	 * 
	 * @param boolean toCheck
	 * @return String, "0" or "1"
	 * @dependencies None
	 * 
	 */
	public static String checkIfTrue(boolean toCheck){
		if(toCheck){
			return "1";
		}
		else{
			return "0";
		}
	}
	/**
	 * January 20th, 2019 checkPaymentMethod: checks values of paymentMethod (person or app)
	 * 									returns corresponsing int as string
	 * 
	 * @param String method
	 * @return String, "0" or "1"
	 * @dependencies None
	 * 
	 */
	public String checkPaymentMethod(String method){
		if(method.equals("person")){
			return "0";
		}
		else {
			return "1";
		}
	}
	/**
	 * January 20th, 2019 parseJSON: parses and returns data from task info (task details or status details)
	 * 
	 * @param String JSONString, int taskOrStatus, String infoRequired
	 * @return String returnString
	 * @dependencies JSONObject, JSONArray
	 * 
	 */
	public static String parseJSON(String JSONString,int taskOrStatus, String infoRequired){
		
		String returnString=""; //holds returned data
		
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString); //builds JSON object
		JSONObject values = obj.getJSONObject("values"); //builds object values
		JSONArray taskDetails = values.getJSONArray("taskDetails"); //array of task details
		JSONArray statusDetails=values.getJSONArray("statusDetails"); //array of status details
		if(taskOrStatus ==0){ //if required info is in task details
		for(int i=0;i<taskDetails.length();i++){
		returnData=taskDetails.getJSONObject(i);
		returnString+=returnData.getString(infoRequired)+" "; //build string with info required from taskDetails array
		}
		}
		else if(taskOrStatus==1){ //if required info is in status details
			for(int i=0;i<taskDetails.length();i++){
			returnData=statusDetails.getJSONObject(i); 
			returnString+=returnData.getString(infoRequired)+" "; //build string with info required from statusDetails array
			}
		}
		return returnString; //return data 
	}
	/**
	 * January 20th, 2019 numberOfTasks: counts total number of jobs on TaskHQ server
	 * 
	 * @param String JSONString
	 * @return int c
	 * @dependencies JSONObject, JSONArray
	 * 
	 */
	public static int numberOfTasks(String JSONString){ 
		String returnString="";
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString);
		JSONObject values = obj.getJSONObject("values");	
		JSONArray taskDetails = values.getJSONArray("taskDetails");
		JSONArray statusDetails=values.getJSONArray("statusDetails");
		int c =0;
		for(int i=0;i<taskDetails.length();i++){ //loops through each item in array
		returnData=taskDetails.getJSONObject(i);
		
		c++; //for every item in array, increase counter
		}
		return c; //return count
	}
	/**
	 * January 20th, 2019 parseJSONDetails: parses and returns data from task details
	 * 
	 * @param String JSONString, String infoRequired
	 * @return String returnString
	 * @dependencies JSONObject, JSONArray
	 * 
	 */
	public static String parseJSONDetails(String JSONString, String infoRequired){
		String returnString=""; //holds data returned
		JSONObject returnData = null; //holds object data read in
		JSONObject obj = new JSONObject(JSONString); //builds json object
		JSONArray values= obj.getJSONArray("values"); //builds array values
		for(int i=0;i<values.length();i++){
			returnData=values.getJSONObject(i); //looks at each item in array
			returnString+=returnData.getString(infoRequired)+" "; //builds string with data required
		}
		return returnString; //return data gathered
	}
	

}