package com.yuiffy.contentresolverdemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//this is MainActivity, oh
public class MainActivity extends AppCompatActivity {
//this is the onCreate function!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String s = "qwerty";
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_concact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConcactsActivity.class);
                startActivity(intent);
            }
        });


        Cursor cursor = getContentResolver().query(
         ..       Uri.parse("content://providerDemoUri"),
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            int columncCount = cursor.getColumnCount();
            String names[] = cursor.getColumnNames();
            List<String> nameList = Arrays.asList(names);
            System.out.println(nameList);
            while (cursor.moveToNext()) {
                List<String> list = new ArrayList<String>();
                for (int i = 0; i < columncCount; i++)
                    list.add(cursor.getString(i));
                System.out.println(list);
            }
        } else {
            System.out.println("cursor==null");
        }
    }
}
