import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;

public class GameApplet extends Applet {
  GameMap map;
  int i, j;
  Image img;
  
  public void init() {
    try {
      map = LoadMap.load(new URL(getCodeBase(), "maps/map01.txt"));
    }
    catch (Exception e) {
    }
    for (i = 0; i < map.getRows(); i++) {
      for (j = 0; j < map.getCols(); j++) {
        Integer value = map.getCell(i, j);
        String imageName = value.toString();
        while (imageName.length() < 4) {
          imageName = "0" + imageName;
        }
        try {
          img = getImage(getCodeBase(), "images/" + imageName + ".png");
          repaint();
        }
        catch (Exception e) {
        }
      }
    }
  }
  
  public void paint(Graphics g) {
    g.drawImage(img, i * 50, j * 50, this);
  }
}
    
    