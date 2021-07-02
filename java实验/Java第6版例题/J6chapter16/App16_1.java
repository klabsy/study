//filename£∫App16_1.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeLineCap;
public class App16_1 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Pane pane=new Pane();
    Line rL=new Line(10,20,20,20);
    rL.setStroke(Color.RED);
    rL.setStrokeWidth(10);
    rL.setStrokeLineCap(StrokeLineCap.BUTT);
    rL.getStrokeDashArray().addAll(10d,5d,15d);
    rL.setStrokeDashOffset(0);
    rL.endXProperty().bind(pane.widthProperty().subtract(10));
    Line gL=new Line(10,50,10,10);
    gL.setStroke(Color.GREEN);
    gL.setStrokeWidth(5);
    gL.endXProperty().bind(pane.widthProperty().subtract(10));
    gL.endYProperty().bind(pane.heightProperty().multiply(4).divide(5));
    Line bL=new Line(10,50,10,10);
    bL.setStroke(Color.BLUE);
    bL.setStrokeWidth(10);
    bL.setStrokeLineCap(StrokeLineCap.ROUND);
    bL.startXProperty().bind(pane.widthProperty().subtract(10));
    bL.endYProperty().bind(pane.heightProperty().multiply(4).divide(5));
    pane.getChildren().addAll(rL,gL,bL);
    Scene scene=new Scene(pane,210,120);
    stage.setTitle("ªÊ÷∆÷±œﬂ");
    stage.setScene(scene);
    stage.show();
  }
}

