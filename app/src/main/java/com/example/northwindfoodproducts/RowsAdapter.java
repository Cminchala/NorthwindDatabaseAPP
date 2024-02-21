package com.example.northwindfoodproducts;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.ViewHolder>
{
    private ArrayList<Row> dataset;

    public RowsAdapter(ArrayList<Row> rows, Context c)
    {
        dataset = rows;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textviewColumn1,textviewColumn2,textviewColumn3;

        public ViewHolder(View itemView)
        {
            super(itemView);
            textviewColumn1 = (TextView) itemView.findViewById(R.id.textView1);
            textviewColumn2 = (TextView) itemView.findViewById(R.id.textView2);
            textviewColumn3 = (TextView) itemView.findViewById(R.id.textView3);
        }
    }

    @NonNull
    public RowsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View rowView = inflater.inflate(R.layout.row_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RowsAdapter.ViewHolder viewHolder,int position){
        Row row = dataset.get(position);
        viewHolder.textviewColumn1.setText(row.column1);
        viewHolder.textviewColumn2.setText(row.column2);
        viewHolder.textviewColumn3.setText(row.column3);
    }
    @Override
    public int getItemCount()
    {
        return dataset.size();
    }
}