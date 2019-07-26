package com.ex.udit.calendar_diary.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.ex.udit.calendar_diary.R;

public class MainActivity extends AppCompatActivity {

    public CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView);



        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String s ="m"+dayOfMonth+month+year;

                Intent int1 = new Intent(MainActivity.this,MainActivity1.class);
                int1.putExtra("messa", s);
                startActivity(int1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.allnotes){
            Intent in= new Intent(MainActivity.this,more.class);
            startActivity(in);
            return true;
        }

        return true;
    }
}
