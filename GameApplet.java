import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;

public class GameApplet extends Applet {
  GameMap map;
  Image[][] imgArr;
  
  public void init() {
    try {
      map = LoadMap.load(new URL(getCodeBase(), "maps/map01.txt"));
    }
    catch (Exception e) {
    }
    int i, j;
    for (i = 0; i < map.getRows(); i++) {
      for (j = 0; j < map.getCols(); j++) {
        Integer value = map.getCell(i, j);
        String imageName = value.toString();
        while (imageName.length() < 4) {
          imageName = "0" + imageName;
        }
        try {
          imgArr[i][j] = getImage(getCodeBase(), "images/" + imageName + ".png");
        }
        catch (Exception e) {
        }
      }
    }
  }
  
  public void paint(Graphics g) {
    int i, j;
    for (i = 0; i < imgArr.length; i++) {
      for (j = 0; j < imgArr[0].length; j++) {
        g.drawImage(imgArr[i][j], i * 50, j * 50, this);
      }
    }
  }
}
    
    