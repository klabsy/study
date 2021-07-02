//filename：App15_2.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
public class App15_2 extends Application
{
  Button bt=new Button("设置字体颜色");
  TextArea ta=new TextArea("字体颜色");
  @Override
  public void start(Stage primaryStage)
  {
    BorderPane bPane=new BorderPane();
    bPane.setCenter(ta);
    bPane.setBottom(bt);
    BorderPane.setAlignment(bt,Pos.CENTER);
    bt.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent e)
        {
          ta.setStyle("-fx-text-fill:red");
        }
      }
     );
    Scene scene=new Scene(bPane,180,100);
    primaryStage.setTitle("操作事件");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
