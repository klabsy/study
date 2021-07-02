//filename：App15_11.java
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class App15_11 extends Application
{
  @Override
  public void start(Stage stage)
  {
    final Slider slider=new Slider();
    slider.setMin(0);
    slider.setMax(50);
    final ProgressBar pb=new ProgressBar();
    final ProgressIndicator pi=new ProgressIndicator();
    ChangeListener<Number> cListener=new ChangeListener<Number>()
    {
      public void changed(ObservableValue<? extends Number> ov,
                       Number old_val,Number new_val)
      {
        pb.setProgress(new_val.doubleValue()/50);
        pi.setProgress(new_val.doubleValue()/50);
      }
    };
    slider.valueProperty().addListener(cListener);
    final HBox hb = new HBox();
    hb.setSpacing(5);
    hb.setAlignment(Pos.CENTER);
    hb.getChildren().addAll(slider,pb,pi);
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.setTitle("进度条应用程序");
    stage.show();
  }
}
