package com.example.saruhan.secondprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Uri CONTENT_URI = Uri.parse("content://com.saruhan.my.company.provider/emp");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLoading(View view) {
        Cursor cr = getContentResolver().query(CONTENT_URI, null, null, null, "_id");
        StringBuilder stringBuilder = new StringBuilder();

        while (cr.moveToNext()){
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            stringBuilder.append(id+"   "+s1+"  "+s2+"\n");
        }

        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();;
    }


}
