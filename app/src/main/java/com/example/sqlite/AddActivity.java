package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private DBManager dbManager;
    private EditText nameText, descText;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbManager = new DBManager(this);
        dbManager.open();
        nameText = findViewById(R.id.name);
        descText = findViewById(R.id.desc);

        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String country = nameText.getText().toString();
                final String desc = descText.getText().toString();
                dbManager.insert(country, desc);
                returnHome();
            }
        });
    }

    public void returnHome() {
        Intent home = new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}
