import java.util.Random;
import java.util.Scanner;

public class Guess {
    private static int maxNumber = 100;
    public static void main(String[] args) {

        introduceGame();
        int gameCount = 0;
        int bestGame = 9999;
        int totalGuesses = 0;
        boolean toPlay = true;
        while(toPlay) {

            System.out.println("I'm thinking of a number between 1 and " + maxNumber + "...");
            int numOfGuesses = playOneGame();
            gameCount++;
            totalGuesses += numOfGuesses;
            if (numOfGuesses < bestGame)
                bestGame = numOfGuesses;
            toPlay = toPlayAgain();

        }

        showOverallResults(gameCount, totalGuesses, bestGame);

    }

    public static boolean toPlayAgain() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? ");
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
        System.out.println("you get it.  For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();

    }

    public static int playOneGame() {

        Random r = new Random();
        int answer = r.nextInt(maxNumber) + 1;
        // int answer = 42;
        // System.out.println("Answer: " + answer); // to be removed on deployment
        int guess = -1; // priming the loop
        int guessCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (answer != guess) {

            guessCount++;
            System.out.print("Your guess? ");
            guess = Integer.parseInt(scanner.next());
            if (guess < answer)
                System.out.println("It's higher.");
            else if (guess > answer)
                System.out.println("It's lower.");
        }

        String pluralOrSingular = guessCount == 1 ? "guess" : "guesses";
        System.out.println(String.format("You got it right in %d %s",guessCount, pluralOrSingular));
        return guessCount;
    }

    public static void showOverallResults(int gameCount, int totalGuesses, int bestGame) {

        System.out.println("Overall results: ");
        System.out.println(String.format("    total games   = %d",gameCount));
        System.out.println(String.format("    total guesses = %d",totalGuesses));
        System.out.println(String.format("    guesses/game  = %.1f", (double) totalGuesses /gameCount));
        System.out.println(String.format("    best game     = %d", bestGame));

    }

}
