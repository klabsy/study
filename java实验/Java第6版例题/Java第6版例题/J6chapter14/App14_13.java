//filename：App14_13.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class App14_13 extends Application
{
  @Override
  public void start(Stage stage)
  {
    TabPane tabPane=new TabPane();
    Tab tab1=new Tab();
    tab1.setText("第一个选项卡");
    tab1.setClosable(false);
    tab1.setContent(new Circle(200,200,30,Color.PINK));
    Tab tab2=new Tab("第二个选项卡");
    Image imb=new Image("祖国.jpg");
    ImageView iv=new ImageView(imb);
    iv.setFitHeight(100);
    iv.setPreserveRatio(true);
    tab2.setContent(new Label("",iv));
    tabPane.getTabs().addAll(tab1,tab2);
    Scene scene=new Scene(tabPane,230,100);
    stage.setTitle("选项卡面板与选项卡");
    stage.setScene(scene);
    stage.show();
  }
}
