package Silva_P1;
import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Character;

public class silva_p1 {

    public static int[] getDigits(int num_digits, int difficulty) {
        SecureRandom random = new SecureRandom();
        int digits[] = new int[num_digits];

        for (int i = 0; i < num_digits; i++)
            if (difficulty == 1)
                digits[i] = random.nextInt(10);
            else if (difficulty == 2)
                digits[i] = random.nextInt(100);
            else if (difficulty == 3)
                digits[i] = random.nextInt(1000);
            else if (difficulty == 4)
                digits[i] = random.nextInt(10000);

        return digits;
    }

    public static String getProblem(int digits[], int type) {
        String message = "How much is ";
        int answer = 0;
        switch (type) {
            case 1:
                for (int i = 0; i < digits.length; i++) {
                    if (i < digits.length - 1)
                        message += Integer.toString(digits[i]) + " plus ";
                    else
                        message += Integer.toString(digits[i]) + "?";
                    answer += digits[i];
                }
                break;
            case 2:
                answer = 1;
                for (int i = 0; i < digits.length; i++) {
                    if (i < digits.length - 1)
                        message += Integer.toString(digits[i]) + " times ";
                    else
                        message += Integer.toString(digits[i]) + "?";
                    answer *= digits[i];
                }
                break;
            case 3:
                answer = digits[0];
                for (int i = 0; i < digits.length; i++) {
                    if (i < digits.length - 1) {
                        message += Integer.toString(digits[i]) + " minus ";
                        answer -= digits[i + 1];
                    } else {
                        message += Integer.toString(digits[i]) + "?";
                    }
                }
                break;
            case 4:
                answer = digits[0];
                for (int i = 0; i < digits.length; i++) {
                    if (i < digits.length - 1) {
                        message += Integer.toString(digits[i]) + " divided ";
                        if (digits[i+1] == 0)
                            digits[i+1] = 1;
                        answer /= digits[i + 1];
                    } else {
                        message += Integer.toString(digits[i]) + "?";
                    }
                }
                break;
        }
        return message + Integer.toString(answer);
    }

    public static String getCorrectMessage(int idx) {
        switch (idx) {
            case 0:
                return "Very good!";
            case 1:
                return "Excellent!";
            case 2:
                return "Nice work!";
            case 3:
                return "Keep up the good work!";
            case 4:
                return "Awesome job!";
            default:
                return "";
        }

    }

    public static String getIncorrectMessage(int idx) {
        switch (idx) {
            case 0:
                return "No. Please try again.";
            case 1:
                return "Wrong, try again.";
            case 2:
                return "Don't give up! Try again.";
            case 3:
                return "That's incorrect, give it another shot.";
            case 4:
                return "Sorry, try again.";
            default:
                return "";
        }

    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int digits[];
        int input, answer, difficulty = 0, type = 0, num_correct = 0;
        double percentage;
        char cont = 'y';
        SecureRandom random = new SecureRandom();
        String msg = "";

        while (cont != 'n') {

            while (difficulty < 1 || difficulty > 4) {
                System.out.println("Please enter difficulty level (1-4), number of digits problems can have.");
                difficulty = scnr.nextInt();
            }

            while (type < 1 || type > 5) {
                System.out.println("Please enter type of problem (1-5).\n[1]: addition\n[2]: multiplication\n[3]: subtraction\n[4]: division\n[5]: random");
                type = scnr.nextInt();
            }

            for (int i = 0; i < 10; i++) {
                digits = getDigits(2, difficulty);
                if (type == 5) {
                    msg = getProblem(digits, random.nextInt(5) + 1);
                    answer = Integer.parseInt(msg.substring(msg.indexOf('?') + 1));
                    System.out.println(msg.substring(0, msg.indexOf('?') + 1));
                } else {
                    msg = getProblem(digits, type);
                    answer = Integer.parseInt(msg.substring(msg.indexOf('?')+1));
                    System.out.println(msg.substring(0, msg.indexOf('?')+1));
                }
                input = scnr.nextInt();

                if (input == answer){
                    System.out.println(getCorrectMessage(random.nextInt(5)));
                    num_correct++;
                } else {
                    System.out.println(getIncorrectMessage(random.nextInt(5)));
                }
            }
            percentage = (double)num_correct / 10;
            System.out.printf("You got %.1f%% of questions correct!\n", percentage * 100);

            if (percentage >= 0.75) {
                System.out.println("Congratulations, you are ready to go to the next level!\n");
            } else {
                System.out.println("Please ask your teacher for extra help.\n");
            }

            System.out.println("Start a new session? (y/n)");
            cont = Character.toLowerCase(scnr.next().charAt(0));
            System.out.println();
            num_correct = 0;
            difficulty = 0;
            type = 0;
        }
        System.out.println("Goodbye!");
        scnr.close();
    }

}
