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

}
