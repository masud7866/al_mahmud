package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper{

    private static final String DBNAME = "al_mahmud.sqlite";
    private static String DBLOCATION = "";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DBManager(Context context) {
        super(context, DBNAME, null, 4);
        this.mContext = context;
        DBLOCATION = context.getApplicationInfo().dataDir + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public void OpenDatabase()
    {
        String dbPath = DBLOCATION + DBNAME;
        if(mDatabase != null && mDatabase.isOpen())
        {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);


    }
    public void CloseDatabase(){

        if(mDatabase != null)
        {
            mDatabase.close();
        }
    }

    public boolean CopyDB()
    {

        try {
            InputStream IS = this.mContext.getAssets().open(DBNAME);
            String OF = DBLOCATION + DBNAME;
            File f = new File(OF);
            if(f.exists())
            {
                Log.d("DatabaseHelper","Database already exists in the "+OF+" directory");
                f.delete();
                f.createNewFile();
            }
            else
            {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            OutputStream OS = new FileOutputStream(OF,true);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = IS.read(buff))>0)
            {
                OS.write(buff,0,length);
            }
            OS.flush();
            OS.close();
            Log.d("DatabaseHelper","Database copied successfully");
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d("DatabaseHelper","Copy database failed with message: " + e.getMessage());
            return false;
        }
    }

    ArrayList<String> getCertificate(String key, Boolean order){
        OpenDatabase();
        ArrayList<String> tmpStr = new  ArrayList<>();
        String orderText;
        if (order)
        {
            orderText = " order by priority asc";
        }
        else
        {
            orderText = " order by priority desc";
        }

        Cursor cur = mDatabase.rawQuery("SELECT * FROM "+ key + orderText,null);
        cur.moveToFirst();

        for(int i =0;i<cur.getCount();i++)
        {
            tmpStr.add(cur.getString(1));
            cur.moveToNext();
        }
        cur.close();

        CloseDatabase();
        return tmpStr;
    }

    ArrayList<String> getDepartment(){
        OpenDatabase();
        ArrayList<String> tmpStr = new  ArrayList<>();
        Cursor cur = mDatabase.rawQuery("SELECT DISTINCT department FROM student",null);
        cur.moveToFirst();
        for(int i =0;i<cur.getCount();i++)
        {
            tmpStr.add(cur.getString(0));
            cur.moveToNext();
        }
        cur.close();

        CloseDatabase();
        return tmpStr;
    }

    ArrayList<String> getDivision(String department){
        OpenDatabase();
        ArrayList<String> tmpStr = new  ArrayList<>();
        String whereText;
        if (department== "জামাত..."){
            whereText = "";
        }
        else {
            whereText = " WHERE department = '"+department+"'";
        }
        Cursor cur = mDatabase.rawQuery("SELECT DISTINCT division FROM student"+whereText,null);
        cur.moveToFirst();
        for(int i =0;i<cur.getCount();i++)
        {
            tmpStr.add(cur.getString(0));
            cur.moveToNext();
        }
        cur.close();

        CloseDatabase();
        return tmpStr;
    }

}
