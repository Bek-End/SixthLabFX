package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class EllipsePro extends CirclePro{
    private double r2;
    private boolean visible = true;

    public EllipsePro(){
        super();
        this.r2 = new Random().nextDouble()*20+20;
    }

    @Override
    public void show(GraphicsContext PlaceToDraw){
        PlaceToDraw.fillOval(getX(),getY(),getR(),r2);
        PlaceToDraw.setFill(getColor());
    }

    public void remove(GraphicsContext PlaceToDraw){
        PlaceToDraw.setFill(Color.WHITE);
        PlaceToDraw.setStroke(Color.WHITE);
        PlaceToDraw.fillOval(getX(),getY(),getR(),r2);
    }
    public void rotate(GraphicsContext graphicsContext){
        double temp;
        remove(graphicsContext);
        temp = getR();
        setR(r2);
        r2 = temp;
        show(graphicsContext);
    }
}