package com.ezio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner provinceSpinner;
    private Spinner citySpinner;
    private Spinner townSpinner;
    ArrayAdapter<String> provinceAdapter = null;
    ArrayAdapter<String> cityAdapter = null;
    ArrayAdapter<String> townAdapter = null;
    static int provincePosition = 0;
    static int cityPosition = 0;
    private String[] province = new String[] {"北京","上海","河南"};
    private String[][] city = new String[][] {
            {"东城区","西城区","崇文区"},
            {"崇明","浦东","宝山"},
            {"郑州","洛阳","安阳"}
    };
    private String[][][] county = new String[][][]{
            {
                    {"东城区1","东城区2","东城区3"},
                    {"西城区1","西城区2","西城区3"},
                    {"崇文区1","崇文区2","崇文区3"}
            },
            {
                    {"崇明1","崇明2","崇明3"},
                    {"浦东1","浦东2","浦东3"},
                    {"宝山1","宝山2","宝山3"},
            },
            {
                    {"郑州1","郑州2","郑州3"},
                    {"洛阳1","洛阳2","洛阳3"},
                    {"安阳1","安阳2","安阳3"}
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setOnItemClickListener();
    }

    private void setOnItemClickListener() {
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provincePosition = position;
                cityAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, city[provincePosition]);
                citySpinner.setAdapter(cityAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityPosition = position;
                townAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, county[provincePosition][cityPosition]);
                townSpinner.setAdapter(townAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        townSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String addr = province[provincePosition]+" "+
                        city[provincePosition][cityPosition]+" "+
                        county[provincePosition][cityPosition][position];
                Toast.makeText(MainActivity.this,addr,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    private void init() {

        provinceSpinner = (Spinner)findViewById(R.id.spin_province);
        provinceAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, province);
        provinceSpinner.setAdapter(provinceAdapter);

        citySpinner = (Spinner)findViewById(R.id.spin_city);
        cityAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, city[0]);
        citySpinner.setAdapter(cityAdapter);


        townSpinner = (Spinner) findViewById(R.id.spin_town);
        townAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, county[0][0]);

        townSpinner.setAdapter(townAdapter);

    }
}
