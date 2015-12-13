package Class;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DIEGO CASALLAS on 26/11/2015.
 */
public class DataBase {
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;

    public DataBase(Context context){

        openHelper=new DataBaseHelper(context);
    }
    public SQLiteDatabase open(){
        database=openHelper.getWritableDatabase();
        return database;
    }
    public  void close(){

        this.openHelper.close();
    }

}
