package bsuir.view;

import bsuir.Main;
import bsuir.controller.ComponentsPayer;
import bsuir.file.GenDocFile;
import bsuir.file.LoadPayerDB;
import bsuir.file.OpenTmp;
import bsuir.file.SaveLoadFile;
import bsuir.model.Organization;

import bsuir.model.Payer;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MenuLine extends MenuBar {

    public SaveLoadFile workFile = new SaveLoadFile();
    BorderPane source;
    public Main parentClass;
    public TableOwners tableOwners;
    public GenDocFile genFile;
    public OpenTmp openTmp;
    public Accounting accounting;

    List <Organization> inU = FXCollections.observableArrayList();



    public MenuLine(BorderPane source, Main parentClass)
    {
        this.source = source;
        this.parentClass = parentClass;
        init();
    }
    public void init()
    {
        Menu file = new Menu("Файл");
        Menu actions = new Menu("Редактировать");
        Menu documents = new Menu("Документы");
        Menu genTable = new Menu("Таблица");
        Menu accountingMenu = new Menu("Учет");
        Menu about = new Menu ("Справка");

        this.getMenus().addAll(file, actions, documents, genTable, accountingMenu, about);

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("файл (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        final FileChooser templateChooser = new FileChooser();
        templateChooser.setTitle("Открыть шаблон");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("файлы (*.doc, *.docx)", "*.doc", "*.docx");
        templateChooser.getExtensionFilters().add(filter);

        final MenuItem newFile = new MenuItem("Новый реестр");
        MenuItem loadFile = new MenuItem("Открыть");
        MenuItem saveFile = new MenuItem("Сохранить как");
        MenuItem addRecord = new MenuItem("Добавить");
        MenuItem findRecord = new MenuItem("Найти/Удалить");

        MenuItem genRandstm = new MenuItem("Создать для одного");
        MenuItem gen_randstms = new MenuItem("Создать для всех");
        MenuItem editTmp = new MenuItem("Редактировать шаблон");

        MenuItem addDocTable = new MenuItem("Создать таблицу");

        MenuItem addAccounting = new MenuItem("Открыть");

        MenuItem info = new MenuItem ("О программе");

        file.getItems().addAll(newFile, loadFile, saveFile);
        actions.getItems().addAll(addRecord, findRecord);
        documents.getItems().addAll(genRandstm, gen_randstms, editTmp);

        genTable.getItems().addAll(addDocTable);

        accountingMenu.getItems().addAll(addAccounting);

        about.getItems().addAll(info);

        newFile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

        newFile.setOnAction(event -> {
            tableOwners = new TableOwners();
            source.setCenter(tableOwners);
            List <Organization> inU = FXCollections.observableArrayList();
            tableOwners.setDataU(inU);
            parentClass.creatingLoadingTable();
        });

        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

        saveFile.setOnAction(event -> {
            File file1 = fileChooser.showSaveDialog(null);
            List <Organization> allDataU = tableOwners.getDataU();
            workFile.setDb(allDataU);
            workFile.dbWrite(file1.getAbsolutePath());
        });

        loadFile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

        loadFile.setOnAction(event -> {
            File file1 = fileChooser.showOpenDialog(null);
            try
            {
                workFile.dbRead(file1.getAbsolutePath());
                tableOwners = new TableOwners();
                source.setCenter(tableOwners);
                inU.addAll(workFile.getDb());
                tableOwners.setDataU(inU);
                parentClass.creatingLoadingTable();
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setContentText("");
                alert.setHeaderText("Предупреждение: Файл не был выбран!");
                alert.showAndWait();
                e.printStackTrace();
            }
        });

        addRecord.setOnAction(event -> {

            AddDialog ARDialog = new AddDialog();
            try
            {
                Stage stage = new Stage();
                List <Organization> allDataU = tableOwners.getDataU();
                ARDialog.start(stage, allDataU, MenuLine.this);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Создайте файл!");
                alert.showAndWait();
            }
        });

//        findRecord.setOnAction(event -> {
//            try
//            {
//                Stage stage = new Stage();
//                List <Organization> allData = tableOwners.getDataU();
//                SearchDelete FRDialog = new SearchDelete();
//                FRDialog.start(stage, allData, MenuLine.this);
//            }
//            catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(null, "Ошибка: Создайте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);
//
//            }
//        });

        genRandstm.setAccelerator(KeyCombination.keyCombination("Ctrl+G"));

        genRandstm.setOnAction(event -> {
            File tempFile = templateChooser.showOpenDialog(null);
            try
            {
                genFile = new GenDocFile();
                if ( getFileExtension(tempFile).equals("doc")) {
                    genFile.genRandTmp(tempFile.getAbsolutePath(), inU, tableOwners);
                } else {
                    genFile.genDocxTmpFile(tempFile.getAbsolutePath(), inU, tableOwners);
                }
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

        gen_randstms.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));

        gen_randstms.setOnAction(event -> {
            File tempFile = templateChooser.showOpenDialog(null);
            try
            {
                genFile = new GenDocFile();
                if ( getFileExtension(tempFile).equals("doc")) {
                    genFile.genRandTmpPackage(tempFile.getAbsolutePath(), inU, tableOwners);
                } else {
                    genFile.genDocxTmpPackageFile(tempFile.getAbsolutePath(), inU, tableOwners);
                }

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

        addDocTable.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));

        addDocTable.setOnAction(event -> {

            GenDocTable GDTable = new GenDocTable();
            try
            {
                Stage stage = new Stage();
                List <Organization> allDataU = tableOwners.getDataU();
                GDTable.start(stage, allDataU, MenuLine.this);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Создайте файл!");
                alert.showAndWait();
            }
        });

        editTmp.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));

        editTmp.setOnAction(event -> {

            OpenTmp openTmp = new OpenTmp();
            try
            {
                Stage stage = new Stage();
                openTmp.start(stage,MenuLine.this);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Создайте файл!");
                alert.showAndWait();
            }
        });

        addAccounting.setAccelerator(KeyCombination.keyCombination("Ctrl+Y"));

        addAccounting.setOnAction(event -> {

            Accounting accounting = new Accounting();
            try
            {
                Stage stage = new Stage();
                accounting.start(stage, inU, tableOwners);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Создайте файл!");
                alert.showAndWait();
            }
        });

        info.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+I"));

        info.setOnAction(event -> {
            try
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("О программе");
                alert.setContentText("\"© 2018 ИИТ - БГУИР, Александр Каравай, Андрей Ольховый, Иван Райкевич\"");
                alert.setHeaderText("Система управления общим недвижимым имуществом");
                alert.showAndWait();
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

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
