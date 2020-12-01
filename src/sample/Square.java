package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Square extends Figure{
    private final int r;
    private final Color color;

    public Square(){
        super();
        this.color = randomColor();
        this.r = new Random().nextInt(60)+10;
    }

    @Override
    public void show(GraphicsContext PlaceToDraw){
        PlaceToDraw.fillRect(getX(),getY(),r,r);
        PlaceToDraw.setFill(color);
    }

    @Override
    public void remove(GraphicsContext PlaceToDraw){
        PlaceToDraw.setFill(Color.WHITE);
        PlaceToDraw.setStroke(Color.WHITE);
        PlaceToDraw.fillRect(getX(),getY(),r,r);
    }

    protected Color randomColor(){
        Random random = new Random();
        int dR = random.nextInt(255);
        int dG = random.nextInt(255);
        int dB = random.nextInt(255);
        Color c = Color.rgb(dR,dG,dB);
        return Color.color(c.getRed(),c.getGreen(),c.getBlue());
    }

    public int getR() {
        return r;
    }

    public Color getColor() {
        return color;
    }

}