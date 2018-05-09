package bsuir.file;

import bsuir.model.Organization;
import bsuir.view.TableOwners;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class GenDocFile {

    private List<Organization> db = FXCollections.observableArrayList();
    public TableOwners tableOwners;

    public void genRandTmp(String filePath, List<Organization> db, TableOwners tableOwners) {

        this.db = db;
        this.tableOwners = tableOwners;

        String filename = filePath;
        POIFSFileSystem fs = null;

        List <Organization> allOwner = this.db;

        try {

            fs = new POIFSFileSystem(new FileInputStream(filename));
            HWPFDocument doc = new HWPFDocument(fs);

            Range range = doc.getRange();

            Organization owner = allOwner.get(tableOwners.getSelectionModel().getSelectedIndex());

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

    public void genRandTmpPackage(String filePath, List<Organization> db, TableOwners tableOwners) {

        this.db = db;
        this.tableOwners = tableOwners;

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

    public void genDocxTmpFile(String filePath, List<Organization> db, TableOwners tableOwners) {

        this.db = db;
        this.tableOwners = tableOwners;

        List <Organization> allOwner = this.db;

        String filename = filePath;

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        try {
            Organization owner = allOwner.get(tableOwners.getSelectionModel().getSelectedIndex());

            XWPFDocument doc = new XWPFDocument(OPCPackage.open(filename));
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("FAMILY")) {
                            text = text.replace("FAMILY", owner.getFio());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("DATE_REG")) {
                            text = text.replace("DATE_REG", owner.getDateReg());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("INV")) {
                            text = text.replace("INV", owner.getInv());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("BOX_SQ")) {
                            text = text.replace("BOX_SQ", owner.getBoxSq());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("NUM")) {
                            text = text.replace("NUM", owner.getNum());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PASP")) {
                            text = text.replace("PASP", owner.getPasp());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PW")) {
                            text = text.replace("PW", owner.getPw());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PD")) {
                            text = text.replace("PD", owner.getPd());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PN")) {
                            text = text.replace("PN", owner.getPn());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PHONE")) {
                            text = text.replace("PHONE", owner.getPhone());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("MAIL")) {
                            text = text.replace("MAIL", owner.getMail());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ADDRESS")) {
                            text = text.replace("ADDRESS", owner.getAddress());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ADRREG")) {
                            text = text.replace("ADRREG", owner.getAdrreg());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("AUTO")) {
                            text = text.replace("AUTO", owner.getAuto());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("IND_DOG")) {
                            text = text.replace("IND_DOG", owner.getIndDog());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("INDEX")) {
                            text = text.replace("INDEX", owner.getIndex());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("SQPR")) {
                            text = text.replace("SQPR", owner.getSqpr());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("PROC")) {
                            text = text.replace("PROC", owner.getProc());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("SQ")) {
                            text = text.replace("SQ", owner.getSq());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("OSAVTO")) {
                            text = text.replace("OSAVTO", owner.getOsavto());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("UR")) {
                            text = text.replace("UR", owner.getUr());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("OSSPECTR")) {
                            text = text.replace("OSSPECTR", owner.getOsspectr());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("NED1")) {
                            text = text.replace("NED1", owner.getNed_1());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("NED2")) {
                            text = text.replace("NED2", owner.getNed_2());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("%FIO%")) {
                            text = text.replace("%FIO%", owner.getId());
                            r.setText(text, 0);
                        }
                    }
                }
            }

            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.contains("FAMILY")) {
                                    text = text.replace("FAMILY", owner.getFio());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("DATE_REG")) {
                                    text = text.replace("DATE_REG", owner.getDateReg());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("INV")) {
                                    text = text.replace("INV", owner.getInv());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("BOX_SQ")) {
                                    text = text.replace("BOX_SQ", owner.getBoxSq());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("NUM")) {
                                    text = text.replace("NUM", owner.getNum());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PASP")) {
                                    text = text.replace("PASP", owner.getPasp());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PW")) {
                                    text = text.replace("PW", owner.getPw());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PD")) {
                                    text = text.replace("PD", owner.getPd());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PN")) {
                                    text = text.replace("PN", owner.getPn());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PHONE")) {
                                    text = text.replace("PHONE", owner.getPhone());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("MAIL")) {
                                    text = text.replace("MAIL", owner.getMail());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("ADDRESS")) {
                                    text = text.replace("ADDRESS", owner.getAddress());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("ADRREG")) {
                                    text = text.replace("ADRREG", owner.getAdrreg());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("AUTO")) {
                                    text = text.replace("AUTO", owner.getAuto());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("IND_DOG")) {
                                    text = text.replace("IND_DOG", owner.getIndDog());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("INDEX")) {
                                    text = text.replace("INDEX", owner.getIndex());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("SQPR")) {
                                    text = text.replace("SQPR", owner.getSqpr());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("PROC")) {
                                    text = text.replace("PROC", owner.getProc());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("SQ")) {
                                    text = text.replace("SQ", owner.getSq());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("OSAVTO")) {
                                    text = text.replace("OSAVTO", owner.getOsavto());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("UR")) {
                                    text = text.replace("UR", owner.getUr());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("OSSPECTR")) {
                                    text = text.replace("OSSPECTR", owner.getOsspectr());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("NED1")) {
                                    text = text.replace("NED1", owner.getNed_1());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("NED2")) {
                                    text = text.replace("NED2", owner.getNed_2());
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("%FIO%")) {
                                    text = text.replace("%FIO%", owner.getId());
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
            doc.write(new FileOutputStream("documents/gen_doc/"+result.get()+"_"+owner.getFio()+".docx"));

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("");
            alert.setHeaderText("Ошибка: Откройте файл!");
            alert.showAndWait();
        }
    }

    public void genDocxTmpPackageFile(String filePath, List<Organization> db, TableOwners tableOwners) {

        this.db = db;
        this.tableOwners = tableOwners;

        List <Organization> allOwner = this.db;

        String filename = filePath;

        TextInputDialog dialog = new TextInputDialog("Заявление");
        dialog.setTitle("Название документа");
        dialog.setHeaderText("Введите имя файла");
        dialog.setContentText("Имя файла:");

        Optional<String> result = dialog.showAndWait();

        try {
            for ( int i = 0; i < allOwner.size(); i++ ) {

                Organization owner = allOwner.get(i);

                XWPFDocument doc = new XWPFDocument(OPCPackage.open(filename));
                for (XWPFParagraph p : doc.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            String text = r.getText(0);
                            if (text != null && text.contains("FAMILY")) {
                                text = text.replace("FAMILY", owner.getFio());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("DATE_REG")) {
                                text = text.replace("DATE_REG", owner.getDateReg());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("INV")) {
                                text = text.replace("INV", owner.getInv());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("BOX_SQ")) {
                                text = text.replace("BOX_SQ", owner.getBoxSq());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("NUM")) {
                                text = text.replace("NUM", owner.getNum());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PASP")) {
                                text = text.replace("PASP", owner.getPasp());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PW")) {
                                text = text.replace("PW", owner.getPw());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PD")) {
                                text = text.replace("PD", owner.getPd());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PN")) {
                                text = text.replace("PN", owner.getPn());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PHONE")) {
                                text = text.replace("PHONE", owner.getPhone());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("MAIL")) {
                                text = text.replace("MAIL", owner.getMail());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("ADDRESS")) {
                                text = text.replace("ADDRESS", owner.getAddress());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("ADRREG")) {
                                text = text.replace("ADRREG", owner.getAdrreg());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("AUTO")) {
                                text = text.replace("AUTO", owner.getAuto());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("IND_DOG")) {
                                text = text.replace("IND_DOG", owner.getIndDog());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("INDEX")) {
                                text = text.replace("INDEX", owner.getIndex());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("SQPR")) {
                                text = text.replace("SQPR", owner.getSqpr());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("PROC")) {
                                text = text.replace("PROC", owner.getProc());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("SQ")) {
                                text = text.replace("SQ", owner.getSq());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("OSAVTO")) {
                                text = text.replace("OSAVTO", owner.getOsavto());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("UR")) {
                                text = text.replace("UR", owner.getUr());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("OSSPECTR")) {
                                text = text.replace("OSSPECTR", owner.getOsspectr());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("NED1")) {
                                text = text.replace("NED1", owner.getNed_1());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("NED2")) {
                                text = text.replace("NED2", owner.getNed_2());
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("%FIO%")) {
                                text = text.replace("%FIO%", owner.getId());
                                r.setText(text, 0);
                            }
                        }
                    }
                }

                for (XWPFTable tbl : doc.getTables()) {
                    for (XWPFTableRow row : tbl.getRows()) {
                        for (XWPFTableCell cell : row.getTableCells()) {
                            for (XWPFParagraph p : cell.getParagraphs()) {
                                for (XWPFRun r : p.getRuns()) {
                                    String text = r.getText(0);
                                    if (text != null && text.contains("FAMILY")) {
                                        text = text.replace("FAMILY", owner.getFio());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("DATE_REG")) {
                                        text = text.replace("DATE_REG", owner.getDateReg());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("INV")) {
                                        text = text.replace("INV", owner.getInv());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("BOX_SQ")) {
                                        text = text.replace("BOX_SQ", owner.getBoxSq());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("NUM")) {
                                        text = text.replace("NUM", owner.getNum());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PASP")) {
                                        text = text.replace("PASP", owner.getPasp());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PW")) {
                                        text = text.replace("PW", owner.getPw());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PD")) {
                                        text = text.replace("PD", owner.getPd());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PN")) {
                                        text = text.replace("PN", owner.getPn());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PHONE")) {
                                        text = text.replace("PHONE", owner.getPhone());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("MAIL")) {
                                        text = text.replace("MAIL", owner.getMail());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("ADDRESS")) {
                                        text = text.replace("ADDRESS", owner.getAddress());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("ADRREG")) {
                                        text = text.replace("ADRREG", owner.getAdrreg());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("AUTO")) {
                                        text = text.replace("AUTO", owner.getAuto());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("IND_DOG")) {
                                        text = text.replace("IND_DOG", owner.getIndDog());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("INDEX")) {
                                        text = text.replace("INDEX", owner.getIndex());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("SQPR")) {
                                        text = text.replace("SQPR", owner.getSqpr());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("PROC")) {
                                        text = text.replace("PROC", owner.getProc());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("SQ")) {
                                        text = text.replace("SQ", owner.getSq());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("OSAVTO")) {
                                        text = text.replace("OSAVTO", owner.getOsavto());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("UR")) {
                                        text = text.replace("UR", owner.getUr());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("OSSPECTR")) {
                                        text = text.replace("OSSPECTR", owner.getOsspectr());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("NED1")) {
                                        text = text.replace("NED1", owner.getNed_1());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("NED2")) {
                                        text = text.replace("NED2", owner.getNed_2());
                                        r.setText(text, 0);
                                    }
                                    if (text != null && text.contains("%FIO%")) {
                                        text = text.replace("%FIO%", owner.getId());
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
                doc.write(new FileOutputStream("documents/gen_doc/package/" + result.get() + "_" + owner.getFio() + ".docx"));
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText("");
            alert.setHeaderText("Ошибка: Откройте файл!");
            alert.showAndWait();
        }
    }
}
