package com.example.ad3am.grbltins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity       {
    ImageView collapse;
    CardView reportcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inspection_form);
//
//        reportcard = findViewById(R.id.form_card_report);
//        collapse = findViewById(R.id.form_iv_collaps);
//        collapse.setOnClickListener(this);
    }

//    public void onClick(View view){
//        if (R.id.form_iv_collaps==view.getId()){
//            ViewGroup.LayoutParams params = reportcard.getLayoutParams();
//            if (params.height == ViewGroup.LayoutParams.WRAP_CONTENT){
//                params.height = 100;
//                reportcard.setLayoutParams(params);
//                collapse.setImageResource(R.drawable.collaps);
//            }else if (params.height == 100){
//                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                reportcard.setLayoutParams(params);
//                collapse.setImageResource(R.drawable.expand);
//            }
//        }
//    }

    }

