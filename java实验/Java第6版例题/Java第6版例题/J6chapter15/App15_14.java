//filename:App15_14.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
public class App15_14 extends Application
{ 
  private Button but1=new Button("打开",new ImageView("icon/openFile.jpg"));
  private Button but2=new Button("保存",new ImageView("icon/saveFile.jpg"));
  private Button but3=new Button("帮助",new ImageView("icon/helpFile.jpg"));
  private TextArea ta=new TextArea("我现在是禁用状态");
  @Override
  public void start(Stage primaryStage)
  {
    ta.setEditable(false); 
    but1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    but2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    but3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    but1.setTooltip(new Tooltip("打开"));
    but2.setTooltip(new Tooltip("保存"));
    but3.setTooltip(new Tooltip("帮助"));
    but1.setOnAction(e->
      {
        ta.setEditable(false);
        ta.setText("恭喜你！\n哈哈，现在可以编辑我了");
        ta.setStyle("-fx-text-fill:red");
      }
    );  
    ToolBar tB=new ToolBar(but1,but2,but3);
    BorderPane rootBP=new BorderPane();
    rootBP.setCenter(ta);
    rootBP.setTop(tB);
    Scene scene=new Scene(rootBP,230,100);
    primaryStage.setTitle("工具栏应用程序");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
