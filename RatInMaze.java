public class RatInMaze {

    final int N = 4;

    // Utility method to print the solution matrix
    void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if x,y is a valid move
    boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N &&
                y >= 0 && y < N &&
                maze[x][y] == 1);
    }

    // Method to solve the maze
    boolean solveMaze(int[][] maze) {

        int[][] sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(sol);
        return true;
    }

    // Backtracking utility method
    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {

        // If destination is reached
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {

            sol[x][y] = 1;

            // Move down
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // Move right
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // Backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {

        RatInMaze rat = new RatInMaze();

        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        rat.solveMaze(maze);
    }
}