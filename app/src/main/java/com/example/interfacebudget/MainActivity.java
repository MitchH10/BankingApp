package com.example.interfacebudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static boolean firstOpen = true;
    //create public amount object to store balance across activities
    public static Account amount = new Account();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set amount balance from shared preferences file storage on start
        if (firstOpen){
            amount.setBal(readBalance());
        }
        //update balance text box with current amount balance
        setBalText();
        //store the amount balance in shared preferences file storage, updates on return to main activity
        writeBalance();
        //update flag to stop setting amount to stored balance (for returning to main activity)
        firstOpen = false;
    }
    //write the amount balance in shared preferences file storage
    public void writeBalance(){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("bal", Double.doubleToRawLongBits(amount.getBal()));
        editor.apply();
    }
    //read the stored balance in shared preferences file storage
    public double readBalance(){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        if ( !sharedPref.contains("bal")) {
            return 0.0;
        } else {
            return Double.longBitsToDouble(sharedPref.getLong("bal", 0));
        }
    }
    //update the current displayed text to the amount balance
    public void setBalText(){
        TextView tv3 = findViewById(R.id.textView5);
        tv3.setText("$" + String.format("%.2f", amount.getBal()));
    }
    //button click to open deposit activity
    public void deposit (View view) {
        Intent i = new Intent(this, DepositActivity.class);
        startActivity(i);
    }
    //button click to open withdraw activity
    public void withdraw (View view) {
        Intent i = new Intent(this, WithdrawActivity.class);
        startActivity(i);
    }

}