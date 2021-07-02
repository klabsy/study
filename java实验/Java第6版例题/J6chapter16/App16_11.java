//filename：App16_11.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
public class App16_11 extends Application
{
  int i=0;
  @Override
  public void start(Stage stage)
  {
    StackPane root=new StackPane();
    Image im=new Image("image/d"+i+".gif");
    ImageView iv=new ImageView(im);
    root.getChildren().add(iv);
    EventHandler<ActionEvent> eventHandler=e->
    {
      Image img=new Image("image/d"+i+".gif");
      iv.setImage(img);
      i=i+1;
      if(i>9) i=0;
    };
    KeyFrame kFrame=new KeyFrame(Duration.millis(500),eventHandler);
    Timeline tLine=new Timeline(kFrame);
    tLine.setCycleCount(Timeline.INDEFINITE);
    tLine.play();
    iv.setOnMouseClicked(e->
        {
          if(tLine.getStatus()==Animation.Status.PAUSED)
            tLine.play();
          else
            tLine.pause();
        }
      );
    Scene scene=new Scene(root,300,200);
    stage.setScene(scene);
    stage.setTitle("动画程序设计");
    stage.show();
  }
}
