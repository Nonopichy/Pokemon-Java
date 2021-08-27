package move.nowars.corporation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Canvas implements Runnable, KeyListener {


    public static int altura = 480;
    public static int largura = 620;
    public static Main Main;
    public static JFrame jframe;
    public static String name = "Move";

    public static Player player;
    public static Camera camera;

    public static ManagerSprite managerSprite;
    public static ManagerSprite managerSpriteBlock;

    public static World world;
    public static World world2;

    public static int fps;
    public static Font font;
    public static Maker maker;
    public static MP3 mp3;

    public Main(){

        Dimension dimension = new Dimension(largura, altura);
        setPreferredSize(dimension);
        addKeyListener(this);
        mp3 = new MP3("data/sounds/bg/b1.mp3");
        mp3.play();
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resource/Font.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(12f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        managerSpriteBlock = new ManagerSprite("/resource/blocks.png");
        managerSprite = new ManagerSprite("/resource/spritesheet.png");
        camera = new Camera(0,0);
        player = new Player(0,0, 4, 14,13,32,32);

        maker = new Maker("/resource/mapa.txt");

        world = new World("Mundo",maker.largura,maker.altura);
        world.blocks = maker.blocks;
        world.setSpawn(new Location(world, world.width/2, world.height/2));

        player.world = world;
        player.teleport(world.spawn);
    }

    public static void main(String[] args){
        Main = new Main();
        jframe = new JFrame(name);
        jframe.add(Main);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.pack();
        jframe.setDefaultCloseOperation(3);
        jframe.setVisible(true);
        (new Thread(Main)).start();
    }

    public void update(){
        player.update();
        camera.update(player.x,player.y);
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(camera.x, camera.y);

        player.world.render(player.x, player.y, g2);
        player.render(g);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Fps: "+fps, player.x - 300, player.y - 220);
        g2.translate(-camera.x, -camera.y);

        bs.show();
    }
    private long lastTime;
    @Override
    public void run() {
        while (true) {
            update();
            render();
            lastTime = System.nanoTime();
            try {
                Thread.sleep((1000 / 60));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fps = (int) (1000000000.0 / (System.nanoTime() - lastTime)); //one second(nano) divided by amount of time it takes for one frame to finish
            lastTime = System.nanoTime();
     }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
          //up

       if(e.getKeyCode()==38||e.getKeyCode()==87) {
           player.moveFrente();

       }

           ;
       //left
        if  (e.getKeyCode()==37||e.getKeyCode()==65)
            player.moveEsquerda();

            ;
        //right
         if(e.getKeyCode()==39||e.getKeyCode()==68)
            player.moveDireita();

            ;
        //down
         if(e.getKeyCode()==40||e.getKeyCode()==83) {
             player.moveAtras();

         }

            ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.movement = false;
    }

}
