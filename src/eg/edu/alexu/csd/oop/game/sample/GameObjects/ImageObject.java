package eg.edu.alexu.csd.oop.game.sample.GameObjects;


import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageObject implements GameObject{
    private static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private boolean visible;
    private int type;
    public void setBuf(BufferedImage img){
        spriteImages[0]=img;
        wid=img.getWidth();
        hi=img.getHeight();
    }

    public String getPath() {
        return path;
    }

    private String path;



    private boolean hand;
    public ImageObject(int posX, int posY, String path){
        this(posX, posY, path, 0);
    }
    private int wid;
    private int hi;

    public ImageObject(int posX, int posY, String path, int type){
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        this.path=path;
        // create   a bunch of buffered images and place into an array, to be displayed sequentially
            if(this instanceof Plates)return;
            try {
                if(!path.equalsIgnoreCase("")) {
                    spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
                    wid = spriteImages[0].getWidth();
                    hi = spriteImages[0].getHeight();
                }
//            Type=path.substring(path.indexOf('/')+1);

            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth(){
        return wid;
    }

    @Override
    public int getHeight() {
        return hi;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}
