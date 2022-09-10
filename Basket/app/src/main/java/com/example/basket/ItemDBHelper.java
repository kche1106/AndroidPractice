package com.example.basket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ItemDBHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "test.db";

    public ItemDBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE item\n" +
                "(\n" +
                "    `barcode_id`    VARCHAR(30)    NOT NULL, \n" +
                "    `barcode_type`  VARCHAR(30)    NOT NULL, \n" +
                "    `item_name`     VARCHAR(30)    NOT NULL, \n" +
                "    `price`         INT            NOT NULL, \n" +
                "    `category`      VARCHAR(30)    NOT NULL, \n" +
                "     PRIMARY KEY (barcode_id, barcode_type)\n" +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS item");
        onCreate(db);
    }
}
