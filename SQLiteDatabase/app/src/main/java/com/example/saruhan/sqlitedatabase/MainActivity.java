package com.example.saruhan.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, college;
    MyCoreDatabase myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editName);
        college = (EditText) findViewById(R.id.editCollege);

        myData = new MyCoreDatabase(this);
    }

    public void doSave(View view) {
        myData.insertData(name.getText().toString(),college.getText().toString());
    }

    public void doLoad(View view) {
        myData.getAll();
    }
}
