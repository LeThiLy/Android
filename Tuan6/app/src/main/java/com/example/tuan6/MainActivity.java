package com.example.tuan6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClick {
    RecyclerView rcv_chair;
    CustomAdapterChair adt;
    ArrayList<Chair> mChairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_chair=findViewById(R.id.rcv_chair);
        mChairs =new ArrayList<>();

        mChairs.add(new Chair(R.drawable.images1,550, "Matteo Armchair", R.drawable.daucong));
        mChairs.add(new Chair(R.drawable.images2,350, "Morden Armchair", R.drawable.daucong));
        mChairs.add(new Chair(R.drawable.images3,250, "Nice Armchair", R.drawable.daucong));
        mChairs.add(new Chair(R.drawable.images4,350, "Chair", R.drawable.daucong));

        adt=new CustomAdapterChair(mChairs, MainActivity.this);
        rcv_chair.setAdapter(adt);
        rcv_chair.setHasFixedSize(true);
        rcv_chair.setLayoutManager(new GridLayoutManager(this, 2));
    }
///////////////
    @Override
    public void itemClick(Chair chair) {
        Intent intent=new Intent(MainActivity.this, MainActivity2.class);
        //implements Serializable ở class Chair thì k lỗi
        intent.putExtra("key1", chair);
        startActivity(intent);
    }
}