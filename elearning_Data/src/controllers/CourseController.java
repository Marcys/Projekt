package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.CourseModel;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable{


    public TableView<CourseModel> myTable;
    public TableColumn<CourseModel,String> columnName;
    public TableColumn<CourseModel,Integer> columnTeilnehmer;
    public TableColumn <CourseModel,String>columnProfessor;
    public TextField textFieldCourseName;
    public TextField textFieldTeilnehmer;
    public TextField textFieldProfessor;
    public Button btnAdd;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
//make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        columnName.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        columnTeilnehmer.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        columnProfessor.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        //add your data to the table here.
        myTable.setItems(CourseModelList);
    }

    private ObservableList<CourseModel> CourseModelList = FXCollections.observableArrayList(
            new CourseModel("Projektmanagment", 50, "Hühne"));




    public void addData(ActionEvent actionEvent) {

        CourseModel course =new CourseModel(textFieldCourseName.getText(), Integer.parseInt(textFieldCourseName.getText()), columnProfessor.getText());
        myTable.getItems().add(course);
    }
}


