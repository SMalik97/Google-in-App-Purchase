package com.furiousbuddy.googleinapppurchase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

public class MainActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler {
BillingProcessor bp;
private Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bp=new BillingProcessor(this, null, this);

        pay=(Button)findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.purchase(MainActivity.this,"android.test.purchased");
            }
        });



    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        Toast.makeText(this, "This product is already purchased", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPurchaseHistoryRestored() {
        Toast.makeText(this, "Purchased history", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBillingInitialized() {
        Toast.makeText(this, "Initializing...", Toast.LENGTH_SHORT).show();
    }
}
