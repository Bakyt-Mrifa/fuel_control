package kg.rifah;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start (Stage mainStage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("/fuelControl.fxml"));
        mainStage.setTitle("Программа расчета расхода топлива");
        mainStage.setScene(new Scene(root));
        mainStage.setResizable(false);
       // mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
