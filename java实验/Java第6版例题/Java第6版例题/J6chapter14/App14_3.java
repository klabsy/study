//filename：App14_3.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
public class App14_3 extends Application
{
  Button bt=new Button("确定");
  @Override
  public void start(Stage primaryStage)
  {
    StackPane sPane=new StackPane();
    bt.setStyle("-fx-border-color:blue");
    Button bt1=new Button("我也是按钮");
    bt1.setPrefSize(80,50);
    bt1.setStyle("-fx-border-color:green");
    bt1.setRotate(-45);
    sPane.getChildren().addAll(bt1,bt);
    sPane.setRotate(45);
    sPane.setStyle("-fx-border-color:red;-fx-background-color:lightgray");
    Scene scene=new Scene(sPane,180,100); 
    primaryStage.setTitle("栈面板");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
