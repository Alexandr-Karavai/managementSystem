package bsuir.view;

import bsuir.model.Organization;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GenDocTable {

    final TextField nameTableText = new TextField();

    public CheckBox add_ID = new CheckBox("ID");
    public CheckBox add_FIO = new CheckBox("ФИО");
    public CheckBox add_DATE_REG = new CheckBox("Дата регистрации");
    public CheckBox add_INV = new CheckBox("Инвентарный номер");
    public CheckBox add_BOX_SQ = new CheckBox("Площадь");
    public CheckBox add_NUM = new CheckBox("Номер");
    public CheckBox add_PASP = new CheckBox("Серия паспорта");
    public CheckBox add_PW = new CheckBox("Кем выдан");
    public CheckBox add_PD = new CheckBox("Дата выдачи");
    public CheckBox add_PN = new CheckBox("ПН");
    public CheckBox add_PHONE = new CheckBox("Телефон");
    public CheckBox add_MAIL = new CheckBox("E-mail");
    public CheckBox add_ADDRESS = new CheckBox("Адрес");
    public CheckBox add_ADRREG = new CheckBox("Прописка");
    public CheckBox add_AUTO = new CheckBox("Авто");
    public CheckBox add_IND_DOG= new CheckBox("Номер договора");
    public CheckBox add_INDEX = new CheckBox("Дата заключения");
    public CheckBox add_SQPR = new CheckBox("SQPR");
    public CheckBox add_PROC = new CheckBox("Процент");
    public CheckBox add_SQ = new CheckBox("Площадь");
    public CheckBox add_OSAVTO = new CheckBox("Номер гаража");
    public CheckBox add_UR = new CheckBox("Уровень");
    public CheckBox add_OSSPECTR = new CheckBox("Описание");
    public CheckBox add_NED1 = new CheckBox("Приложение 1");
    public CheckBox add_NED2 = new CheckBox("Приложение 2");

    final TextField firstTableRecord = new TextField();
    final TextField lastTableRecord = new TextField();

    private List<Organization> db = FXCollections.observableArrayList();

    public void start(final Stage primaryStage, final List<Organization> allDataU, final MenuLine parentClass) {

        this.db = allDataU;

        Pane pane = new Pane();

        //* BorderPane pane = new BorderPane();
        primaryStage.setTitle("Создать таблицу");
        Scene scene;

        scene = new Scene(pane, 640, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

        Label nameTableLabel = new Label("Название таблицы");
        nameTableLabel.setLayoutX(100);
        nameTableLabel.setLayoutY(10);

        nameTableText.setLayoutX(300);
        nameTableText.setLayoutY(10);

        add_ID.setMinSize(50, 20);
        add_ID.setLayoutX(50);
        add_ID.setLayoutY(50);

        add_FIO.setMinSize(50, 20);
        add_FIO.setLayoutX(180);
        add_FIO.setLayoutY(50);

        add_DATE_REG.setMinSize(50, 20);
        add_DATE_REG.setLayoutX(310);
        add_DATE_REG.setLayoutY(50);

        add_INV.setMinSize(50, 20);
        add_INV.setLayoutX(440);
        add_INV.setLayoutY(50);

        add_BOX_SQ.setMinSize(50, 20);
        add_BOX_SQ.setLayoutX(50);
        add_BOX_SQ.setLayoutY(100);

        add_NUM.setMinSize(50, 20);
        add_NUM.setLayoutX(180);
        add_NUM.setLayoutY(100);

        add_PASP.setMinSize(50, 20);
        add_PASP.setLayoutX(310);
        add_PASP.setLayoutY(100);

        add_PW.setMinSize(50, 20);
        add_PW.setLayoutX(440);
        add_PW.setLayoutY(100);

        add_PD.setMinSize(50, 20);
        add_PD.setLayoutX(50);
        add_PD.setLayoutY(150);

        add_PN.setMinSize(50, 20);
        add_PN.setLayoutX(180);
        add_PN.setLayoutY(150);

        add_PHONE.setMinSize(50, 20);
        add_PHONE.setLayoutX(310);
        add_PHONE.setLayoutY(150);

        add_MAIL.setMinSize(50, 20);
        add_MAIL.setLayoutX(440);
        add_MAIL.setLayoutY(150);

        add_ADDRESS.setMinSize(50, 20);
        add_ADDRESS.setLayoutX(50);
        add_ADDRESS.setLayoutY(200);

        add_ADRREG.setMinSize(50, 20);
        add_ADRREG.setLayoutX(180);
        add_ADRREG.setLayoutY(200);

        add_AUTO.setMinSize(50, 20);
        add_AUTO.setLayoutX(310);
        add_AUTO.setLayoutY(200);

        add_IND_DOG.setMinSize(50, 20);
        add_IND_DOG.setLayoutX(440);
        add_IND_DOG.setLayoutY(200);

        add_INDEX.setMinSize(50, 20);
        add_INDEX.setLayoutX(50);
        add_INDEX.setLayoutY(250);

        add_SQPR.setMinSize(50, 20);
        add_SQPR.setLayoutX(180);
        add_SQPR.setLayoutY(250);

        add_PROC.setMinSize(50, 20);
        add_PROC.setLayoutX(310);
        add_PROC.setLayoutY(250);

        add_SQ.setMinSize(50, 20);
        add_SQ.setLayoutX(440);
        add_SQ.setLayoutY(250);

        add_OSAVTO.setMinSize(50, 20);
        add_OSAVTO.setLayoutX(50);
        add_OSAVTO.setLayoutY(300);

        add_UR.setMinSize(50, 20);
        add_UR.setLayoutX(180);
        add_UR.setLayoutY(300);

        add_OSSPECTR.setMinSize(50, 20);
        add_OSSPECTR.setLayoutX(310);
        add_OSSPECTR.setLayoutY(300);

        add_NED1.setMinSize(50, 20);
        add_NED1.setLayoutX(440);
        add_NED1.setLayoutY(300);

        add_NED2.setMinSize(50, 20);
        add_NED2.setLayoutX(50);
        add_NED2.setLayoutY(350);

        Label firstTableLabel = new Label("C:");
        firstTableLabel.setLayoutX(190);
        firstTableLabel.setLayoutY(355);

        firstTableRecord.setMaxSize(40,20);
        firstTableRecord.setLayoutX(210);
        firstTableRecord.setLayoutY(350);

        Label lastTableLabel = new Label("По:");
        lastTableLabel.setLayoutX(290);
        lastTableLabel.setLayoutY(355);

        lastTableRecord.setMaxSize(40,20);
        lastTableRecord.setLayoutX(320);
        lastTableRecord.setLayoutY(350);

        Button add = new Button("Добавить");
        add.setMinSize(50, 20);
        add.setLayoutX(150);
        add.setLayoutY(400);

        pane.getChildren().addAll(add,
                add_ID, add_FIO, add_DATE_REG, add_INV, add_BOX_SQ, add_NUM, add_PASP, add_PW,
                add_PD, add_PN, add_PHONE, add_MAIL, add_ADDRESS, add_ADRREG, add_AUTO, add_IND_DOG,
                add_INDEX, add_SQPR, add_PROC, add_SQ, add_OSAVTO, add_UR, add_OSSPECTR,
                add_NED1, add_NED2, nameTableLabel, nameTableText, firstTableRecord, lastTableRecord,
                firstTableLabel, lastTableLabel);

        add.setOnAction(event -> {
            try {
                writeIntoExcel("documents/gen_tables/"+nameTableText.getText()+".xls", allDataU);
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

    public void writeIntoExcel(String file, List<Organization> db) throws IOException {

        this.db = db;
        List <Organization> allOwner = this.db;

        int countCell = 0, size=0, rowCount=0;

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet(nameTableText.getText());

        for ( int i = Integer.parseInt(firstTableRecord.getText())-1; i < Integer.parseInt(lastTableRecord.getText()); i++ ) {

            Organization owner = allOwner.get(i);

            // Нумерация начинается с нуля
            Row row = sheet.createRow(rowCount++);

            if (add_ID.isSelected()) {
                Cell id = row.createCell(countCell++);
                id.setCellValue(owner.getId());
            }
            if (add_FIO.isSelected()) {
                Cell family = row.createCell(countCell++);
                family.setCellValue(owner.getFio());
            }
            if (add_DATE_REG.isSelected()) {
                Cell date_reg = row.createCell(countCell++);
                date_reg.setCellValue(owner.getDateReg());
            }
            if (add_INV.isSelected()) {
                Cell inv = row.createCell(countCell++);
                inv.setCellValue(owner.getInv());
            }
            if (add_BOX_SQ.isSelected()) {
                Cell box_sq = row.createCell(countCell++);
                box_sq.setCellValue(owner.getBoxSq());
            }
            if (add_NUM.isSelected()) {
                Cell num = row.createCell(countCell++);
                num.setCellValue(owner.getNum());
            }
            if (add_PASP.isSelected()) {
                Cell pasp = row.createCell(countCell++);
                pasp.setCellValue(owner.getPasp());
            }
            if (add_PW.isSelected()) {
                Cell pw = row.createCell(countCell++);
                pw.setCellValue(owner.getPw());
            }
            if (add_PD.isSelected()) {
                Cell pd = row.createCell(countCell++);
                pd.setCellValue(owner.getPd());
            }
            if (add_PN.isSelected()) {
                Cell pn = row.createCell(countCell++);
                pn.setCellValue(owner.getPn());
            }
            if (add_PHONE.isSelected()) {
                Cell phone = row.createCell(countCell++);
                phone.setCellValue(owner.getPhone());
            }
            if (add_MAIL.isSelected()) {
                Cell mail = row.createCell(countCell++);
                mail.setCellValue(owner.getMail());
            }
            if (add_ADDRESS.isSelected()) {
                Cell address = row.createCell(countCell++);
                address.setCellValue(owner.getAddress());
            }
            if (add_ADRREG.isSelected()) {
                Cell adrreg = row.createCell(countCell++);
                adrreg.setCellValue(owner.getAdrreg());
            }
            if (add_AUTO.isSelected()) {
                Cell auto = row.createCell(countCell++);
                auto.setCellValue(owner.getAuto());
            }
            if (add_IND_DOG.isSelected()) {
                Cell ind_dog = row.createCell(countCell++);
                ind_dog.setCellValue(owner.getIndDog());
            }
            if (add_INDEX.isSelected()) {
                Cell index = row.createCell(countCell++);
                index.setCellValue(owner.getIndex());
            }
            if (add_SQPR.isSelected()) {
                Cell sqpr = row.createCell(countCell++);
                sqpr.setCellValue(owner.getSqpr());
            }
            if (add_PROC.isSelected()) {
                Cell proc = row.createCell(countCell++);
                proc.setCellValue(owner.getProc());
            }
            if (add_SQ.isSelected()) {
                Cell sq = row.createCell(countCell++);
                sq.setCellValue(owner.getSq());
            }
            if (add_OSAVTO.isSelected()) {
                Cell osavto = row.createCell(countCell++);
                osavto.setCellValue(owner.getOsavto());
            }
            if (add_UR.isSelected()) {
                Cell ur = row.createCell(countCell++);
                ur.setCellValue(owner.getUr());
            }
            if (add_OSSPECTR.isSelected()) {
                Cell osspectr = row.createCell(countCell++);
                osspectr.setCellValue(owner.getOsspectr());
            }
            if (add_NED1.isSelected()) {
                Cell ned1 = row.createCell(countCell++);
                ned1.setCellValue(owner.getNed_1());
            }
            if (add_NED2.isSelected()) {
                Cell ned2 = row.createCell(countCell++);
                ned2.setCellValue(owner.getNed_2());
            }
            size = countCell;
            countCell=0;
        }

        // Меняем размер столбца
        for (int i=0; i<size; i++){
            sheet.autoSizeColumn(i);
        }

        // Записываем всё в файл
        book.write(new FileOutputStream(file));
        book.close();
    }
}