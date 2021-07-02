//filename:App15_16.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class App15_16 extends Application
{
  @Override
  public void start(Stage stage)
  {
    HBox hB=new HBox();
    final ColorPicker cP=new ColorPicker(Color.RED);
    final Text t=new Text("请选择颜色来设置我");
    hB.getChildren().addAll(cP,t);
    t.setFill(cP.getValue());
    cP.setOnAction(e->t.setFill(cP.getValue()));
    Scene scene = new Scene(hB,260,100);
    stage.setTitle("颜色选择器应用");
    stage.setScene(scene);
    stage.show();
  }
}
