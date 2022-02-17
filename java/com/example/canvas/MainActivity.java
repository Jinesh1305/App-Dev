package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    TouchScreen ts;
    LinearLayout ll;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ts=new TouchScreen(this,null);
        ll=findViewById(R.id.ll_draw);
        bt=findViewById(R.id.btn);
        ll.addView(ts);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ts.clearCanvas();
            }
        });
    }
}