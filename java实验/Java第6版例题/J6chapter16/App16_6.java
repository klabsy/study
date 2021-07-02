//filename：App16_6.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
public class App16_6 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Pane rPane=new Pane();
    Polygon pg=new Polygon();
    pg.setFill(null);
    pg.setStroke(Color.RED);
    ObservableList<Double> myList=pg.getPoints();
    double cX=130,cY=70,r=40;
    for(int i=0;i<6;i++)
    {
      myList.add(cX+r*Math.cos(2*i*Math.PI/6));
      myList.add(cY-r*Math.sin(2*i*Math.PI/6));
    }
    Polyline pl=new Polyline(new double[]{45,30,10,110,80,110});
    pl.setStroke(Color.BLUE);
    rPane.getChildren().addAll(pg,pl);
    Scene scene=new Scene(rPane,220,130);
    stage.setTitle("多边形和折线应用");
    stage.setScene(scene);
    stage.show();
  }
}
