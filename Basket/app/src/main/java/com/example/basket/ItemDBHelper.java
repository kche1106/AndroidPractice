package com.example.basket;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

//public class ItemDBHelper extends SQLiteOpenHelper
//{
//    private Context context;
//    private static final String DATABASE_NAME = "whippingTest.db";
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABLE_NAME = "item";
//
//    private static final String COLUMN_BARCODE_ID = "barcode_id";
//    private static final String COLUMN_BARCODE_TYPE = "barcode_type";
//    private static final String COLUMN_ITEM_NAME = "item_name";
//    private static final String COLUMN_PRICE = "price";
//    private static final String COLUMN_CATEGORY= "category";
//
//    public ItemDBHelper(@Nullable Context context)
//    {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        this.context = context;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db)
//    {
//        String query = "CREATE TABLE " + TABLE_NAME
//                + " (" + COLUMN_BARCODE_ID + " VARCAHR(30) PRIMARY KEY, "
//                + COLUMN_BARCODE_TYPE + " VARCAHR(30) PRIMARY KEY, "
//                + COLUMN_ITEM_NAME + " VARCAHR(30), "
//                + COLUMN_PRICE + " INTEGER, "
//                + COLUMN_CATEGORY + " VARCAHR(30)); ";
//        db.execSQL(query);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
//    {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    void addItem(String barcodeId, String barcodeType, String itemName, String price, String category)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(COLUMN_BARCODE_ID, barcodeId);
//        cv.put(COLUMN_BARCODE_TYPE, barcodeType);
//        cv.put(COLUMN_ITEM_NAME, itemName);
//        cv.put(COLUMN_PRICE, price);
//        cv.put(COLUMN_CATEGORY, category);
//        long result = db.insert(TABLE_NAME, null, cv);
//        if (result == -1)
//        {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(context, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//}