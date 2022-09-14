package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    String sql;
    SQLiteDatabase db;   // db를 다루기 위한 SQLiteDatabase 객체 생성
    Cursor cursor;   // select 문 출력위해 사용하는 Cursor 형태 객체 생성
    ListView listView;   // ListView 객체 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        db = openOrCreateDatabase("whippingTest.db", MODE_PRIVATE, null);   // 있으면 열고 없으면 DB를 생성

        listView = (ListView)findViewById(R.id.listView);

        final ArrayList<String> items;
        final ArrayAdapter adapter;  // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.

        sql = "select * from basket";
        cursor = db.rawQuery(sql, null);   // select 사용시 사용(sql문, where조건 줬을 때 넣는 값)

        int count = cursor.getCount();   // db에 저장된 행 개수를 읽어온다
        items = new ArrayList<String>(count) ;

        for (int i = 0; i < count; i++) {

            cursor.moveToNext();   // 첫번째에서 다음 레코드가 없을때까지 읽음

            String barcodeType = cursor.getString(2);
            String barcodeId = cursor.getString(3);
            String amount = cursor.getString(4);

            items.add(0, "바코드 번호: " + barcodeType + barcodeId + " 수량: " + amount);   // 각각의 속성값들을 해당 배열의 i번째에 저장
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        listView.setAdapter(adapter);   // listView 객체에 Adapter를 붙인다


        Button btn_delete = (Button)findViewById(R.id.delete) ;
        btn_delete.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked) ;

                        // listview 선택 초기화.
                        listView.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();

                        db.execSQL("DELETE FROM basket WHERE basket_id = '" + checked + "';");
                    }
                }
            }
        }) ;
    }
}