package bsuir.view;

import bsuir.Main;
import bsuir.file.SaveLoadFile;
import bsuir.file.SearchDelete;
import bsuir.model.University;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class MenuLine extends MenuBar {

    public SaveLoadFile workFile = new SaveLoadFile();
    BorderPane source;
    public Main parentClass;
    public MyTable myTable;

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
        Menu about = new Menu ("Справка");

        this.getMenus().addAll(file, actions, about);

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("файл (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        final MenuItem newFile = new MenuItem("Новый реестр");
        MenuItem loadFile = new MenuItem("Открыть");
        MenuItem saveFile = new MenuItem("Сохранить");
        MenuItem addRecord = new MenuItem("Добавить");
        MenuItem findRecord = new MenuItem("Найти/Удалить");
        MenuItem programm = new MenuItem ("О программе");

        file.getItems().addAll(newFile, loadFile, saveFile);
        actions.getItems().addAll(addRecord, findRecord);
        about.getItems().addAll(programm);

        newFile.setOnAction(event -> {
            myTable = new MyTable();
            source.setCenter(myTable);
            List <University> inU = FXCollections.observableArrayList();
            myTable.setDataU(inU);
            parentClass.creatingLoadingTable();
        });

        saveFile.setOnAction(event -> {
            File file1 = fileChooser.showSaveDialog(null);
            List <University> allDataU = myTable.getDataU();
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
                List  <University> inU = FXCollections.observableArrayList();
                inU.addAll(workFile.getDb());
                myTable.setDataU(inU);
                parentClass.creatingLoadingTable();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Файл не был выбран", "Ошибка", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });

        addRecord.setOnAction(event -> {

            AddDialog ARDialog = new AddDialog();
            try
            {
                Stage stage = new Stage();
                List <University> allDataU = myTable.getDataU();
                ARDialog.start(stage, allDataU, MenuLine.this);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog (null, "Ошибка: Создайте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);
            }
        });

        findRecord.setOnAction(event -> {
            try
            {
                Stage stage = new Stage();
                List <University> allData = myTable.getDataU();
                SearchDelete FRDialog = new SearchDelete();
                FRDialog.start(stage, allData, MenuLine.this);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Ошибка: Создайте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);

            }
        });

        programm.setOnAction(event -> {
            try
            {
                JOptionPane.showMessageDialog(null,
                        new String[] {"ИИТ - БГУИР",
                                "\"Система управления общим недвижимым имуществом\"",
                                "© 2018 г., Александр Каравай"},
                        "О программе",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Ошибка: Перезапустите программу!", "Ошибка" , JOptionPane.ERROR_MESSAGE);

            }


        });

    }







}
