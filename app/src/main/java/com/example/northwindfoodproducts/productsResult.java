package com.example.northwindfoodproducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

public class productsResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_result);

        String categoryName = getIntent().getStringExtra("categoryName");
        String priceLimit = getIntent().getStringExtra("priceLimit");

        String sqlquery = "SELECT ProductName,UnitPrice,CategoryName From Products,Categories WHERE CategoryName = ? AND UnitPrice < ?";
        String[] selectionArgs = { categoryName, priceLimit };

        ArrayList<Row> rows = queryDatabase(sqlquery, selectionArgs); // Pass the query and arguments to the method

        RecyclerView rv = (RecyclerView) findViewById(R.id.queryresults);

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        RowsAdapter adapter = new RowsAdapter(rows,this);

        rv.setAdapter(adapter);
    }
    ArrayList<Row> queryDatabase (String query, String[] selectionArgs)
    {
        ArrayList<Row> queryResult = new ArrayList<Row>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try{
            db = openOrCreateDatabase("northwind.db", Context.MODE_PRIVATE,null);

            cursor = db.rawQuery(query, selectionArgs);
            while(cursor.moveToNext())
            {
                Row r = new Row("","","");
                if(cursor.getColumnCount() == 1){
                    r = new Row(cursor.getString(0),"","");
                }
                else if (cursor.getColumnCount() == 2){
                    r = new Row(cursor.getString(0), cursor.getString(1),"");
                }
                else if (cursor.getColumnCount() > 2)
                {
                    r = new Row(cursor.getString(0), cursor.getString(1),cursor.getString(2));
                }
                queryResult.add(r);
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error opening/querying Database",Toast.LENGTH_LONG).show();
            Log.e("Database Error", e.getMessage(), e);
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return queryResult;
    }
}


