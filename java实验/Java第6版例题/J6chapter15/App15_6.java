//filename：App15_6.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class App15_6 extends Application
{
  Font fN=Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,16);
  Font fB=Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,16);
  Font fI=Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.ITALIC,16);
  Font fBI=Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,16);
  CheckBox chkB=new CheckBox("粗体");
  CheckBox chkI=new CheckBox("斜体");
  RadioButton r=new RadioButton("红色");
  RadioButton g=new RadioButton("绿色");
  RadioButton b=new RadioButton("蓝色");
  Text t=new Text("我喜欢JavaFX编程");
  @Override
  public void start(Stage primaryStage)
  {
    VBox vbL=new VBox(20);
    vbL.setStyle("-fx-border-color:green");
    vbL.getChildren().addAll(chkB,chkI);
    ToggleGroup gro=new ToggleGroup();
    r.setToggleGroup(gro);
    g.setToggleGroup(gro);
    b.setToggleGroup(gro);
    VBox vbR=new VBox();
    vbR.setStyle("-fx-border-color:blue");
    vbR.getChildren().addAll(r,g,b);
    BorderPane rootBP=new BorderPane();
    t.setFont(fN);
    rootBP.setLeft(vbL);
    rootBP.setRight(vbR);
    rootBP.setCenter(t);
    Han hand=new Han();
    r.setOnAction(hand);
    g.setOnAction(hand);
    b.setOnAction(hand);
    chkB.setOnAction(hand);
    chkI.setOnAction(hand);
    Scene scene=new Scene(rootBP,260,60);
    primaryStage.setTitle("复选框与单选按钮");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  class Han implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent e)
    {
      if(r.isSelected()) t.setFill(Color.RED);
      if(g.isSelected()) t.setFill(Color.GREEN);
      if(b.isSelected()) t.setFill(Color.BLUE);
      if(chkB.isSelected() && chkI.isSelected())
        t.setFont(fBI);
      else if(chkB.isSelected())
        t.setFont(fB);
      else if(chkI.isSelected())
        t.setFont(fI);
      else
        t.setFont(fN);
    }
  }
}
