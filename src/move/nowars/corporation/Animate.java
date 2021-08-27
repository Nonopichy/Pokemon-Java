package move.nowars.corporation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animate {
    public int loop;
    public int delay;
    private int count_frames;

    public int frameNow = 0;
    public BufferedImage[] frames;

    public BufferedImage image;

    public Animate(int delay, BufferedImage... frames){
        this.frames = new BufferedImage[frames.length];
        for(int x = 0; x < frames.length ; x++)
            this.frames[x] = frames[x];
        this.delay = delay;

        image = frames[0];
        count_frames = frames.length;
    }

    public void update(){
        loop++;
        if(loop >= delay){
            loop = 0;
            nextFrame();
        }
    }

    public void nextFrame(){
        for(int x = 0; x < count_frames; x++){
            if(frameNow==x)
                image = frames[x];
        }

        frameNow++;

        if(frameNow > count_frames)
            frameNow = 0;
    }

    public void drawAnimate(Graphics g, int x, int y, int width, int height){
        g.drawImage(image, x, y, width, height, null);
    }

}
