package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbortPurchaseActivity extends AppCompatActivity implements View.OnClickListener {
    TextView returnBillView, returnCoinView;
    Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abort_purchase);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        returnBillView = (TextView) findViewById(R.id.textViewReturnBills);
        returnCoinView = (TextView) findViewById(R.id.textViewReturnCoins);
        buttonMain = (Button) findViewById(R.id.buttonAbortToMain);
        buttonMain.setOnClickListener(this);

        // return money (bills and coins separated)
        returnBillView.setText("紙張退回: $1("+String.format("%2d",database.Bills[0])+"張), "+
                                       "$5("+String.format("%2d",database.Bills[1])+"張), "+
                                       "$10("+String.format("%2d",database.Bills[2])+"張), "+
                                       "$20("+String.format("%2d",database.Bills[3])+"張)");

        returnCoinView.setText("零錢退回: ¢5("+String.format("%2d",database.Coins[0])+"枚), "+
                                       "¢10("+String.format("%2d",database.Coins[1])+"枚), "+
                                       "¢25("+String.format("%2d",database.Coins[2])+"枚)");

        // clear data
        for (int i=0; i<8; i++) {
            database.Product[i]=0;
        }
        database.depositMoney=0.0;
        database.selectProductMoney=0.0;
        database.totalBills=0.0;
        database.totalCoins=0.0;
        for (int i=0; i<=3; i++) {
            database.Bills[i]=0;
            if(i<3) {
                database.Coins[i]=0;
                database.CoinChange[i]=0;
            }
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}