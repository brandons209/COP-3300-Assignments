package silva_p1;
import java.util.Scanner; 

public class Encrypt {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input, d1, d2, d3, d4;
		
		System.out.println("Enter number to encrypt:");
		input = scnr.nextInt();
		scnr.close();
		
		d4 = input % 10;
		d3 = (input / 10) % 10;
		d2 = (input / 100) % 10;
		d1 = (input / 1000) % 10;
		
		d4 = (d4 + 7) / 10;
		d3 = (d3 + 7) / 10;
		d2 = (d2 + 7) / 10;
		d1 = (d1 + 7) / 10;
		
		System.out.printf("Encrypted number: %d%d%d%d\n", d3, d4, d1, d2);
		
		
	}
}
