package bsuir.view;

import bsuir.model.Organization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import java.io.*;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class GenDocTable {

    final TextField text_1 = new TextField();
    final TextField text_2 = new TextField();
    final TextField text_3 = new TextField();
    final TextField text_4 = new TextField();
    final TextField text_5 = new TextField();
    final TextField text_6 = new TextField();
    final TextField text_7 = new TextField();
    final TextField text_8 = new TextField();
    final TextField text_9 = new TextField();
    final TextField text_10 = new TextField();
    final TextField text_11 = new TextField();
    final TextField text_12 = new TextField();
    final TextField text_13 = new TextField();
    final TextField text_14 = new TextField();
    final TextField text_15 = new TextField();
    final TextField text_16 = new TextField();

    public CheckBox tSwitch_1 = new CheckBox();
    public CheckBox tSwitch_2 = new CheckBox();
    public CheckBox tSwitch_3 = new CheckBox();
    public CheckBox tSwitch_4 = new CheckBox();
    public CheckBox tSwitch_5 = new CheckBox();
    public CheckBox tSwitch_6 = new CheckBox();
    public CheckBox tSwitch_7 = new CheckBox();
    public CheckBox tSwitch_8 = new CheckBox();
    public CheckBox tSwitch_9 = new CheckBox();
    public CheckBox tSwitch_10 = new CheckBox();
    public CheckBox tSwitch_11 = new CheckBox();
    public CheckBox tSwitch_12 = new CheckBox();
    public CheckBox tSwitch_13 = new CheckBox();
    public CheckBox tSwitch_14 = new CheckBox();
    public CheckBox tSwitch_15 = new CheckBox();
    public CheckBox tSwitch_16 = new CheckBox();

    ObservableList<String> tagList = FXCollections.observableArrayList
            (
            "ID",
                    "FIO",
                    "DATE_REG",
                    "INV",
                    "BOX_SQ",
                    "NUM",
                    "PASP",
                    "PW",
                    "PD",
                    "PN",
                    "PHONE",
                    "MAIL",
                    "ADDRESS",
                    "ADRREG",
                    "AUTO",
                    "IND_DOG",
                    "INDEX",
                    "SQPR",
                    "PROC",
                    "SQ",
                    "OSAVTO",
                    "UR",
                    "OSSPECTR",
                    "NED_1",
                    "NED_2"
            );

    public ChoiceBox tagBox_1 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_2 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_3 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_4 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_5 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_6 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_7 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_8 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_9 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_10 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_11 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_12 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_13 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_14 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_15 = new ChoiceBox<String>(tagList);
    public ChoiceBox tagBox_16 = new ChoiceBox<String>(tagList);

    private Button addXls = new Button("Создать xls");
    private Button addDocx = new Button("Создать docx");

    private Label nameCellLabel = new Label("Название колонки");
    private Label nameSwitchLabel = new Label("Выкл/Вкл");
    private Label nameTagLabel = new Label("Тег в реестре");

    private List<Organization> db = FXCollections.observableArrayList();

    public void start(final Stage primaryStage, final List<Organization> allDataU, final MenuLine parentClass) {

        this.db = allDataU;

        // Create a ScrollPane
        ScrollPane scrollPane = new ScrollPane();

        final BorderPane container = new BorderPane();

        HBox hBox = new HBox();
        VBox vBoxR = new VBox();
        VBox vBoxL = new VBox();
        VBox vBoxM =new VBox();

        vBoxL.getChildren().addAll(nameCellLabel,
                text_1, text_2, text_3 ,text_4 ,text_5, text_6, text_7,
                text_8, text_9, text_10, text_11, text_12, text_13, text_14,
                text_15, text_16
        );
        vBoxR.getChildren().addAll(nameTagLabel,
                tagBox_1, tagBox_2, tagBox_3, tagBox_4, tagBox_5, tagBox_6, tagBox_7,
                tagBox_8, tagBox_9, tagBox_10, tagBox_11, tagBox_12, tagBox_13, tagBox_14,
                tagBox_15, tagBox_16
        );
        vBoxM.getChildren().addAll(nameSwitchLabel,
                tSwitch_1, tSwitch_2, tSwitch_3, tSwitch_4, tSwitch_5, tSwitch_6, tSwitch_7,
                tSwitch_8, tSwitch_9, tSwitch_10, tSwitch_11, tSwitch_12, tSwitch_13, tSwitch_14,
                tSwitch_15, tSwitch_16
        );

        vBoxL.setPadding(new Insets(20, 20, 20, 90));
        vBoxR.setPadding(new Insets(20, 70, 20, 50));
        vBoxM.setPadding(new Insets(20, 40, 20, 120));

        vBoxL.setSpacing(35);
        vBoxR.setSpacing(35);
        vBoxM.setSpacing(45);

        hBox.getChildren().addAll(addXls, addDocx);
        hBox.setPadding(new Insets(20, 250, 30, 370));
        hBox.setSpacing(15);

        container.setLeft(vBoxL);
        container.setCenter(vBoxM);
        container.setRight(vBoxR);

        container.setBottom(hBox);

        // Set content for ScrollPane
        scrollPane.setContent(container);

        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        primaryStage.setTitle("Создать таблицу");

        Scene scene = new Scene(scrollPane, 950, 550);
        primaryStage.setScene(scene);
        primaryStage.show();

        addDocx.setOnAction(event -> {
            try {
                createSimpleTable();
                parentClass.parentClass.updatePage();
                primaryStage.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Откройте файл!");
                alert.showAndWait();
            }

        });

        addXls.setOnAction(event -> {
            try {
                writeIntoExcel(allDataU);
                parentClass.parentClass.updatePage();
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

    public void writeIntoExcel(List<Organization> db) throws IOException {

        this.db = db;
        List <Organization> allOwner = this.db;

        int countCell = 0, size=0, rowCount=0;

        Workbook book = new HSSFWorkbook();

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        Sheet sheet = book.createSheet(result.get());

            Row row = sheet.createRow(0);

            if (tSwitch_1.isSelected()) {
                Cell id = row.createCell(countCell++);
                id.setCellValue(text_1.getText());
            }
            if (tSwitch_2.isSelected()) {
                Cell family = row.createCell(countCell++);
                family.setCellValue(text_2.getText());
            }
            if (tSwitch_3.isSelected()) {
                Cell date_reg = row.createCell(countCell++);
                date_reg.setCellValue(text_3.getText());
            }
            if (tSwitch_4.isSelected()) {
                Cell inv = row.createCell(countCell++);
                inv.setCellValue(text_4.getText());
            }
            if (tSwitch_5.isSelected()) {
                Cell box_sq = row.createCell(countCell++);
                box_sq.setCellValue(text_5.getText());
            }
            if (tSwitch_6.isSelected()) {
                Cell num = row.createCell(countCell++);
                num.setCellValue(text_6.getText());
            }
            if (tSwitch_7.isSelected()) {
                Cell pasp = row.createCell(countCell++);
                pasp.setCellValue(text_7.getText());
            }
            if (tSwitch_8.isSelected()) {
                Cell pw = row.createCell(countCell++);
                pw.setCellValue(text_8.getText());
            }
            if (tSwitch_9.isSelected()) {
                Cell pd = row.createCell(countCell++);
                pd.setCellValue(text_9.getText());
            }
            if (tSwitch_10.isSelected()) {
                Cell pn = row.createCell(countCell++);
                pn.setCellValue(text_10.getText());
            }
            if (tSwitch_11.isSelected()) {
                Cell phone = row.createCell(countCell++);
                phone.setCellValue(text_11.getText());
            }
            if (tSwitch_12.isSelected()) {
                Cell mail = row.createCell(countCell++);
                mail.setCellValue(text_12.getText());
            }
            if (tSwitch_13.isSelected()) {
                Cell address = row.createCell(countCell++);
                address.setCellValue(text_13.getText());
            }
            if (tSwitch_14.isSelected()) {
                Cell adrreg = row.createCell(countCell++);
                adrreg.setCellValue(text_14.getText());
            }
            if (tSwitch_15.isSelected()) {
                Cell auto = row.createCell(countCell++);
                auto.setCellValue(text_15.getText());
            }
            if (tSwitch_16.isSelected()) {
                Cell ind_dog = row.createCell(countCell++);
                ind_dog.setCellValue(text_16.getText());
            }

            size = countCell;

        // Меняем размер столбца
        for (int i=0; i<size; i++){
            sheet.autoSizeColumn(i);
        }

        // Записываем всё в файл
        OutputStream out = new FileOutputStream("documents/gen_tables/"+result.get()+".xls");
        book.write(out);
        book.close();

        out.flush();
        out.close();
    }

    public void createSimpleTable() throws Exception {

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        try  {

            XWPFDocument doc = new XWPFDocument();

            XWPFTable table = doc.createTable(3, calcSizeTable());

            if (tSwitch_1.isSelected()) {
                table.getRow(0).getCell(0).setText(text_1.getText());
            }

            if (tSwitch_2.isSelected()) {
                table.getRow(0).getCell(1).setText(text_2.getText());
            }

            if (tSwitch_3.isSelected()) {
                table.getRow(0).getCell(2).setText(text_3.getText());
            }

            if (tSwitch_4.isSelected()) {
                table.getRow(0).getCell(3).setText(text_4.getText());
            }

            if (tSwitch_5.isSelected()) {
                table.getRow(0).getCell(4).setText(text_5.getText());
            }

            if (tSwitch_6.isSelected()) {
                table.getRow(0).getCell(5).setText(text_6.getText());
            }

            if (tSwitch_7.isSelected()) {
                table.getRow(0).getCell(6).setText(text_7.getText());
            }

            if (tSwitch_8.isSelected()) {
                table.getRow(0).getCell(7).setText(text_8.getText());
            }

            if (tSwitch_9.isSelected()) {
                table.getRow(0).getCell(8).setText(text_9.getText());
            }

            if (tSwitch_10.isSelected()) {
                table.getRow(0).getCell(9).setText(text_10.getText());
            }

            if (tSwitch_11.isSelected()) {
                table.getRow(0).getCell(10).setText(text_11.getText());
            }

            if (tSwitch_12.isSelected()) {
                table.getRow(0).getCell(11).setText(text_12.getText());
            }

            if (tSwitch_13.isSelected()) {
                table.getRow(0).getCell(12).setText(text_13.getText());
            }

            if (tSwitch_14.isSelected()) {
                table.getRow(0).getCell(13).setText(text_14.getText());
            }

            if (tSwitch_15.isSelected()) {
                table.getRow(0).getCell(14).setText(text_15.getText());
            }

            if (tSwitch_16.isSelected()) {
                table.getRow(0).getCell(15).setText(text_16.getText());
            }

            if (result.isPresent()){
                OutputStream out = new FileOutputStream("documents/gen_tables/"+result.get()+".docx");

                doc.write(out);

                out.flush();
                out.close();
            }
        }  catch(Exception e){e.printStackTrace();}
    }

    public int calcSizeTable() {

        int cols = 0;

        if (tSwitch_1.isSelected()) { cols++; }

        if (tSwitch_2.isSelected()) { cols++; }

        if (tSwitch_3.isSelected()) { cols++; }

        if (tSwitch_4.isSelected()) { cols++; }

        if (tSwitch_5.isSelected()) { cols++; }

        if (tSwitch_6.isSelected()) { cols++; }

        if (tSwitch_7.isSelected()) { cols++; }

        if (tSwitch_8.isSelected()) { cols++; }

        if (tSwitch_9.isSelected()) { cols++; }

        if (tSwitch_10.isSelected()) { cols++; }

        if (tSwitch_11.isSelected()) { cols++; }

        if (tSwitch_12.isSelected()) { cols++; }

        if (tSwitch_13.isSelected()) { cols++; }

        if (tSwitch_14.isSelected()) { cols++; }

        if (tSwitch_15.isSelected()) { cols++; }

        if (tSwitch_16.isSelected()) { cols++; }

        return cols;
    }
}