//filename：App14_5.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
public class App14_5 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    BorderPane rootPane=new BorderPane();
    rootPane.setPadding(new Insets(10));
    Button bt=new Button("顶部工具条");
    bt.setPrefSize(280,20);
    rootPane.setTop(bt);
    rootPane.setBottom(new Button("底部状态栏"));
    rootPane.setLeft(new Button("左部导航菜单"));
    rootPane.setRight(new Button("显示信息"));
    rootPane.setCenter(new Button("中间工作区"));
    Scene scene=new Scene(rootPane,280,130);
    primaryStage.setTitle("边界式面板");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
