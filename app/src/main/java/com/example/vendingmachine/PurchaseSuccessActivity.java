package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class PurchaseSuccessActivity extends AppCompatActivity {

    TextView[] textView = new TextView[10];
    int Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_success);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

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

        PrintProduct();
    }

    private void PrintProduct() {
        for(int i=0;i<8;i++){
            if(database.Product[i]!=0){
                textView[Index].setText(Index+1+" ) 名稱："+database.ProductName[i]+", 價錢：$ "+String.format("%.2f",database.Price[i])+" x "+database.Product[i]+" = $ "+String.format("%.2f",database.Price[i]*database.Product[i]));
                Index++;
            }
        }
    }
}