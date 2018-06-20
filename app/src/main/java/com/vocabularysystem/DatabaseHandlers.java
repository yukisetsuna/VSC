package com.vocabularysystem;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHandlers extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "VGA";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHandlers(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("admin", null, null, null, null, null, null);
    }

    public Cursor hexing(String ex1, String ex2) {

        String els = "select * from \"admin\" where \"admin_code\" = \"" + ex1 + "\" and \"admin_password\" = \"" + ex2 + "\"";
        Cursor hex = myDataBase.rawQuery(els, null);


        return hex;
    }

    public Cursor quester1() {

        String els = null;
        DataHandlers data = new DataHandlers();
        switch (data.getTypes()) {
            case "Multiple Choice":
                els = "SELECT * FROM  `Multiple_Choice`";
                break;
            case "Identification":
                els = "SELECT * FROM  `Identification`";
                break;
            case "True or False":
                els = "SELECT * FROM  `True_False`";
                break;
        }

        Cursor hex = myDataBase.rawQuery(els, null);

        return hex;

    }

    public Cursor quester2(String[] axe) {

        String els = null;
        DataHandlers data = new DataHandlers();
        switch (data.getTypes()) {
            case "Multiple Choice":
                els = "insert into `Multiple_Choice` (Q1_Code, Q1_Subject, Q1_Question, Q1_Answer, Q1_Wrong1, Q1_Wrong2, Q1_Wrong3) " +
                        "values (\"" + axe[0] + "\", \"" + axe[1] + "\", \"" + axe[2] + "\", \"" + axe[3] + "\", \"" + axe[4] + "\", \"" + axe[5] + "\", \"" + axe[6] + "\");";
                break;
            case "Identification":
                els = "insert into `Identification` (Q3_Code, Q3_Subject, Q3_Question, Q3_Answer1, Q3_Answer2, Q3_Answer3) values (\"" + axe[0] + "\", \"" + axe[1] + "\", \"" + axe[2] + "\", \"" + axe[3] + "\", \"" + axe[4] + "\", \"" + axe[5] + "\");";
                break;
            case "True or False":
                els = "insert into `True_False` (Q2_Code, Q2_Subject, Q2_Question, Q2_Answer) values (\"" + axe[0] + "\", \"" + axe[1] + "\", \"" + axe[2] + "\", \"" + axe[3] + "\");";
                break;
        }

        Cursor hex = myDataBase.rawQuery(els, null);

        return hex;

    }

    public Cursor quester3_1(int x){

        DataHandlers cc = new DataHandlers();

        String sub = cc.getSubject().toString();

        String els = "SELECT * FROM `Multiple_Choice` WHERE `Q1_Subject` = '"+sub+"' ORDER BY RANDOM() LIMIT "+x;

        Cursor hex = myDataBase.rawQuery(els, null);
        return hex;
    }

    public Cursor quester3_2(int x){

        DataHandlers cc = new DataHandlers();

        String sub = cc.getSubject().toString();

        String els = "SELECT * FROM `True_False` WHERE `Q2_Subject` = '"+sub+"' ORDER BY RANDOM() LIMIT "+x;

        Cursor hex = myDataBase.rawQuery(els, null);
        return hex;
    }

    public Cursor quester3_3(int x){

        DataHandlers cc = new DataHandlers();

        String sub = cc.getSubject().toString();

        String els = "SELECT * FROM `Identification` WHERE `Q3_Subject` = '"+sub+"' ORDER BY RANDOM() LIMIT "+x;

        Cursor hex = myDataBase.rawQuery(els, null);
        return hex;
    }


}
