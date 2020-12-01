package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class CirclePro extends Figure{
    private double r;
    private final Color color;

    public CirclePro(){
        super();
        this.color = randomColor();
        this.r = new Random().nextDouble()*20+20;
    }

    @Override
    public void show(GraphicsContext PlaceToDraw){
        PlaceToDraw.setLineWidth(5);
        PlaceToDraw.setStroke(color);
        PlaceToDraw.strokeOval(getX()-r,getY()-r,r*2,r*2);
    }

    @Override
    public void remove(GraphicsContext PlaceToDraw){
        PlaceToDraw.setStroke(Color.WHITE);
        PlaceToDraw.strokeOval(getX()-r,getY()-r,r*2,r*2);
    }

    protected Color randomColor(){
        Random random = new Random();
        int dR = random.nextInt(255);
        int dG = random.nextInt(255);
        int dB = random.nextInt(255);
        Color c = Color.rgb(dR,dG,dB);
        return Color.color(c.getRed(),c.getGreen(),c.getBlue());
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public Color getColor(){
        return color;
    }

}