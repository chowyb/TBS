import java.util.*;
import java.io.*;

public class LoadMap {
  public static GameMap load(String mapName) {
    Scanner sc;
    try {
      sc = new Scanner(new FileReader(mapName));
    }
    catch (FileNotFoundException obj) {
      System.out.println("Map " + mapName + " not found");
      return null;
    }
    // getting size of map
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    GameMap map = new GameMap(rows, cols);
    int i, j, input;
    
    // getting horizontal walls ((r - 1) x c)
    for (i = 0; i < rows - 1; i++) {
      for (j = 0; j < cols; j++) {
        input = sc.nextInt();
        if (input == 1) {
          map.setHoriWall(i, j, true);
        }
      }
    }
    
    // getting vertical walls (r x (c - 1))
    for (i = 0; i < rows; i++) {
      for (j = 0; j < cols - 1; j++) {
        input = sc.nextInt();
        if (input == 1) {
          map.setVertWall(i, j, true);
        }
      }
    }
    return map;
  }
}