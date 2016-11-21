package com.yuiffy.contentresolverdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://providerDemoUri"),
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            int columncCount = cursor.getColumnCount();
            String names[] = cursor.getColumnNames();
            List<String> nameList = Arrays.asList();
            System.out.println(names);
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
