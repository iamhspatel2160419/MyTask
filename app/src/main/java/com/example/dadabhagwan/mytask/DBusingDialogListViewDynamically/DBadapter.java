package com.example.dadabhagwan.mytask.DBusingDialogListViewDynamically;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by dadabhagwan on 10/22/2016.
 */

public class DBadapter {
    //Columns
   public static final String ROWID="_ID";
    public static final String NAME="name";
    public static final String POSITION="position";

    //DB Properties
    public static final String DBNAME="db2";
    public static final String TBNAME="user";
    public static final int DBVERSION='1';

    public static final String CREATE_TB="CREATE TABLE "+TBNAME+"("+ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255) NOT NULL,"+POSITION+" VARCHAR(255) NOT NULL)";

    public final Context context;
    SQLiteDatabase sqLiteDatabase;
    DBhelper helper;

    public DBadapter(Context c)
    {
      this.context=c;
      helper=new DBhelper(context);
    }
    public static class DBhelper extends SQLiteOpenHelper {


        public DBhelper(Context context) {
            super(context, DBNAME, null, DBVERSION);
            Toast.makeText(context, "context created", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {

            sqLiteDatabase.execSQL(CREATE_TB);
//                Toast.makeText(context, "table created..", Toast.LENGTH_SHORT).show();
            }
            catch (SQLException e)
            {
               e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TBNAME+"");
  //          Toast.makeText(context, "table updated...", Toast.LENGTH_SHORT).show();
            onCreate(sqLiteDatabase);
        }


    }

    public DBadapter openDB()
    {
        try {
            sqLiteDatabase=helper.getWritableDatabase();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    return this;

    }

    public void close()
    {
        helper.close();
    }
    public long add(String name,String position)
    {
        try {

            ContentValues cv=new ContentValues();
            cv.put(NAME,name);
            cv.put(POSITION,position);
            return sqLiteDatabase.insert(TBNAME,ROWID,cv);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public Cursor getAllData()
    {
        String[] columns={ROWID,NAME,POSITION};
        return sqLiteDatabase.query(TBNAME,columns,null,null,null,null,null);

    }
}
