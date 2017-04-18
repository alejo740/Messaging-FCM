package com.edwin.cobos.appmessagingfcm.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.edwin.cobos.appmessagingfcm.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);

    }
}
