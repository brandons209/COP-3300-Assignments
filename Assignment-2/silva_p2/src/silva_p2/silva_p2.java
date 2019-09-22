package silva_p2;
import java.util.Scanner; 

public class silva_p2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int calc_mode;
		double weight, height, bmi;
		
		// get mode, 1 is for lbs and 2 is for kg
		System.out.println("Select mode for BMI calculation (lb/in or kg/m)");
		System.out.printf("[1] %s\n[2] %s\n", "lb/in", "kg/m");
		calc_mode = scnr.nextInt();
		
		// get weight and height, prints lb if calc_mode is 1 otherwise prints kg
		System.out.printf("Enter weight in %s.\n", (calc_mode == 1) ? "lb" : "kg" );
		weight = scnr.nextDouble();
		
		System.out.printf("Enter height in %s.\n", (calc_mode == 1) ? "in" : "m" );
		height = scnr.nextDouble();
		
		scnr.close();
		
		// calculates BMI with approiate function
		bmi = (calc_mode == 1) ? (703 * weight) / Math.pow(height, 2.0) : weight / Math.pow(height, 2.0);
		
		// print out BMI and type
		System.out.printf("Your BMI is: %.2f\n", bmi);
		
		System.out.print("According to your BMI, you are: ");
		
		if (bmi < 18.5)
		{
			System.out.println("underweight.");
		}
		else if (bmi >= 18.5 && bmi < 25.0)
		{
			System.out.println("normal weight.");
		}
		else if (bmi >= 25.0 && bmi < 30)
		{
			System.out.println("overweight.");
		}
		else
		{
			System.out.println("obese.");
		}

	}

}
