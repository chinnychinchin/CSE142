import java.util.Random;
import java.util.Scanner;

public class GuessEven {

    public static void main(String[] args) {

        System.out.println("Try to guess an even one-digit number");
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int answer = r.nextInt(5) * 2;
        System.out.println("The answer is: " + answer); //to be removed on deployment
        int guess = -1; // priming the loop. Use -1 because it is always false
        int numOfGuesses = 0;
        while(guess != answer) {
            numOfGuesses++;
            System.out.println("Your guess? ");
            guess = scanner.nextInt();
        }

        System.out.println("You're right! Your current guess count: " + numOfGuesses);

    }
}
