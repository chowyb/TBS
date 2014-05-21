public class VertWall {
  private boolean[][] walls;
  
  // constructor - creates the horizontal wall array
  // given the size of the original map
  public VertWall(int rows, int cols) {
    walls = new boolean[rows][cols-1];
  }
  
  // accessor - gets the state of the wall
  // returns 1 if index is out of bounds
  public boolean hasWall(int row, int col) {
    if (row < 0 || row >= walls.length || col < 0 || col >= walls[0].length) {
      return 1;
    }
    return walls[row][col];
  }
  
  // mutator - sets the value of the wall
  public void setWall(int row, int col, boolean toWall) {
    walls[row][col] = toWall;
  }
}