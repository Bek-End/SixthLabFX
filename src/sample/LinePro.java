package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class LinePro extends Figure{
    private final int r;
    private final Color color;

    public LinePro(){
        super();
        this.r = new Random().nextInt(70)+10;
        this.color = randomColor();
    }

    @Override
    public void show(GraphicsContext PlaceToDraw){
        PlaceToDraw.setStroke(color);
        PlaceToDraw.setLineWidth(4);
        PlaceToDraw.strokeLine(getX(),getY(),getX()+r,getY()+r);
    }

    @Override
    public void remove(GraphicsContext PlaceToDraw){
        PlaceToDraw.setFill(Color.WHITE);
        PlaceToDraw.setStroke(Color.WHITE);
        PlaceToDraw.setLineWidth(4);
        PlaceToDraw.strokeLine(getX(),getY(),getX()+r,getY()+r);
    }

    private Color randomColor(){
        Random random = new Random();
        int dR = random.nextInt(255);
        int dG = random.nextInt(255);
        int dB = random.nextInt(255);
        Color c = Color.rgb(dR,dG,dB);
        return Color.color(c.getRed(),c.getGreen(),c.getBlue());
    }
}