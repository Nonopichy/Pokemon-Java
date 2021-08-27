package move.nowars.corporation.MapMaker;

import move.nowars.corporation.*;

import java.awt.*;

public class PlayerMapMaker {
    public int x;
    public int y;
    public int weight;
    public int height;
    public Direction direction = Direction.atras;
    public int speed;
    public boolean movement;
    public World world;

    /**
     * Paramento de contrução para o objeto Player
     * @return void
     */

    public PlayerMapMaker(int x, int y, int speed, int sx, int sy, int weight, int height){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
    }

    /**
     * Atualização por tick do objeto Player
     * @return void
     */

    public void update(){
        if(direction==Direction.frente) {
            if(movement == true)
                frente.update();
            else
                frente.image = frente.frames[0];
        }
        else if (direction==Direction.atras) {
            if(movement == true)
                atras.update();
            else
                atras.image = atras.frames[0];
        }
        else if (direction==Direction.esquerda) {
            if(movement == true)
                esquerda.update();
            else
                esquerda.image = esquerda.frames[0];
        }
        else if (direction==Direction.direita) {
            if(movement == true)
                direita.update();
            else
                direita.image = direita.frames[0];
        }
    }

    /**
     * Renderização do objeto Player
     * @return void
     */

    public void render(Graphics g){

        if(direction==Direction.frente)
            frente.drawAnimate(g, x,y,weight,height);
        else if (direction==Direction.atras)
            atras.drawAnimate(g, x,y,weight,height);
        else if (direction==Direction.esquerda)
            esquerda.drawAnimate(g, x,y,weight,height);
        else if (direction==Direction.direita)
            direita.drawAnimate(g, x,y,weight,height);
    }

    /**
     * Animações de Sprites disponiveis
     * @return Animate
     */

    public Animate frente = new Animate(20,
            MapMaker.managerSprite.getSprite(14,206,34,50),
            MapMaker.managerSprite.getSprite(78,204,34,50),
            MapMaker.managerSprite.getSprite(142,206,34,46),
            MapMaker.managerSprite.getSprite(206,204,34,50));
    public Animate atras = new Animate(20,
            MapMaker.managerSprite.getSprite(14,13,33,46),
            MapMaker.managerSprite.getSprite(78,10,34,52),
            MapMaker.managerSprite.getSprite(142,12,34,48),
            MapMaker.managerSprite.getSprite(206,10,34,52)
    );
    public Animate esquerda = new Animate(20,
            MapMaker.managerSprite.getSprite(14,78,33,46),
            MapMaker.managerSprite.getSprite(80,76,32,48),
            MapMaker.managerSprite.getSprite(144,78,32,46),
            MapMaker.managerSprite.getSprite(208,76,32,46));
    public Animate direita = new Animate(20,
            MapMaker.managerSprite.getSprite(14,142,33,46),
            MapMaker.managerSprite.getSprite(80,140,32,48),
            MapMaker.managerSprite.getSprite(144,142,32,46),
            MapMaker.managerSprite.getSprite(208,140,32,46)
            );

    /**
     * Movimentos
     * @return void
     */

    public void teleport(Location location){
        x = location.x;
        y = location.y;
        world = location.world;
    }

    public Boolean canWalk(int x, int y){
        /*
        for(Block b : MapMaker.world.blocks){
            if(b.colission==true) {
                if (x < b.x + b.size && x + weight > b.x && y < b.y + b.size && y + height > b.y) {
                    System.out.println("false");
                    return false;
                }
            }
        }
        System.out.println("true");

         */
        return true;
    }

    public void moveFrente(){
        direction = Direction.frente;
        for(int i = 1; i < speed;i++){
            if(canWalk(x, y - i)==false)
                return;
        }
        y = y - speed;
        movement = true;
    } public void moveEsquerda(){
        direction = Direction.esquerda;
        for(int i = 1; i < speed;i++){
            if(canWalk(x - i, y )==false)
                return;
        }
        x = x - speed;
        movement = true;
    } public void moveDireita(){
        direction = Direction.direita;
        for(int i = 1; i < speed;i++){
            if(canWalk(x + i, y)==false)
                return;
        }
        x = x + speed;
        movement = true;
    } public void moveAtras(){
        direction = Direction.atras;
        for(int i = 1; i < speed;i++){
            if(canWalk(x, y + i)==false)
                return;
        }
        y = y + speed;
        movement = true;
    }

}
