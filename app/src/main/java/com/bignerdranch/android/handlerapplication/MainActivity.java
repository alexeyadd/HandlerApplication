package com.bignerdranch.android.handlerapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean flagProcessing;
    private int index1;
    private int index2;
    private int index3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            flagProcessing = savedInstanceState.getBoolean("flagProcessing", false);
            index1 = savedInstanceState.getInt("index1", 0);
            index2 = savedInstanceState.getInt("index2", 0);
            index3 = savedInstanceState.getInt("index3", 0);
            if (flagProcessing) {
                flagProcessing = false;
                onClickStart(null);
            }
        } else
        {
            flagProcessing = false;
            index1 = 0;
            index2 = 0;
            index3 = 0;
        }
    }

    protected void onClickStart(View view) {
        if (flagProcessing) return;
        flagProcessing = true;

        final Handler handler1 = new Handler();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textView1);

                textView.setText(String.valueOf(index1));
                index1++;

                if (flagProcessing) handler1.postDelayed(this, 1000);
            }
        };
        final Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textView2);

                textView.setText(String.valueOf(index2));
                index2++;

                if (flagProcessing) handler2.postDelayed(this, 1000);
            }
        };
        final Handler handler3 = new Handler();
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textView3);

                textView.setText(String.valueOf(index3));
                index3++;

                if (flagProcessing) handler3.postDelayed(this, 1000);
            }
        };
        handler1.post(runnable1);
        handler2.post(runnable2);
        handler3.post(runnable3);
    }

    protected void onClickStop(View view) {
        flagProcessing = false;

        index1 = 0;
        index2 = 0;
        index3 = 0;

        int aaa = 89;
        aaa *= 3;

        Toast.makeText(this, "Проверка!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("flagProcessing", flagProcessing);
        outState.putInt("index1", index1);
        outState.putInt("index2", index2);
        outState.putInt("index3", index3);
    }
}
