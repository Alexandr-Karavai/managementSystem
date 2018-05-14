package bsuir.view;

import bsuir.model.AccountingMonth;
import bsuir.model.Organization;
import bsuir.model.Payer;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AddAccounting {

    List<Payer> inPayerData = FXCollections.observableArrayList();

    final TextField idText = new TextField();
    final TextField fioText = new TextField();
    final TextField monthText = new TextField();
    final TextField hot_waterText = new TextField();
    final TextField cold_waterText = new TextField();
    final TextField electric_powerText = new TextField();

    private Label idLabel = new Label("ID");
    private Label fioLabel = new Label("ФИО");
    private Label monthLabel = new Label("Дата");
    private Label hot_waterLabel = new Label("Горячая вода");
    private Label cold_waterLabel = new Label("Холодная вода");
    private Label electric_powerLabel = new Label("Электричество");

    private Button addAcc = new Button("Добавить");


    public void start(final Stage primaryStage, final List<Payer> allDataPayers, final Accounting parentClass) {

        this.inPayerData = allDataPayers;

        primaryStage.setTitle("Добавить запись");
        Scene scene;

        BorderPane root = new BorderPane();
        HBox hBox = new HBox();
        VBox vBoxR = new VBox();
        VBox vBoxL = new VBox();

        vBoxR.getChildren().addAll(idLabel, fioLabel, monthLabel, hot_waterLabel, cold_waterLabel, electric_powerLabel);
        vBoxL.getChildren().addAll(idText, fioText, monthText, hot_waterText, cold_waterText, electric_powerText);

        vBoxL.setPadding(new Insets(20, 70, 20, 30));
        vBoxR.setPadding(new Insets(20, 20, 20, 70));

        vBoxR.setSpacing(32);
        vBoxL.setSpacing(25);

        hBox.getChildren().addAll(addAcc);

        hBox.setPadding(new Insets(30, 280, 100, 280));

        scene = new Scene(root, 640, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.setLeft(vBoxR);
        root.setRight(vBoxL);

        root.setBottom(hBox);

        addAcc.setOnAction(event -> {
            try {
                getInfo();
                parentClass.componentsPayer.updatePages();
                primaryStage.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Откройте файл!");
                alert.showAndWait();
            }

        });

    }

    public void getInfo() {
        AccountingMonth accountingMonth = new AccountingMonth(monthText.getText(), hot_waterText.getText(), cold_waterText.getText(), electric_powerText.getText());
        inPayerData.add(new Payer(idText.getText(), fioText.getText(), accountingMonth));
    }
}
