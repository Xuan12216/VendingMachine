package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DepositBillsOrCoinsActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonMain,buttonBills,buttonCoins;
    EditText editTextBills,editTextCoins;
    TextView textViewBills,textViewCoins,textViewTotal;

    double tempCoins=0.0,tempBills=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_bills_or_coins);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        buttonMain = (Button) findViewById(R.id.button_main2);
        buttonBills = (Button) findViewById(R.id.buttonBills);
        buttonCoins = (Button) findViewById(R.id.buttonCoins);

        editTextBills = (EditText) findViewById(R.id.editBills);
        editTextCoins = (EditText) findViewById(R.id.editCoins);

        textViewBills = (TextView) findViewById(R.id.textViewBIlls);
        textViewCoins = (TextView) findViewById(R.id.textViewCoins);
        textViewTotal = (TextView) findViewById(R.id.textviewTotal);

        textViewTotal.setText("總金額：$"+database.depositMoney);
        textViewBills.setText("紙幣金額：$"+database.totalBills);
        textViewCoins.setText("硬幣金額：$"+database.totalCoins/100);

        buttonMain.setOnClickListener(this);
        buttonCoins.setOnClickListener(this);
        buttonBills.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.button_main2:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.buttonBills:
                if("".equals(editTextBills.getText().toString().trim())) {}
                else{
                    int temp = Integer.valueOf(editTextBills.getText().toString());
                    if (temp==1||temp==5||temp==10||temp==20)
                        database.totalBills+=temp;
                        textViewBills.setText("紙幣金額：$"+database.totalBills);
                        if (temp==1) database.Bills[0]+=1;
                        else if (temp==5) database.Bills[1]+=1;
                        else if (temp==10) database.Bills[2]+=1;
                        else if (temp==20) database.Bills[3]+=1;
                        database.depositMoney=(database.totalBills+(database.totalCoins/100));
                        textViewTotal.setText("總金額：$"+database.depositMoney);
                }
                editTextBills.getText().clear();
                break;
            case R.id.buttonCoins:
                if("".equals(editTextCoins.getText().toString().trim())) {}
                else{
                    int temp1 = Integer.valueOf(editTextCoins.getText().toString());
                    if (temp1==5 ||temp1==10 ||temp1==25)
                        database.totalCoins+=temp1;
                        textViewCoins.setText("硬幣金額：$"+database.totalCoins/100);
                        if (temp1==5) database.Coins[0]+=1;
                        else if (temp1==10) database.Coins[1]+=1;
                        else if (temp1==25) database.Coins[2]+=1;
                        database.depositMoney=(database.totalBills+(database.totalCoins/100));
                        textViewTotal.setText("總金額：$"+database.depositMoney);
                }
                editTextCoins.getText().clear();
                break;
        }
    }
}