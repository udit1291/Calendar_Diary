package com.ex.udit.calendar_diary.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ex.udit.calendar_diary.R;
import com.ex.udit.calendar_diary.database.handle2;

public class MainActivity1 extends AppCompatActivity {
    private EditText text1;
    private handle2 db;

    static MainActivity1 obj=new MainActivity1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        String message = getIntent().getStringExtra("messa");
        handle2.name=message;

        Button saveButton = (Button)findViewById(R.id.saveButton);
        text1 = (EditText)findViewById(R.id.text29);
        Button deletebutton=(Button)findViewById(R.id.deleteButton);

        db = new handle2(this);
        try{
            text1.setText(db.getNote());
        }catch (Exception e){
            Toast.makeText(this, "No Data Found ", Toast.LENGTH_LONG).show();
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity1.this);
                builder.setTitle("Save data");
                builder.setMessage("Are you sure you want to save ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        try{
                            db.insertData(text1.getText().toString());
                            Toast.makeText(MainActivity1.this,"Inserted..",Toast.LENGTH_SHORT).show();
                        }
                        catch(Exception e){
                            Toast.makeText(MainActivity1.this,"Error: while inserting data",Toast.LENGTH_SHORT).show();
                        }
                        Intent in = new Intent(MainActivity1.this , MainActivity.class);
                        startActivity(in);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();





            }
        });

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity1.this);
                builder.setTitle("Delete data");
                builder.setMessage("Are you sure you want to delete ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();

                            db.deleteData();

                            Toast.makeText(MainActivity1.this,"Deleted..",Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(MainActivity1.this , MainActivity.class);
                        startActivity(in);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }


}