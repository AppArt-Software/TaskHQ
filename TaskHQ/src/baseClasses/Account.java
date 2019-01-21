/**
***********************************************
 @Author : Akram Hannoufa
 @Last Modified: January 20th, 2019
 @Description: One of the base classes for TaskHQ. Account class holds necessary info for a user in TaskHQ
 @Dependencies: 
***********************************************
*/



package baseClasses;


import java.io.*;
import java.net.MalformedURLException;
import java.net.*;
import java.util.*;

import org.json.*;

//Account Class
public class Account {

	public  static int id; //set by scripts
	static private String username; //email
	static private String firstName; //user first name
	static private String lastName; //user last name
	static private String password; //user password
	static private int age; //user age
	
	private static Bio bio; //user bio, uses Bio class
	private Review reviews; //user reviews, uses Review class
	
	//Constructor
	/**
	 * January 20th, 2019 Account: Constructor for account class in TaskHQ
	 * 
	 * @param String userName, String firstName, String lastName, String password, int age
	 * @return 
	 * @dependencies none
	 * 
	 */
	public Account(String userName, String firstName, String lastName, String password, int age){
		this.username=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.age=age;
		
	}
	//Getters
	public int getId(){
		return this.id;
	}
	public String getUsername(){
		return this.username;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getPassword(){
		return this.password;
	}
	public int getAge(){
		return this.age;
	}
	public Bio getBio(){
		return this.bio;
	}
	
	//Setters
	
	public void setId(int id){
		this.id=id;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setBio(Bio bio){
		this.bio=bio;
	}
	
	/**
	 * January 20th, 2019 createAccount: Sends data to server to create account
	 * 
	 * @param none/gets from Account object, (username, firstName, lastName, password, age)
	 * @return none
	 * @dependencies URL, bufferedWriter, OutputStream
	 * 
	 */
	public void createAccount(){
		//parameters from object
		String newUsername =username; 
		String newFirstName =firstName;
		String newLastName=lastName;
		String newPassword=password;
		String newAge=Integer.toString(age);
		
		 
		URL URLcreateAccount;
		try {
			URLcreateAccount = new URL("http://104.196.62.218/CreateAccount.php"); //create url to server
			HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection(); //open connection
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			OutputStream outputStream = httpUrlConnection.getOutputStream();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			  //format data 
			String data_string = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(newUsername, "UTF-8") + "&" +
			           URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(newFirstName, "UTF-8")+ "&" +
					   URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(newLastName, "UTF-8")+ "&" +
					   URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(newPassword, "UTF-8")+ "&" +
					   URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(newAge, "UTF-8");

			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close(); //close stream
			   outputStream.close();

			   InputStream inputStream = httpUrlConnection.getInputStream();
			  
			   inputStream.close();
			   httpUrlConnection.disconnect();//disconnect from server
			  

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		 
		 

}
	/**
	 * January 20th, 2019 updateAccount: Updates account info on server
	 * 
	 * @param String userName, String firstName, String lastName, String password, int age, Strings: skills, completedJobs, hoursWorked, description
	 * 			phoneNumber
	 * @return none
	 * @dependencies URL, bufferedWriter, OutputStream
	 * 
	 */
	public static void updateAccount(){ 
		//all parameters taken from current object and ucrrent object Bio
		String newUsername =username; 
		String newFirstName =firstName;
		String newLastName=lastName;
		String newPassword=password;
		String newAge=Integer.toString(id);
		String newSkills = bio.getSkills().toString();
		//data from bio
		String newCompletedJobs =Integer.toString(bio.getCompletedJobs());
		String newHoursWorked = Integer.toString(bio.getHoursWorked());
		String newDescription = bio.getDescription();
		String newPhoneNumber = bio.getPhoneNumber();
		
		 
		URL URLcreateAccount;
		try {
			URLcreateAccount = new URL("http://104.196.62.218/UpdateAccount.php"); //create URL to correct server
			HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
			//open connection 
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			OutputStream outputStream = httpUrlConnection.getOutputStream();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   //format data to be sent to server
			String data_string = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(newUsername, "UTF-8") + "&" +
			           URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(newFirstName, "UTF-8")+ "&" +
					   URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(newLastName, "UTF-8")+ "&" +
					   URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(newPassword, "UTF-8")+ "&" +
					   URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(newAge, "UTF-8")+ "&" +
					   URLEncoder.encode("skills", "UTF-8") + "=" + URLEncoder.encode(newSkills, "UTF-8")+ "&" +
					   URLEncoder.encode("completedJobs", "UTF-8") + "=" + URLEncoder.encode(newCompletedJobs, "UTF-8")+ "&" +
					   URLEncoder.encode("hoursWorked", "UTF-8") + "=" + URLEncoder.encode(newHoursWorked, "UTF-8")+ "&" +
					   URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(newDescription, "UTF-8")+ "&" +
					   URLEncoder.encode("phoneNumber", "UTF-8") + "=" + URLEncoder.encode(newPhoneNumber, "UTF-8");

			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close();
			   outputStream.close(); //close stream
			 
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
	 * January 20th, 2019 getAccount: gets account info from server
	 * 
	 * @param String userName
	 * @return String returnString
	 * @dependencies URL, bufferedWriter, OutputStream, InputStream
	 * 
	 */
	
	public static String getAccount(String userName){
		
		String JSON_STRING;
		String returnString=""; //holds account info to be returned
		try {
			   URL url = new URL("http://104.196.62.218/GetAccount.php"); //create url
			   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection(); //open connection
			   httpUrlConnection.setRequestMethod("POST");
			   httpUrlConnection.setDoOutput(true);
			   OutputStream outputStream = httpUrlConnection.getOutputStream();
			   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   String data_string = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8");
			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close();

			   
			   InputStream inputStream = httpUrlConnection.getInputStream(); //create input stream
			  //setup reader
			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
			   StringBuilder stringBuilder = new StringBuilder(); //string builder to receive JSON data

			   while ((JSON_STRING = bufferedReader.readLine()) != null) {

			       stringBuilder.append(JSON_STRING + "\n"); //builds string from data being received
			   }

			   bufferedReader.close(); //close reader
			   inputStream.close(); //close input
			   httpUrlConnection.disconnect(); //disconnect from server
			   returnString=stringBuilder.toString().trim(); //trim adn return data string
			

			}
		
		 catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		 return returnString;

	}
	
	/**
	 * January 20th, 2019 parseJSON: parses and returns data from account info
	 * 
	 * @param String JSONString, int accountOrBio, String infoRequired
	 * @return String returnString
	 * @dependencies JSONObject, JSONArray
	 * 
	 */
	public static String parseJSON(String JSONString,int accountOrBio, String infoRequired){ 
		
		if (JSONString.length() > 0) {
		String returnString=""; //holds data to be returned
		JSONObject returnData = null; 
		JSONObject obj = new JSONObject(JSONString); //build JSONObject
		JSONObject values = obj.getJSONObject("values");	 //gets values object
		JSONArray accountDetailsArray = values.getJSONArray("accountDetails"); //account details JSONarray
		JSONArray bioDetailsArray = values.getJSONArray("bioDetails");//bio details JSONarray
		for(int i=0;i<accountDetailsArray.length();i++){
			
			if(accountOrBio==0){ //returns required data from account
				returnData = accountDetailsArray.getJSONObject(i);
				returnString += returnData.getString(infoRequired)+"\t";
			}
			
			else if(accountOrBio==1){ //return required data from bio
				returnData = bioDetailsArray.getJSONObject(i);
				returnString+=returnData.getString(infoRequired)+"\t";
			}
		
		
		}
		
		return returnString; //returns data as string
		} else {
			return null;
		}
		
	}
	
	
public static void main(String[] args) {

	
}
}