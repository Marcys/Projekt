package utils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class CourseModel {

    private SimpleStringProperty columnName;
    private SimpleIntegerProperty columnTeilnehmer;
    private SimpleStringProperty columnProfessor;

    public CourseModel(String columnName, int columnTeilnehmer, String columnProfessor) {
        this.columnName = new SimpleStringProperty(columnName);
        this.columnTeilnehmer = new SimpleIntegerProperty(columnTeilnehmer);
        this.columnProfessor = new SimpleStringProperty(columnProfessor);
    }

    public String getStudentId() {
        return columnName.get();
    }

    public void setStudentId(String columnName) {
        this.columnName = new SimpleStringProperty(columnName);
    }

    public int getFirstName() {
        return columnTeilnehmer.get();
    }

    public void setFirstName(int columnTeilnehmer) {
        this.columnTeilnehmer = new SimpleIntegerProperty(columnTeilnehmer);
    }

    public String getLastName() {
        return columnProfessor.get();
    }

    public void setLastName(String columnProfessor) {
        this.columnProfessor = new SimpleStringProperty(columnProfessor);
    }

}
