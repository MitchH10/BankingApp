package com.example.interfacebudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        TextView tV7 = findViewById(R.id.textView7);
        tV7.setText("$" + String.format("%.2f", MainActivity.amount.getBal()));

    }



    public void enterDeposit(View view) {
        EditText depText = (EditText) findViewById(R.id.editTextTextPersonName);
        double dep = Double.parseDouble(String.valueOf(depText.getText()));

        MainActivity.amount.setBal(MainActivity.amount.getBal() + dep);

        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}