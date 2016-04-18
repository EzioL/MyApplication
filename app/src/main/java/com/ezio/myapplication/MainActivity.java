package com.ezio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.roger.psdloadingview.library.PsdLoadingView;
import com.roger.psdloadingview.library.animate.EatAnimate;
import com.roger.psdloadingview.library.animate.IAnimate;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mImageView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PsdLoadingView psd = (PsdLoadingView) findViewById(
                R.id.psdloadingview);
        Button beginBtn = (Button) findViewById(R.id.beginBtn);
        Button endBtn = (Button) findViewById(R.id.endBtn);
        IAnimate iAnimate = new EatAnimate();
        psd.init(iAnimate);
        beginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                psd.startLoading();
            }
        });
        endBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                psd.stopLoading();
            }
        });

        mButton= (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    psd.startLoading();
                }else{
                    psd.stopLoading();
                }
            }
        });
    }


    public  void myClick(View v){
        Toast.makeText(MainActivity.this,"按钮被点击",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button:
                Toast.makeText(MainActivity.this,"按钮被点击",Toast.LENGTH_LONG).show();
                break;
            case R.id.imageView:
                Toast.makeText(MainActivity.this,"图片被点击",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
