public class Maze {
    private static final int rows = 12;
    private static final int columns = 12;


    public static char getRight(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getColumn() + 1 >= 0) && (currentPosition.getColumn() + 1 < columns)){
            return array[currentPosition.getRow()][currentPosition.getColumn()+1].getData();
        }
        else {
            return '#';
        }
    }

    public static char getLeft(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getColumn() - 1 >= 0) && (currentPosition.getColumn() - 1 <= columns)){
            return array[currentPosition.getRow()][currentPosition.getColumn()-1].getData();
        }
        else {
            return '#';
        }
    }

    public static char getUp(MazePoint currentPosition, MazePoint[][] array) {
        if ((currentPosition.getRow() - 1 >= 0) && (currentPosition.getRow()-1 <= rows)){
            return array[currentPosition.getRow()-1][currentPosition.getColumn()].getData();
        }
        else {
            return '#';
        }
    }

    public static char getDown(MazePoint currentPosition, MazePoint[][] array) {
        if((currentPosition.getRow() + 1 >= 0) && (currentPosition.getRow() + 1 < rows)){
            return array[currentPosition.getRow()+1][currentPosition.getColumn()].getData();
        }
        else {
            return '#';
        }
    }

    public static MazePoint[][] charToPoint(char[][] maze){
        MazePoint[][] points = new MazePoint[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                points[i][j] = new MazePoint(i,j,maze[i][j]);
            }
        }
        return points;
    }

    public static char[][] pointToChar(MazePoint[][] maze){
        char[][] charMaze = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                charMaze[i][j] = maze[i][j].getData();
            }
        }
        return charMaze;
    }

    public static void printMaze(char[][] maze){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
    }

    public static boolean mazeTraversal(char[][] Maze, int currentRow, int currentColumn){
        boolean gameOver = false;
        MazePoint[][] pointMaze = charToPoint(Maze);
        MazePoint currentPoint = pointMaze[currentRow][currentColumn];
        Maze[currentRow][currentColumn] = 'x';
        //printMaze(Maze);
        if(getRight(currentPoint,pointMaze) == 'E'){
            gameOver = true;
        }

        if(getRight(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, currentRow, currentColumn + 1);
        }

        if(getLeft(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, currentRow, currentColumn - 1);
        }

        if(getUp(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, currentRow-1, currentColumn);
        }

        if(getDown(currentPoint,pointMaze) == '.' && !gameOver){
            gameOver = mazeTraversal(Maze, currentRow+1, currentColumn);
        }

        return gameOver;
    }
}
