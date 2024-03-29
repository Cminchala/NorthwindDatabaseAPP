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

import java.util.ArrayList;

public class supplierResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_results);
        Intent i = getIntent();
        String q = i.getStringExtra("query");


        ArrayList<Row> rows = queryDatabase(q);
        RecyclerView rv = (RecyclerView) findViewById(R.id.supplierqueryresults);

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        RowsAdapter adapter = new RowsAdapter(rows,this);

        rv.setAdapter(adapter);
    }
    ArrayList<Row> queryDatabase (String query)
    {
        ArrayList<Row> queryResult = new ArrayList<>();
        try{
            SQLiteDatabase db = openOrCreateDatabase("northwind.db", Context.MODE_PRIVATE,null);
            Cursor cursor = db.rawQuery(query,null);

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


            cursor.close();
            db.close();

        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error opening/querying Database",Toast.LENGTH_LONG).show();
        }
        return queryResult;
    }
}