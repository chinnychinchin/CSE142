package partB;

import java.awt.*;

public class CafeWall {

    public static int MORTAR = 2;

    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel(650,400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();
        singleRow(g,0,0,4,20);
        singleRow(g,50,70,5,30);
        grid(g,10,150,4,25,0);
        grid(g,250,200,3,25,10);
        grid(g,425,180,5,20,10);
        grid(g,400,20,2,35,35);

    }

    // (x,y) represents the x and y position of the top left corner of each row.
    // numOfPairs is the number of black/white pairs
    // size is the size of each box in pixels
    public static void singleRow(Graphics g, int x, int y, int numOfPairs, int size) {

        for (int i = 0; i < numOfPairs; i++) {

            int z = x + (i * size * 2);
            g.setColor(Color.BLACK);
            g.fillRect(z,y,size,size);
            g.setColor(Color.BLUE);
            g.drawLine(z,y,z + size, y + size);
            g.drawLine(z+ size,y,z,y + size);
            g.setColor(Color.WHITE);
            g.fillRect(z + size, y, size, size);

        }
    }

    public static void grid(Graphics g, int x, int y, int numOfPairs, int size, int offset) {

        int z = y;

        for (int i = 0; i < numOfPairs; i++) {

            singleRow(g, x,z,numOfPairs,size);
            z = z + size + MORTAR;
            singleRow(g, x+offset,z, numOfPairs,size);
            z = z + size + MORTAR;
        }

    }
}
