package move.nowars.corporation;

import java.awt.image.BufferedImage;

public enum TypeBlocks {

    GRASS(32, false, Main.managerSpriteBlock.getSprite(2,2, 32,32)),
    GRASS_1(32, false, Main.managerSpriteBlock.getSprite(36,2, 32,32)),
    GRASS_2(32, false, Main.managerSpriteBlock.getSprite(70,2, 32,32)),
    GRASS_3(32, false, Main.managerSpriteBlock.getSprite(104,2, 32,32)),
    GRASS_4(32, false, Main.managerSpriteBlock.getSprite(36,36, 32,32)),
    GRASS_5(32, false, Main.managerSpriteBlock.getSprite(70,36, 32,32)),
    GRASS_6(32, false, Main.managerSpriteBlock.getSprite(104,36, 32,32)),
    GRASS_7(32, false, Main.managerSpriteBlock.getSprite(36,70, 32,32)),
    GRASS_8(32, false, Main.managerSpriteBlock.getSprite(70,70, 32,32)),
    GRASS_9(32, false, Main.managerSpriteBlock.getSprite(104,70, 32,32)),

    PEDRA(32, true, Main.managerSpriteBlock.getSprite(2,36, 32,32));

    private int size;
    private boolean colission;
    private BufferedImage texture;

    TypeBlocks(int size, Boolean colission, BufferedImage texture) {
        this.size = size;
        this.colission = colission;
        this.texture = texture;
    }

    public BufferedImage getTexture(){
        return texture;
    }
    public int getSize() {
        return size;
    }
    public boolean getColission() {
        return colission;
    }

}
