package com.example.kazi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, add, reg, dob;
    Button sub, view;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);

        name = (EditText)findViewById(R.id.name);
        reg = (EditText)findViewById(R.id.reg);
        add = (EditText)findViewById(R.id.address);
        dob = (EditText)findViewById(R.id.dob);

        sub = (Button) findViewById(R.id.sub);
        view = (Button) findViewById(R.id.view);

        final String stname = name.getText().toString();
        final String streg = reg.getText().toString();
        final String stadd = add.getText().toString();
        final String stdob = dob.getText().toString();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String stname = name.getText().toString();
                 String streg = reg.getText().toString();
                 String stadd = add.getText().toString();
                 String stdob = dob.getText().toString();

               boolean insert = db.InsertStudent(streg,stname,stadd,stdob);
                if (insert){
                    name.setText("");
                    reg.setText("");
                    add.setText("");
                    dob.setText("");
                    Toast.makeText(getApplicationContext(), "Student inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Student not inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(next);
            }
        });


    }

}