
public class CeasarCipher {
	private int shift;
	private String alpha, input, output;
	private char[] arr, inArr;
	
	public CeasarCipher(String input, int shift) {
		this.alpha = "abcdefghijklmnopqrstuvwxyz";
		this.input = input;
		this.arr = new char[26];
		this.arr = alpha.toCharArray();
		this.shift = shift;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
	}
	public CeasarCipher() {
		this.alpha = "abcdefghijklmnopqrstuvwxyz";
		this.input = "";
		this.arr = new char[26];
		this.arr = alpha.toCharArray();
		this.shift = 0;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
	}
	
	public String encrypt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < inArr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				if(inArr[i] == arr[j]) {
					if(j + shift > 25) {
						int difference = 25 - (j + shift);
						int remainder = (j + shift) - 26;
						int tillEnd = shift - remainder;
						if(remainder <= 25) { 
					
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							inArr[i] = arr[j + remainder];
							j = 25;
						}
						else if(remainder > 25) {
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							remainder = remainder%26;
							inArr[i] = arr[j + remainder];
							j = 25;
						}
					}	
					else if(j + shift <= 25) {
						inArr[i] = arr[j + shift];
						j = 25;
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
