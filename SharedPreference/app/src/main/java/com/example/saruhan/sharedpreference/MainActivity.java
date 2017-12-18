package com.example.saruhan.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editName);
        age = (EditText) findViewById(R.id.editAge);

        SharedPreferences mSharedPrefs = getSharedPreferences("xmlFile", MODE_PRIVATE);
        SharedPreferences.Editor mPrefsEditor = mSharedPrefs.edit();

        int mCounter = mSharedPrefs.getInt("counter", 0);

        TextView tv = (TextView) findViewById(R.id.tvSampleTv);
        tv.setText("Uygulama daha önce " + String.valueOf(mCounter) + " defa çalıştırıldı.");

        mPrefsEditor.putInt("counter", ++mCounter);
        mPrefsEditor.commit();


        //onPause fonksiyonunda kaydedilen verileri gösterecek.
        SharedPreferences sh1 = getSharedPreferences("MyOwnShared", MODE_APPEND);
        String  s1 = sh1.getString("user","");
        int a1 = sh1.getInt("age",0);

        name.setText(s1);
        age.setText(String.valueOf(a1));
    }


    @Override
    protected void onPause() {

        SharedPreferences sh = getSharedPreferences("MyOwnShared", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        myEdit.putString("user", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.commit();
        super.onPause();
    }


}

