package kg.rifah.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;


public class FuelController {

        @FXML
        private TextField txtFuel1;

        @FXML
        private TextField txtDistance;

        @FXML
        private Button btnCalc1;

        @FXML
        private TextField txtFuel2;

        @FXML
        private TextField txtСonsumption;

        @FXML
        private Button btnCalc2;

        @FXML
        private Label lblDisplayFuelCons;

        @FXML
        private Label lblDisplayDistanceCons;

        @FXML
        private Button btnCancel;

        @FXML
        void onBtnClicked(ActionEvent event) {
        if(event.getSource().equals(btnCalc1)){
            fuelConsumption();
        }else if (event.getSource().equals(btnCalc2)){
            distanceConsumption();
        }else if (event.getSource().equals(btnCancel)){
            onExitBtn();
        }

    }

    private void onExitBtn() {
        (btnCancel.getScene().getWindow()).hide();
    }

    @FXML
    void initialize() {
//Поля принимают только Double значения, но пока еще типа String
        setAcceptOnlyDouble(txtFuel1);
        setAcceptOnlyDouble(txtDistance);
        setAcceptOnlyDouble(txtFuel2);
        setAcceptOnlyDouble(txtСonsumption);
    }


//Расчет - сколько топлива расходует авто на 100км?
        private void fuelConsumption() {

            if (txtFuel1.getLength()==0){
                Alert message=new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка заполнения");
                message.setContentText("Введите количество топлива в литрах");
                message.showAndWait();
            }
            if (txtDistance.getLength()==0){
                Alert message=new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка заполнения");
                message.setContentText("Введите количество пройденной дистанции в КМ");
                message.showAndWait();
            }

        double value1=Double.parseDouble(checkContent(txtFuel1.getText()));
        double value2=Double.parseDouble(checkContent(txtDistance.getText()));
        double result=(value1*100)/value2;

        lblDisplayFuelCons.setWrapText(true);
        lblDisplayFuelCons.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 20; -fx-text-fill: #0d5a8b;");

        lblDisplayFuelCons.setText("Ваш автомобиль расходует "+ new DecimalFormat("##.##").format(result)+"л. топлива на 100 км");
   }



//Расчет - на сколько КМ хватит указанное количестов топлива?
    private void distanceConsumption() {

        if (txtFuel2.getLength()==0){
            Alert message=new Alert(Alert.AlertType.ERROR);
            message.setHeaderText("Ошибка заполнения");
            message.setContentText("Введите количество топлива в литрах");
            message.showAndWait();
        }else if (txtСonsumption.getLength()==0){
            Alert message=new Alert(Alert.AlertType.ERROR);
            message.setHeaderText("Ошибка заполнения");
            message.setContentText("Введите расход вашего авто на 100 КМ");
            message.showAndWait();
        }

        double value1=Double.parseDouble(checkContent(txtFuel2.getText()));
        double value2=Double.parseDouble(checkContent(txtСonsumption.getText()));
        double result=(100/value2)*value1;

        lblDisplayDistanceCons.setWrapText(true);
        lblDisplayDistanceCons.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 20; -fx-text-fill: #0d5a8b;");

        lblDisplayDistanceCons.setText(value1+"л. топлива, хватит на "+ new DecimalFormat("##.##").format(result)+"км");
    }


    private String checkContent(String content){
        String value;
        if (content.contains(",")){

            value=content.replace(",",".");
            return value;
        }
        return content;
    }


    private TextField setAcceptOnlyDouble (final TextField value){

        value.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}(([\\.]||[\\,])\\d{0,4})?")) {
                    value.setText(oldValue);
                }
            }
        });

            return value;
    }
}
