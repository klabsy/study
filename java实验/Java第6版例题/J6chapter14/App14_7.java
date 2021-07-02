//filename：App14_7.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
public class App14_7 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    Image imb=new Image("image/中国灯笼.jpg");
    ImageView iv1=new ImageView(imb);
    Button bt1=new Button("您好",iv1);
    Button bt2=new Button("中国",new ImageView("image/中国心.jpg"));
    HBox box=new HBox(20);
    box.getChildren().addAll(bt1,bt2);
    box.setAlignment(Pos.CENTER);
    Image im=new Image("image/国旗.jpg");
    ImageView iv2=new ImageView();
    iv2.setImage(im);
    iv2.setFitWidth(80);
    iv2.setPreserveRatio(true);
    iv2.setSmooth(true);
    iv2.setCache(true);
    ImageView iv3=new ImageView();
    iv3.setImage(im);
    iv3.setRotate(90);
    iv3.setFitWidth(100);
    iv3.setPreserveRatio(true);
    BorderPane rootPane=new BorderPane();
    rootPane.setBottom(box);
    rootPane.setCenter(iv2);
    rootPane.setRight(iv3);
    Scene scene=new Scene(rootPane,200,150);
    primaryStage.setTitle("图像与显示");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
