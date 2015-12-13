package Class;

import android.provider.BaseColumns;

/**
 * Created by DIEGO  CASALLAS  on 25/11/2015.
 */
public  class ShemaDataBase {

    public static final String DATABASE_NAME="BDperson";
    public static final int DATABASE_VERSION=1;

    //Create  structure basic
    public static final String TEXT_TYPE=" TEXT";
    public static final String TEXT_INTEGER=" INTEGER";
    public static final String COMMA_SEP=",";
    public static final String CREATE_TABLE=" CREATE TABLE ";
    public static final String SELECT=" SELECT ";
    public static final String DELETE=" DELETE ";
    public static final String UPDATE=" UPDATE ";
    public static final String INSERT=" INSERT INTO";
    public static final String VALUES=" VALUES ";
    public static final String SET =" SET  ";
    public static final String FROM =" FROM  ";
    public static final String LIKE =" LIKE  ";
    public static final String ORDER_BY=" ORDER BY ";
    public static final String WHERE=" WHERE ";
    public static final String PRIMARY_KEY=" PRIMARY KEY ";
    public static final String DROP_TABLE=" DROP TABLE IF EXISTS ";
    public static final String NOT_NULL=" NOT NULL ";
    public static final String UNIQUE =" UNIQUE  ";
    public static final String OR =" OR  ";
    public static final String AUTOINCREMENT=" AUTOINCREMENT ";
    //Create  table
    public static final String SQL_CREATE_ENTRIES=CREATE_TABLE+ FeedEntry.TABLE_NAME+"("+
            FeedEntry.TABLE_PERSON[0]+TEXT_INTEGER+PRIMARY_KEY+AUTOINCREMENT+COMMA_SEP+
            FeedEntry.TABLE_PERSON[1]+TEXT_TYPE+NOT_NULL+COMMA_SEP+
            FeedEntry.TABLE_PERSON[2]+TEXT_TYPE+NOT_NULL+COMMA_SEP+
            FeedEntry.TABLE_PERSON[3]+TEXT_TYPE+NOT_NULL+COMMA_SEP+
            FeedEntry.TABLE_PERSON[4]+TEXT_TYPE+NOT_NULL+COMMA_SEP+
            FeedEntry.TABLE_PERSON[5]+TEXT_TYPE+NOT_NULL+")";
    //Insert person
    public  static  final  String SQL_INSERT_ENTRIES=INSERT+ FeedEntry.TABLE_NAME
            +"("
            + FeedEntry.TABLE_PERSON[1]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[2]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[3]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[4]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[5]
            +")"+
    VALUES+"(";
    //Update person
    public  static  final  String SQL_UPDATE_ENTRIES=UPDATE+ FeedEntry.TABLE_NAME+SET;

    //Delete person
    public  static  final  String SQL_DELETE_ENTRIES=DELETE+FROM+ FeedEntry.TABLE_NAME+WHERE+ FeedEntry.TABLE_PERSON[1]+"=";

    /*Campos T_PERSONA*/
    public static final String PER_DOCUMENT = "Per_Document";
    public static final String PER_NAME="Per_Name";
    public static final String PER_SURNAME = "Per_Surname";
    public static final String PER_CITY = "Per_City";
    public static final String PER_PHONE = "Per_Phone";
    /*Create  selects*/

    public static  final  String SELECT_ALL_PERSON=SELECT
            + FeedEntry.TABLE_PERSON[0]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[1]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[2]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[3]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[4]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[5]+FROM+ FeedEntry.TABLE_NAME;

    public static  final  String SELECT_ALL_PERSON_LIKE=SELECT
            + FeedEntry.TABLE_PERSON[0]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[1]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[2]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[3]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[4]+COMMA_SEP
            + FeedEntry.TABLE_PERSON[5]+FROM+ FeedEntry.TABLE_NAME;

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = " person ";
        public static final String [] TABLE_PERSON=new String[]{"id","Per_Document","Per_Name","Per_Surname","Per_City","Per_Phone"};

    }

}
