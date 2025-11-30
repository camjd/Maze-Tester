import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner mazeFile = new Scanner(new File("maze.dat"));

            // Read through mazeFile line by line
            while (mazeFile.hasNextLine()) {
                char[][] grid = new char[20][20];

                // Once 20 lines are read, one maze is made
                for (int r = 0; r < 20; r++) {
                    String line = mazeFile.nextLine(); // one row is a line from mazeFile
                    
                    for (int c = 0; c < 20; c++) {
                        grid[r][c] = line.charAt(c);
                    }
                }

                // Maze object
                Maze m = new Maze(grid);
                m.printGrid();
                System.out.println(m + "\n");

                // Skip blank lines between mazes to delineate mazes
                if (mazeFile.hasNextLine()) {
                    mazeFile.nextLine();
                }
            }

            mazeFile.close();
        }
        catch (Exception err) {
            System.out.println("Error message: " + err.getMessage());
        }
    }
}