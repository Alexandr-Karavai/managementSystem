package bsuir.view;

import bsuir.model.Owner;
import bsuir.model.Payer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class TablePayers extends TableView {

    private List<Payer> payersData = FXCollections.observableArrayList();

    private Owner owner;

    public TablePayers() {

        this.setEditable(false);

        TableColumn idColumn = new TableColumn("ID");
        idColumn.setPrefWidth(100.0);

        TableColumn fioColumn = new TableColumn("ФИО");
        fioColumn.setPrefWidth(200.0);

        TableColumn hot_waterColumn = new TableColumn("Горячая вода");
        hot_waterColumn.setPrefWidth(100.0);

        TableColumn coldWaterColumn = new TableColumn("Холодная вода");
        coldWaterColumn.setPrefWidth(100.0);

        TableColumn electricPowerColumn = new TableColumn("Электроенергия");
        electricPowerColumn.setPrefWidth(100.0);

        TableColumn dateColumn = new TableColumn("Дата");
        dateColumn.setPrefWidth(100.0);

        idColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("idPayer"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setIdPayer(payersStringCellEditEvent.getNewValue());
            }
        });

        fioColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("fioPayer"));
        fioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fioColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setFioPayer(payersStringCellEditEvent.getNewValue());
            }
        });

        dateColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("month"));
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setMonth(payersStringCellEditEvent.getNewValue());
            }
        });

        hot_waterColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("hotWater"));
        hot_waterColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        hot_waterColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setHotWater(payersStringCellEditEvent.getNewValue());
            }
        });

        coldWaterColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("coldWater"));
        coldWaterColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        coldWaterColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setColdWater(payersStringCellEditEvent.getNewValue());
            }
        });

        electricPowerColumn.setCellValueFactory(new PropertyValueFactory<Payer, String>("electricPower"));
        electricPowerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        electricPowerColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Payer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Payer, String> payersStringCellEditEvent) {
                payersStringCellEditEvent.getTableView().getItems().get(payersStringCellEditEvent.getTablePosition().getRow()).setElectricPower(payersStringCellEditEvent.getNewValue());
            }
        });

        this.getColumns().addAll(idColumn, fioColumn, dateColumn, hot_waterColumn, coldWaterColumn, electricPowerColumn);

        this.setItems((ObservableList) payersData);

    }

    public List<Payer> getDataPayers()
    {
        return this.payersData;
    }

    public void setDataPayers(List <Payer> inDataPayers)
    {
        this.payersData = inDataPayers;
    }
}
