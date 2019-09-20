package silva_p1;
import java.util.Scanner; 

public class Decrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input, d1, d2, d3, d4;
		
		System.out.println("Enter number to decrypt:");
		input = scnr.nextInt();
		scnr.close();
		
		d4 = input % 10;
		d3 = (input / 10) % 10;
		d2 = (input / 100) % 10;
		d1 = (input / 1000) % 10;
		
		
		
	}

}
