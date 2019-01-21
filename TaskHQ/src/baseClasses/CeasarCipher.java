package baseClasses;
public class CeasarCipher {
	private int shift;
	private String alpha, input, output;
	private char[] arr, inArr;
	
	public CeasarCipher(String input) {
		this.alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		this.input = input;
		this.arr = new char[alpha.length()];
		this.arr = alpha.toCharArray();
		this.shift = 36;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
		this.output = this.encrypt();
	}
	public CeasarCipher() {
		this.alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		this.input = "";
		this.arr = new char[alpha.length()];
		this.arr = alpha.toCharArray();
		this.shift = 36;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
	}
	
	public String encrypt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < inArr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				if(inArr[i] == arr[j]) {
					if(j + shift > alpha.length()-1) {
						int remainder = (j + shift) - alpha.length();
						int tillEnd = shift - remainder;
						if(remainder <= alpha.length()-1) { 
					
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							inArr[i] = arr[j + remainder];
							j = arr.length-1;
						}
						else if(remainder > arr.length-1) {
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							remainder = remainder % alpha.length();
							inArr[i] = arr[j + remainder];
							j = arr.length-1;
						}
					}	
					else if(j + shift <= arr.length-1) {
						inArr[i] = arr[j + shift];
						j = arr.length-1;
						}			
					}
			}
			sb.append(inArr[i]);
			
			
		}
		
		output = sb.toString();
		return output;
	}
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public String getAlpha() {
		return alpha;
	}
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public char[] getArr() {
		return arr;
	}
	public void setArr(char[] arr) {
		this.arr = arr;
	}
	public char[] getInArr() {
		return inArr;
	}
}