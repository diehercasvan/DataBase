package Class;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DIEGO CASALLAS on 24/11/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
    super(context, ShemaDataBase.DATABASE_NAME, null, ShemaDataBase.DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShemaDataBase.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ShemaDataBase.DROP_TABLE+ ShemaDataBase.FeedEntry.TABLE_NAME);
    }
}
