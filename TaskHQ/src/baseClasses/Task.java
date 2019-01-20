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
	private String title; //add stuff 
	private static int id;
	private Account author;
	private double wage;//if pay ==0, volunteer
	private String skillsRequired;
	private String start;
	private String end;
	private String location;
	private String description;
	private TaskStatus status;
	private String appOrPerson;
	
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
	
	
	public void createTask(){
		
		
		String newAuthor = author.getUsername();;
		String newWage = Double.toString(wage);
		String newStart=start;
		String newEnd = end;
		String newSkillsRequired=skillsRequired;
		String newLocation = location;
		String newDescription = description;
		String newTitle = title;
		String newAppOrPerson = checkPaymentMethod(appOrPerson);
		
		URL URLcreateAccount;
		try {
			URLcreateAccount = new URL("http://104.196.62.218/CreateTask.php");
			HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			OutputStream outputStream = httpUrlConnection.getOutputStream();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   String data_string = URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(newAuthor, "UTF-8") + "&" +
			           URLEncoder.encode("pay", "UTF-8") + "=" + URLEncoder.encode(newWage, "UTF-8")+ "&" +
					   URLEncoder.encode("skillsRequired", "UTF-8") + "=" + URLEncoder.encode(newSkillsRequired, "UTF-8")+ "&" +
					   URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(newLocation, "UTF-8")+ "&" +
					   URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(newDescription, "UTF-8")+ "&" +
					   URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(newTitle, "UTF-8")+ "&" +
					   URLEncoder.encode("paymentType", "UTF-8") + "=" + URLEncoder.encode(newAppOrPerson, "UTF-8")+ "&" +
					   URLEncoder.encode("start", "UTF-8") + "=" + URLEncoder.encode(newStart, "UTF-8")+ "&" +
					   URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(newEnd, "UTF-8");

			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close();
			   outputStream.close();
			 //Getting data
			   InputStream inputStream = httpUrlConnection.getInputStream();
			  
			   inputStream.close();
			   httpUrlConnection.disconnect();
			  

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getTaskDetails(int id){
		String newId = Integer.toString(id);
		String JSON_STRING;
		String returnString="";
		try {
			   URL url = new URL("http://104.196.62.218/GetTaskDetails.php");
			   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			   httpUrlConnection.setRequestMethod("POST");
			   httpUrlConnection.setDoOutput(true);
			   OutputStream outputStream = httpUrlConnection.getOutputStream();
			   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(newId, "UTF-8");
			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close();

			   //Getting data
			   InputStream inputStream = httpUrlConnection.getInputStream();
			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
			   StringBuilder stringBuilder = new StringBuilder();

			   while ((JSON_STRING = bufferedReader.readLine()) != null) {

			       stringBuilder.append(JSON_STRING + "\n");
			   }

			   bufferedReader.close();
			   inputStream.close();
			   httpUrlConnection.disconnect();
			   returnString=stringBuilder.toString().trim();
			
			   System.out.println("Task details " + returnString);
			}
		
		 catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		 return returnString;

	}
	public static String getTasks(){
		
			String JSON_STRING;
			String returnString="";
			try {
				   URL url = new URL("http://104.196.62.218/GetTasks.php");
				   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
				   httpUrlConnection.setRequestMethod("POST");
				   httpUrlConnection.setDoOutput(true);
				   OutputStream outputStream = httpUrlConnection.getOutputStream();
				   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
				  // String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(newId, "UTF-8");
				   //bufferedWriter.write(data_string);
				   bufferedWriter.flush();
				   bufferedWriter.close();

				   //Getting data
				   InputStream inputStream = httpUrlConnection.getInputStream();
				   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
				   StringBuilder stringBuilder = new StringBuilder();

				   while ((JSON_STRING = bufferedReader.readLine()) != null) {

				       stringBuilder.append(JSON_STRING + "\n");
				   }

				   bufferedReader.close();
				   inputStream.close();
				   httpUrlConnection.disconnect();
				   returnString=stringBuilder.toString().trim();
				

				}
			
			 catch (MalformedURLException e) {
				   e.printStackTrace();
				} catch (IOException e) {
				   e.printStackTrace();
				}
			 return returnString;
	 }
	public static void updateTaskStatus(int id, boolean posted, boolean pickedUp, boolean accepted, boolean completed){
		 String newId = Integer.toString(id);
		 String newPosted= checkIfTrue(posted);
		 String newPickedUp = checkIfTrue(pickedUp);
		 String newAccepted = checkIfTrue(accepted);
		 String newCompleted = checkIfTrue(completed);
		 
		 URL URLcreateAccount;
			try {
				URLcreateAccount = new URL("http://104.196.62.218/UpdateTaskStatus.php");
				HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
				httpUrlConnection.setRequestMethod("POST");
				httpUrlConnection.setDoOutput(true);
				OutputStream outputStream = httpUrlConnection.getOutputStream();
				
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
				   String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(newId, "UTF-8") + "&" +
				           URLEncoder.encode("posted", "UTF-8") + "=" + URLEncoder.encode(newPosted, "UTF-8")+ "&" +
						   URLEncoder.encode("pickedUp", "UTF-8") + "=" + URLEncoder.encode(newPickedUp, "UTF-8")+ "&" +
						   URLEncoder.encode("accepted", "UTF-8") + "=" + URLEncoder.encode(newAccepted, "UTF-8")+ "&" +
						   URLEncoder.encode("completed", "UTF-8") + "=" + URLEncoder.encode(newCompleted, "UTF-8");

				   bufferedWriter.write(data_string);
				   bufferedWriter.flush();
				   bufferedWriter.close();
				   outputStream.close();
				 //Getting data
				   InputStream inputStream = httpUrlConnection.getInputStream();
				  
				   inputStream.close();
				   httpUrlConnection.disconnect();
				  

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	public static String checkIfTrue(boolean toCheck){
		if(toCheck){
			return "1";
		}
		else{
			return "0";
		}
	}
	public String checkPaymentMethod(String method){
		if(method.equals("person")){
			return "0";
		}
		else {
			return "1";
		}
	}
	
	public static String parseJSON(String JSONString,int taskOrStatus, String infoRequired){
		//System.out.println(JSONString);
		String returnString="";
		System.out.println(JSONString);
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString);
		JSONObject values = obj.getJSONObject("values");
		JSONArray taskDetails = values.getJSONArray("taskDetails");
		JSONArray statusDetails=values.getJSONArray("statusDetails");
		if(taskOrStatus ==0){
		for(int i=0;i<taskDetails.length();i++){
		returnData=taskDetails.getJSONObject(i);
		returnString+=returnData.getString(infoRequired)+" ";
		}
		}
		else if(taskOrStatus==1){
			for(int i=0;i<taskDetails.length();i++){
			returnData=statusDetails.getJSONObject(i);
			returnString+=returnData.getString(infoRequired)+" ";
			}
		}
		return returnString;
	}
	public static int numberOfTasks(String JSONString){ //task details, status details arrays
		String returnString="";
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString);
		JSONObject values = obj.getJSONObject("values");	
		JSONArray taskDetails = values.getJSONArray("taskDetails");
		JSONArray statusDetails=values.getJSONArray("statusDetails");
		int c =0;
		for(int i=0;i<taskDetails.length();i++){
		returnData=taskDetails.getJSONObject(i);
		//returnString +="\n"+returnData.getString(infoRequired);
		c++;
		}
		return c;
	}
	public static String parseJSONDetails(String JSONString, String infoRequired){
		String returnString="";
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString);
		JSONArray values= obj.getJSONArray("values");
		for(int i=0;i<values.length();i++){
			returnData=values.getJSONObject(i);
			returnString+=returnData.getString(infoRequired)+" ";
		}
		return returnString;
	}
	public static void main(String[] args) {
		//System.out.println(parseJSON(getTaskDetails(3),"author"));
		//System.out.println(parseJSONDetails(Task.getTaskDetails(3), ""));
		System.out.println(parseJSON(getTasks(), 1, "pickedUp"));
	}

}