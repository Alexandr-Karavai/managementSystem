package bsuir.view;


import bsuir.model.University;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class MyTable extends TableView {

    private List<University> usersData = FXCollections.observableArrayList();




    public MyTable()
    {

        this.setEditable(true);

        TableColumn idColumn = new TableColumn("ID");
            idColumn.setPrefWidth(100.0);

        TableColumn fioColumn = new TableColumn("ФИО собственника");
            fioColumn.setPrefWidth(190.0);

        TableColumn dateRegColumn = new TableColumn("Дата регистрации");
            dateRegColumn.setPrefWidth(100.0);

        TableColumn invColumn = new TableColumn("Инвентарный номер");
            invColumn.setPrefWidth(100.0);

        TableColumn boxSqColumn = new TableColumn("Площадь");
            boxSqColumn.setPrefWidth(100.0);

        TableColumn numColumn = new TableColumn("Номер");
            numColumn.setPrefWidth(100.0);

        TableColumn paspColumn = new TableColumn("Серия паспорта");
            paspColumn.setPrefWidth(100.0);

        TableColumn pwColumn = new TableColumn("Кем выдан");
            pwColumn.setPrefWidth(100.0);

        TableColumn pdColumn = new TableColumn("Дата выдачи");
            pdColumn.setPrefWidth(100.0);

        TableColumn pnColumn = new TableColumn("ПН");
            pnColumn.setPrefWidth(100.0);

        TableColumn phoneColumn = new TableColumn("Телефон");
            phoneColumn.setPrefWidth(100.0);

        TableColumn mailColumn = new TableColumn("E-mail");
            mailColumn.setPrefWidth(100.0);

        TableColumn addressColumn = new TableColumn("Адрес");
            addressColumn.setPrefWidth(100.0);

        TableColumn adrregColumn = new TableColumn("Прописка");
            adrregColumn.setPrefWidth(100.0);

        TableColumn autoColumn = new TableColumn("Авто");
            autoColumn.setPrefWidth(100.0);

        TableColumn indDogColumn = new TableColumn("Индекс города");
            indDogColumn.setPrefWidth(100.0);

        TableColumn indexColumn = new TableColumn("Индекс");
            indexColumn.setPrefWidth(100.0);

        TableColumn sqprColumn = new TableColumn("SQPR");
            sqprColumn.setPrefWidth(100.0);

        TableColumn procColumn = new TableColumn("Процент");
            procColumn.setPrefWidth(100.0);

        TableColumn sqColumn = new TableColumn("Площадь");
            sqColumn.setPrefWidth(100.0);

        TableColumn osavtoColumn = new TableColumn("Номер гаража");
            osavtoColumn.setPrefWidth(100.0);

        TableColumn urColumn = new TableColumn("Уровень");
            urColumn.setPrefWidth(170.0);

        TableColumn osspectrColumn = new TableColumn("Описание");
            osspectrColumn.setPrefWidth(170.0);

        TableColumn nedOneColumn = new TableColumn("Приложение 1");
            nedOneColumn.setPrefWidth(170.0);

        TableColumn nedTwoColumn = new TableColumn("Приложение 2");
            nedTwoColumn.setPrefWidth(170.0);

        /**
         * //////////////////////////////////////////////////////////////////////////////////
         */


//        TableColumn nameOfDepartmentColumn = new TableColumn("Название кафедры");
//        nameOfDepartmentColumn.setPrefWidth(170.0);
//
//
//
//        TableColumn titleColumn = new TableColumn("Ученое звание");
//            titleColumn.setPrefWidth(220.0);
//
//        TableColumn academicDegreeColumn = new TableColumn("Ученая степень");
//            academicDegreeColumn.setPrefWidth(220.0);


        idColumn.setCellValueFactory(new PropertyValueFactory<University, String>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        fioColumn.setCellValueFactory(new PropertyValueFactory<University, String>("fio"));
        fioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fioColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFio(studentsStringCellEditEvent.getNewValue());
            }
        });

        dateRegColumn.setCellValueFactory(new PropertyValueFactory<University, String>("dateReg"));
        dateRegColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateRegColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        invColumn.setCellValueFactory(new PropertyValueFactory<University, String>("inv"));
        invColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        invColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        boxSqColumn.setCellValueFactory(new PropertyValueFactory<University, String>("boxSq"));
        boxSqColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        boxSqColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        numColumn.setCellValueFactory(new PropertyValueFactory<University, String>("num"));
        numColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        numColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        paspColumn.setCellValueFactory(new PropertyValueFactory<University, String>("pasp"));
        paspColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        paspColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        pwColumn.setCellValueFactory(new PropertyValueFactory<University, String>("pw"));
        pwColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pwColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        pdColumn.setCellValueFactory(new PropertyValueFactory<University, String>("pd"));
        pdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pdColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        pnColumn.setCellValueFactory(new PropertyValueFactory<University, String>("pn"));
        pnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pnColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        phoneColumn.setCellValueFactory(new PropertyValueFactory<University, String>("phone"));
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        mailColumn.setCellValueFactory(new PropertyValueFactory<University, String>("mail"));
        mailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        addressColumn.setCellValueFactory(new PropertyValueFactory<University, String>("address"));
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        adrregColumn.setCellValueFactory(new PropertyValueFactory<University, String>("adrreg"));
        adrregColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adrregColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        autoColumn.setCellValueFactory(new PropertyValueFactory<University, String>("auto"));
        autoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        autoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        indDogColumn.setCellValueFactory(new PropertyValueFactory<University, String>("indDog"));
        indDogColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        indDogColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        indexColumn.setCellValueFactory(new PropertyValueFactory<University, String>("index"));
        indexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        indexColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        sqprColumn.setCellValueFactory(new PropertyValueFactory<University, String>("sqpr"));
        sqprColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sqprColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        procColumn.setCellValueFactory(new PropertyValueFactory<University, String>("proc"));
        procColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        procColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        sqColumn.setCellValueFactory(new PropertyValueFactory<University, String>("sq"));
        sqColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sqColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        osavtoColumn.setCellValueFactory(new PropertyValueFactory<University, String>("osavto"));
        osavtoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        osavtoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        urColumn.setCellValueFactory(new PropertyValueFactory<University, String>("ur"));
        urColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        urColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFaculty(studentsStringCellEditEvent.getNewValue());
            }
        });

        osspectrColumn.setCellValueFactory(new PropertyValueFactory<University, String>("osspectr"));
        osspectrColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        osspectrColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNameOfDepartment(studentsStringCellEditEvent.getNewValue());
            }
        });

        nedOneColumn.setCellValueFactory(new PropertyValueFactory<University, String>("nedOne"));
        nedOneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nedOneColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNameOfDepartment(studentsStringCellEditEvent.getNewValue());
            }
        });

        nedTwoColumn.setCellValueFactory(new PropertyValueFactory<University, String>("nedTwo"));
        nedTwoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nedTwoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNameOfDepartment(studentsStringCellEditEvent.getNewValue());
            }
        });


        /**
         * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         */


//        titleColumn.setCellValueFactory(new PropertyValueFactory<University, String>("title"));
//        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        titleColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
//                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setTitle(studentsStringCellEditEvent.getNewValue());
//            }
//        });
//
//        academicDegreeColumn.setCellValueFactory(new PropertyValueFactory<University, String>("academicDegree"));
//        academicDegreeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        academicDegreeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<University, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<University, String> studentsStringCellEditEvent) {
//                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setAcademicDegree(studentsStringCellEditEvent.getNewValue());
//            }
//        });

        this.getColumns().addAll(idColumn, fioColumn, dateRegColumn, invColumn, boxSqColumn, numColumn, paspColumn, pwColumn, pdColumn, pnColumn, phoneColumn,
                mailColumn, addressColumn, adrregColumn, autoColumn, indDogColumn, indexColumn, sqprColumn, procColumn,
                sqColumn, osavtoColumn, urColumn, osspectrColumn, nedOneColumn, nedTwoColumn);

        this.setItems((ObservableList) usersData);

    }


    public List<University> getDataU()
    {
        return this.usersData;
    }
    public void setDataU(List <University> inU)
    {
        this.usersData = inU;
    }

}

