import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner inKey = new Scanner(System.in);
		
		System.out.println("Please Enter A Phrase");
		String s = inKey.nextLine();
		
		System.out.println("Please Enter Shift");
		int shift = inKey.nextInt();
		
		CeasarCipher cc = new CeasarCipher(s, shift);
		System.out.println(cc.encrypt());
		
	}

}
