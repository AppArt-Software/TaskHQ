/**
***********************************************
 @Author : Akram Hannoufa
 @Last Modified: January 20th, 2019
 @Description: One of the base classes for TaskHQ. TaskStatus class holds necessary info for Task's details in TaskHQ
 @Dependencies: 
***********************************************
*/

package baseClasses;

public class TaskStatus {

	private int id; // unique to task
	private boolean posted = false; // checks if posted
	private boolean pickedUp = false; // checks if task is picked up
	private boolean accepted = false; // checks if task has been accepted
	private boolean completed = false; // checks if task is completed
	private Account worker; // holds the account of person who picked up task

	// blank constructor
	TaskStatus() {

	}

	// setters and getters
	public boolean isPosted() {
		return posted;
	}

	public void setPosted(boolean posted) {
		this.posted = posted;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Account getWorker() {
		return worker;
	}

	public void setWorker(Account worker) {
		this.worker = worker;
	}

}
