public class GameMap {
  private HoriWall horizontal;
  private VertWall vertical;
  private int rows;
  private int cols;
  private int[][] map;
  
  // constructor - creates arrays of appropriate size
  public GameMap(int rows, int cols) {
    horizontal = new HoriWall(rows, cols);
    vertical = new VertWall(rows, cols);
    this.rows = rows;
    this.cols = cols;
    map = new int[rows][cols];
  }
  
  // accessor - gets the value of a cell in the map
  public int getCell(int row, int col) {
    return map[row][col];
  }
  
  // mutator - changes a single horizontal wall
  // and updates the map accordingly
  public void setHoriWall(int row, int col, boolean hasWall) {
    horizontal.setWall(row, col, hasWall);
    if (map[row][col] % 2 >= 1 && !hasWall) {
      map[row][col] -= 1;
    }
    else if (map[row][col] % 2 < 1 && hasWall) {
      map[row][col] += 1;
    }
    if (map[row + 1][col] % 16 >= 8 && !hasWall) {
      map[row + 1][col] -= 8;
    }
    else if (map[row + 1][col] % 16 < 8 && hasWall) {
      map[row + 1][col] += 8;
    }
  }
  
  // mutator - changes a single vertical wall
  // and updates the map accordingly
  public void setVertWall(int row, int col, boolean hasWall) {
    vertical.setWall(row, col, hasWall);
    if (map[row][col] % 4 >= 2 && !hasWall) {
      map[row][col] -= 4;
    }
    else if (map[row][col] % 4 < 2 && hasWall) {
      map[row][col] += 4;
    }
    if (map[row][col + 1] % 8 >= 4 && !hasWall) {
      map[row][col + 1] -= 2;
    }
    else if (map[row][col + 1] % 8 < 4 && hasWall) {
      map[row][col + 1] += 2;
    }
  }
  
  // accessor - gets the value of a single vertical wall
  public boolean getVertWall(int row, int col) {
    return vertical.hasWall(row, col);
  }
  
  // accessor - gets the value of a single horizontal wall
  public boolean getHoriWall(int row, int col) {
    return horizontal.hasWall(row, col);
  }
  
  // accessor - gets number of rows in the map
  public int getRows() {
    return rows;
  }
  
  // accessor - gets number of columns in the map
  public int getCols() {
    return cols;
  }
  
  // instance method - creates an integer array with the number of action points left
  // once that square is reached, with a -1 representing out of range
  public int[][] getActionPointsMap(int row, int col, int actionPoints) {
    int[][] actionPointsMap = new int[rows][cols];
    int i, j;
    for (i = 0; i < rows; i++) {
      for (j = 0; j < cols; j++) {
        actionPointsMap[i][j] = -1;
      }
    }
    actionPointsMapRecur(row, col, actionPoints, actionPointsMap);
    return actionPointsMap;
  }
  
  //generates the action points map recursively
  public void actionPointsMapRecur(int row, int col, int actionPoints, int[][] actionPointsMap) {
    // base case: no more action points
    // note: may be unnecessary
    if (actionPoints <= -1) {
      return;
    }
    // base case: exceeded bounds of map
    // note: may also not be necessary
    else if (row >= rows || col >= cols || row < 0 || col < 0) {
      return;
    }
    // base case: action points currently held is less than the value already found
    else if (actionPoints <= actionPointsMap[row][col]) {
      return;
    }
    
    actionPointsMap[row][col] = actionPoints;
    //movement in all 4 directions: north, south, west, east
    if (row > 0 && !horizontal.hasWall(row - 1, col)) {
      actionPointsMapRecur(row - 1, col, actionPoints - 1, actionPointsMap);
    }
    if (row < rows - 1 && !horizontal.hasWall(row, col)) {
      actionPointsMapRecur(row + 1, col, actionPoints - 1, actionPointsMap);
    }
    if (col > 0 && !vertical.hasWall(row, col - 1)) {
      actionPointsMapRecur(row, col - 1, actionPoints - 1, actionPointsMap);
    }
    if (col < cols - 1 && !vertical.hasWall(row, col)) {
      actionPointsMapRecur(row, col + 1, actionPoints - 1, actionPointsMap);
    }
  }
      
}