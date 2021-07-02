//filename：App15_10.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.geometry.Orientation;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
public class App15_10 extends Application
{ 
  private Slider sl=new Slider();
  private Slider rsl=new Slider(0.0,1.0,0.5);
  private Slider gsl=new Slider(0.0,1.0,0.5);
  private Slider bsl=new Slider(0.0,1.0,0.5);
  private Text t=new Text("JavaFX编程");
  @Override
  public void start(Stage primaryStage)
  {
    sl.setShowTickLabels(true);
    sl.setShowTickMarks(true);
    sl.setValue(t.getFont().getSize());
    rsl.setOrientation(Orientation.VERTICAL);
    bsl.setOrientation(Orientation.VERTICAL);
    rsl.setShowTickLabels(true);
    gsl.setShowTickLabels(true);
    bsl.setShowTickLabels(true);
    IListener Fc=new IListener();
    rsl.valueProperty().addListener(Fc);
    gsl.valueProperty().addListener(Fc);
    bsl.valueProperty().addListener(Fc);
    StackPane sPane=new StackPane();
    sPane.getChildren().add(t);
    sl.valueProperty().addListener(ov->
        {
          double size=sl.getValue();
          Font font=new Font(size);
          t.setFont(font);
        }
      );
    BorderPane rootBP=new BorderPane();
    rootBP.setLeft(rsl); rootBP.setTop(gsl); rootBP.setRight(bsl);
    rootBP.setBottom(sl); rootBP.setCenter(sPane);
    Scene scene=new Scene(rootBP,360,200);
    primaryStage.setTitle("滑动条的应用");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  class IListener implements InvalidationListener
  {
    @Override
    public void invalidated(Observable ov)
    {
      double r=rsl.getValue(); 
      double g=gsl.getValue();
      double b=bsl.getValue();
      Color c=Color.color(r,g,b);
      t.setFill(c);
    }
  }
}
