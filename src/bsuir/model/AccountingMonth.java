package bsuir.model;

public class AccountingMonth {

    private  String month;
    private  String hot_water;
    private  String cold_water;
    private  String electric_power;

    public AccountingMonth(String month, String hot_water, String cold_water, String electric_power) {

        this.month = month;
        this.hot_water = hot_water;
        this.cold_water = cold_water;
        this.electric_power = electric_power;
    }

    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public String getHotWater() {
        return hot_water;
    }
    public void setHotWater(String hot_water) {
        this.hot_water = hot_water;
    }

    public String getColdWater() {
        return cold_water;
    }
    public void setColdWater(String cold_water) {
        this.cold_water = cold_water;
    }

    public String getElectricPower() {
        return electric_power;
    }
    public void setElectricPower(String electric_power) {
        this.electric_power = electric_power;
    }

}
