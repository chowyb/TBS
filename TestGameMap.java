import java.util.*;

public class TestGameMap {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of rows:");
    int rows = sc.nextInt();
    System.out.println("Enter no. of cols:");
    int cols = sc.nextInt();
    GameMap map = new GameMap(rows, cols);
    System.out.println("Enter " + (rows - 1) + " rows of " + cols + " horizontal walls.");
    System.out.println("0 - no wall, 1 - wall");
    int i, j, input;
    for (i = 0; i < rows - 1; i++) {
      for (j = 0; j < cols; j++) {
        input = sc.nextInt();
        if (input == 1) {
          map.setHoriWall(i, j, true);
        }
      }
    }
    System.out.println("Enter " + rows + " rows of " + (cols - 1) + " vertical walls.");
    System.out.println("0 - no wall, 1 - wall");
    for (i = 0; i < rows; i++) {
      for (j = 0; j < cols - 1; j++) {
        input = sc.nextInt();
        if (input == 1) {
          map.setVertWall(i, j, true);
        }
      }
    }
    System.out.println("Enter origin point: row, col");
    int originRow = sc.nextInt();
    int originCol = sc.nextInt();
    System.out.println("Enter no. of action points:");
    int actionPoints = sc.nextInt();
    int[][] actionPointsMap = map.getActionPointsMap(originRow, originCol, actionPoints);
    
    printMap(map, actionPointsMap);
  }
  
  public static void printMap (GameMap map, int[][] actionPointsMap) {
    int printRow, printCol;
    int rows = map.getRows() * 2 - 1, cols = map.getCols()* 2 - 1;
    for (printRow = 0; printRow < rows; printRow++) {
      if (printRow % 2 == 0) {
        for (printCol = 0; printCol < cols; printCol++) {
          if (printCol % 2 == 0) {
            System.out.print(actionPointsMap[printRow / 2][printCol / 2]);
          }
          else {
            if(map.getVertWall(printRow / 2, printCol / 2) == true) {
              System.out.print("|");
            }
            else {
              System.out.print(" ");
            }
          }
        }
      }
      else {
        for (printCol = 0; printCol < cols; printCol++) {
          if (printCol % 2 == 0) {
            if(map.getHoriWall(printRow / 2, printCol / 2) == true) {
              System.out.print("-");
            }
            else {
              System.out.print(" ");
            }
          }
          else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }
  }
}
        