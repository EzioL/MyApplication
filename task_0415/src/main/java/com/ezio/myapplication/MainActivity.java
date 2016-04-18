package com.ezio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton mToggleButton;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mToggleButton = (ToggleButton) findViewById(R.id.toggle);
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mImageView.setImageResource(R.drawable.ship2);
                    Log.e("isChecked",true+"");
                }else {
                    mImageView.setImageResource(R.drawable.ship1);
                    Log.e("Checked",false+"");
                }

            }
        });
    }
}
