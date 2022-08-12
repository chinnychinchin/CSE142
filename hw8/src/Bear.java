import java.awt.*;

public class Bear extends Critter {

    private boolean polar;
    private boolean slash; // slash = true will be / , slash = false will be \ . Starts with /

    public Bear(boolean polar) {
        this.polar = polar;
        this.slash = true;
    }

    public Color getColor() {
        if (polar) return Color.WHITE;
        else return Color.BLACK;
    }

    public String toString() {
        return (slash) ? "/" : "\\";
    }

    public Action getMove(CritterInfo info) {

        this.slash = !this.slash; // alternate between slash and backslash with each move

        // always infect if an enemy is in front otherwise hop if possible otherwise turn left.
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;

        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }

        else return Action.LEFT;
    }
}
