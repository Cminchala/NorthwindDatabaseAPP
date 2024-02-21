package com.example.northwindfoodproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class productAndSuppliers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_and_suppliers);
    }

    public void displayProandSup(View x)
    {
        Intent i = new Intent(this,productResultAndSupplier.class);
        EditText a = (EditText) findViewById(R.id.units);
        EditText b = (EditText) findViewById(R.id.productCountry);

            i.putExtra("query", "SELECT productname,companyname,unitsinstock From Products,Suppliers WHERE Products.supplierid = Suppliers.supplierid AND country == " + "'" + b.getText().toString() + "'" + "AND unitsinstock < "+ a.getText().toString());
            startActivity(i);

    }
}