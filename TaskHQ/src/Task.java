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
	
	Task(String title, Account author, double wage, String start, String end, String location, String description, String appOrPerson, String skillsRequired){
		
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
	int getId(){
		return this.id;
	}
	Account getAuthour(){
		return this.author;
	}
	double getWage(){
		return this.wage;
	}
String getStart(){
	return this.start;
}
String getEnd(){
	return this.end;
}
	
	
	String getTitle(){
		return this.title;
	}

	
	String getLocation(){
		return this.getLocation();
	}
	String getDescription(){
		return this.description;
	}
	TaskStatus getTaskStatus(){
		return this.status;
	}
	String getAppOrPerson(){
		return this.appOrPerson;
	}
	String getSkillsRequired(){
		return this.skillsRequired;
	}
	
	//setters
	
	void setWage(double wage){
		this.wage=wage;
	}

	void setStart(String start){
		this.start=start;
	}
	void setEndTime(String end){
		this.end=end;
	}

	void setLocation(String location){
		this.location=location;
	}
	void setDescription(String desc){
		this.description=desc;
	}
	void setTitle(String title){
		this.title=title;
	}
	
	void setAppOrPerson(String appOrPerson){
		this.appOrPerson=appOrPerson;
	}
	void setSkillsRequired(String skillsRequired){
		this.skillsRequired=skillsRequired;
	}
	
	
	 void createTask(){
		
		
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
	 static String getTaskDetails(int id){
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
			

			}
		
		 catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		 return returnString;

	}
	 static String getTasks(){
		
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
	 void updateTaskStatus(){
		 String newId = Integer.toString(id);
		 String newPosted= checkIfTrue(status.isPosted());
		 String newPickedUp = checkIfTrue(status.isPickedUp());
		 String newAccepted = checkIfTrue(status.isAccepted());
		 String newCompleted = checkIfTrue(status.isCompleted());
		 URL URLcreateAccount;
			try {
				URLcreateAccount = new URL("http://104.196.62.218/UpdateAccount.php");
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
	String checkIfTrue(boolean toCheck){
		if(toCheck){
			return "1";
		}
		else{
			return "0";
		}
	}
	String checkPaymentMethod(String method){
		if(method.equals("person")){
			return "0";
		}
		else {
			return "1";
		}
	}
	
	static String parseJSON(String JSONString, String infoRequired){
		//System.out.println(JSONString);
		String returnString="";
		JSONObject returnData = null;
		JSONObject obj = new JSONObject(JSONString);
		JSONObject values = obj.getJSONObject("values");
		JSONArray taskDetails = values.getJSONArray("taskDetails");
		JSONArray statusDetails=values.getJSONArray("statusDetails");
		
		for(int i=0;i<taskDetails.length();i++){
		returnData=taskDetails.getJSONObject(i);
		returnString+=returnData.getString(infoRequired)+" ";
		}
		return returnString;
	}
	static int numberOfTasks(String JSONString){ //task details, status details arrays
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
	static String parseJSON(String JSONString){
		String returnString="";
		//return all info about all available tasks
		return null;
	}
	public static void main(String[] args) {
		System.out.println(getTasks());
		//System.out.println(parseJSON(getTasks(), "title"));
	}

}
