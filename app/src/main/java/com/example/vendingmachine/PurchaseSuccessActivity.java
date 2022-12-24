package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PurchaseSuccessActivity extends AppCompatActivity implements View.OnClickListener {

    TextView[] textView = new TextView[10];
    int Index = 0;
    TextView totalPaymentView, totalMoneyView, coinOutView;
    Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_success);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        buttonMain = (Button) findViewById(R.id.buttonPurchaseToMain);
        buttonMain.setOnClickListener(this);
        textView[0] = (TextView) findViewById(R.id.textViewOne);
        textView[1] = (TextView) findViewById(R.id.textViewTwo);
        textView[2] = (TextView) findViewById(R.id.textViewThree);
        textView[3] = (TextView) findViewById(R.id.textViewFour);
        textView[4] = (TextView) findViewById(R.id.textViewFive);
        textView[5] = (TextView) findViewById(R.id.textViewSIx);
        textView[6] = (TextView) findViewById(R.id.textViewSeven);
        textView[7] = (TextView) findViewById(R.id.textViewEight);
        textView[8] = (TextView) findViewById(R.id.textViewNine);
        textView[9] = (TextView) findViewById(R.id.textViewTen);
        totalMoneyView = (TextView) findViewById(R.id.textViewEleven);
        totalPaymentView = (TextView) findViewById(R.id.textViewTwelve);
        coinOutView = (TextView) findViewById(R.id.textViewThirteen);

        // print product list, total money, money paid
        PrintProduct();
        totalMoneyView.setText("總金額: $ "+String.format("%.2f",database.depositMoney));
        totalPaymentView.setText("付款: $ "+String.format("%.2f",database.selectProductMoney));

        // count total coin change and print
        CountTotalChange();
        coinOutView.setText("找零: ¢5("+String.format("%2d",database.CoinChange[0])+"枚), "+
                                 "¢10("+String.format("%2d",database.CoinChange[1])+"枚), "+
                                 "¢25("+String.format("%2d",database.CoinChange[2])+"枚)");

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

    private void PrintProduct() {
        for(int i=0;i<8;i++){
            // print all product bought
            if(database.Product[i]!=0){
                textView[Index].setText(Index+1+" ) 名稱："+database.ProductName[i]+", 價錢：$ "+String.format("%.2f",database.Price[i])+" x "+database.Product[i]+" = $ "+String.format("%.2f",database.Price[i]*database.Product[i]));
                Index++;
            }
        }
    }

    private void CountTotalChange() {
        double i=database.depositMoney-database.selectProductMoney;
        if (i/0.25>=1) {
            database.CoinChange[2]=(int)(i/0.25);
            i-=(double)database.CoinChange[2]*0.25;
        }
        if (i/0.10>=1) {
            database.CoinChange[1]=(int)(i/0.10);
            i-=(double)database.CoinChange[1]*0.10;
        }
        if (i/0.05>=1) {
            database.CoinChange[0]=(int)(i/0.05);
            i-=(double)database.CoinChange[0]*0.05;
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}