//filename：App14_12.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
public class App14_12 extends Application
{
  final CheckBox chk1=new CheckBox("粗体");
  final CheckBox chk2=new CheckBox("斜体");
  final CheckBox chk3=new CheckBox("楷体");
  final RadioButton rb1=new RadioButton("红色");
  final RadioButton rb2=new RadioButton("绿色");
  final RadioButton rb3=new RadioButton("蓝色");
  final Button bt1=new Button("确认");
  final Button bt2=new Button("取消"); 
  final TextArea ta=new TextArea("我是文本区");
  @Override
  public void start(Stage primaryStage)
  {
    chk2.setSelected(true);
    VBox vbL=new VBox(3);
    vbL.getChildren().addAll(chk1,chk2,chk3);
    rb1.setSelected(true);
    final ToggleGroup gro=new ToggleGroup();
    rb1.setToggleGroup(gro);
    rb2.setToggleGroup(gro);
    rb3.setToggleGroup(gro);
    VBox vbR=new VBox(3);
    vbR.getChildren().addAll(rb1,rb2,rb3);
    HBox hB=new HBox(20);
    hB.getChildren().addAll(bt1,bt2);
    hB.setAlignment(Pos.CENTER);
    BorderPane rootBP=new BorderPane();
    ta.setPrefColumnCount(10);
    ta.setPrefRowCount(3);
    ta. setWrapText(true);
    rootBP.setLeft(vbL);
    rootBP.setRight(vbR);
    rootBP.setCenter(ta);
    rootBP.setBottom(hB);
    Scene scene=new Scene(rootBP);
    primaryStage.setTitle("复选框与单选按钮");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
