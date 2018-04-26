package bsuir.view;

import bsuir.model.Organization;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.controlsfx.control.ToggleSwitch;

public class GenDocTable {

    final TextField nameTableText = new TextField();

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

    public ToggleSwitch tSwitch_1 = new ToggleSwitch();
    public ToggleSwitch tSwitch_2 = new ToggleSwitch();
    public ToggleSwitch tSwitch_3 = new ToggleSwitch();
    public ToggleSwitch tSwitch_4 = new ToggleSwitch();
    public ToggleSwitch tSwitch_5 = new ToggleSwitch();
    public ToggleSwitch tSwitch_6 = new ToggleSwitch();
    public ToggleSwitch tSwitch_7 = new ToggleSwitch();
    public ToggleSwitch tSwitch_8 = new ToggleSwitch();
    public ToggleSwitch tSwitch_9 = new ToggleSwitch();
    public ToggleSwitch tSwitch_10 = new ToggleSwitch();
    public ToggleSwitch tSwitch_11 = new ToggleSwitch();
    public ToggleSwitch tSwitch_12 = new ToggleSwitch();
    public ToggleSwitch tSwitch_13 = new ToggleSwitch();
    public ToggleSwitch tSwitch_14 = new ToggleSwitch();
    public ToggleSwitch tSwitch_15 = new ToggleSwitch();
    public ToggleSwitch tSwitch_16 = new ToggleSwitch();

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

     public ChoiceBox titleBox = new ChoiceBox<String>(tagList);



//    public CheckBox add_ID = new CheckBox("ID");
//    public CheckBox add_FIO = new CheckBox("ФИО");
//    public CheckBox add_DATE_REG = new CheckBox("Дата регистрации");
//    public CheckBox add_INV = new CheckBox("Инвентарный номер");
//    public CheckBox add_BOX_SQ = new CheckBox("Площадь");
//    public CheckBox add_NUM = new CheckBox("Номер");
//    public CheckBox add_PASP = new CheckBox("Серия паспорта");
//    public CheckBox add_PW = new CheckBox("Кем выдан");
//    public CheckBox add_PD = new CheckBox("Дата выдачи");
//    public CheckBox add_PN = new CheckBox("ПН");
//    public CheckBox add_PHONE = new CheckBox("Телефон");
//    public CheckBox add_MAIL = new CheckBox("E-mail");
//    public CheckBox add_ADDRESS = new CheckBox("Адрес");
//    public CheckBox add_ADRREG = new CheckBox("Прописка");
//    public CheckBox add_AUTO = new CheckBox("Авто");
//    public CheckBox add_IND_DOG= new CheckBox("Номер договора");
//    public CheckBox add_INDEX = new CheckBox("Дата заключения");
//    public CheckBox add_SQPR = new CheckBox("SQPR");
//    public CheckBox add_PROC = new CheckBox("Процент");
//    public CheckBox add_SQ = new CheckBox("Площадь");
//    public CheckBox add_OSAVTO = new CheckBox("Номер гаража");
//    public CheckBox add_UR = new CheckBox("Уровень");
//    public CheckBox add_OSSPECTR = new CheckBox("Описание");
//    public CheckBox add_NED1 = new CheckBox("Приложение 1");
//    public CheckBox add_NED2 = new CheckBox("Приложение 2");

    final TextField firstTableRecord = new TextField();
    final TextField lastTableRecord = new TextField();

    private List<Organization> db = FXCollections.observableArrayList();

