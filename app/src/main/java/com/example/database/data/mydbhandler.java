package com.example.database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.ConsumerIrManager;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.database.model.contact;
import com.example.database.params.params;

import java.util.ArrayList;
import java.util.List;

public class mydbhandler extends SQLiteOpenHelper {

//    public mydbhandler(Context context){
//
//        super(context, params.DB_NAME,null);
//    }


    public mydbhandler(Context context) {
        super(context, params.DB_NAME , null, params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "CREATE TABLE " + params.TABLE_NAME + "(" + params.KEY_ID +
                " INTEGER PRIMARY KEY," + params.KEY_NAME + " TEXT, "
                +  params.KEY_PHONE + " TEXT , "+ params.KEY_ADDRESS +" TEXT)";
                       /* "CREATE TABLE " + params.TABLE_NAME + "("
                + params.KEY_ID + " INTEGER PRIMARY KEY," + params.KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_EMAIL + " TEXT,"+ KEY_ADD + " TEXT  )";*/
        Log.d("dbraj","Query Being Run is : "+ create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addcontact(contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,contact.getName());
        values.put(params.KEY_PHONE,contact.getPhonenumber());
        values.put(params.KEY_ADDRESS,contact.getAddress());
        db.insert(params.TABLE_NAME,null,values);
        Log.d("dbraj","Successfully Inserted!!!");
        db.close();

    }

    public List<contact> getAllcontacts(){
        List<contact> contactlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // generate the query to read from the database

        String select = "SELECT * FROM " + params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        // loop throw now
        if (cursor.moveToFirst()){
            do {
                contact contact = new contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhonenumber(cursor.getString(2));
                contact.setAddress(cursor.getString(3));
                contactlist.add(contact);

            }while (cursor.moveToNext());
        }
        return contactlist;
    }

    public int updatecontacts(contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,contact.getName());
        values.put(params.KEY_PHONE,contact.getPhonenumber());

        // lets update here

        return db.update(params.TABLE_NAME,values,params.KEY_ID + "=?",
        new String[]{String.valueOf(contact.getId())});
    }

    public void deletecontact(int id){
        SQLiteDatabase db =this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID + "=?",new String[]{String.valueOf(id)});
        db.close();

    }

    public void deletecont(contact contact){
        SQLiteDatabase db =this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID + "=?",new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getcount(){
        String query = "SELECT * FROM " + params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }
}
