package bsuir.file;

import bsuir.TagsForFile;
import bsuir.model.AccountingMonth;
import bsuir.model.Organization;
import bsuir.model.Payer;
import bsuir.view.TableOwners;
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

public class LoadPayerDB {

    private List<Payer> db = FXCollections.observableArrayList();

    private List<Organization> dbOrg = FXCollections.observableArrayList();
    public TableOwners tableOwners;

    public void dbRead(String filePath, List<Organization> dbO, TableOwners tableOwners) {
        db.clear();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("documents/payer.xml");
        Document document;

        this.dbOrg = dbO;
        this.tableOwners = tableOwners;

        List <Organization> allOwner = this.dbOrg;


        Organization owner = allOwner.get(tableOwners.getSelectionModel().getSelectedIndex());

        try {

            document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            List listPayer = rootNode.getChildren(TagsForFile.payer);


            for (int i = 0; i < (listPayer.size()); i++) {

                String ID;
                String FIO;
                String DATE_ACC;
                String HOT_WATER;
                String COLD_WATER;
                String ELECTRIC_POWER;

                AccountingMonth accountingMonth;

                Element payer = (Element) listPayer.get(i);

                if (owner.getId().equals(payer.getChildText(TagsForFile.ID))) {

                    ID         =    payer.getChildText(TagsForFile.ID);
                    FIO        =    payer.getChildText(TagsForFile.FIO);

                    List accountingList = payer.getChildren(TagsForFile.accountingMonth);

                    for (int j = 0; j < accountingList.size(); j++) {

                        Element month = (Element) accountingList.get(j);

                        DATE_ACC   =    month.getChildText(TagsForFile.DATE_ACC);
                        HOT_WATER        =    month.getChildText(TagsForFile.HOT_WATER);
                        COLD_WATER     =    month.getChildText(TagsForFile.COLD_WATER);
                        ELECTRIC_POWER        =    month.getChildText(TagsForFile.ELECTRIC_POWER);


                        accountingMonth = new AccountingMonth(DATE_ACC, HOT_WATER, COLD_WATER, ELECTRIC_POWER);
                        db.add(new Payer(ID, FIO, accountingMonth));
                    }

                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dbTest(String filePath, List<Organization> dbO, TableOwners tableOwners, final List<Payer> allDataPayers) {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("documents/payer.xml");
        Document document;

        this.dbOrg = dbO;
        this.tableOwners = tableOwners;
        this.db = allDataPayers;

        List <Organization> allOwner = this.dbOrg;

        List <Payer> allPayer =this.db;

        Organization owner = allOwner.get(tableOwners.getSelectionModel().getSelectedIndex());

        try {

            document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            List listPayer = rootNode.getChildren(TagsForFile.payer);


            for (int i = 0; i < (listPayer.size()); i++) {

                Element payer = (Element) listPayer.get(i);

                if (owner.getId().equals(payer.getChildText(TagsForFile.ID))) {

                    for (int a = 0; a < db.size(); a++) {
                        Payer dbPayer = db.get(a);

                        if (allPayer.get(a).getFioPayer().equals(payer.getChildText(TagsForFile.FIO))) {

                            System.out.println("///////");

                        } else {

                            Element accountingMonth = new Element(TagsForFile.accountingMonth);

                            Element DATE_ACC = new Element(TagsForFile.DATE_ACC).setText(dbPayer.getMonth());
                            Element HOT_WATER = new Element(TagsForFile.HOT_WATER).setText(dbPayer.getHotWater());
                            Element COLD_WATER = new Element(TagsForFile.COLD_WATER).setText(dbPayer.getColdWater());
                            Element ELECTRIC_POWER = new Element(TagsForFile.ELECTRIC_POWER).setText(dbPayer.getElectricPower());

                            accountingMonth.addContent(DATE_ACC);
                            accountingMonth.addContent(HOT_WATER);
                            accountingMonth.addContent(COLD_WATER);
                            accountingMonth.addContent(ELECTRIC_POWER);

                            payer.addContent(accountingMonth);
                        }
                    }
                }
            }

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(filePath));

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dbWriteTest(String filePath, List<Organization> dbO, TableOwners tableOwners, final List<Payer> allDataPayers) {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("documents/payer.xml");
        Document document;

        this.dbOrg = dbO;
        this.tableOwners = tableOwners;
        this.db = allDataPayers;

        try {

            document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            for (int i = 0; i < db.size(); i++) {

                Payer dbPayer = db.get(db.size()-1);

                Element payer = new Element(TagsForFile.payer);
                Element accountingMonth = new Element(TagsForFile.accountingMonth);

                Element ID = new Element(TagsForFile.ID).setText(dbPayer.getIdPayer());
                Element FIO = new Element(TagsForFile.FIO).setText(dbPayer.getFioPayer());
                Element DATE_ACC = new Element(TagsForFile.DATE_ACC).setText(dbPayer.getMonth());
                Element HOT_WATER = new Element(TagsForFile.HOT_WATER).setText(dbPayer.getHotWater());
                Element COLD_WATER = new Element(TagsForFile.COLD_WATER).setText(dbPayer.getColdWater());
                Element ELECTRIC_POWER = new Element(TagsForFile.ELECTRIC_POWER).setText(dbPayer.getElectricPower());

                accountingMonth.addContent(DATE_ACC);
                accountingMonth.addContent(HOT_WATER);
                accountingMonth.addContent(COLD_WATER);
                accountingMonth.addContent(ELECTRIC_POWER);

                payer.addContent(ID);
                payer.addContent(FIO);

                payer.addContent(accountingMonth);

                rootNode.addContent(payer);
            }

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(filePath));

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Payer> getDbPayer() {
        return db;
    }

    public void setDbPayer(ObservableList<Payer> db) {
        this.db = db;
    }

    public void setDbPayer(List<Payer> db) {
        this.db = db;
    }
}
