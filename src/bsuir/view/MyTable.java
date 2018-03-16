package bsuir.view;


import bsuir.model.Organization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class MyTable extends TableView {

    private List<Organization> usersData = FXCollections.observableArrayList();




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


        idColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setId(studentsStringCellEditEvent.getNewValue());
            }
        });

        fioColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("fio"));
        fioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fioColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setFio(studentsStringCellEditEvent.getNewValue());
            }
        });

        dateRegColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("dateReg"));
        dateRegColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateRegColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setDateReg(studentsStringCellEditEvent.getNewValue());
            }
        });

        invColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("inv"));
        invColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        invColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setInv(studentsStringCellEditEvent.getNewValue());
            }
        });

        boxSqColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("boxSq"));
        boxSqColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        boxSqColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setBoxSq(studentsStringCellEditEvent.getNewValue());
            }
        });

        numColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("num"));
        numColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        numColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNum(studentsStringCellEditEvent.getNewValue());
            }
        });

        paspColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("pasp"));
        paspColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        paspColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setPasp(studentsStringCellEditEvent.getNewValue());
            }
        });

        pwColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("pw"));
        pwColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pwColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setPw(studentsStringCellEditEvent.getNewValue());
            }
        });

        pdColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("pd"));
        pdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pdColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setPd(studentsStringCellEditEvent.getNewValue());
            }
        });

        pnColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("pn"));
        pnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pnColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setPn(studentsStringCellEditEvent.getNewValue());
            }
        });

        phoneColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("phone"));
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setPhone(studentsStringCellEditEvent.getNewValue());
            }
        });

        mailColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("mail"));
        mailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setMail(studentsStringCellEditEvent.getNewValue());
            }
        });

        addressColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("address"));
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setAddress(studentsStringCellEditEvent.getNewValue());
            }
        });

        adrregColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("adrreg"));
        adrregColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adrregColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setAdrreg(studentsStringCellEditEvent.getNewValue());
            }
        });

        autoColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("auto"));
        autoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        autoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setAuto(studentsStringCellEditEvent.getNewValue());
            }
        });

        indDogColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("indDog"));
        indDogColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        indDogColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setIndDog(studentsStringCellEditEvent.getNewValue());
            }
        });

        indexColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("index"));
        indexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        indexColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setIndex(studentsStringCellEditEvent.getNewValue());
            }
        });

        sqprColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("sqpr"));
        sqprColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sqprColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setSqpr(studentsStringCellEditEvent.getNewValue());
            }
        });

        procColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("proc"));
        procColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        procColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setProc(studentsStringCellEditEvent.getNewValue());
            }
        });

        sqColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("sq"));
        sqColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sqColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setSq(studentsStringCellEditEvent.getNewValue());
            }
        });

        osavtoColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("osavto"));
        osavtoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        osavtoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setOsavto(studentsStringCellEditEvent.getNewValue());
            }
        });

        urColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("ur"));
        urColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        urColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setUr(studentsStringCellEditEvent.getNewValue());
            }
        });

        osspectrColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("osspectr"));
        osspectrColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        osspectrColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setOsspectr(studentsStringCellEditEvent.getNewValue());
            }
        });

        nedOneColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("ned_1"));
        nedOneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nedOneColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNed_1(studentsStringCellEditEvent.getNewValue());
            }
        });

        nedTwoColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("ned_2"));
        nedTwoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nedTwoColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setNed_2(studentsStringCellEditEvent.getNewValue());
            }
        });


        /**
         * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         */


//        titleColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("title"));
//        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        titleColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
//                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setTitle(studentsStringCellEditEvent.getNewValue());
//            }
//        });
//
//        academicDegreeColumn.setCellValueFactory(new PropertyValueFactory<Organization, String>("academicDegree"));
//        academicDegreeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        academicDegreeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<Organization, String> studentsStringCellEditEvent) {
//                studentsStringCellEditEvent.getTableView().getItems().get(studentsStringCellEditEvent.getTablePosition().getRow()).setAcademicDegree(studentsStringCellEditEvent.getNewValue());
//            }
//        });

        this.getColumns().addAll(idColumn, fioColumn, dateRegColumn, invColumn, boxSqColumn, numColumn, paspColumn, pwColumn, pdColumn, pnColumn, phoneColumn,
                mailColumn, addressColumn, adrregColumn, autoColumn, indDogColumn, indexColumn, sqprColumn, procColumn,
                sqColumn, osavtoColumn, urColumn, osspectrColumn, nedOneColumn, nedTwoColumn);

        this.setItems((ObservableList) usersData);

    }


    public List<Organization> getDataU()
    {
        return this.usersData;
    }
    public void setDataU(List <Organization> inU)
    {
        this.usersData = inU;
    }

}
