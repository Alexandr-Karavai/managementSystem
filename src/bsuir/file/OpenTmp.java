package bsuir.file;

import bsuir.view.MenuLine;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

public class OpenTmp {

    TextArea textArea = new TextArea();

    public String styleFile;

    public void start(final Stage primaryStage, final MenuLine parentClass) {

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu fileMenu = new Menu("Файл");
        Menu helpMenu = new Menu("Помощь");

        // Create MenuItems
        MenuItem openFileItem = new MenuItem("Открыть файл");
        MenuItem saveItem = new MenuItem("Сохранить");

        // Add menuItems to the Menus
        fileMenu.getItems().addAll(openFileItem, saveItem);

        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        textArea.setWrapText(true);
        root.setCenter(textArea);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(
                new Label("==============="),
                new Label("Теги в системе: "),
                new Label("==============="),
                new Label("ID"),
                new Label("FIO"),
                new Label("DATE_REG"),
                new Label("INV"),
                new Label("BOX_SQ"),
                new Label("NUM"),
                new Label("PASP"),
                new Label("PW"),
                new Label("PD"),
                new Label("PN"),
                new Label("PHONE"),
                new Label("MAIL"),
                new Label("ADDRESS"),
                new Label("ADRREG"),
                new Label("AUTO"),
                new Label("IND_DOG"),
                new Label("INDEX"),
                new Label("SQPR"),
                new Label("PROC"),
                new Label("SQ"),
                new Label("OSAVTO"),
                new Label("UR"),
                new Label("OSSPECTR"),
                new Label("NED_1"),
                new Label("NED_2"),
                new Label("===============")
        );
        root.setRight(vBox);

        primaryStage.setTitle("Редактировать шаблон");
        Scene scene;

        scene = new Scene(root, 940, 780);
        primaryStage.setScene(scene);
        primaryStage.show();

        final FileChooser templateChooser = new FileChooser();
        templateChooser.setTitle("Открыть шаблон");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("файл (*.docx, *.doc)", "*.docx", "*.doc");
        templateChooser.getExtensionFilters().add(filter);

        openFileItem.setOnAction(event -> {

            File tempFile = templateChooser.showOpenDialog(null);
            styleFile = tempFile.getAbsolutePath();
            try
            {
                if ( getFileExtension(tempFile).equals("doc")) {
                    readDocFile(tempFile.getAbsolutePath());
                } else {
                    readDocxFile(tempFile.getAbsolutePath());
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

        saveItem.setOnAction(event -> {
            try
            {
                saveTmp();
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

    public void readDocxFile(String filePath) {

        String filename = filePath;

        try {
            Runtime.getRuntime().exec("cmd /C " + filePath);
            XWPFDocument docx = new XWPFDocument(new FileInputStream(filename));
            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            textArea.setText(we.getText());

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("");
            alert.setHeaderText("Ошибка: Откройте файл!");
            alert.showAndWait();
        }
    }

    public void saveTmp() throws Exception {

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("documents/templates/"+result.get()+".docx"));

        //create Paragraph
        List dgf = textArea.getParagraphs();

        for(Object person : dgf){
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(person.toString());
        }
        document.write(out);
        out.flush();
        out.close();
    }


    public void readDocFile(String fileName) {

        try {
            File file = new File(fileName);
            Runtime.getRuntime().exec("cmd /C " + fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            HWPFDocument doc = new HWPFDocument(fis);

            WordExtractor we = new WordExtractor(doc);

            textArea.setText(we.getText());

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
