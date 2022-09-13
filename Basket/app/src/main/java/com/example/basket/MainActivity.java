package com.example.basket;

import android.content.Intent;
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

                Intent intent = new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(intent);

            }
        });
    }
}