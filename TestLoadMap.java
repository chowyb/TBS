import java.util.*;

public class TestLoadMap {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter map name:");
    String mapName = sc.next();
    GameMap map = LoadMap.load("maps/" + mapName);
    
    System.out.println("Enter origin point: row, col");
    int originRow = sc.nextInt();
    int originCol = sc.nextInt();
    System.out.println("Enter no. of action points:");
    int actionPoints = sc.nextInt();
    int[][] actionPointsMap = map.getActionPointsMap(originRow, originCol, actionPoints);
    
    TestGameMap.printMap(map, actionPointsMap);
  }
}