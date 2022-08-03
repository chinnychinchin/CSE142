import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Names {

    public static int startYear = 1880;
    public static int numOfDecades = 14;
    public static int horizontalWidth = 70;

    public static void main(String[] args) throws FileNotFoundException {

        introduction();
        // Initialize scanners for inputs
        Scanner input = new Scanner(new File("C:\\Users\\P0106549\\IdeaProjects\\CSE142\\hw6\\src\\names.txt"));
        Scanner console = new Scanner(System.in);
        System.out.print("name? ");
        String name = console.next().toLowerCase();
        System.out.print("sex (M or F)? ");
        String sex = console.next().toLowerCase();

        String lineFound = findLine(input,name,sex);
        if (lineFound.length() != 0) {

            plotGraph(lineFound);

        }

        else System.out.println("name/sex combination not found");

    }

    public static void introduction() {
        System.out.println("This program allows you to search through the");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a particular name has been");
        System.out.println("since " + startYear + ".");
    }

    public static String findLine(Scanner input, String name, String sex) {

        while (input.hasNextLine()) {
            String originalLine = input.nextLine();
            String lowerCaseLine = originalLine.toLowerCase();
            Scanner dataLine = new Scanner(lowerCaseLine);
            String inputName = dataLine.next();
            String inputSex = dataLine.next();
            if (inputName.equals(name) && inputSex.equals(sex))
                return originalLine;
        }

        return "";

    }

    public static void plotGraph(String line) {

        int panelWidth = horizontalWidth * numOfDecades;
        int panelHeight = 550;
        DrawingPanel panel = new DrawingPanel(panelWidth, panelHeight);
        Graphics g = panel.getGraphics();
        // Draw top horizontal line
        g.drawLine(0,25,panelWidth,25);
        // Draw bottom horizontal line
        g.drawLine(0,panelHeight-25,panelWidth,panelHeight-25);
        int year = startYear;
        int xCoord = 0;

        Scanner lineInput = new Scanner(line);
        String name = readToken(lineInput);
        String sex = readToken(lineInput);
        int currentRank = Integer.parseInt(readToken(lineInput));
        for (int i = 1; i <= numOfDecades; i++) {

            // draw vertical line
            g.setColor(Color.BLACK);
            g.drawLine(xCoord,0,xCoord,panelHeight);
            // write year
            g.drawString(String.valueOf(year),xCoord,panelHeight);
            // Draw red graph line
            g.setColor(Color.RED);
            int yPos1 = calYPos(currentRank);
            System.out.println(yPos1);
            String rankSubsequent = readToken(lineInput);

            // Draw the string like "Sam M 492"
            g.drawString(String.format("%s %s %s",name,sex,currentRank),xCoord,yPos1);

            if (i != numOfDecades) {
                // Draw line
                int yPos2 = calYPos(Integer.parseInt(rankSubsequent));
                System.out.println(yPos2);
                g.drawLine(xCoord,yPos1,xCoord+horizontalWidth,yPos2);
                currentRank = Integer.parseInt(rankSubsequent);
            }

            year += 10;
            xCoord += horizontalWidth;
        }

    }

    public static String readToken(Scanner lineInput) {

        if (lineInput.hasNext()) {
            return lineInput.next();
        }
        return "";
    }

    public static int calYPos(int rank) {
        int yPos;

        if (rank == 0)
            yPos = 525;

        else if (rank % 2 == 0) {
            yPos = (rank-2) / 2 + 25;
        }

        else yPos = (rank-1) / 2 + 25;

        return yPos;
    }
}
