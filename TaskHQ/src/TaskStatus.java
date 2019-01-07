public class TaskStatus {

	
		private int id;
		private boolean posted=false;
		private  boolean pickedUp=false;
		private boolean accepted=false;
		private boolean completed =false;
		private Account worker;
		
		
		
		TaskStatus(){
			
		}
		
		
		
	 


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



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}