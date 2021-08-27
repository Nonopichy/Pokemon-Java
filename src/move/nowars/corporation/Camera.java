package move.nowars.corporation;

public class Camera {
    public int x,y;
    public Camera(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void update(int x, int y){
        this.x = -x+Main.largura/2;
        this.y = -y+Main.altura/2;
    }

}
