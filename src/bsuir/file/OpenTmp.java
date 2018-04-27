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
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OpenTmp {

    TextArea textArea = new TextArea();
//
    public String styleFile;
//
//    public boolean Both;
//    public boolean Italic;
//    public boolean Strike;
//
//    public String aligment;
//    public String styleP;
//
//    public int fontSize;

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

//        style(styleFile);

        for(Object person : dgf){

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
//            paragraph.setAlignment(ParagraphAlignment.CENTER);

            run.setText(person.toString());

//            run.setBold(Both);
//            run.setFontSize(fontSize);
//            run.setItalic(Italic);
//            run.setStrike(Strike);
////            System.out.println(person.toString());

        }



        document.write(out);
        out.flush();
        out.close();
    }

//    public void style(String fileName) {
//        try {
//            FileInputStream fis = new FileInputStream(fileName);
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//
//            List <XWPFParagraph> paragraphList = xdoc.getParagraphs();
//
//            for (XWPFParagraph paragraph : paragraphList) {
//
//                for (XWPFRun rn : paragraph.getRuns()) {
//
//                    Both = rn.isBold();
//                    Strike = rn.isStrike();
//                    Italic = rn.isItalic();
//                    fontSize = rn.getFontSize();
//                    aligment = paragraph.getAlignment().toString();
//                    paragraph.getRuns().size();
//
////                    System.out.println(rn.isBold());
////                    System.out.println(rn.isStrike());
////                    System.out.println(rn.isItalic());
////                    System.out.println(rn.getFontSize());
////
////                    System.out.println(paragraph.getText());
////                    System.out.println(paragraph.getAlignment());
////                    System.out.print(paragraph.getRuns().size());
////                    System.out.println(paragraph.getStyle());
////
////                System.out.println("=====================================================================");
//                }
//
//                System.out.println("********************************************************************");
//                styleP = paragraph.getStyle();
////                paragraph.setStyle();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }

//    public void parag() {
//        try {
//            FileInputStream fis = new FileInputStream("test.docx");
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//
//            List paragraphList = xdoc.getParagraphs();
//
//            for (XWPFParagraph paragraph : paragraphList) {
//
//                System.out.println(paragraph.getText());
//                System.out.println(paragraph.getAlignment());
//                System.out.print(paragraph.getRuns().size());
//                System.out.println(paragraph.getStyle());
//
//                // Returns numbering format for this paragraph, eg bullet or lowerLetter.
//                System.out.println(paragraph.getNumFmt());
//                System.out.println(paragraph.getAlignment());
//
//                System.out.println(paragraph.isWordWrapped());
//
//                System.out.println("********************************************************************");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }


    public void readDocFile(String fileName) {

        try {
            File file = new File(fileName);
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
