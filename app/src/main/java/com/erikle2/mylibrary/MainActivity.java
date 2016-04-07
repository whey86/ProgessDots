package com.erikle2.mylibrary;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erikle2.progressdots.ProgressDot;
import com.erikle2.progressdots.ProgressDotBar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ProgressDotBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressDotBar)findViewById(R.id.progbar);
        bar.next();
        bar.next();
    }


}
