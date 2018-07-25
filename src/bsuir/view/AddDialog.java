package bsuir.view;

        import bsuir.model.Organization;
        import bsuir.model.Owner;
        import bsuir.view.MenuLine;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.geometry.Insets;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;

        import java.util.List;


public class AddDialog {

    final TextField idText = new TextField();
    final TextField fioText = new TextField();
    final TextField dateRegText = new TextField();
    final TextField invText = new TextField();
    final TextField boxSqText = new TextField();
    final TextField numText = new TextField();
    final TextField paspText = new TextField();
    final TextField pwText = new TextField();
    final TextField pdText = new TextField();
    final TextField pnText = new TextField();
    final TextField phoneText = new TextField();
    final TextField mailText = new TextField();
    final TextField addressText = new TextField();
    final TextField adrregText = new TextField();
    final TextField autoText = new TextField();
    final TextField indDogText = new TextField();
    final TextField indexText = new TextField();
    final TextField sqprText = new TextField();
    final TextField procText = new TextField();
    final TextField sqText = new TextField();
    final TextField osAvtoText = new TextField();
    final TextField urText = new TextField();
    final TextField osspectrText = new TextField();
    final TextField nedOneText = new TextField();
    final TextField nedTwoText = new TextField();

    private Label idLabel = new Label("ID: ");
    private Label fioLabel = new Label("ФИО собственника: ");
    private Label dateRegLabel = new Label("Дата госрегистрации: ");
    private Label invLabel = new Label("Инвентарный номер: ");
    private Label boxSqLabel = new Label("Площадь: ");
    private Label numLabel = new Label("Свидетельство о госрегистрации: ");
    private Label paspLabel = new Label("Серия паспорта: ");
    private Label pwLabel = new Label("Кем выдан: ");
    private Label pdLabel = new Label("Дата выдачи: ");
    private Label pnLabel = new Label("И.Н. паспорта: ");
    private Label phoneLabel = new Label("Телефон: ");
    private Label mailLabel = new Label("E-mail: ");
    private Label addressLabel = new Label("Адрес: ");
    private Label adrregLabel = new Label("Прописка: ");
    private Label autoLabel = new Label("Авто: ");
    private Label indDogLabel = new Label("Номер договора: ");
    private Label indexLabel = new Label("Дата заключения: ");
    private Label sqprLabel = new Label("SQPR: ");
    private Label procLabel = new Label("Процент: ");
    private Label sqLabel = new Label("Площадь: ");
    private Label osAvtoLabel = new Label("Номер гаража: ");
    private Label urLabel = new Label("Уровень: ");
    private Label osspectrLabel = new Label("Описание: ");
    private Label nedOneLabel = new Label("Приложение 1: ");
    private Label nedTwoLabel = new Label("Приложение 2: ");

    private Button addAcc = new Button("Добавить");

    public void start(final Stage primaryStage, final List<Organization> allDataU, final MenuLine parentClass) {

        // Create a ScrollPane
        ScrollPane scrollPane = new ScrollPane();

        final BorderPane container = new BorderPane();

        HBox hBox = new HBox();
        VBox vBoxR = new VBox();
        VBox vBoxL = new VBox();

        vBoxL.getChildren().addAll(
                idLabel, fioLabel, dateRegLabel, invLabel, boxSqLabel,
                numLabel, paspLabel, pwLabel, pdLabel, pnLabel, phoneLabel,
                mailLabel, addressLabel, adrregLabel, autoLabel, indDogLabel,
                indexLabel, sqprLabel, procLabel, sqLabel, osAvtoLabel, urLabel,
                osspectrLabel, nedOneLabel, nedTwoLabel
        );
        vBoxR.getChildren().addAll(
                idText, fioText, dateRegText, invText, boxSqText,
                numText, paspText, pwText, pdText, pnText, phoneText,
                mailText, addressText, adrregText, autoText, indDogText,
                indexText, sqprText, procText, sqText, osAvtoText, urText,
                osspectrText, nedOneText, nedTwoText
        );

        vBoxL.setPadding(new Insets(20, 20, 20, 90));
        vBoxR.setPadding(new Insets(20, 70, 20, 50));

        vBoxL.setSpacing(35);
        vBoxR.setSpacing(25);

        hBox.getChildren().addAll(addAcc);

        hBox.setPadding(new Insets(20, 280, 30, 320));

        container.setLeft(vBoxL);
        container.setRight(vBoxR);

        container.setBottom(hBox);

        // Set content for ScrollPane
        scrollPane.setContent(container);

        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        primaryStage.setTitle("Добавить запись");

        Scene scene = new Scene(scrollPane, 750, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        addAcc.setOnAction(event -> {
            Owner owner = new Owner(
                    idText.getText(), fioText.getText(), dateRegText.getText(), invText.getText(),
                    boxSqText.getText(), numText.getText(), paspText.getText(), pwText.getText(),
                    pdText.getText(), pnText.getText(), phoneText.getText(), mailText.getText(),
                    addressText.getText(), adrregText.getText(), autoText.getText(),
                    indDogText.getText(), indexText.getText()
            );
            allDataU.add(new Organization(
                    owner, sqprText.getText(), procText.getText(), sqText.getText(), osAvtoText.getText(),
                    urText.getText(), osspectrText.getText(), nedOneText.getText(), nedTwoText.getText())
            );
            parentClass.parentClass.updatePage();
            primaryStage.close();
        });
    }
}
