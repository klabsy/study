//filename：App16_3.java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class App16_3 extends Application
{
  Button bIn=new Button("放大");
  Button bRe=new Button("缩小");
  Circle circle=new Circle(50);
  @Override
  public void start(Stage stage)
  {
    StackPane sPane=new StackPane();
    circle.setStroke(Color.RED);
    circle.setFill(Color.WHITE);
    sPane.getChildren().add(circle);
    HBox hBox=new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(bIn,bRe);
    bIn.setOnAction(new IRHandler());
    bRe.setOnAction(new IRHandler());
    BorderPane bPane=new BorderPane();
    bPane.setCenter(sPane);
    bPane.setBottom(hBox);
    Scene scene=new Scene(bPane,200,150);
    stage.setTitle("圆的缩放");
    stage.setScene(scene);
    stage.show();
  }
  class IRHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource()==bIn)
      {
        circle.setRadius(circle.getRadius()+2);
      }
      else
        circle.setRadius(circle.getRadius()-2);
    }
  }
}
