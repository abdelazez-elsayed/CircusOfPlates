
package eg.edu.alexu.csd.oop.game.sample.GameObjects;

import java.awt.image.BufferedImage;

public class YellowBall extends Plates{
    static int MAX=1;
    static BufferedImage[] spiriteImages = new BufferedImage[1];
    public YellowBall(int posX, int posY, String path) {
        super(posX, posY, "");
      //  spiriteImages=super.getSpriteImages();
        super.setColor("Yellow");
        super.setType("Ball");
        if(spiriteImages[0]!=null)super.setBuf(spiriteImages[0]);

    }
    @Override
    public  BufferedImage[] getSpriteImages(){
        return spiriteImages;
    }
    @Override
    public void setBuf(BufferedImage img){
        spiriteImages[0]=img;
        super.setBuf(spiriteImages[0]);
    }
}