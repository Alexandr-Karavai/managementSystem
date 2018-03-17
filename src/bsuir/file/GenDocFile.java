package bsuir.file;

import bsuir.model.Organization;
import bsuir.view.MyTable;
import javafx.collections.FXCollections;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class GenDocFile {

    private List<Organization> db = FXCollections.observableArrayList();
    public MyTable myTable;

    public void genStatement(List<Organization> db, MyTable myTable) {

        this.db = db;
        this.myTable = myTable;

        String filename = "documents/templates/Заявление_шаблон.doc";
        POIFSFileSystem fs = null;

        List <Organization> allOwner = this.db;

        try {

            fs = new POIFSFileSystem(new FileInputStream(filename));
            HWPFDocument doc = new HWPFDocument(fs);

            Range range = doc.getRange();

            Organization owner = allOwner.get(myTable.getSelectionModel().getSelectedIndex());

            range.replaceText("FAMILY", owner.getFio());
            range.replaceText("ADDRESS", owner.getAddress());
            range.replaceText("PN", owner.getPn());
            range.replaceText("%FIO%", owner.getId());
            range.replaceText("UR", owner.getUr());
            range.replaceText("OSAVTO", owner.getOsavto());
            range.replaceText("NED1", owner.getNed_1());
            range.replaceText("NED2", owner.getNed_2());


            OutputStream out = new FileOutputStream("documents/gen_statement/Заявление_"+owner.getFio()+".doc");
            doc.write(out);

            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка: Откройте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);
        }
    }

    public void genBulletin(List<Organization> db, MyTable myTable) {

        this.db = db;
        this.myTable = myTable;

        String filename = "documents/templates/Бюллетень_шаблон.doc";
        POIFSFileSystem fs = null;

        List <Organization> allOwner = this.db;

        try {

            fs = new POIFSFileSystem(new FileInputStream(filename));
            HWPFDocument doc = new HWPFDocument(fs);

            Range range = doc.getRange();

            Organization owner = allOwner.get(myTable.getSelectionModel().getSelectedIndex());

            range.replaceText("IND_DOG", owner.getIndDog());
            range.replaceText("INDEX", owner.getIndex());
            range.replaceText("FAMILY", owner.getFio());
            range.replaceText("%FIO%", owner.getId());
            range.replaceText("BOX_SQ", owner.getBoxSq());
            range.replaceText("PASP", owner.getPasp());
            range.replaceText("PW", owner.getPw());
            range.replaceText("PD", owner.getPd());
            range.replaceText("PN", owner.getPn());
            range.replaceText("ADDRESS", owner.getAddress());
            range.replaceText("PHONE", owner.getPhone());
            range.replaceText("MAIL", owner.getMail());
            range.replaceText("NUM", owner.getNum());
            range.replaceText("DATE_REG", owner.getDateReg());
            range.replaceText("INV", owner.getInv());

            OutputStream out = new FileOutputStream("documents/gen_bulletin/Бюллетень_"+owner.getFio()+".doc");
            doc.write(out);

            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка: Откройте файл!", "Ошибка" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
