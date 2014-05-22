import java.util.*;
import java.io.*;
import java.net.*;

public class LoadMap {
  public static GameMap load(URL fileLocation) {
    InputStream is = null;
    Scanner sc;
    try {
      is = fileLocation.openStream();
      sc = new Scanner(is);
    }
    catch (Exception obj) {
      System.out.println("Exception - Failed to access URL");
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
    
    map.setOuterWalls();
    
    try {
      is.close();
    }
    catch (Exception obj) {
      System.out.println("Exception - Failed to close stream");
    }
    return map;
  }
}