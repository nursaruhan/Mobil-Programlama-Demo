package com.example.saruhan.contentproviders;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName, editJob;
    ContentValues values = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editJob = (EditText) findViewById(R.id.editJob);
    }

    public void doSaveContent(View view) {
        values.put("emp_name", editName.getText().toString());
        values.put("profile", editJob.getText().toString());

        Uri uri = getContentResolver().insert(CompanyProvider.CONTENT_URI,values);
        Toast.makeText(this, uri.toString(),Toast.LENGTH_SHORT).show();
    }

    public void doLoadContent(View view) {
    Cursor cr = getContentResolver().query(CompanyProvider.CONTENT_URI, null, null, null, "_id");
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
