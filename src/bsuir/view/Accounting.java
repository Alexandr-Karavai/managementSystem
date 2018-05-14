package bsuir.view;

import bsuir.controller.Components;
import bsuir.controller.ComponentsPayer;
import bsuir.file.LoadPayerDB;
import bsuir.model.Organization;
import bsuir.model.Payer;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Accounting {

    private AddAccounting addAccounting;

    private List<Organization> db = FXCollections.observableArrayList();
    public TableOwners tableOwners;

    public LoadPayerDB workPayerDB = new LoadPayerDB();
    List<Payer> inPayerData = FXCollections.observableArrayList();

    public ComponentsPayer componentsPayer;
    public TablePayers tablePayers;

    public void start(final Stage primaryStage, List<Organization> db, TableOwners tableOwners) {

        this.db = db;
        this.tableOwners = tableOwners;

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu fileMenu = new Menu("Файл");
        Menu helpMenu = new Menu("Помощь");

        // Create MenuItems
        MenuItem openFileItem = new MenuItem("Добавить");
        MenuItem addNewItem = new MenuItem("Добавить нового пользователя");
        MenuItem saveItem = new MenuItem("Сохранить");

        // Add menuItems to the Menus
        fileMenu.getItems().addAll(openFileItem, addNewItem, saveItem);

        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        componentsPayer = new ComponentsPayer();
        componentsPayer.setVisible(false);
        root.setBottom(componentsPayer);

        workPayerDB.dbRead("documents/payer.xml", db, tableOwners);
        tablePayers = new TablePayers();
        root.setCenter(tablePayers);
        inPayerData.addAll(workPayerDB.getDbPayer());
        tablePayers.setDataPayers(inPayerData);
        componentsPayer.setTable(tablePayers);
        componentsPayer.setVisible(true);

        primaryStage.setTitle("Учет");
        Scene scene;

        scene = new Scene(root, 750, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        openFileItem.setOnAction(event -> {

            addAccounting = new AddAccounting();

            try
            {
                Stage stage = new Stage();
                addAccounting.start(stage, inPayerData, Accounting.this);

            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Перезапустите программу!");
                alert.showAndWait();
            }
        });

        addNewItem.setOnAction(event -> {

            try
            {
                workPayerDB.dbWriteTest("documents/payer.xml", db, tableOwners, inPayerData);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Перезапустите программу!");
                alert.showAndWait();
            }
        });

        saveItem.setOnAction(event -> {

            try
            {
                workPayerDB.dbTest("documents/payer.xml", db, tableOwners, inPayerData);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Перезапустите программу!");
                alert.showAndWait();
            }
        });
    }
}
