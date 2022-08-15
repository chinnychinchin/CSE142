import java.awt.*;
import java.util.Random;

public class Lion extends Critter {

    private long stepCount;
    private static final Color[] possibleColors = {Color.RED, Color.GREEN, Color.BLUE};
    private Color color;
    private final Random random = new Random();

    public Lion() {
        this.stepCount = 0; // for clarity's sake. If not here, stepCount will be auto initialized to 0
        this.color = possibleColors[random.nextInt(3)];
    }

    public String toString() {return "L"; }

    public Action getMove(CritterInfo info) {

        if (++stepCount == 3) {
            // reset step count
            stepCount = 0;
            // set color to another random color
            color = possibleColors[random.nextInt(3)];

        }

        /*
        always infect if an enemy is in front
        otherwise if a wall is in front or to the right, then turn left
        otherwise if a fellow Lion is in front, then turn right
        otherwise hop.
        */
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;

        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }

        else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }

        else return Action.HOP;

    }


    public Color getColor() { return color; }

}
