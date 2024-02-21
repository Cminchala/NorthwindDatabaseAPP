package com.example.northwindfoodproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class supplier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
    }
    public void displayRSupplier(View x)
    {
        Intent i = new Intent(this,productsResult.class);
        EditText a = (EditText) findViewById(R.id.supplierCountry);
        EditText b = (EditText) findViewById(R.id.City);
        if(a.getText().toString().matches("")) {
            i.putExtra("query", "SELECT companyname,country,city From Suppliers");
            startActivity(i);
        }
        else if(b.getText().toString().matches(""))
        {
            i.putExtra("query", "SELECT companyname,country,city From Suppliers");
            startActivity(i);
        }
        else {
            i.putExtra("query", "SELECT companyname,country,city From Suppliers WHERE country == " + "'" + a.getText().toString() + "'" + " AND city  == " + "'" + b.getText().toString() + "'");

            startActivity(i);
        }
    }
}