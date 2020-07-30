package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Nombre de la tabla
    public static final String TABLE_NAME = "COUNTRIES";
    //Columnas
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";
    //Databases NAME
    public static final String DB_NAME = "DEV_CONTRIES.DB";
    //Version
    static final int DB_VERSION = 1;
    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + SUBJECT +
            " TEXT NOT NULL," + DESC + " TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //RESPALDAR Y DESPUES BORRAR
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
