package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView depositMoney,selectProductMoney;
    Button buttonA,buttonB,buttonC,buttonD,buttonE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        depositMoney = (TextView) findViewById(R.id.depositMoney);
        selectProductMoney = (TextView) findViewById(R.id.selectProductMoney);

        depositMoney.setText("投幣金額：$ "+String.format("%.2f",database.depositMoney));
        selectProductMoney.setText("需付金額：$ "+String.format("%.2f",database.selectProductMoney));

        buttonA = (Button) findViewById(R.id.button_a);
        buttonA.setOnClickListener(this);

        buttonB = (Button) findViewById(R.id.button_b);
        buttonB.setOnClickListener(this);

        buttonC = (Button) findViewById(R.id.button_c);
        buttonC.setOnClickListener(this);

        buttonD = (Button) findViewById(R.id.button_d);
        buttonD.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.button_a:
                startActivity(new Intent(this,DepositBillsOrCoinsActivity.class));
                break;
            case R.id.button_b:
                startActivity(new Intent(this,SelectProductActivity.class));
                break;
            case R.id.button_c:
                startActivity(new Intent(this,CancelProductActivity.class));
                break;
            case R.id.button_d:
                startActivity(new Intent(this,PurchaseProductActivity.class));
                break;
        }
    }
}