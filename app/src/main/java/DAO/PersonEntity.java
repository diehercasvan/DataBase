package DAO;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Class.ShemaDataBase;
import DTO.DtoPerson;
import Interfaces.IntPerson;

/**
 * Created by Dell on 26/11/2015.
 */
public class PersonEntity  implements IntPerson {
    private SQLiteDatabase db;

    public PersonEntity(SQLiteDatabase db) {
        this.db=db;
    }

    @Override
    public int insertPerson(DtoPerson person) {

        ContentValues contentValues=new ContentValues();
        contentValues.put(ShemaDataBase.PER_DOCUMENT,person.getsDocument());
        contentValues.put(ShemaDataBase.PER_NAME,person.getsName());
        contentValues.put(ShemaDataBase.PER_SURNAME,person.getsSurname());
        contentValues.put(ShemaDataBase.PER_CITY,person.getsCity());
        contentValues.put(ShemaDataBase.PER_PHONE,person.getsPhone());


        return (int)db.insert(ShemaDataBase.FeedEntry.TABLE_NAME,null,contentValues);
    }

    @Override
    public int deletePerson(DtoPerson person) {

        return db.delete(ShemaDataBase.FeedEntry.TABLE_NAME,ShemaDataBase.FeedEntry.TABLE_PERSON[0]+ "=" + person.getiID(), null);
    }

    @Override
    public int updatePerson(DtoPerson person) {
        return 0;
    }

    @Override
    public ArrayList<DtoPerson> searchPerson(DtoPerson person, int type) {

        ArrayList<DtoPerson> PersonList = new ArrayList<DtoPerson>();
        String sSQL=null;
        switch (type)
        {
            case 0:
                sSQL =ShemaDataBase.SELECT_ALL_PERSON;
                break;
            case 1:
                sSQL =ShemaDataBase.SELECT_ALL_PERSON +ShemaDataBase.WHERE+ShemaDataBase.FeedEntry.TABLE_PERSON[3]+ShemaDataBase.LIKE+" '%"+person.getsName()+"%' "+ShemaDataBase.OR+ShemaDataBase.FeedEntry.TABLE_PERSON[2]+ShemaDataBase.LIKE+" '%"+person.getsName()+"%' ";
                break;
        }

        Cursor personCursor = db.rawQuery(sSQL, null);
        if(personCursor.moveToFirst()){
            do{
                DtoPerson personaBO = new DtoPerson(
                        personCursor.getInt(0),
                        personCursor.getString(1),
                        personCursor.getString(2),
                        personCursor.getString(3),
                        personCursor.getString(4),
                        personCursor.getString(5));
                PersonList.add(personaBO);
            }while(personCursor.moveToNext());
        }
        return PersonList;

    }
}
