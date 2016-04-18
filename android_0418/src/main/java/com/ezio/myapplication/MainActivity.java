package com.ezio.myapplication;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DatePicker mDatePicker;
    private int year;
    private int monthOfYear;
    private int dayOfMonth;
    private int hourOfDay;
    private int minute;
    Calendar mCaledar;
    TimePickerDialog mTimePickerDialog;
    Spinner mSpinner;

    List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        mCaledar = Calendar.getInstance();
        year = mCaledar.get(Calendar.YEAR);
        monthOfYear = mCaledar.get(Calendar.MONTH);
        dayOfMonth = mCaledar.get(Calendar.DAY_OF_MONTH);

        mDatePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //monthOfYear(0---11)  中国习惯是(1---12)
                Toast.makeText(MainActivity.this, year + "-" + (monthOfYear + 1) + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        });
*/

        mSpinner = (Spinner) findViewById(R.id.spinner);
        getData();
        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
                list,
                R.layout.itemlayout,
                new String[]{"iv","tv"},
                new int[]{R.id.item_iv,R.id.item_tv}
                );
        mSpinner.setAdapter(simpleAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                String context = (String) map.get("tv");
                Toast.makeText(MainActivity.this,context,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       /* String [] cities = {"上海","郑州","北京","西藏"};

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                cities
        );

        mSpinner.setAdapter(stringArrayAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
    }

    private void getData() {
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("iv", R.mipmap.ic_launcher);
            map.put("tv", "item" + i);
            list.add(map);
        }
    }

   /* public void showDiaLog(View v) {
        mCaledar = Calendar.getInstance();
        hourOfDay = mCaledar.get(Calendar.HOUR_OF_DAY);
        minute = mCaledar.get(Calendar.MINUTE);
        mTimePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(MainActivity.this,hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true

        );
        mTimePickerDialog.show();
    }*/
}
