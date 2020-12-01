package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import java.util.Random;

public class Controller {
    @FXML
    public Button rot= new Button();
    @FXML
    public Canvas PlaceToDraw = new Canvas();
    @FXML
    public Button Up = new Button();
    @FXML
    public Button Down = new Button();
    @FXML
    public Button Right = new Button();
    @FXML
    public Button Left = new Button();
    @FXML
    public Button Create = new Button();
    @FXML
    public Button Clear = new Button();
    @FXML
    public Button Move = new Button();
    @FXML
    public Button Show = new Button();
    @FXML
    public Button Destroy = new Button();
    @FXML
    public ComboBox<String> FigurePicker = new ComboBox<>();
    @FXML
    public Group group = new Group();

    private final ObservableList<String> figures = FXCollections.observableArrayList("All","Circle", "Rectangle", "Line", "Ellipse", "Square");
    private static final int size = 20;
    private static final Figure[] Figures = new Figure[size];
    private boolean detector = false;

    public Controller() {}

    @FXML
    void initialize() {
        GraphicsContext graphicsContext = PlaceToDraw.getGraphicsContext2D();
        FigurePicker.setItems(figures);
        FigurePicker.setValue("All");
        rot.setOnAction(actionEvent -> {
            if (detector) {
                Random random = new Random();
                int x = random.nextInt(800);
                int y = random.nextInt(300);
                for (int i = 0; i < size; i++) {
                    if (Figures[i] instanceof EllipsePro) {
                        ((EllipsePro)Figures[i]).rotate(graphicsContext);
                    }
                    graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                    for (int j = 0; j < size; j++) {
                        Figures[j].show(graphicsContext);
                    }
                }
            } else {
                System.out.println("Exception out of figures");
            }
        });
        Create.setOnAction(actionEvent -> {
            graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                int shape = random.nextInt(5);
                switch (shape) {
                    case 0:
                        Figures[i] = new CirclePro();
                        break;
                    case 1:
                        Figures[i] = new Square();
                        break;
                    case 2:
                        Figures[i] = new LinePro();
                        break;
                    case 3:
                        Figures[i] = new EllipsePro();
                        break;
                    case 4:
                        Figures[i] = new Rectangle();
                        break;
                    default:
                        break;
                }
            }
            detector = true;
        });

        Show.setOnAction(actionEvent -> {
            if (detector) {
                for (int i = 0; i < size; i++) {
                    Figures[i].show(graphicsContext);
                }
            } else {
                System.out.println("Exception out of figures");
            }
        });

