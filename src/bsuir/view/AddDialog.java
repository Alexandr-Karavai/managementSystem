package bsuir.view;

        import bsuir.model.Organization;
        import bsuir.model.Owner;
        import bsuir.view.MenuLine;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;

        import java.util.List;


public class AddDialog {

    public void start(final Stage primaryStage, final List<Organization> allDataU, final MenuLine parentClass) {

        Pane pane = new Pane();
        //* BorderPane pane = new BorderPane();
        primaryStage.setTitle("Добавить запись");
        Scene scene;

        scene = new Scene(pane, 640, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

        Button add = new Button("Добавить");
        add.setMinSize(50, 20);
        add.setLayoutX(150);
        add.setLayoutY(400);

        Label idLabel = new Label("ID");
        idLabel.setLayoutX(100);
        idLabel.setLayoutY(20);

        Label fioLabel = new Label("ФИО");
        fioLabel.setLayoutX(100);
        fioLabel.setLayoutY(100);

        Label dateRegLabel = new Label("Дата регистрации");
        dateRegLabel.setLayoutX(100);
        dateRegLabel.setLayoutY(180);

        Label invLabel = new Label("Инвентарный номер");
        invLabel.setLayoutX(100);
        invLabel.setLayoutY(260);

        Label boxSqLabel = new Label("Площадь");
        boxSqLabel.setLayoutX(100);
        boxSqLabel.setLayoutY(340);

        Label numLabel = new Label("Номер");
        numLabel.setLayoutX(100);
        numLabel.setLayoutY(420);

        Label paspLabel = new Label("Серия паспорта");
        paspLabel.setLayoutX(100);
        paspLabel.setLayoutY(500);

        Label pwLabel = new Label("Кем выдан");
        pwLabel.setLayoutX(100);
        pwLabel.setLayoutY(580);

        Label pdLabel = new Label("Дата выдачи");
        pdLabel.setLayoutX(100);
        pdLabel.setLayoutY(660);


        final TextField facultyText = new TextField();
        facultyText.setLayoutX(300);
        facultyText.setLayoutY(20);

        final TextField nameOfDepartmentText = new TextField();
        nameOfDepartmentText.setLayoutX(300);
        nameOfDepartmentText.setLayoutY(100);

        final TextField fioText = new TextField();
        fioText.setLayoutX(300);
        fioText.setLayoutY(180);

        ObservableList<String> titleList = FXCollections.observableArrayList
                (
                        "мл. науч. сотр.",
                        "науч. сотр.",
                        "ст. науч. сотр.",
                        "вед. науч. сотр.",
                        "гл. науч. сотр.",
                        "доц.",
                        "проф.",
                        "чл.-кор.",
                        "акад."
                );
        ChoiceBox<String> titleBox = new ChoiceBox<String>(titleList);
        titleBox.setLayoutX(300);
        titleBox.setLayoutY(260);
        titleBox.setPrefSize(185,30);

        ObservableList<String> academicList = FXCollections.observableArrayList
                (
                        "кандидат наук",
                        "доктор наук"
                );
        ChoiceBox<String> academicBox = new ChoiceBox<String>(academicList);

        academicBox.setLayoutX(300);
        academicBox.setLayoutY(340);
        academicBox.setPrefSize(185,30);


        pane.getChildren().addAll(
                idLabel, fioText,
                fioLabel,
                dateRegLabel, nameOfDepartmentText,
                invLabel, academicBox,
                boxSqLabel, titleBox,
                numLabel, paspLabel, pwLabel, pdLabel,
                add);

//        add.setOnAction(event -> {
//            Owner owner = new Owner(fioText.getText(),
//                    titleBox.getSelectionModel().getSelectedItem(), academicBox.getSelectionModel().getSelectedItem());
//            allDataU.add(new Organization(facultyText.getText(), nameOfDepartmentText.getText(),owner));
//            parentClass.parentClass.updatePage();
//            primaryStage.close();
//        });

    }


}
