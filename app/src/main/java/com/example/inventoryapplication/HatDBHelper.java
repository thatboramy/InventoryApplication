package com.example.inventoryapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class HatDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Hat";
    public static final int DB_VERSION = 3;

    public HatDBHelper(Context context){
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HAT(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, COLOR TEXT, STATUS TEXT);");
        insertHat(db, "Beanie", "Brown", "SOLD");
        insertHat(db, "Fedora", "Blue", "LISTED");
        insertHat(db, "Bowler Hat", "Red", "SOLD");
        insertHat(db, "Baseball Cap", "Brown", "UNLISTED");
        insertHat(db, "Cap", "Black", "SOLD");
        insertHat(db, "Cap", "Black", "SOLD");
    }

    private void insertHat(SQLiteDatabase db, String n, String c, String s) {
        ContentValues hatValues = new ContentValues();
        hatValues.put("NAME", n);
        hatValues.put("COLOR", c);
        hatValues.put("STATUS", s);
        db.insert("HAT", null, hatValues);
    }

    private void deleteItem(SQLiteDatabase db, Cursor cursor){

    }

    //public Cursor searchHatByName(SQLiteDatabase db, String queryname){ }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Hat");
        onCreate(db);
    }



    public Cursor getallData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Hat", null);
        return res;
    }

    public ArrayList<String> getALLNames() {
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = getallData();
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("NAME")));
            res.moveToNext();
        }
        return array_list;
    }
}
