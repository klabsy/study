//filename：App14_2.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
public class App14_2 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    Button bt=new Button("我是按钮");
    Scene scene=new Scene(bt,210,80);
    primaryStage.setTitle("我是主舞台"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    Stage stage=new Stage();
    stage.setAlwaysOnTop(true);
    stage.setTitle("第二舞台");
    Button bt1=new Button("我也是按钮");
    stage.setScene(new Scene(bt1,180,100));
    stage.show();   //显示新的舞台
  }
}
