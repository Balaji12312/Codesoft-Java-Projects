package number;
import java.util.Scanner;
public class numbergame {
	        public static void main(String args[]) {
	            Scanner sc = new Scanner(System.in);
	            System.out.println("Enter the Number which you guess: ");
	            int num = sc.nextInt();
	            
	            int num1 = 77;
	            
	            if (num > num1) {
	                System.out.println("Your guess is Higher");
	            }
	            else if (num == num1) {
	                System.out.println("Your guess is Correct");
	            } else {
	                System.out.println("Your guess is Lower");
	            }
	        }
	    }

