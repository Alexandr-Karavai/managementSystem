package bsuir.file;

import bsuir.TagsForFile;
import bsuir.model.Owner;
import bsuir.model.Organization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveLoadFile {

    private List<Organization> db = FXCollections.observableArrayList();


    public void dbRead() {this.dbRead("file.xml");}

    public void dbRead(String filePath) {
        db.clear();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        Document document;
        try {

            document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            List listOrganization = rootNode.getChildren(TagsForFile.organization);


            for (int i = 0; i < (listOrganization.size()); i++) {

                  String ID;
                  String FIO;
                  String DATE_REG;
                  String INV;
                  String BOX_SQ;
                  String NUM;
                  String PASP;
                  String PW;
                  String PD;
                  String PN;
                  String PHONE;
                  String MAIL;
                  String ADDRESS;
                  String ADRREG;
                  String AUTO;
                  String IND_DOG;
                  String INDEX;

                  String SQPR;
                  String PROC;
                  String SQ;
                  String OSAVTO;
                  String UR;
                  String OSSPECTR;
                  String NED_1;
                  String NED_2;

                  Owner ownerOrganization;

                Element organization = (Element) listOrganization.get(i);

                SQPR = organization.getChildText(TagsForFile.SQPR);
                PROC = organization.getChildText(TagsForFile.PROC);
                SQ = organization.getChildText(TagsForFile.SQ);
                OSAVTO = organization.getChildText(TagsForFile.OSAVTO);
                UR = organization.getChildText(TagsForFile.UR);
                OSSPECTR = organization.getChildText(TagsForFile.OSSPECTR);
                NED_1 = organization.getChildText(TagsForFile.NED_1);
                NED_2 = organization.getChildText(TagsForFile.NED_2);

                List ownerList = organization.getChildren(TagsForFile.owner);

                for (int j = 0; j < ownerList.size(); j++) {

                    Element owner = (Element) ownerList.get(j);

                    ID = owner.getChildText(TagsForFile.ID);
                    FIO = owner.getChildText(TagsForFile.FIO);
                    DATE_REG = owner.getChildText(TagsForFile.DATE_REG);

                    INV = owner.getChildText(TagsForFile.INV);
                    BOX_SQ = owner.getChildText(TagsForFile.BOX_SQ);
                    NUM = owner.getChildText(TagsForFile.NUM);
                    PASP = owner.getChildText(TagsForFile.PASP);
                    PW = owner.getChildText(TagsForFile.PW);
                    PD = owner.getChildText(TagsForFile.PD);
                    PN = owner.getChildText(TagsForFile.PN);
                    PHONE = owner.getChildText(TagsForFile.PHONE);
                    MAIL = owner.getChildText(TagsForFile.MAIL);
                    ADDRESS = owner.getChildText(TagsForFile.ADDRESS);
                    ADRREG = owner.getChildText(TagsForFile.ADRREG);
                    AUTO = owner.getChildText(TagsForFile.AUTO);
                    IND_DOG = owner.getChildText(TagsForFile.IND_DOG);
                    INDEX = owner.getChildText(TagsForFile.INDEX);

                    ownerOrganization = new Owner(ID, FIO, DATE_REG, INV, BOX_SQ, NUM, PASP, PW, PD, PN, PHONE, MAIL, ADDRESS, ADRREG, AUTO, IND_DOG, INDEX);
                    db.add(new Organization(ownerOrganization, SQPR, PROC, SQ, OSAVTO, UR, OSSPECTR, NED_1, NED_2));
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void dbWrite() {
//        dbWrite("file.xml");
//    }

//    public void dbWrite(String filePath) {
//        try {
//            Element rootNode = new Element(TagsForFile.organization);
//            Document doc = new Document(rootNode);
//
//            for (int i = 0; i < db.size(); i++) {
//                Organization dbOrganization = db.get(i);
//
//                Element organization = new Element(TagsForFile.organization);
//                Element owner = new Element(TagsForFile.owner);
//
//                Element faculty = new Element(TagsForFile.faculty).setText(dbOrganization.getFaculty());
//                Element department = new Element(TagsForFile.department).setText(dbOrganization.getNameOfDepartment());
//                Element fio = new Element(TagsForFile.fio).setText(dbOrganization.getFio());
//                Element title = new Element(TagsForFile.title).setText(dbOrganization.getTitle());
//                Element academic = new Element(TagsForFile.academic).setText(dbOrganization.getAcademicDegree());
//
//                organization.addContent(faculty);
//                organization.addContent(department);
//
//                owner.addContent(fio);
//                owner.addContent(title);
//                owner.addContent(academic);
//
//                organization.addContent(owner);
//
//                rootNode.addContent(organization);
//            }
//
//            XMLOutputter xmlOutput = new XMLOutputter();
//
//            xmlOutput.setFormat(Format.getPrettyFormat());
//
//            xmlOutput.output(doc, new FileWriter(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Organization> getDb() {
        return db;
    }

    public void setDb(ObservableList<Organization> db) {
        this.db = db;
    }

    public void setDb(List<Organization> db) {
        this.db = db;
    }
}
