import java.util.Random;
import java.util.Scanner;

public class Guess {

    private static int maxNumber = 200;


    public static void main(String[] args) {

        introduceGame();
        int gameCount = 0;
        boolean toPlay = true;
        while(toPlay) {

            System.out.println("I'm thinking of a number between 1 and " + maxNumber + "...");
            playOneGame();
            toPlay = toPlayAgain();
        }

    }

    public static boolean toPlayAgain() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again?");
        String userResponse = scanner.next().toLowerCase();
        System.out.println();
        if (userResponse.startsWith("y"))
            return true;
        else if (userResponse.startsWith("n"))
            return false;

        return false;
    }
    public static void introduceGame() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println(maxNumber + " and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();

    }

    public static void playOneGame() {

        Random r = new Random();
        int answer = r.nextInt(maxNumber) + 1;
        System.out.println("Answer: " + answer); // to be removed on deployment
        int guess = -1; // priming the loop
        int guessCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (answer != guess) {

            guessCount++;
            System.out.println("Your guess?");
            guess = scanner.nextInt();
            if (guess < answer)
                System.out.println("It's higher.");
            else if (guess > answer)
                System.out.println("It's lower.");
        }

        System.out.println(String.format("You got it right in %s guesses",guessCount));

    }

    public static void showOverallResults() {

    }

}
