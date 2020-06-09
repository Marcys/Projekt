package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.ActionEvent;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField courseInput, memberInput, deadlineInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("e-learning Plattform");

        //Name column
        TableColumn<Product, String> courseColumn = new TableColumn<>("Kurs");
        courseColumn.setMinWidth(200);
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        //Price column
        TableColumn<Product, Double> memberColumn = new TableColumn<>("Teilnehmerzahl");
        memberColumn.setMinWidth(100);
        memberColumn.setCellValueFactory(new PropertyValueFactory<>("member"));

        //Quantity column
        TableColumn<Product, String> deadlineColumn = new TableColumn<>("Nächste Abgabe");
        deadlineColumn.setMinWidth(100);
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        //Name input
        courseInput = new TextField();
        courseInput.setPromptText("Kurs");
        courseInput.setMinWidth(100);

        //Price input
        memberInput = new TextField();
        memberInput.setPromptText("Teilnehmerzahl");

        //Quantity input
        deadlineInput = new TextField();
        deadlineInput.setPromptText("Nächste Abgabe");

        //Button
        Button addButton = new Button("Hinzufügen");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Löschen");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(courseInput, memberInput, deadlineInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(courseColumn, memberColumn, deadlineColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        addButtonToTable();

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    private void addButtonToTable() {
        TableColumn<Product, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<TableColumn<Product, Void>, TableCell<Product, Void>>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<Product, Void>() {

                    private final Button btn = new Button("Anzeigen");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Stage stage = new Stage();
                            stage.setTitle("Informationen");


                            stage.show();
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);


    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setCourse(courseInput.getText());
        product.setMember(Integer.parseInt(memberInput.getText()));
        product.setDeadline(deadlineInput.getText());
        table.getItems().add(product);
        courseInput.clear();
        memberInput.clear();
        deadlineInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 50, "Abagbe bis zum 2.2.20"));

        return products;
    }


}