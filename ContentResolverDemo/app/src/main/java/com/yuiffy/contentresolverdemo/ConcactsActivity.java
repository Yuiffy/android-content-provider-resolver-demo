package com.yuiffy.contentresolverdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConcactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concacts);
        ContentResolver resolver = this.getContentResolver();
        Cursor cursor = resolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME
                        + " DESC");
        ListView lv = (ListView) findViewById(R.id.concact_listview);
        lv.setAdapter(new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, null, null, 0));
    }
}
