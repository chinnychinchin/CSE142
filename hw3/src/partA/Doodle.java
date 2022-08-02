package partA;

import java.awt.*;

public class Doodle {

    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics g = panel.getGraphics();

        g.drawLine(150,50,50,100);
        g.drawLine(150,50, 250,100);
        // Draw main house building
        g.setColor(Color.CYAN);
        g.fillRect(50,100,200,200);

        // Draw door
        g.setColor(Color.RED);
        g.fillOval(100,200,100,100);
    }
}
