package com.example.basket;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BasketDBHelper extends SQLiteOpenHelper {

    Context context;
    static final int version = 1;
    static final String DATABASE_NAME = "test.db";
    static final String TABLE_NAME = "basket";

    public BasketDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TABLE_NAME (basket_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "device INTEGER NOT NULL, barcode_id  VARCHAR(30) NOT NULL, \n" +
                "amount INTEGER NOT NULL, FOREIGN KEY(barcode_id) REFERENCES item(barcode_id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS basket");
        onCreate(db);
    }

    void addBasket(Integer device, String barcode_id, Integer amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(String.valueOf(device), device);
        cv.put(barcode_id, barcode_id);
        cv.put(String.valueOf(amount), amount);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
        }
    }
}
