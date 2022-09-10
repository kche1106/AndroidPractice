package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText device_input = findViewById(R.id.device_input);
        EditText barcodeId_input = findViewById(R.id.barcodeId_input);
        EditText amount_input = findViewById(R.id.amount_input);
        Button add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasketDBHelper basketDBHelper = new BasketDBHelper(MainActivity.this);
                basketDBHelper.addBasket(Integer.parseInt(device_input.getText().toString().trim()), barcodeId_input.getText().toString().trim(), Integer.parseInt(amount_input.getText().toString().trim()));
            }
        });
    }
}