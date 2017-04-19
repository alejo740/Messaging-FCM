package com.edwin.cobos.appmessagingfcm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.edwin.cobos.appmessagingfcm.R;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView messageTextView = (TextView) findViewById(R.id.messageTextView);

        Intent intent = getIntent();
        if(intent.getSerializableExtra("dataMap") instanceof HashMap) {
            HashMap<String, String> hashMap = (HashMap<String, String>) intent.getSerializableExtra("dataMap");
            messageTextView.setText(hashMap.get("customMessageKey"));
        }
    }
}
