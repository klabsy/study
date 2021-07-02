//filename£∫App15_17.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
public class App15_17 extends Application
{
  String eURL="file:///D:/java/wd.mp4 ";
  @Override
  public void start(Stage stage)
  {
    Media media=new Media(eURL);
    MediaPlayer mPlayer=new MediaPlayer(media);
    MediaView mView=new MediaView(mPlayer);
    mView.setFitWidth(350);
    mView.setFitHeight(180);
    Button pBut=new Button(">");
    pBut.setOnAction(e->
      {
        if(pBut.getText().equals(">"))
        {
          mPlayer.play();
          pBut.setText("||");
        }
        else
        {
          mPlayer.pause();
          pBut.setText(">");
        }
      });
    Button rBut=new Button("<<");
    rBut.setOnAction(e->mPlayer.seek(Duration.ZERO));
    Slider sVol=new Slider();
    sVol.setMinWidth(30);
    sVol.setPrefWidth(150);
    sVol.setValue(50);
    mPlayer.volumeProperty().bind(sVol.valueProperty().divide(100));
    HBox hB=new HBox(10);
    hB.setAlignment(Pos.CENTER);
    Label vol=new Label("“Ù¡ø");
    hB.getChildren().addAll(pBut,rBut,vol,sVol);
    BorderPane bPane=new BorderPane();
    bPane.setCenter(mView);
    bPane.setBottom(hB);
    Scene scene=new Scene(bPane);
    stage.setTitle(" ”∆µ≤•∑≈∆˜");
    stage.setScene(scene);
    stage.show();
  }
}
