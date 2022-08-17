package com.example.interfacebudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WithdrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        TextView tV12 = findViewById(R.id.textView12);
        tV12.setText("$" + String.format("%.2f", MainActivity.amount.getBal()));
    }
    public void enterWithdraw(View view) {
        EditText witText = (EditText) findViewById(R.id.editTextTextPersonName3);
        double wit = Double.parseDouble(String.valueOf(witText.getText()));

        MainActivity.amount.setBal(MainActivity.amount.getBal() - wit);

        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}