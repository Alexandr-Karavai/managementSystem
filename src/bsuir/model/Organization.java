package bsuir.model;

public class Organization {

    private  Owner owner;
    private  String sqpr;
    private  String proc;
    private  String sq;
    private  String osavto;
    private  String ur;
    private  String osspectr;
    private  String ned_1;
    private  String ned_2;


    public Organization (Owner owner, String sqpr, String proc, String sq, String osavto, String ur, String osspectr, String ned_1, String ned_2 ) {
        this.owner = owner;
        this.sqpr = sqpr;
        this.proc = proc;
        this.sq = sq;
        this.osavto = osavto;
        this.ur = ur;
        this.osspectr = osspectr;
        this.ned_1 = ned_1;
        this.ned_2 = ned_2;
    }

    public Owner getOwner() {return owner;}
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getSqpr() {
        return sqpr;
    }
    public void setSqpr(String sqpr) {
        this.sqpr = sqpr;
    }

    public String getProc() {
        return proc;
    }
    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getSq() {
        return sq;
    }
    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getOsavto() {
        return osavto;
    }
    public void setOsavto(String osavto) {
        this.osavto = osavto;
    }

    public String getUr() {
        return ur;
    }
    public void setUr(String ur) {
        this.ur = ur;
    }

    public String getOsspectr() {
        return osspectr;
    }
    public void setOsspectr(String osspectr) {
        this.osspectr = osspectr;
    }

    public String getNed_1() {
        return ned_1;
    }
    public void setNed_1(String ned_1) {
        this.ned_1 = ned_1;
    }

    public String getNed_2() {
        return ned_2;
    }
    public void setNed_2(String ned_2) {
        this.ned_2 = ned_2;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return owner.getId();
    }
    public void setId(String id) {
        owner.setId(id);
    }

    public String getFio() {
        return owner.getFio();
    }
    public void setFio(String fio) {
        owner.setFio(fio);
    }

    public String getDateReg() {
        return owner.getDateReg();
    }
    public void setDateReg(String date_reg) {
        owner.setDateReg(date_reg);
    }

    public String getInv() {
        return owner.getInv();
    }
    public void setInv(String inv) {
        owner.setInv(inv);
    }

    public String getBoxSq() {
        return owner.getBoxSq();
    }
    public void setBoxSq(String box_sq) {
        owner.setBoxSq(box_sq);
    }

    public String getNum() {
        return owner.getNum();
    }
    public void setNum(String num) {
        owner.setNum(num);
    }

    public String getPasp() {
        return owner.getPasp();
    }
    public void setPasp(String pasp) {
        owner.setPasp(pasp);
    }

    public String getPw() {
        return owner. getPw();
    }
    public void setPw(String pw) {
        owner.setPw(pw);
    }

    public String getPd() {
        return owner.getPd();
    }
    public void setPd(String pd) {
        owner.setPd(pd);
    }

    public String getPn() {
        return owner.getPn();
    }
    public void setPn(String pn) {
        owner.setPn(pn);
    }

    public String getPhone() {
        return owner.getPhone();
    }
    public void setPhone(String phone) {
        owner.setPhone(phone);
    }

    public String getMail() {
        return owner.getMail();
    }
    public void setMail(String mail) {
        owner.setMail(mail);
    }

    public String getAddress() {
        return owner.getAddress();
    }
    public void setAddress(String address) {
        owner.setAddress(address);
    }

    public String getAdrreg() {
        return owner.getAdrreg();
    }
    public void setAdrreg(String adrreg) {
        owner.setAdrreg(adrreg);
    }

    public String getAuto() {
        return owner.getAuto();
    }
    public void setAuto(String auto) {
        owner.setAuto(auto);
    }

    public String getIndDog() {
        return owner.getIndDog();
    }
    public void setIndDog(String ind_dog) {
        owner.setIndDog(ind_dog);
    }

    public String getIndex() {
        return owner.getIndex();
    }
    public void setIndex(String index) {
        owner.setIndex(index);
    }

}
