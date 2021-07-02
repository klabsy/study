//filename：App14_4.java
import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
public class App14_4 extends Application
{
  Button[] bt=new Button[6];    //创建按钮数组
  @Override
  public void start(Stage primaryStage)
  {
    FlowPane rootNode=new FlowPane();
    rootNode.setOrientation(Orientation.HORIZONTAL);
    rootNode.setPadding(new Insets(12,13,14,15));
    rootNode.setHgap(8);
    rootNode.setVgap(5);
    for(int i=0;i<bt.length;i++)
    {
      bt[i]=new Button("按钮"+(i+1));
      rootNode.getChildren().add(bt[i]);
    }
    Scene scene=new Scene(rootNode,200,80);
    primaryStage.setTitle("流式面板"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
  }
}
