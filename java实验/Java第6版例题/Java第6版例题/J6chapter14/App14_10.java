//filename：App14_10.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
public class App14_10 extends Application
{
  Label lab1=new Label("JavaFX");
  Label lab2=new Label("祖国中心");
  Font fon=new Font("Cambria",30);
  @Override
  public void start(Stage primaryStage)
  {
    HBox hbp=new HBox();
    hbp.setSpacing(5);
    hbp.setPadding(new Insets(10,10,10,10));
    Image imb=new Image("天安门.jpg");
    ImageView iv1=new ImageView(imb);
    iv1.setFitWidth(120);
    iv1.setPreserveRatio(true);
    lab1.setGraphic(iv1);
    lab1.setTextFill(Color.RED);
    lab1.setFont(fon);
    lab2.setFont(new Font("黑体",20));
    lab2.setRotate(270);
    lab2.setTranslateY(50);
    lab2.setStyle("-fx-border-color:blue");
    Tooltip t=new Tooltip("我是标签2");
    t.setStyle("-fx-background-color:green;-fx-opacity:0.8");
    Tooltip.install(lab2,t);
    hbp.getChildren().addAll(lab1,lab2);
    hbp.setStyle("-fx-border-color:red;-fx-background-color:lightgray");
    Scene scene=new Scene(hbp,400,150);
    primaryStage.setTitle("标签的应用");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
