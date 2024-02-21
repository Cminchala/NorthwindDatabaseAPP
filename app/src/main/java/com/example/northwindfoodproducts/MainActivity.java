package com.example.northwindfoodproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


// add order by in the query
    public void viewProducts(View v)
    {
        Intent i = new Intent(this,products.class);
        startActivity(i);
    }

    public void viewSupplier(View e)
    {
        Intent x = new Intent(this,supplier.class);
        startActivity(x);
    }

    public void viewBoth(View a){
        Intent u = new Intent(this, productAndSuppliers.class);
        startActivity(u);
    }

}