//filename：App15_8.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
public class App15_8 extends Application
{ 
  private ComboBox<String> cbo=new ComboBox<String>();
  private String[] color={"红色","绿色","蓝色"};
  private TextArea ta=new TextArea("我喜欢用JavaFX编程");
  @Override
  public void start(Stage primaryStage)
  {
    ObservableList<String> items=FXCollections.observableArrayList(color);
    cbo.getItems().addAll(items);
    cbo.setPrefWidth(180);
    cbo.setValue("红色");
    BorderPane bPane=new BorderPane();
    ta.setPrefColumnCount(10);
    bPane.setTop(cbo);
    bPane.setCenter(ta);
    cbo.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent e)
        {
          if(cbo.getValue().equals("红色")) ta.setStyle("-fx-text-fill:red");
          if(cbo.getValue().equals("绿色")) ta.setStyle("-fx-text-fill:green");
          if(cbo.getValue().equals("蓝色")) ta.setStyle("-fx-text-fill:blue");
        }
      }
     );
    Scene scene=new Scene(bPane,185,100);
    primaryStage.setTitle("组合框应用");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
