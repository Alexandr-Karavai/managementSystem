package bsuir.model;

public class Owner {

    private  String id;
    private  String fio;
    private  String date_reg;
    private  String inv;
    private  String box_sq;
    private  String num;
    private  String pasp;
    private  String pw;
    private  String pd;
    private  String pn;
    private  String phone;
    private  String mail;
    private  String address;
    private  String adreg;
    private  String auto;
    private  String int_dog;
    private  String index;





    public Owner(String id, String fio, String date_reg, String inv, String box_sq, String num, String pasp, String pw, String pd, String pn, String phone
            , String mail, String address, String adreg, String auto, String int_dog, String index) {

        this.id = id;
        this.fio = fio;
        this.date_reg = date_reg;
        this.inv = inv;
        this.box_sq = box_sq;
        this.num = num;
        this.pasp = pasp;
        this.pw = pw;
        this.pd = pd;
        this.pn = pn;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.adreg = adreg;
        this.auto = auto;
        this.int_dog = int_dog;
        this.index = index;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDateReg() {
        return date_reg;
    }
    public void setDateReg(String date_reg) {
        this.date_reg = date_reg;
    }

    public String getInv() {
        return inv;
    }
    public void setInv(String inv) {
        this.inv = inv;
    }

    public String getBoxSq() {
        return box_sq;
    }
    public void setBoxSq(String box_sq) {
        this.box_sq = box_sq;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getPasp() {
        return pasp;
    }
    public void setPasp(String pasp) {
        this.pasp = pasp;
    }

    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPd() {
        return pd;
    }
    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPn() {
        return pn;
    }
    public void setPn(String pn) {
        this.pn = pn;
    }

}
