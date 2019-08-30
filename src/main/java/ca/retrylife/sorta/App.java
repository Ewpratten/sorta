package ca.retrylife.sorta;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.sql.rowset.spi.SyncResolver;

import ca.retrylife.hsa2.GraphicsConsole;
import ca.retrylife.sorta.sorters.QuickSorter;

public class App {
    GraphicsConsole gc = new GraphicsConsole(800, 600, "sorta");
    Random rand = new Random();
    
    QuickSorter m_QuickSorter = new QuickSorter();

    public static void main(String[] args) {
        new App();
    }

    public App() {
        // Setup
        gc.setLocationRelativeTo(null);
        gc.setAntiAlias(true);
        gc.enableMouse();

        // Inform SorterChooser of the random list
        SorterChooser.getInstance().setList(getRandAtLen(50));

        // Drawing
        while (true) {
            synchronized (gc) {
                gc.clear();
                gc.setColor(Color.gray);
                SorterChooser.getInstance().getSelection().draw(gc);

                gc.setColor(Color.blue);
                gc.drawRect(0, 0, 20, 20);

            }
            gc.sleep(300);

            // Check for a mouse click to open the menu
            if (gc.getMouseClick() > 0) {
                Point loc = gc.getMousePosition();

                // handle an unfocused window
                if (loc == null) {
                    continue;
                }

                // Handle a correct mouse click
                if (loc.x <= 40 && loc.y <= 40) {
                    System.out.println("Menu open");

                    SorterChooser.getInstance().displayChooser(gc);
                }else if (loc.x <= 40 && loc.y <= 80) {
                    System.out.println("Reset");

                    SorterChooser.getInstance().getSelection().reset();
                }
            }
        }

    }

    public ArrayList<Integer> getRandAtLen(int len) {
        ArrayList<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < len; i++) {
            output.add(rand.nextInt(gc.getHeight()));
        }

        return output;
    }
}
