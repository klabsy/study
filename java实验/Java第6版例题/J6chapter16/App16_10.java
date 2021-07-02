//filename：App16_10.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
public class App16_10 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Text t=new Text("滚动字幕");
    t.setTextOrigin(VPos.TOP);
    t.setFont(Font.font(24));
    Pane root=new Pane(t);
    root.setPrefSize(300,60);
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.setTitle("时间轴动画程序设计");
    stage.show();
    double sceneWidth=scene.getWidth();
    double tWidth=t.getLayoutBounds().getWidth();
    KeyValue sKeyValue=
       new KeyValue(t.translateXProperty(),sceneWidth); 
    KeyFrame sFrame=new KeyFrame(Duration.ZERO,sKeyValue);
    KeyValue eKeyValue=
       new KeyValue(t.translateXProperty(),-1.0*tWidth);
    KeyFrame eFrame=new KeyFrame(Duration.seconds(5),eKeyValue);
    Timeline timeline=new Timeline(sFrame,eFrame);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }
}