    public void start(final Stage primaryStage, final List<Organization> allDataU, final MenuLine parentClass) {

        this.db = allDataU;

        Pane pane = new Pane();

        //* BorderPane pane = new BorderPane();
        primaryStage.setTitle("Создать таблицу");
        Scene scene;

        scene = new Scene(pane, 640, 880);
        primaryStage.setScene(scene);
        primaryStage.show();

//        Label nameTableLabel = new Label("Название таблицы");
//        nameTableLabel.setLayoutX(100);
//        nameTableLabel.setLayoutY(10);
//
//        nameTableText.setLayoutX(300);
//        nameTableText.setLayoutY(10);

        text_1.setLayoutX(50);
        text_1.setLayoutY(50);

        text_2.setLayoutX(50);
        text_2.setLayoutY(100);

        text_3.setLayoutX(50);
        text_3.setLayoutY(150);

        text_4.setLayoutX(50);
        text_4.setLayoutY(200);

        text_5.setLayoutX(50);
        text_5.setLayoutY(250);

        text_6.setLayoutX(50);
        text_6.setLayoutY(300);

        text_7.setLayoutX(50);
        text_7.setLayoutY(350);

        text_8.setLayoutX(50);
        text_8.setLayoutY(400);

        text_9.setLayoutX(50);
        text_9.setLayoutY(450);

        text_10.setLayoutX(50);
        text_10.setLayoutY(500);

        text_11.setLayoutX(50);
        text_11.setLayoutY(550);

        text_12.setLayoutX(50);
        text_12.setLayoutY(600);

        text_13.setLayoutX(50);
        text_13.setLayoutY(650);

        text_14.setLayoutX(50);
        text_14.setLayoutY(700);

        text_15.setLayoutX(50);
        text_15.setLayoutY(750);

        text_16.setLayoutX(50);
        text_16.setLayoutY(800);

        tSwitch_1.setLayoutX(220);
        tSwitch_1.setLayoutY(55);

        tSwitch_2.setLayoutX(220);
        tSwitch_2.setLayoutY(105);

        tSwitch_3.setLayoutX(220);
        tSwitch_3.setLayoutY(155);

        tSwitch_4.setLayoutX(220);
        tSwitch_4.setLayoutY(205);

        tSwitch_5.setLayoutX(220);
        tSwitch_5.setLayoutY(255);

        tSwitch_6.setLayoutX(220);
        tSwitch_6.setLayoutY(305);

        tSwitch_7.setLayoutX(220);
        tSwitch_7.setLayoutY(355);

        tSwitch_8.setLayoutX(220);
        tSwitch_8.setLayoutY(405);

        tSwitch_9.setLayoutX(220);
        tSwitch_9.setLayoutY(455);

        tSwitch_10.setLayoutX(220);
        tSwitch_10.setLayoutY(505);

        tSwitch_11.setLayoutX(220);
        tSwitch_11.setLayoutY(555);

        tSwitch_12.setLayoutX(220);
        tSwitch_12.setLayoutY(605);

        tSwitch_13.setLayoutX(220);
        tSwitch_13.setLayoutY(655);

        tSwitch_14.setLayoutX(220);
        tSwitch_14.setLayoutY(705);

        tSwitch_15.setLayoutX(220);
        tSwitch_15.setLayoutY(755);

        tSwitch_16.setLayoutX(220);
        tSwitch_16.setLayoutY(805);

        titleBox.setLayoutX(400);
        titleBox.setLayoutY(50);
//        add_ID.setMinSize(50, 20);
//
//        add_FIO.setMinSize(50, 20);
//        add_FIO.setLayoutX(180);
//        add_FIO.setLayoutY(50);
//
//        add_DATE_REG.setMinSize(50, 20);
//        add_DATE_REG.setLayoutX(310);
//        add_DATE_REG.setLayoutY(50);
//
//        add_INV.setMinSize(50, 20);
//        add_INV.setLayoutX(440);
//        add_INV.setLayoutY(50);
//
//        add_BOX_SQ.setMinSize(50, 20);
//
//        add_NUM.setMinSize(50, 20);
//        add_NUM.setLayoutX(180);
//        add_NUM.setLayoutY(100);
//
//        add_PASP.setMinSize(50, 20);
//        add_PASP.setLayoutX(310);
//        add_PASP.setLayoutY(100);
//
//        add_PW.setMinSize(50, 20);
//        add_PW.setLayoutX(440);
//        add_PW.setLayoutY(100);
//
//        add_PD.setMinSize(50, 20);
//
//
//        add_PN.setMinSize(50, 20);
//        add_PN.setLayoutX(180);
//        add_PN.setLayoutY(150);
//
//        add_PHONE.setMinSize(50, 20);
//        add_PHONE.setLayoutX(310);
//        add_PHONE.setLayoutY(150);
//
//        add_MAIL.setMinSize(50, 20);
//        add_MAIL.setLayoutX(440);
//        add_MAIL.setLayoutY(150);
//
//        add_ADDRESS.setMinSize(50, 20);
//
//
//        add_ADRREG.setMinSize(50, 20);
//        add_ADRREG.setLayoutX(180);
//        add_ADRREG.setLayoutY(200);
//
//        add_AUTO.setMinSize(50, 20);
//        add_AUTO.setLayoutX(310);
//        add_AUTO.setLayoutY(200);
//
//        add_IND_DOG.setMinSize(50, 20);
//        add_IND_DOG.setLayoutX(440);
//        add_IND_DOG.setLayoutY(200);
//
//        add_INDEX.setMinSize(50, 20);
//
//
//        add_SQPR.setMinSize(50, 20);
//        add_SQPR.setLayoutX(180);
//        add_SQPR.setLayoutY(250);
//
//        add_PROC.setMinSize(50, 20);
//        add_PROC.setLayoutX(310);
//        add_PROC.setLayoutY(250);
//
//        add_SQ.setMinSize(50, 20);
//        add_SQ.setLayoutX(440);
//        add_SQ.setLayoutY(250);
//
//        add_OSAVTO.setMinSize(50, 20);
//
//
//        add_UR.setMinSize(50, 20);
//        add_UR.setLayoutX(180);
//        add_UR.setLayoutY(300);
//
//        add_OSSPECTR.setMinSize(50, 20);
//        add_OSSPECTR.setLayoutX(310);
//        add_OSSPECTR.setLayoutY(300);
//
//        add_NED1.setMinSize(50, 20);
//        add_NED1.setLayoutX(440);
//        add_NED1.setLayoutY(300);
//
//        add_NED2.setMinSize(50, 20);

//        Label firstTableLabel = new Label("C:");
//        firstTableLabel.setLayoutX(190);
//        firstTableLabel.setLayoutY(355);
//
//        firstTableRecord.setMaxSize(40,20);
//        firstTableRecord.setLayoutX(210);
//        firstTableRecord.setLayoutY(350);
//
//        Label lastTableLabel = new Label("По:");
//        lastTableLabel.setLayoutX(290);
//        lastTableLabel.setLayoutY(355);
//
//        lastTableRecord.setMaxSize(40,20);
//        lastTableRecord.setLayoutX(320);
//        lastTableRecord.setLayoutY(350);
//
        Button addXls = new Button("Создать xls");
        addXls.setMinSize(50, 20);
        addXls.setLayoutX(150);
        addXls.setLayoutY(840);

        Button addDocx = new Button("Создать docx");
        addDocx.setMinSize(50, 20);
        addDocx.setLayoutX(350);
        addDocx.setLayoutY(840);

        pane.getChildren().addAll( addDocx, addXls,
//                add_ID, add_FIO, add_DATE_REG, add_INV, add_BOX_SQ, add_NUM, add_PASP, add_PW,
//                add_PD, add_PN, add_PHONE, add_MAIL, add_ADDRESS, add_ADRREG, add_AUTO, add_IND_DOG,
//                add_INDEX, add_SQPR, add_PROC, add_SQ, add_OSAVTO, add_UR, add_OSSPECTR,
//                add_NED1, add_NED2, nameTableLabel, nameTableText, firstTableRecord, lastTableRecord,
//                firstTableLabel, lastTableLabel,
text_1, text_2, text_3, text_4, text_5, text_6, text_7, text_8, text_9, text_10, text_11, text_12, text_13, text_14, text_15, text_16,
                tSwitch_1, tSwitch_2, tSwitch_3, tSwitch_4, tSwitch_5, tSwitch_6, tSwitch_7, tSwitch_8, tSwitch_9, tSwitch_10, tSwitch_11, tSwitch_12, tSwitch_13, tSwitch_14, tSwitch_15, tSwitch_16,
                titleBox);

        addDocx.setOnAction(event -> {
            try {
//                writeIntoExcel("documents/gen_tables/"+nameTableText.getText()+".xls", allDataU);
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

//        for ( int i = 0; i < calcSizeTable(); i++ ) {

//            Organization owner = allOwner.get(i);

            // Нумерация начинается с нуля
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
//            if (add_INDEX.isSelected()) {
//                Cell index = row.createCell(countCell++);
//                index.setCellValue(owner.getIndex());
//            }
//            if (add_SQPR.isSelected()) {
//                Cell sqpr = row.createCell(countCell++);
//                sqpr.setCellValue(owner.getSqpr());
//            }
//            if (add_PROC.isSelected()) {
//                Cell proc = row.createCell(countCell++);
//                proc.setCellValue(owner.getProc());
//            }
//            if (add_SQ.isSelected()) {
//                Cell sq = row.createCell(countCell++);
//                sq.setCellValue(owner.getSq());
//            }
//            if (add_OSAVTO.isSelected()) {
//                Cell osavto = row.createCell(countCell++);
//                osavto.setCellValue(owner.getOsavto());
//            }
//            if (add_UR.isSelected()) {
//                Cell ur = row.createCell(countCell++);
//                ur.setCellValue(owner.getUr());
//            }
//            if (add_OSSPECTR.isSelected()) {
//                Cell osspectr = row.createCell(countCell++);
//                osspectr.setCellValue(owner.getOsspectr());
//            }
//            if (add_NED1.isSelected()) {
//                Cell ned1 = row.createCell(countCell++);
//                ned1.setCellValue(owner.getNed_1());
//            }
//            if (add_NED2.isSelected()) {
//                Cell ned2 = row.createCell(countCell++);
//                ned2.setCellValue(owner.getNed_2());
//            }
            size = countCell;
            countCell=0;
//        }

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