package com.example.admin.layoutsandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    EditText edName;
    EditText edPersonName;
    EditText edPersonGender;
    Button btnDoMagic;
    Button btnPerson;
    TextView txtName;

    EditText edSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.edName);
        edSum = (EditText) findViewById(R.id.edSum);
        btnDoMagic = (Button) findViewById(R.id.btnDoMagic);
        txtName = (TextView) findViewById(R.id.txtName);

        edPersonName = (EditText) findViewById(R.id.edPersonName);
        edPersonGender = (EditText) findViewById(R.id.edPersonGender);
        btnPerson = (Button) findViewById(R.id.btnPerson);

        btnDoMagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etValue = edName.getText().toString();
                String sumValue = edSum.getText().toString();
                int sum = Integer.parseInt(etValue) + Integer.parseInt(sumValue);
                Log.d(TAG, "onClick: "+ etValue + sumValue);
                txtName.setText(String.valueOf(sum));
            }
        });
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void goToSecond(View view) {
        String value = edName.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(getString(R.string.KEY_VALUE1),value);
        startActivity(intent);
    }

    public void passValues(View view) {
        String personName = edPersonName.getText().toString();
        String personGender = edPersonGender.getText().toString();

        Person person = new Person(personName, personGender);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.setAction("sendingPerson");
        intent.putExtra("person", person);
        startActivity(intent);
    }
}
