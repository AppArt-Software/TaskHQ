/**
***********************************************
 @Author : Akram Hannoufa
 @Last Modified: January 20th, 2019
 @Description: One of the base classes for TaskHQ. Review class holds necessary info for a review in TaskHQ
 @Dependencies: 
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

import org.json.JSONArray;
import org.json.JSONObject;

public class Review {

	private int id; //unique to user
	private Account subject; //subject of the review
	private Account author; //author of the review
	private String message; //message of the review
	private int rating; //user's rating
	 //constructor
	Review(int id, Account subject, Account author, String message, int rating){
		this.id=id;
		this.subject=subject;
		this.author=author;
		this.message=message;
		this.rating=rating;
		
	}
	
	Review(int rating){
		this.rating=rating;
	}
	
	//Getters
	int getId(){
		return this.id;
	}
	Account getSubject(){
		return this.subject;
	}
	Account getAuthor(){
		return this.author;
	}
	String getMessage(){
		return this.message;
	}
	int getRating(){
		return this.rating;
	}
	
	//Setters
	void setMessage(String message){
		this.message=message;
	}
	void setRating(int rating){
		this.rating=rating;
	}
	/**
	 * January 20th, 2019 createReview: Sends data to server to create a review
	 * 
	 * @param none/gets from Review object, (subject, author, message, rating)
	 * @return none
	 * @dependencies URL, bufferedWriter, OutputStream
	 * 
	 */
	 void createReview(){
		 //parameters from Review class
		String newSubject =subject.getUsername(); 
		String newAuthor = author.getUsername();
		String newMessage = message;
		String newRating = Integer.toString(rating);
		 
		URL URLcreateAccount;
		try {
			URLcreateAccount = new URL("http://104.196.62.218/CreateReview.php");// url
			HttpURLConnection httpUrlConnection = (HttpURLConnection) URLcreateAccount.openConnection();
			//open url connection
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			OutputStream outputStream = httpUrlConnection.getOutputStream();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			//format string to be sent   
			String data_string = URLEncoder.encode("subject", "UTF-8") + "=" + URLEncoder.encode(newSubject, "UTF-8") + "&" +
			           URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(newAuthor, "UTF-8")+ "&" +
					   URLEncoder.encode("message", "UTF-8") + "=" + URLEncoder.encode(newMessage, "UTF-8")+ "&" +
					   URLEncoder.encode("rating", "UTF-8") + "=" + URLEncoder.encode(newRating, "UTF-8");

			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close(); //close writer and stream
			   outputStream.close();
			 //Getting data
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
		 * January 20th, 2019 getReview: gets review info from server on user
		 * 
		 * @param String subject (of review)
		 * @return String returnString
		 * @dependencies URL, bufferedWriter, OutputStream
		 * 
		 */
	static String getReview(String subject){ 
	
		
		String JSON_STRING;
		String returnString=""; //holds string to be returned
		try {
			   URL url = new URL("http://104.196.62.218/GetReviews.php"); //url 
			   HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			   //open connection
			   httpUrlConnection.setRequestMethod("POST");
			   httpUrlConnection.setDoOutput(true);
			   OutputStream outputStream = httpUrlConnection.getOutputStream();
			   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			   //format parameter
			   String data_string = URLEncoder.encode("subject", "UTF-8") + "=" + URLEncoder.encode(subject, "UTF-8");
			   bufferedWriter.write(data_string);
			   bufferedWriter.flush();
			   bufferedWriter.close();

			   InputStream inputStream = httpUrlConnection.getInputStream(); //open input stream
			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
			   StringBuilder stringBuilder = new StringBuilder();

			   while ((JSON_STRING = bufferedReader.readLine()) != null) {
				   //builds json string
			       stringBuilder.append(JSON_STRING + "\n");
			   }

			   bufferedReader.close();
			   inputStream.close(); //close streams
			   httpUrlConnection.disconnect(); //disconnect from server
			   returnString=stringBuilder.toString().trim(); //trim string built
			

			}
		
		 catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		 return returnString;

	}
	/**
	 * January 20th, 2019 parseJSON: parses and returns data from review info
	 * 
	 * @param String JSONString, String infoRequired
	 * @return String returnString
	 * @dependencies JSONObject, JSONArray
	 * 
	 */
	static String parseJSON(String JSONText, String infoRequired){

		String returnString=""; //holds string to be returned
		JSONObject reviewDetails = null; //holds jsonObject read in
		JSONObject obj = new JSONObject(JSONText); //build JSONObject
		JSONArray values = obj.getJSONArray("values");	 //gets json array from obj
		for(int i=0;i<values.length();i++){ //get all info required
			reviewDetails = values.getJSONObject(i);
			returnString+="\n"+reviewDetails.getString(infoRequired); //builds string with required info
		}
		return returnString; //returns data
	}
	
	

}