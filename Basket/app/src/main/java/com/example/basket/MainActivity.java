package com.example.basket;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    TextView device, barcodeId, barcodeType, amount;
    Button add_button, show_button;
    SQLiteDatabase sqlDB;
    EditText edtBarcodeType, edtBarcodeId, edtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        device = findViewById(R.id.device);
        barcodeId = findViewById(R.id.barcodeId);
        barcodeType = findViewById(R.id.barcodeType);
        amount = findViewById(R.id.amount);
        add_button = findViewById(R.id.add_button);
        show_button = findViewById(R.id.show_button);

        add_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DBHelper dbHelper = new DBHelper(MainActivity.this);

                dbHelper.addItem("6789", "88", "초코 우유", "1500", "유제품");
                dbHelper.addBasket(device.getText().toString().trim(), barcodeId.getText().toString().trim(),
                        barcodeType.getText().toString().trim(), amount.getText().toString().trim());
            }
        });

        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbHelper = new DBHelper(MainActivity.this);
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
        });
    }
}