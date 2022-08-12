import java.awt.*;

public class Giant extends Critter {

    private long stepCount;
    private String displayName;
    private String[] possibleDisplayNames = {"fee","fie","foe","fum"};

    public Color getColor() {return Color.GRAY; }

    public Giant() {
        stepCount = 0;
        displayName = possibleDisplayNames[0];
    }


    public Action getMove(CritterInfo info) {

        if (++stepCount == 24) stepCount = 0;

        if (stepCount <= 5)
            displayName = possibleDisplayNames[0];
        else if (stepCount <= 11) {
            displayName = possibleDisplayNames[1];
        }
        else if (stepCount <= 17) {
            displayName = possibleDisplayNames[2];
        }
        else if (stepCount <=23) {
            displayName = possibleDisplayNames[3];
        }

        /*
        always infect if an enemy is in front
        otherwise hop if possible
        otherwise turn right.
        */
        
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;

        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;

        else return Action.RIGHT;

    }

    public String toString() {return displayName;}
}
