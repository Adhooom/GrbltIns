package com.example.ad3am.grbltins.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ad3am.grbltins.R;
import com.example.ad3am.grbltins.SqlDataBase.FormDataBase;
import com.example.ad3am.grbltins.model.NewInspectionFormPojo;
import com.example.ad3am.grbltins.model.ViewSavedRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewSaved extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved);
        init();
    }

    public void init() {
        recyclerView = findViewById(R.id.view_saved_reycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FormDataBase db = new FormDataBase(this);
        ArrayList<NewInspectionFormPojo> data = db.view();
        adapter = new ViewSavedRecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}

