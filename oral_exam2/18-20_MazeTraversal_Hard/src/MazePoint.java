public class MazePoint {
    private final int row;
    private final int column;
    private char data;

    public MazePoint(int row, int column, char data){
        this.row = row;
        this.column = column;
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}
