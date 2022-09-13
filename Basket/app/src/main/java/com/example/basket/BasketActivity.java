package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class BasketActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;
    EditText edtBarcodeType, edtBarcodeId, edtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        DBHelper dbHelper = new DBHelper(BasketActivity.this);
        sqlDB = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM basket;", null);

        edtBarcodeType = findViewById(R.id.edtBarcodeType);
        edtBarcodeId = findViewById(R.id.edtBarcodeId);
        edtAmount = findViewById(R.id.edtAmount);

        String barcodeTypeStr =  "바코드 타입" + "\r\n" + "-------" + "\r\n";;
        String barcodeIdStr =  "바코드 번호" + "\r\n" + "-------" + "\r\n";;
        String amountStr =  "개수" + "\r\n" + "-------" + "\r\n";;

        while(cursor.moveToNext()){
            barcodeTypeStr += cursor.getString(2) + "\r\n";
            barcodeIdStr += cursor.getString(3) + "\r\n";
            amountStr += cursor.getString(4) + "\r\n";
        }

        //출력해주기
        edtBarcodeType.setText(barcodeTypeStr);
        edtBarcodeId.setText(barcodeIdStr);
        edtAmount.setText(amountStr);

        cursor.close();
        sqlDB.close();
    }
}