package baseClasses;
// TODO: Auto-generated Javadoc

/**
 * The Class CeasarCipher.
 */
public class CeasarCipher {
	
	/** The shift. */
	//the number of characters that the input will be shifted
	private int shift;
	
	/** The output. */
	//Strings that hold the characters being used when shifting the input, the input string and the encrypted output
	private String alpha, input, output;
	
	/** The in arr. */
	//character arrays to hold the alphabet and the input strings
	private char[] arr, inArr;
	
	/**
	 * Instantiates a new ceasar cipher.
	 *
	 * @param input the input
	 */
	public CeasarCipher(String input) {
		//alphabet being used includes capitals and numbers
		this.alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		this.input = input;
		this.arr = new char[alpha.length()];
		this.arr = alpha.toCharArray();
		//shifts each character of the input by 36 characters
		this.shift = 36;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
		//automatically encrypts input on initialization
		this.output = this.encrypt();
	}
	
	/**
	 * Instantiates a new ceasar cipher.
	 */
	public CeasarCipher() {
		this.alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		this.input = "";
		this.arr = new char[alpha.length()];
		this.arr = alpha.toCharArray();
		this.shift = 36;
		this.inArr = new char[input.length()];
		this.inArr = input.toCharArray();
	}
	
	/**
	 * Encrypt.
	 *
	 * @return the string
	 */
	public String encrypt() {
		//string builder to build output string
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < inArr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				//when the nth character in the input string matches a character in the given alphabet
				if(inArr[i] == arr[j]) {
					//if the shift will go past the end of the alphabet
					if(j + shift > alpha.length()-1) {
						int remainder = (j + shift) - alpha.length();
						int tillEnd = shift - remainder;
						if(remainder <= alpha.length()-1) { 
					
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							inArr[i] = arr[j + remainder];
							j = arr.length-1;
						}
						//if the shift minus the number of characters till the end of the alphabet will still go past the end of the alphabet
						else if(remainder > arr.length-1) {
							inArr[i] = arr[j + tillEnd-1];
							j = 0;
							remainder = remainder % alpha.length();
							inArr[i] = arr[j + remainder];
							j = arr.length-1;
						}
					}	
					//if the shift is within the alphabet
					else if(j + shift <= arr.length-1) {
						inArr[i] = arr[j + shift];
						j = arr.length-1;
						}			
					}
			}
			sb.append(inArr[i]);
			
			
		}
		
		output = sb.toString();
		//return the encrypted form of the input string
		return output;
	}
	
	/**
	 * Gets the shift.
	 *
	 * @return the shift
	 */
	public int getShift() {
		return shift;
	}
	
	/**
	 * Sets the shift.
	 *
	 * @param shift the new shift
	 */
	public void setShift(int shift) {
		this.shift = shift;
	}
	
	/**
	 * Gets the alpha.
	 *
	 * @return the alpha
	 */
	public String getAlpha() {
		return alpha;
	}
	
	/**
	 * Sets the alpha.
	 *
	 * @param alpha the new alpha
	 */
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}
	
	/**
	 * Gets the input.
	 *
	 * @return the input
	 */
	public String getInput() {
		return input;
	}
	
	/**
	 * Sets the input.
	 *
	 * @param input the new input
	 */
	public void setInput(String input) {
		this.input = input;
	}
	
	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}
	
	/**
	 * Sets the output.
	 *
	 * @param output the new output
	 */
	public void setOutput(String output) {
		this.output = output;
	}
	
	/**
	 * Gets the arr.
	 *
	 * @return the arr
	 */
	public char[] getArr() {
		return arr;
	}
	
	/**
	 * Sets the arr.
	 *
	 * @param arr the new arr
	 */
	public void setArr(char[] arr) {
		this.arr = arr;
	}
	
	/**
	 * Gets the in arr.
	 *
	 * @return the in arr
	 */
	public char[] getInArr() {
		return inArr;
	}
}