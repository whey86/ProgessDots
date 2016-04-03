package com.erikle2.mylibrary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erikle2.progressdots.ProgressDot;
import com.erikle2.progressdots.ProgressDotBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressDotBar bar = new ProgressDotBar(this,3,20,Color.BLUE,Color.GRAY);
        setContentView(bar);

    }
}
