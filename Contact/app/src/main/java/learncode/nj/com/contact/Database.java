package learncode.nj.com.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    public static String DATABASE_NAME="contacts";
    public static int DATABASE_VERSION= 1;
    public static String COLUMN_ID="id";
    public static String COLUMN_NAME="name";
    public static String COLUMN_MOBILE="mobile";
    public static String COLUMN_EMAIL="email";
    public static String TABLE_NAME="contactinfo";
    public static String COLUMN_ADD="address";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable=" CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" integer(10) primary key, "
                +" "+COLUMN_NAME+" varchar(50) NOT NULL,"
                +" "+COLUMN_MOBILE+" varchar(200) NOT NULL,"
                +" "+COLUMN_EMAIL+" varchar(200) NOT NULL,"
                +" "+COLUMN_ADD+"  varchar(200) );";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addContact(Contact contact){
        SQLiteDatabase db1=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME, contact.getName());
        cv.put(COLUMN_MOBILE, contact.getContact());
        cv.put(COLUMN_EMAIL, contact.getEmail());
        cv.put(COLUMN_ADD, contact.getAddress());
        boolean h=db1.insert(TABLE_NAME,null,cv)!=-1;
        return  h;
    }



    public List<Contact> getContact(){
        List<Contact> dat=new ArrayList<>();
        SQLiteDatabase db2=getReadableDatabase();
        Cursor c=db2.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(c.moveToFirst()){
            do{
                dat.add(new Contact(c.getString(1),c.getString(2),c.getString(3),c.getString(4)));
            }while(c.moveToNext());
        }
        return  dat;
    }
}
