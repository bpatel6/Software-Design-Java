/**
 * The class to represent location and data in maze
 * @see MazePoint
 */
public class MazePoint {
    /**
     * Stores row position
     */
    private final int row;
    /**
     * Stores column position
     */
    private final int column;
    /**
     * Stores data at a location
     */
    private char data;

    /**
     * MazePoint constructor
     * @param row ith row position in maze
     * @param column jth column position in maze
     * @param data value to store at (i,J) position
     */
    public MazePoint(int row, int column, char data){
        this.row = row;
        this.column = column;
        this.data = data;
    }

    /**
     * Method to return the row in maze
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Method to return the column in maze
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Method to return the data at location
     * @return
     */
    public char getData() {
        return data;
    }

    /**
     * Method to set location data
     * @param data value to be set
     */
    public void setData(char data) {
        this.data = data;
    }
}
