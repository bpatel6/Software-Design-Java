/**
 * The class to represent maze
 * @see Maze
 */

public class Maze {
    private static final int rows = 12;
    private static final int columns = 12;

    /**
     * Maze class constructor
     */
    public Maze() {
    }

    /**
     * Method to access the location to right of the current location in the maze
     * @param currentPosition in the maze
     * @param array maze
     * @return value to right of the current location
     */
    public static char getRight(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getColumn() + 1 >= 0) && (currentPosition.getColumn() + 1 < columns)){
            return array[currentPosition.getRow()][currentPosition.getColumn()+1].getData();
        }
        else {
            return '#';
        }
    }

    /**
     * Method to access the location to left of the current location in the maze
     * @param currentPosition in the maze
     * @param array maze
     * @return value to left of the current location
     */
    public static char getLeft(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getColumn() - 1 >= 0) && (currentPosition.getColumn() - 1 <= columns)){
            return array[currentPosition.getRow()][currentPosition.getColumn()-1].getData();
        }
        else {
            return '#';
        }
    }

    /**
     * Method to access the location above the current location in the maze
     * @param currentPosition in the maze
     * @param array maze
     * @return value above the current location
     */
    public static char getUp(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getRow() - 1 >= 0) && (currentPosition.getRow()-1 <= rows)){
            return array[currentPosition.getRow()-1][currentPosition.getColumn()].getData();
        }
        else {
            return '#';
        }
    }

    /**
     * Method to access the location below the current location in the maze
     * @param currentPosition in the maze
     * @param array maze
     * @return value below the current location
     */
    public static char getDown(MazePoint currentPosition, MazePoint[][] array) {
        if((currentPosition.getRow() + 1 >= 0) && (currentPosition.getRow() + 1 < rows)){
            return array[currentPosition.getRow()+1][currentPosition.getColumn()].getData();
        }
        else {
            return '#';
        }
    }

    /**
     * Method to convert character maze to point object maze
     * @param maze character represented maze
     * @return maze-point represented maze
     */
    public static MazePoint[][] charToPoint(char[][] maze){
        MazePoint[][] points = new MazePoint[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                points[i][j] = new MazePoint(i,j,maze[i][j]);
            }
        }
        return points;
    }

    /**
     * Method to convert maze-point object maze to character maze
     * @param maze mazepoint object represented maze
     * @return character represented maze
     */
    public static char[][] pointToChar(MazePoint[][] maze){
        char[][] charMaze = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                charMaze[i][j] = maze[i][j].getData();
            }
        }
        return charMaze;
    }

    /**
     * Method to print the maze
     * @param maze char maze to print
     */
    public static void printMaze(char[][] maze){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
    }

    /**
     * Algorithm to traversal through maze
     * @param Maze character represented maze
     * @param startingRow starting index of row
     * @param startingColumn starting index of column
     * @return game is over or not
     */
    public static boolean mazeTraversal(char[][] Maze, int startingRow, int startingColumn){
        boolean gameOver = false;
        MazePoint[][] pointMaze = charToPoint(Maze);
        MazePoint currentPoint = pointMaze[startingRow][startingColumn];
        // put x at the location
        Maze[startingRow][startingColumn] = 'x';
        //System.out.println("\n");
        //printMaze(Maze);
        //System.out.println("\n");
        // if we reached the Exit then the game is over
        if(getRight(currentPoint,pointMaze) == 'E'){
            gameOver = true;
        }

        // check right of current location and continue recursion until finds a path
        if(getRight(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, startingRow, startingColumn + 1);
        }

        // check left of current location and continue recursion until finds a path
        if(getLeft(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, startingRow, startingColumn - 1);
        }

        // check above of current location and continue recursion until finds a path
        if(getUp(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, startingRow-1, startingColumn);
        }

        // check below of current position and continue recursion until finds a path
        if(getDown(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, startingRow+1, startingColumn);
        }

        return gameOver;
    }
}
