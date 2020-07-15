package com.example.kazi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Database db = new Database(this);

        Cursor select = db.getStudent();

        StringBuffer buffer = new StringBuffer();
        int y = 1;
        while(select.moveToNext()){
            buffer.append(y+" Student\n");
            buffer.append("\nStudent Name : "+ select.getString(1));
            buffer.append("\nReg No. : "+ select.getString(0));
            buffer.append("\nAddress : "+ select.getString(2));
            buffer.append("\nDate of Birth : "+ select.getString(3));
            buffer.append("\n\n\n");
            y++;
        }
        showMessage("Registered Student",buffer.toString());

    }
    public void showMessage(String title, String messange){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(messange);
        builder.show();
    }
}