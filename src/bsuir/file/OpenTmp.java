package bsuir.file;

import bsuir.view.MenuLine;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Optional;

public class OpenTmp {

    TextArea textArea = new TextArea();

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
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("файл (*.docx)", "*.docx");
        templateChooser.getExtensionFilters().add(filter);

        openFileItem.setOnAction(event -> {
            File tempFile = templateChooser.showOpenDialog(null);
            try
            {
                openTmp(tempFile.getAbsolutePath());
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

    public void openTmp(String filePath) {

        String filename = filePath;

        try {
            
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
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(textArea.getText());

        document.write(out);
        out.flush();
        out.close();
    }
}
