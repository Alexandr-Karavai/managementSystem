package bsuir.model;

public class Payer {

    private    String idPayer;
    private  String fioPayer;
    private  AccountingMonth accountingMonth;

    public Payer(String idPayer, String fioPayer, AccountingMonth accountingMonth) {

        this.idPayer = idPayer;
        this.fioPayer = fioPayer;
        this.accountingMonth = accountingMonth;

    }

    public String getIdPayer() {
        return idPayer;
    }
    public void setIdPayer(String idPayer) {
        this.idPayer = idPayer;
    }

    public String getFioPayer() {
        return fioPayer;
    }
    public void setFioPayer(String fioPayer) {
        this.fioPayer = fioPayer;
    }

    public AccountingMonth getAccountingMonth() {return accountingMonth;}
    public void setAccountingMonth(AccountingMonth accountingMonth) {
        this.accountingMonth = accountingMonth;
    }

    public String getMonth() {
        return accountingMonth.getMonth();
    }
    public void setMonth(String month) {
        accountingMonth.setMonth(month);
    }

    public String getHotWater() {
        return accountingMonth.getHotWater();
    }
    public void setHotWater(String hotWater) {
        accountingMonth.setHotWater(hotWater);
    }

    public String getColdWater() {
        return accountingMonth.getColdWater();
    }
    public void setColdWater(String coldWater) {
        accountingMonth.setColdWater(coldWater);
    }

    public String getElectricPower() {
        return accountingMonth.getElectricPower();
    }
    public void setElectricPower(String electricPower) {
        accountingMonth.setElectricPower(electricPower);
    }
}
