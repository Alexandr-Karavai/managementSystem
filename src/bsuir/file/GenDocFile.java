package bsuir.file;

import bsuir.model.Organization;
import bsuir.view.MyTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class GenDocFile {

    private List<Organization> db = FXCollections.observableArrayList();
    public MyTable myTable;

    public void genRandTmp(String filePath, List<Organization> db, MyTable myTable) {

        this.db = db;
        this.myTable = myTable;

        String filename = filePath;
        POIFSFileSystem fs = null;

        List <Organization> allOwner = this.db;

        try {

            fs = new POIFSFileSystem(new FileInputStream(filename));
            HWPFDocument doc = new HWPFDocument(fs);

            Range range = doc.getRange();

            Organization owner = allOwner.get(myTable.getSelectionModel().getSelectedIndex());

            range.replaceText("%FIO%", owner.getId());
            range.replaceText("FAMILY", owner.getFio());
            range.replaceText("DATE_REG", owner.getDateReg());
            range.replaceText("INV", owner.getInv());
            range.replaceText("BOX_SQ", owner.getBoxSq());
            range.replaceText("NUM", owner.getNum());
            range.replaceText("PASP", owner.getPasp());
            range.replaceText("PW", owner.getPw());
            range.replaceText("PD", owner.getPd());
            range.replaceText("PN", owner.getPn());
            range.replaceText("PHONE", owner.getPhone());
            range.replaceText("MAIL", owner.getMail());
            range.replaceText("ADDRESS", owner.getAddress());
            range.replaceText("ADRREG", owner.getAdrreg());
            range.replaceText("AUTO", owner.getAuto());
            range.replaceText("IND_DOG", owner.getIndDog());
            range.replaceText("INDEX", owner.getIndex());
            range.replaceText("SQPR", owner.getSqpr());
            range.replaceText("PROC", owner.getProc());
            range.replaceText("SQ", owner.getSq());
            range.replaceText("OSAVTO", owner.getOsavto());
            range.replaceText("UR", owner.getUr());
            range.replaceText("OSSPECTR", owner.getOsspectr());
            range.replaceText("NED1", owner.getNed_1());
            range.replaceText("NED2", owner.getNed_2());

            TextInputDialog dialog = new TextInputDialog("Заявление");
            dialog.setTitle("Название документа");
            dialog.setHeaderText("Введите имя файла");
            dialog.setContentText("Имя файла:");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()){
                OutputStream out = new FileOutputStream("documents/gen_doc/"+result.get()+"_"+owner.getFio()+".doc");

                doc.write(out);

                out.flush();
                out.close();
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("");
            alert.setHeaderText("Ошибка: Откройте файл!");
            alert.showAndWait();
        }

    }

    public void genRandTmpPackage(String filePath, List<Organization> db, MyTable myTable) {

        this.db = db;
        this.myTable = myTable;

        String filename = filePath;
        POIFSFileSystem fs = null;

        List <Organization> allOwner = this.db;

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        try {

            for ( int i = 0; i < allOwner.size(); i++ ) {

                fs = new POIFSFileSystem(new FileInputStream(filename));
                HWPFDocument doc = new HWPFDocument(fs);

                Range range = doc.getRange();

                Organization owner = allOwner.get(i);

                range.replaceText("%FIO%", owner.getId());
                range.replaceText("FAMILY", owner.getFio());
                range.replaceText("DATE_REG", owner.getDateReg());
                range.replaceText("INV", owner.getInv());
                range.replaceText("BOX_SQ", owner.getBoxSq());
                range.replaceText("NUM", owner.getNum());
                range.replaceText("PASP", owner.getPasp());
                range.replaceText("PW", owner.getPw());
                range.replaceText("PD", owner.getPd());
                range.replaceText("PN", owner.getPn());
                range.replaceText("PHONE", owner.getPhone());
                range.replaceText("MAIL", owner.getMail());
                range.replaceText("ADDRESS", owner.getAddress());
                range.replaceText("ADRREG", owner.getAdrreg());
                range.replaceText("AUTO", owner.getAuto());
                range.replaceText("IND_DOG", owner.getIndDog());
                range.replaceText("INDEX", owner.getIndex());
                range.replaceText("SQPR", owner.getSqpr());
                range.replaceText("PROC", owner.getProc());
                range.replaceText("SQ", owner.getSq());
                range.replaceText("OSAVTO", owner.getOsavto());
                range.replaceText("UR", owner.getUr());
                range.replaceText("OSSPECTR", owner.getOsspectr());
                range.replaceText("NED1", owner.getNed_1());
                range.replaceText("NED2", owner.getNed_2());

                if (result.isPresent()){
                    OutputStream out = new FileOutputStream("documents/gen_doc/package/"+result.get()+"_"+owner.getFio()+".doc");

                    doc.write(out);

                    out.flush();
                    out.close();
                }
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("");
            alert.setHeaderText("Ошибка: Откройте файл!");
            alert.showAndWait();
        }

    }
}
