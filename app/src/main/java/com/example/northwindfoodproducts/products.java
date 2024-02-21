package com.example.northwindfoodproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


    }

    public void displayRProducts(View x)
    {
        Intent i = new Intent(this, productsResult.class);
        EditText a = (EditText) findViewById(R.id.productUnderDollar);
        EditText b = (EditText) findViewById(R.id.categoryType);
        String add = b.getText().toString();
        String priceLimit = a.getText().toString();

        // Pass the parameters separately from the query
        i.putExtra("categoryName", add);
        i.putExtra("priceLimit", priceLimit);

        startActivity(i);
    }


}