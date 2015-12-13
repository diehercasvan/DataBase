package VO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DAO.PersonEntity;
import DTO.DtoPerson;
import Class.DataBase;

/**
 * Created by DIEGO  CASALLAS on 26/11/2015.
 */
public class PersonBusiness extends DataBase {
    private SQLiteDatabase db;

    public PersonBusiness(Context context) {
        super(context);
    }


    public int insertPerson(DtoPerson person) {
        this.db=super.open();
        try
        {
            PersonEntity personEntity=new PersonEntity(db);
            db.beginTransaction();
            int idPerson=personEntity.insertPerson(person);
            db.setTransactionSuccessful();
            return idPerson;
        }
        catch(Exception e)
        {
            throw  e;

        }finally {
            db.endTransaction();
            super.close();
        }

    }


    public int deletePerson(DtoPerson person) {
        this.db=super.open();
        try
        {
            PersonEntity personEntity=new PersonEntity(db);
            db.beginTransaction();
            int idPerson=personEntity.deletePerson(person);
            db.setTransactionSuccessful();
            return idPerson;
        }
        catch(Exception e)
        {
            throw  e;

        }finally {
            db.endTransaction();
            super.close();
        }
    }


    public int updatePerson(DtoPerson person) {
        this.db=super.open();
        try
        {
            PersonEntity personEntity=new PersonEntity(db);
            db.beginTransaction();
            int idPerson=personEntity.updatePerson(person);
            db.setTransactionSuccessful();
            return idPerson;
        }
        catch(Exception e)
        {
            throw  e;

        }finally {
            db.endTransaction();
            super.close();
        }
    }


    public ArrayList<DtoPerson> searchPerson(DtoPerson person, int type) {

        this.db = super.open();
        try {
            PersonEntity personEntity = new PersonEntity(db);
            db.beginTransaction();
            ArrayList<DtoPerson> listPerson = personEntity.searchPerson(person,type);
            db.setTransactionSuccessful();
            return listPerson;
        } catch (Exception e) {
            throw e;
        }finally{
            db.endTransaction();
            super.close();
        }
    }
}