        Move.setOnAction(actionEvent -> {
            if (detector) {
                Random random = new Random();
                int x = random.nextInt(800);
                int y = random.nextInt(300);
                for (int i = 0; i < size; i++) {
                    switch (FigurePicker.getValue()) {
                        case "All":
                            Figures[i].moveTo(x, y, graphicsContext);
                            break;
                        case "Circle":
                            if (Figures[i] instanceof CirclePro) {
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Rectangle":
                            if (Figures[i] instanceof Rectangle) {
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Line":
                            if (Figures[i] instanceof LinePro) {
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Ellipse":
                            if (Figures[i] instanceof EllipsePro) {
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Square":
                            if (Figures[i] instanceof Square) {
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        default:
                            break;
                    }
                    graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                    for (int j = 0; j < size; j++) {
                        Figures[j].show(graphicsContext);
                    }
                }
            } else {
                System.out.println("Exception out of figures");
            }
        });

        Clear.setOnAction(actionEvent -> graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight()));


        Destroy.setOnAction(actionEvent -> {
            int i = 0;
            for (Figure figure : Figures) {
                figure.remove(graphicsContext);
                Figures[i] = null;
                i += 1;
            }
            detector = false;
            graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
        });

        Right.setOnAction(actionEvent -> {
            if (!detector) {
                System.out.println("Exception out of figures");
            } else {
                for (int i = 0; i < size; i++) {
                    double x = Figures[i].getX();
                    double y = Figures[i].getY();
                    switch (FigurePicker.getValue()) {
                        case "All":
                            if (Figures[i].getX() < (900)) {
                                x = Figures[i].getX() + 10;
                                y = Figures[i].getY();
                            }
                            Figures[i].moveTo(x, y, graphicsContext);
                            break;
                        case "Circle":
                            if (Figures[i] instanceof CirclePro) {
                                if (Figures[i].getX() < (900)) {
                                    x = Figures[i].getX() + 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Rectangle":
                            if (Figures[i] instanceof Rectangle) {
                                if (Figures[i].getX() < (900)) {
                                    x = Figures[i].getX() + 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Line":
                            if (Figures[i] instanceof LinePro) {
                                if (Figures[i].getX() < (900)) {
                                    x = Figures[i].getX() + 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Ellipse":
                            if (Figures[i] instanceof EllipsePro) {
                                if (Figures[i].getX() < (900)) {
                                    x = Figures[i].getX() + 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Square":
                            if (Figures[i] instanceof Square) {
                                if (Figures[i].getX() < (900)) {
                                    x = Figures[i].getX() + 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        default:
                            break;
                    }
                }
                graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                for (int j = 0; j < size; j++) {
                    Figures[j].show(graphicsContext);
                }
            }
        });
        Left.setOnAction(actionEvent -> {
            if (detector) {
                for (int i = 0; i < size; i++) {
                    double x = Figures[i].getX();
                    double y = Figures[i].getY();
                    switch (FigurePicker.getValue()) {
                        case "All":
                            if (Figures[i].getX() > (20)) {
                                x = Figures[i].getX() - 10;
                                y = Figures[i].getY();
                            }
                            Figures[i].moveTo(x, y, graphicsContext);
                            break;
                        case "Circle":
                            if (Figures[i] instanceof CirclePro) {
                                if (Figures[i].getX() > (20)) {
                                    x = Figures[i].getX() - 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Rectangle":
                            if (Figures[i] instanceof Rectangle) {
                                if (Figures[i].getX() > (20)) {
                                    x = Figures[i].getX() - 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Line":
                            if (Figures[i] instanceof LinePro) {
                                if (Figures[i].getX() > (20)) {
                                    x = Figures[i].getX() - 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Ellipse":
                            if (Figures[i] instanceof EllipsePro) {
                                if (Figures[i].getX() > (20)) {
                                    x = Figures[i].getX() - 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Square":
                            if (Figures[i] instanceof Square) {
                                if (Figures[i].getX() > (20)) {
                                    x = Figures[i].getX() - 10;
                                    y = Figures[i].getY();
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        default:
                            break;
                    }
                }
                graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                for (int j = 0; j < size; j++) {
                    Figures[j].show(graphicsContext);
                }
            } else {
                System.out.println("Exception out of figures");
            }

        });

        Down.setOnAction(actionEvent -> {
            if (detector) {
                for (int i = 0; i < size; i++) {
                    double x = Figures[i].getX();
                    double y = Figures[i].getY();
                    switch (FigurePicker.getValue()) {
                        case "All":
                            if (Figures[i].getY() < (500)) {
                                x = Figures[i].getX();
                                y = Figures[i].getY() + 10;
                            }
                            Figures[i].moveTo(x, y, graphicsContext);
                            break;
                        case "Circle":
                            if (Figures[i] instanceof CirclePro) {
                                if (Figures[i].getY() < (500)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() + 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Rectangle":
                            if (Figures[i] instanceof Rectangle) {
                                if (Figures[i].getY() < (500)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() + 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Line":
                            if (Figures[i] instanceof LinePro) {
                                if (Figures[i].getY() < (500)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() + 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Ellipse":
                            if (Figures[i] instanceof EllipsePro) {
                                if (Figures[i].getY() < (500)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() + 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Square":
                            if (Figures[i] instanceof Square) {
                                if (Figures[i].getY() < (500)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() + 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        default:
                            break;
                    }
                }
                graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                for (int j = 0; j < size; j++) {
                    Figures[j].show(graphicsContext);
                }
            } else {
                System.out.println("Exception out of figures");
            }


        });

        Up.setOnAction(actionEvent -> {
            if (detector) {
                for (int i = 0; i < size; i++) {
                    double x = Figures[i].getX();
                    double y = Figures[i].getY();
                    switch (FigurePicker.getValue()) {
                        case "All":
                            if (Figures[i].getY() > (20)) {
                                x = Figures[i].getX();
                                y = Figures[i].getY() - 10;
                            }
                            Figures[i].moveTo(x, y, graphicsContext);
                            break;
                        case "Circle":
                            if (Figures[i] instanceof CirclePro) {
                                if (Figures[i].getY() > (20)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() - 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Rectangle":
                            if (Figures[i] instanceof Rectangle) {
                                if (Figures[i].getY() > (20)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() - 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Line":
                            if (Figures[i] instanceof LinePro) {
                                if (Figures[i].getY() > (20)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() - 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Ellipse":
                            if (Figures[i] instanceof EllipsePro) {
                                if (Figures[i].getY() > (20)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() - 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        case "Square":
                            if (Figures[i] instanceof Square) {
                                if (Figures[i].getY() > (20)) {
                                    x = Figures[i].getX();
                                    y = Figures[i].getY() - 10;
                                }
                                Figures[i].moveTo(x, y, graphicsContext);
                            }
                            break;
                        default:
                            break;
                    }
                }
                graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
                for (int j = 0; j < size; j++) {
                    Figures[j].show(graphicsContext);
                }
            } else {
                System.out.println("Exception out of figures");
            }
        });
    }
}