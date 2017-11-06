package com.example.digendra.ghsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_NAME = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_PASS1 = "password1";
    private static final String KEY_PASS2 = "password2";

    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }
    public DataBaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACT_TABLE="CREATE TABLE " + TABLE_NAME + "(" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME +" TEXT,"
                +KEY_PH_NO+ " TEXT,"+KEY_EMAIL+" TEXT,"+KEY_USER_NAME+" TEXT,"+KEY_PASS1+" TEXT,"+KEY_PASS2+" TEXT"+");";
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);

    }
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getUserNo()); // Contact Phone
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_USER_NAME, contact.getUserName());
        values.put(KEY_PASS1, contact.getPassword1());
        values.put(KEY_PASS2, contact.getPassword2());



        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public String searchPass(String uname)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select user_name,password1 from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query, null);
        String a="",b="not match";

        if(cursor.moveToFirst())
        {
            do
            {
                a=cursor.getString(cursor.getColumnIndex(KEY_USER_NAME));
                b=cursor.getString(cursor.getColumnIndex(KEY_PASS1));
                if(a.equals(uname))
                {
                    b=cursor.getString(cursor.getColumnIndex(KEY_PASS1));
                    break;
                }
            }while(cursor.moveToNext());
        }
        return (a+"="+b);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }
}
