package io.modernfamily;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 *
 * @author baseerfaizan
 */
public class FXMLDocumentController implements Initializable {

    public static int CountID;

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;

    ImageView img = new ImageView();
    @FXML
    private ImageView ring1;
    @FXML
    private ImageView ring2;
    @FXML
    private ImageView ring3;
    @FXML
    private ImageView ring4;

    Parent root;
    Stage theStage;
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;


    public void initialize(URL url, ResourceBundle rb) {

        ring1.setVisible(false);
        ring2.setVisible(false);
        ring3.setVisible(false);
        ring4.setVisible(false);
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        ring1.setVisible(true);
    }

    @FXML
    private void handleButtonAction1(MouseEvent event) {
        ring1.setVisible(false);
    }

    @FXML
    private void handleButtonAction2(MouseEvent event) {
        ring2.setVisible(true);
    }

    @FXML
    private void handleButtonAction3(MouseEvent event) {
        ring2.setVisible(false);
    }

    @FXML
    private void handleButtonAction4(MouseEvent event) {
        ring3.setVisible(true);
    }

    @FXML
    private void handleButtonAction5(MouseEvent event) {
        ring3.setVisible(false);
    }

    @FXML
    private void handleButtonAction6(MouseEvent event) {
        ring4.setVisible(true);
    }

    @FXML
    private void handleButtonAction7(MouseEvent event) {
        ring4.setVisible(false);
    }

    @FXML
    public int handleButtonActionLast1(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == Button1) {
            CountID = 1;
            setCountID(CountID);
            //get reference to the button's stage
            stage = (Stage) Button1.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        return CountID;
    }

    @FXML
    public int handleButtonActionLast2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == Button2) {
            CountID = 2;
            setCountID(CountID);
            //get reference to the button's stage
            stage = (Stage) Button2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        return CountID;
    }

    @FXML
    public int handleButtonActionLast3(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == Button3) {
            CountID = 3;
            setCountID(CountID);
            //get reference to the button's stage
            stage = (Stage) Button3.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        return CountID;
    }

    @FXML
    public int handleButtonActionLast4(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == Button4) {
            CountID = 4;
            setCountID(CountID);
            //get reference to the button's stage
            stage = (Stage) Button4.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        return CountID;
    }

    public static void setCountID(int CID) {
        FXMLDocumentController.CountID = CID;
    }

    public int getCountID() {
        return CountID;
    }

}

