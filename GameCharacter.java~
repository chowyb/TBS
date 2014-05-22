public class GameCharacter {
  int currRow, currCol;
  int actionPoints;
  
  public GameCharacter(int row, int col) {
    currRow = row;
    currCol = col;
  }
  
  public void moveTo(int destRow, int destCol, GameMap map, int[][] actionPointsMap) {
    if (actionPointsMap[destRow][destCol] < 0) {
      return;
    }
    String moveOrder = moveToRecur(destRow, destCol, map, actionPointsMap);
    moveExecute(moveOrder, map);
  }
  
  private void moveExecute(String moveOrder, GameMap map) {
    while (!moveOrder.isEmpty()) {
      char move = moveOrder.charAt(0);
      moveOrder = moveOrder.substring(1);
      
      // TODO: add animations
      switch(move) {
        case 'n':
          currRow--;
          break;
        case 's':
          currRow++;
          break;
        case 'w':
          currCol--;
          break;
        case 'e':
          currCol++;
          break;
      }
      actionPoints--;
    }
  }
}