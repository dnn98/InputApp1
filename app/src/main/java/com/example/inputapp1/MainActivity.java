package com.example.inputapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView textView;
    private String[] number_array = {"971708708", "902223343", "655773238", "000990239"};
    DatePickerDialog picker;
    private String current_date;
    TimePickerDialog time;
    private String current_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        textView.setText(number_array[pos]);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void doDate(View view) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        current_date = (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(), current_date, Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }, year, month, day);
        picker.show();
    }

    public void doTime(View view){
        final Calendar time1 = Calendar.getInstance();
        int hour = time1.get(Calendar.HOUR_OF_DAY);
        int minutes = time1.get(Calendar.MINUTE);
        // time picker dialog
        time = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        current_time = ("Selected Date: "+ sHour +":"+ sMinute);
                        Toast toast2 =
                                Toast.makeText(getApplicationContext(), current_time, Toast.LENGTH_SHORT);
                        toast2.show();
                    }
                }, hour, minutes, true);
        time.show();


    }
}

