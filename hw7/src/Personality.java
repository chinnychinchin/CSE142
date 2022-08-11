import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Personality {

    public static final int DIMENSIONS = 4;
    public static void main(String[] args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);
        introduction();
        System.out.print("input file name? ");
        String inputFileName = console.nextLine();
        System.out.print("output file name? ");
        String outputFileName = console.nextLine();
        Scanner inputFile = new Scanner(new File(inputFileName));
        PrintStream output = new PrintStream(new File(outputFileName));

        while (inputFile.hasNextLine()) {
            String name = inputFile.nextLine();
            String line = inputFile.nextLine();
            // initialize arrays
            int[] aCounts = new int[DIMENSIONS];
            int[] bCounts = new int[DIMENSIONS];
            // call method to manipulate the line
            counter(line, aCounts, bCounts);
            int[] bPercentages = calculatePercentages(aCounts,bCounts);
            String personality = calPersType(bPercentages);
            output.println(String.format("%s: %s = %s",name,Arrays.toString(bPercentages),personality));
        }

    }

    public static void counter(String line, int[] aCounts, int[] bCounts) {

        for (int i = 0; i < line.length(); i++) {
            int questionType = detQuestType(i +1); // questionType = 0 || 1 || 2 || 3
            char ans = Character.toLowerCase(line.charAt(i)); // ans == 'a' || 'b' || '-', case insensitive
            if (ans == 'a')
                aCounts[questionType]++;
            else if (ans == 'b')
                bCounts[questionType]++;
        }
    }

    public static int[] calculatePercentages(int[] aCounts, int[] bCounts) {
        int[] bPercentages = new int[DIMENSIONS];

        for (int i = 0; i < DIMENSIONS; i++) {
            int total = aCounts[i] + bCounts[i];
            bPercentages[i] = (int) Math.round(bCounts[i]/(double) total * 100);
        }

        return bPercentages;
    }

    public static String calPersType(int[] bPercentages) {
        String personality = "";
        int[] personalityConstructor = new int[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            if (bPercentages[i] > 50)
                personalityConstructor[i] = 2;
            else if (bPercentages[i] < 50)
                personalityConstructor[i] = 1;

            switch(i) {
                case 0:
                    if (personalityConstructor[i] == 1)
                        personality += "E";

                    else if (personalityConstructor[i] == 2)
                        personality += "I";
                    else
                        personality += "X";
                    break;
                case 1:
                    if (personalityConstructor[i] == 1)
                        personality += "S";

                    else if (personalityConstructor[i] == 2)
                        personality += "N";
                    else
                        personality += "X";
                    break;
                case 2:
                    if (personalityConstructor[i] == 1)
                        personality += "T";

                    else if (personalityConstructor[i] == 2)
                        personality += "F";
                    else
                        personality += "X";
                    break;
                case 3:
                    if (personalityConstructor[i] == 1)
                        personality += "J";

                    else if (personalityConstructor[i] == 2)
                        personality += "P";
                    else
                        personality += "X";
                    break;
            }


        }


        return personality;
    }

    // takes in a 1-based question index and returns the question type 0,1,2 or 3
    public static int detQuestType(int index) {


        if ((index - 1)%7 == 0) {
            return 0;
        } else if ((index-2)%7 == 0 || (index-3)%7 == 0) {
            return 1;
        } else if ((index-4)%7 == 0 || (index-5)%7 == 0) {
            return 2;
        } else if ((index-6)%7 == 0 || (index-7)%7 == 0) {
            return 3;
        }

        return -1;
    }

    public static void introduction() {

        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter.  It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }
}