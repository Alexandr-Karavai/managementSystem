package bsuir.view;

import bsuir.Main;
import bsuir.file.GenDocFile;
import bsuir.file.SaveLoadFile;
import bsuir.model.Organization;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MenuLine extends MenuBar {

    public SaveLoadFile workFile = new SaveLoadFile();
    BorderPane source;
    public Main parentClass;
    public MyTable myTable;
    public GenDocFile genFile;

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
        Menu about = new Menu ("Справка");

        this.getMenus().addAll(file, actions, documents, genTable, about);

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("файл (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        final MenuItem newFile = new MenuItem("Новый реестр");
        MenuItem loadFile = new MenuItem("Открыть");
        MenuItem saveFile = new MenuItem("Сохранить как");
        MenuItem addRecord = new MenuItem("Добавить");
        MenuItem findRecord = new MenuItem("Найти/Удалить");

        Menu statement = new Menu("Заявление");
        Menu statementGSPK = new Menu("Заявление ГСПК");
        Menu bulletin = new Menu("Бюллетень");

        MenuItem genStatement = new MenuItem("Создать заявление");
        MenuItem gen_statements = new MenuItem("Создать для всех");

        MenuItem genStatementGSPK = new MenuItem("Создать заявление ГСПК");
        MenuItem gen_statementsGSPK = new MenuItem("Создать для всех");

        MenuItem genBulletin = new MenuItem("Создать бюллетень");
        MenuItem gen_bulletins = new MenuItem("Создать для всех");

        MenuItem addDocTable = new MenuItem("Создать таблицу");

        MenuItem info = new MenuItem ("О программе");

        file.getItems().addAll(newFile, loadFile, saveFile);
        actions.getItems().addAll(addRecord, findRecord);
        documents.getItems().addAll(statement, statementGSPK, bulletin);

        statement.getItems().addAll(genStatement, gen_statements);
        statementGSPK.getItems().addAll(genStatementGSPK, gen_statementsGSPK);
        bulletin.getItems().addAll(genBulletin, gen_bulletins);

        genTable.getItems().addAll(addDocTable);

        about.getItems().addAll(info);

        newFile.setOnAction(event -> {
            myTable = new MyTable();
            source.setCenter(myTable);
            List <Organization> inU = FXCollections.observableArrayList();
            myTable.setDataU(inU);
            parentClass.creatingLoadingTable();
        });

        saveFile.setOnAction(event -> {
            File file1 = fileChooser.showSaveDialog(null);
            List <Organization> allDataU = myTable.getDataU();
            workFile.setDb(allDataU);
            workFile.dbWrite(file1.getAbsolutePath());
        });

        loadFile.setOnAction(event -> {
            File file1 = fileChooser.showOpenDialog(null);
            try
            {
                workFile.dbRead(file1.getAbsolutePath());
                myTable = new MyTable();
                source.setCenter(myTable);
                inU.addAll(workFile.getDb());
                myTable.setDataU(inU);
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
                List <Organization> allDataU = myTable.getDataU();
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
//                List <Organization> allData = myTable.getDataU();
//                SearchDelete FRDialog = new SearchDelete();
//                FRDialog.start(stage, allData, MenuLine.this);
//            }
//            catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(null, "Ошибка: Создайте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);
//
//            }
//        });

        genStatement.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genStatement(inU, myTable);
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

            gen_statements.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genStatements(inU, myTable);
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

        genStatementGSPK.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genStatementGSPK(inU, myTable);
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

        gen_statementsGSPK.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genStatementsGSPK(inU, myTable);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка #2");
                alert.setContentText("");
                alert.setHeaderText("Ошибка: Перезапустите программу!");
                alert.showAndWait();
            }


        });

        genBulletin.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genBulletin(inU, myTable);
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

        gen_bulletins.setOnAction(event -> {
            try
            {
                genFile = new GenDocFile();
                genFile.genBulletins(inU, myTable);
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

        addDocTable.setOnAction(event -> {

            GenDocTable GDTable = new GenDocTable();
            try
            {
                Stage stage = new Stage();
                List <Organization> allDataU = myTable.getDataU();
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
}
