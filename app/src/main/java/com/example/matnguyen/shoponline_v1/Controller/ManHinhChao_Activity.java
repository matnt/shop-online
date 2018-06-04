package com.example.matnguyen.shoponline_v1.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.matnguyen.shoponline_v1.R;



public class ManHinhChao_Activity extends Activity  {
    private final int DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao_layout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(ManHinhChao_Activity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, DISPLAY_LENGTH);
    }
}
