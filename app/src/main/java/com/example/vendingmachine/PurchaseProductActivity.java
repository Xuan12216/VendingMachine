package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PurchaseProductActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonMain,buttonPurchase,buttonA;
    TextView AAmount,BAmount,CAmount,DAmount,EAmount,FAmount,GAmount,HAmount;
    TextView textViewDeposit,textViewSelect,textViewRemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_product);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        buttonMain = (Button) findViewById(R.id.buttonMain1);
        buttonPurchase = (Button) findViewById(R.id.buttonPurchase);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonMain.setOnClickListener(this);
        buttonPurchase.setOnClickListener(this);
        buttonA.setOnClickListener(this);

        AAmount = (TextView) findViewById(R.id.A_Amount);
        BAmount = (TextView) findViewById(R.id.B_Amount);
        CAmount = (TextView) findViewById(R.id.C_Amount);
        DAmount = (TextView) findViewById(R.id.D_Amount);
        EAmount = (TextView) findViewById(R.id.E_Amount);
        FAmount = (TextView) findViewById(R.id.F_Amount);
        GAmount = (TextView) findViewById(R.id.G_Amount);
        HAmount = (TextView) findViewById(R.id.H_Amount);
        SelectProductAmount();

        textViewDeposit = (TextView) findViewById(R.id.depositMoney);
        textViewSelect  = (TextView) findViewById(R.id.selectProductMoney);
        textViewRemain  = (TextView) findViewById(R.id.remainMoney);
        textViewDeposit.setText("投幣金額：$ "+String.format("%.2f",database.depositMoney));
        textViewSelect.setText("需付金額：$ "+String.format("%.2f",database.selectProductMoney));
        textViewRemain.setText("剩餘金額：$ "+String.format("%.2f",database.depositMoney-database.selectProductMoney));
    }

    private void SelectProductAmount() {
        AAmount.setText("數量："+database.Product[0]);
        BAmount.setText("數量："+database.Product[1]);
        CAmount.setText("數量："+database.Product[2]);
        DAmount.setText("數量："+database.Product[3]);
        EAmount.setText("數量："+database.Product[4]);
        FAmount.setText("數量："+database.Product[5]);
        GAmount.setText("數量："+database.Product[6]);
        HAmount.setText("數量："+database.Product[7]);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonMain1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.buttonPurchase:
                if (database.depositMoney-database.selectProductMoney==0.0||database.selectProductMoney==0.0) Toast.makeText(this,"Not Item Select!",Toast.LENGTH_SHORT).show();
                else if (database.depositMoney-database.selectProductMoney<0){
                    buttonA.setVisibility(View.VISIBLE);
                    Toast.makeText(this,"金額不足，請加值！！",Toast.LENGTH_SHORT).show();
                }
                else startActivity(new Intent(this,PurchaseSuccessActivity.class));
                break;
            case R.id.buttonA:
                startActivity(new Intent(this,DepositBillsOrCoinsActivity.class));
                break;
        }
    }
}