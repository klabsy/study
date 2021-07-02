//filename：App15_5.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
public class App15_5 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Text t=new Text(20,20,"移动我");
    Pane pane=new Pane();
    pane.getChildren().add(t);
    t.setOnKeyPressed(e->
      {
        switch(e.getCode())
        {
          case UP:
          case KP_UP:
            t.setY(t.getY()-5);
           break;
          case DOWN:
          case KP_DOWN:
            t.setY(t.getY()+5);
            break;
          case LEFT:
          case KP_LEFT:
            t.setX(t.getX()-5);
            break;
          case RIGHT:
          case KP_RIGHT:
            t.setX(t.getX()+5);
            break;
          default:
            t.setText(e.getText());
        }
      }
    );
    Scene scene=new Scene(pane,180,100);
    stage.setTitle("移动操作");
    stage.setScene(scene);
    stage.show();
    t.requestFocus();
  }
}
