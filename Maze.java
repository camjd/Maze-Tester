public class Maze {

    private char[][] grid;        // 2D 20x20 array to hold maze chars
    private boolean solvable;     // True if E is reachable
    private boolean[][] visited;  // Matching 20x20 grid of T/F values

    // Constructor
    public Maze(char[][] grid) {
        this.grid = grid;
        this.visited = new boolean[20][20];
        this.solvable = checkIfSolvable();
    }

    // Loop through every row and column for 'S' to store starting position
    private boolean checkIfSolvable() {
        int startRowPos = -1, startColumnPos = -1;

        // find position of S
        for(int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                if (grid[r][c] == 'S') {
                    startRowPos = r;
                    startColumnPos = c;
                }
            }
        }

        return explore(startRowPos, startColumnPos);  // maze solving method
    }


    private boolean explore(int r, int c) {
        // check if outside of maze
        if (r < 0 || r >= 20 || c < 0 || c >= 20) {
            return false;
        }
        // check if a spot is a wall
        if (grid[r][c] == '#') {
            return false;
        }
        // check if spot has been visited
        if (visited[r][c]) {
            return false;
        }
        // check if we are on 'E'
        if (grid[r][c] == 'E') {
            return true;
        }
        visited[r][c] = true;  // mark spot as visited

        // Try to go down ... if fails try up ... if fails try right ... if fails try left
        return explore(r + 1, c) || explore(r - 1, c) || explore(r, c + 1) || explore(r, c - 1);
    }

    // Prints the grid
    public void printGrid() {
        for(int r = 0; r < 20; r++) {
            
            for (int c = 0; c < 20; c++) {
                System.out.print(grid[r][c]);
            }
        System.out.println();
        }
    }

    public String toString() {
        return "Maze: " + (solvable ? "YES" : "NO");
    }

}