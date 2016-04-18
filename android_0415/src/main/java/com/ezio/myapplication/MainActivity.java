package com.ezio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup mRadioGroup;
    CheckBox mCheckBox1, mCheckBox2, mCheckBox3;
    SeekBar mSeekBar;
    RatingBar mRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.man:
                        Toast.makeText(MainActivity.this, "男", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.women:
                        Toast.makeText(MainActivity.this, "女", Toast.LENGTH_LONG).show();
                        break;


                }
            }
        });
        mCheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkBox3);
        mCheckBox1.setOnCheckedChangeListener
                (new myOnCheckedChangeListener(mCheckBox1.getText().toString()));
        mCheckBox2.setOnCheckedChangeListener
                (new myOnCheckedChangeListener(mCheckBox2.getText().toString()));
        mCheckBox3.setOnCheckedChangeListener
                (new myOnCheckedChangeListener(mCheckBox3.getText().toString()));

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                show("当前进度:"+p);
            }
        });


        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                show(rating+"颗星");
            }
        });

    }

    class myOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        String text;

        public myOnCheckedChangeListener(String text) {
            this.text = text;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                show("用户选择了" + text);
            } else {
                show("用户取消了" + text);
            }
        }
    }

    public void show(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}

