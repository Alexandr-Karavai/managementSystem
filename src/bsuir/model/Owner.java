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
    private  String adrreg;
    private  String auto;
    private  String ind_dog;
    private  String index;


    public Owner(String id, String fio, String date_reg, String inv, String box_sq, String num, String pasp, String pw, String pd, String pn, String phone
            , String mail, String address, String adrreg, String auto, String ind_dog, String index) {

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
        this.adrreg = adrreg;
        this.auto = auto;
        this.ind_dog = ind_dog;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdrreg() {
        return adrreg;
    }
    public void setAdrreg(String adrreg) {
        this.adrreg = adrreg;
    }

    public String getAuto() {
        return auto;
    }
    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getIndDog() {
        return ind_dog;
    }
    public void setIndDog(String ind_dog) {
        this.ind_dog = ind_dog;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }

}
