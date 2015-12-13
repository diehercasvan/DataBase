package DTO;

/**
 * Created by DIEGO CASALLAS on 23/11/2015.
 */
public class DtoPerson {
    private String sName;
    private String sSurname;
    private String sDocument;
    private String sCity;
    private String sPhone;
    private int iID;


    public DtoPerson( int iID,String sDocument,String sName, String sSurname, String sCity, String sPhone) {
        this.iID=iID;
        this.sName = sName;
        this.sSurname = sSurname;
        this.sDocument = sDocument;
        this.sCity = sCity;
        this.sPhone = sPhone;
    }
    public DtoPerson(){

        this.sName = null;
        this.sSurname = null;
        this.sDocument = null;
        this.sCity = null;
        this.sPhone = null;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSurname() {
        return sSurname;
    }

    public void setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public String getsDocument() {
        return sDocument;
    }

    public void setsDocument(String sDocument) {
        this.sDocument = sDocument;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }
}
