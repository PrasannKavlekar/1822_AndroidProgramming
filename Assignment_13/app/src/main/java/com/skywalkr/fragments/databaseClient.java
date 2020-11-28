package com.skywalkr.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class databaseClient {
    UserDBHelper userDB;
    Context context;
    SQLiteDatabase sql;

    public databaseClient(Context context) {
        this.context= context;
    }

    public void open() {
        userDB = new UserDBHelper(context);
        sql= userDB.getWritableDatabase();
    }

    public void close() {
        userDB.close();
    }

    public void addUser(String name, String contact, String email, String pass, String confirm_pass) {
        ContentValues params = new ContentValues();
        params.put("name", name);
        params.put("contact", contact);
        params.put("email", email);
        params.put("pass", pass);
        params.put("confirm_pass", confirm_pass);
        sql.insert("user",null,params);
    }

    public Cursor getData() {
        Cursor cur = sql.rawQuery("SELECT * FROM user",null);
        return  cur;
    }
}
