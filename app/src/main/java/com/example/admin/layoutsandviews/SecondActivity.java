package com.example.admin.layoutsandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Second";
    TextView txtSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtSecond = (TextView) findViewById(R.id.txtSecond);
        Intent intent = getIntent();

        switch (intent.getAction()){
            case "sendingPerson":
                Person person = (Person) intent.getSerializableExtra("person");
                txtSecond.setText(person.getName().toString()+ " " + person.getGender().toString());
                Log.d(TAG, "onCreate: "+person.getName()+ " " + person.getGender());
                break;
            case "SendingValue":
                Log.d(TAG, "onCreate: " + intent.getStringExtra(getString(R.string.KEY_VALUE1)));
                txtSecond.setText(intent.getStringExtra(getString(R.string.KEY_VALUE1)));
                break;
        }


    }
}
