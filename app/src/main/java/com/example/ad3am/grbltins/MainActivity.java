package com.example.ad3am.grbltins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ad3am.grbltins.SqlDataBase.FormDataBase;
import com.example.ad3am.grbltins.view.NewInspectionForm;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button insert , view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.main_activity_insert_btn);
        view = findViewById(R.id.main_activity_view_btn);
        insert.setOnClickListener(this);
        view.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.main_activity_insert_btn:
            Intent intent = new Intent(this, NewInspectionForm.class);
            startActivity(intent);
            break;
            case R.id.main_activity_view_btn:
                FormDataBase db = new FormDataBase(this);
                List names = db.view();
                for (int i = 0; i<names.size() ; i++ ){
                    Log.i("data","coloum"+ names.get(i));
                }


        }


    }
}

