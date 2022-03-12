package com.example.recyclerviewwithmultipleviewtypedemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();

    public MainAdapter(Context context, ArrayList<String> arrayList) {
        this.arrayList=arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Init View
        View view;
        if (viewType == 2){
            //When view type is equal to 2
            //Inflate man2 layout
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main2, parent, false);
        }else {
            //When view type is equal to 1
            //Inflate main1 layout
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main1, parent, false);
        }
        //Return holder view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set text on text view
        holder.text_view.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {

        //Check condition
        if ((position+1) % 5 * 2 == 0){
            //When position in table of 5
            //Return main 2
            return 2;
        }else {
            //When position not in table 5
            return 1;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_view = itemView.findViewById(R.id.text_view);

        }
    }
}
