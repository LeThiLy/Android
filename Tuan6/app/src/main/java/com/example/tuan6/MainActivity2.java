package com.example.tuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgChairDt;
    TextView tvPriceDt, tbNameDt, tvSoDt;
    ImageButton imgbtn_plusDt, getImgbtn_minusDt;
    //
    Chair mChair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgChairDt=findViewById(R.id.imgChairDt);
        tvPriceDt=findViewById(R.id.tvPriceDt);
        tbNameDt=findViewById(R.id.tbNameDt);
        tvSoDt=findViewById(R.id.tvSoDt);
        imgbtn_plusDt=findViewById(R.id.imgbtn_plusDt);
        getImgbtn_minusDt=findViewById(R.id.getImgbtn_minusDt);

        Intent intent=getIntent();

        if(intent!=null){
            mChair= (Chair) intent.getSerializableExtra("key1");
            tbNameDt.setText(mChair.getName());
            tvPriceDt.setText(mChair.getPrice()+"");
            imgChairDt.setImageResource(mChair.getAnh());
        }
    }
}