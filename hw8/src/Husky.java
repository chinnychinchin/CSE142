import java.awt.*;

public class Husky extends Critter {

    private boolean isOddStep;
    private Color color;

    public Husky() {
        isOddStep = false;
    }

    public String toString() {return "Woof!!";}

    public Action getMove(CritterInfo info) {

        isOddStep = !isOddStep;

        if (info.getFront() == Neighbor.OTHER && !info.frontThreat())
            return Action.INFECT;

        else if (info.backThreat() && info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }

        else {
            Direction direction = info.getDirection();
            switch (direction) {

                case NORTH:
                    return Action.RIGHT;
                case SOUTH:
                    return Action.LEFT;
                case EAST:
                    return Action.HOP;
                case WEST:
                    color = Color.RED;
                    if (info.getFront() == Neighbor.SAME || info.getRight() == Neighbor.SAME ||
                    info.getBack() == Neighbor.SAME || info.getLeft() == Neighbor.SAME)
                        return Action.HOP;
                default:
                    return Action.RIGHT;
            }
        }
    }

    public Color getColor() {
        // black if odd step, almond color if even step
        return color = isOddStep ? Color.BLACK : new Color(234, 221, 202);
    }
}
