package com.example.recyclerviewwithmultipleviewtypedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        //Array Initialize array list
        ArrayList<String> arrayList = new ArrayList<>();
        //
        for (int i = 0; i < 40; i++){
            //Add values in Array list
            arrayList.add("Item "+ i);
        }

        //init layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        //Set span size
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //check condition
                if ((position+1) % 5 * 2 == 0){
                    //When position will be in table of 5
                    //Return span size 2
                    return 2;
                }else {
                    //When position will not be in table of 5
                    //return span size 1
                    return 1;
                }
            }
        });
        //Set layout manager
        recyclerView.setLayoutManager(layoutManager);
        //Set Number
        recyclerView.setAdapter(new MainAdapter(this, arrayList));

    }
}