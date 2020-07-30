package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private DBManager dbManager;
    private Long _id;
    private EditText nameText, descText;
    private Button update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbManager = new DBManager(this);
        dbManager.open();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String country = intent.getStringExtra("country");
        String desc = intent.getStringExtra("desc");
        _id = Long.parseLong(id);

        nameText = findViewById(R.id.editTexNamet);
        descText = findViewById(R.id.editTextDesc);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);

        nameText.setText(country);
        descText.setText(desc);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonUpdate) {
            dbManager.update(_id, nameText.getText().toString(), descText.getText().toString());
        } else if (v.getId() == R.id.buttonDelete) {
            dbManager.delete(_id);
        }
        returnHome();
    }

    public void returnHome() {
        Intent home = new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}
