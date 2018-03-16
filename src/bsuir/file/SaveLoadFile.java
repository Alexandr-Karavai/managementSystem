package bsuir.file;

import bsuir.TagsForFile;
import bsuir.model.Lecturer;
import bsuir.model.University;
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

    private List<University> db = FXCollections.observableArrayList();


    public void dbRead() {this.dbRead("file.xml");}

    public void dbRead(String filePath) {
        db.clear();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        Document document;
        try {

            document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();

            List listUniversity = rootNode.getChildren(TagsForFile.university);


            for (int i = 0; i < (listUniversity.size()); i++) {

                String faculty ;
                String department;
                String fio;
                String title;
                String academic;
                Lecturer lecturerUniversity;

                Element university = (Element) listUniversity.get(i);

                faculty = university.getChildText(TagsForFile.faculty);
                department = university.getChildText(TagsForFile.department);

                List lecturerList = university.getChildren(TagsForFile.lecturer);

                for (int j = 0; j < lecturerList.size(); j++) {

                    Element lecturer = (Element) lecturerList.get(j);
                    fio = lecturer.getChildText(TagsForFile.fio);
                    title = lecturer.getChildText(TagsForFile.title);
                    academic = lecturer.getChildText(TagsForFile.academic);
                    lecturerUniversity = new Lecturer(fio,title,academic);
                    db.add(new University(faculty, department, lecturerUniversity));
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dbWrite() {
        dbWrite("file.xml");
    }

    public void dbWrite(String filePath) {
        try {
            Element rootNode = new Element(TagsForFile.university);
            Document doc = new Document(rootNode);

            for (int i = 0; i < db.size(); i++) {
                University dbUniversity = db.get(i);

                Element university = new Element(TagsForFile.university);
                Element lecturer = new Element(TagsForFile.lecturer);

                Element faculty = new Element(TagsForFile.faculty).setText(dbUniversity.getFaculty());
                Element department = new Element(TagsForFile.department).setText(dbUniversity.getNameOfDepartment());
                Element fio = new Element(TagsForFile.fio).setText(dbUniversity.getFio());
                Element title = new Element(TagsForFile.title).setText(dbUniversity.getTitle());
                Element academic = new Element(TagsForFile.academic).setText(dbUniversity.getAcademicDegree());

                university.addContent(faculty);
                university.addContent(department);

                lecturer.addContent(fio);
                lecturer.addContent(title);
                lecturer.addContent(academic);

                university.addContent(lecturer);

                rootNode.addContent(university);
            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());

            xmlOutput.output(doc, new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<University> getDb() {
        return db;
    }

    public void setDb(ObservableList<University> db) {
        this.db = db;
    }

    public void setDb(List<University> db) {
        this.db = db;
    }
}
