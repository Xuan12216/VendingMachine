package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SelectProductActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonMain,buttonMinus,buttonAdd;
    TextView textViewDepositMoney1,textViewSelectProductMoney;
    TextView textViewAB,textViewCD,textViewEF,textViewGH;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        buttonMain = (Button) findViewById(R.id.buttonMain1);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMain.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        //buttonMinus.setOnClickListener(this);

        textViewDepositMoney1 = (TextView) findViewById(R.id.depositMoney);
        textViewSelectProductMoney = (TextView) findViewById(R.id.selectProductMoney);
        textViewDepositMoney1.setText("投幣金額：$ "+String.format("%.2f",database.depositMoney));
        textViewSelectProductMoney.setText("需付金額：$ "+String.format("%.2f",database.selectProductMoney));

        textViewAB = (TextView) findViewById(R.id.textViewproductAB1);
        textViewCD = (TextView) findViewById(R.id.textViewproductCD1);
        textViewEF = (TextView) findViewById(R.id.textViewproductEF1);
        textViewGH = (TextView) findViewById(R.id.textViewproductGH1);
        CountProduct();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
    }

    private void CountProduct() {
        textViewAB.setText("A : "+database.Product[0]+"     B : "+database.Product[1]);
        textViewCD.setText("C : "+database.Product[2]+"     D : "+database.Product[3]);
        textViewEF.setText("E : "+database.Product[4]+"     F : "+database.Product[5]);
        textViewGH.setText("G : "+database.Product[6]+"     H : "+database.Product[7]);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonMain1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.buttonAdd:
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                if (radioButton==null) Toast.makeText(this,"Not Item Select!",Toast.LENGTH_SHORT).show();
                else{
                    if("A".equals(radioButton.getText())) ProductAdd(0);
                    else if ("B".equals(radioButton.getText()))ProductAdd(1);
                    else if ("C".equals(radioButton.getText()))ProductAdd(2);
                    else if ("D".equals(radioButton.getText()))ProductAdd(3);
                    else if ("E".equals(radioButton.getText()))ProductAdd(4);
                    else if ("F".equals(radioButton.getText()))ProductAdd(5);
                    else if ("G".equals(radioButton.getText()))ProductAdd(6);
                    else if ("H".equals(radioButton.getText()))ProductAdd(7);
                }
                CountProduct();
                textViewSelectProductMoney.setText("需付金額：$ "+String.format("%.2f",database.selectProductMoney));
                break;
        }
    }

    private void ProductAdd(int i) {
        database.Product[i]+=1;
        database.selectProductMoney+=database.Price[i];
    }
}