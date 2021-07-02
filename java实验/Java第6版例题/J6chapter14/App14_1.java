//filename：App14_1.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
public class App14_1 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    Button bt=new Button("我是按钮");
    Scene scene=new Scene(bt,210,80);
    primaryStage.setTitle("我的JavaFX窗口");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args)
  {
    Application.launch(args);
  }
}
