package com.example.ad3am.grbltins;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewInspectionForm extends AppCompatActivity implements View.OnClickListener  {
    //report card elements
    CardView newInspectionReportCard;
    ImageView reportCardArrow;
    Spinner newInspectionRoadNumSpinner;
    ImageView reportCardDate;
    TextView reportCardDateText;
    //project details
    Spinner newInspectionAreaSpinner;
    Spinner newInspectionRoadTypeSpinner;
    Spinner newInspectionFloorSignSpinner;
    Spinner newInspectionUpperSignSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inspection_form);
        init();
    }

    public void init() {
        //first card
        newInspectionReportCard = findViewById(R.id.new_inspection_report_card);
        reportCardArrow = findViewById(R.id.new_inspection_report_card_arrow);
        newInspectionRoadNumSpinner = findViewById(R.id.new_inspection_spinner_way_num);
        reportCardDateText = findViewById(R.id.new_inspection_report_card_date_tv);
        //second card
        newInspectionAreaSpinner = findViewById(R.id.new_inspection_spinner_area);
        newInspectionRoadTypeSpinner = findViewById(R.id.new_inspection_spinner_road_taype);
        newInspectionFloorSignSpinner=findViewById(R.id.new_inspection_spinner_floor_sign_statue);
        newInspectionUpperSignSpinner=findViewById(R.id.new_inspection_spinner_upper_sign_statue);
        //


        reportCardArrow.setOnClickListener(this);

        initSpinnersDialog();

        View view = getLayoutInflater().inflate(R.layout.activity_new_inspection_form, null, false);
        initDialog(view);
        reportCardDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_inspection_report_card_arrow:
                ViewGroup.LayoutParams params = newInspectionReportCard.getLayoutParams();
                Log.i("height", String.valueOf(params.height));
                if (params.height == 120) {
                    reportCardArrow.setImageResource(R.drawable.collaps);
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    newInspectionReportCard.setLayoutParams(params);
                } else if (params.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    reportCardArrow.setImageResource(R.drawable.expand);
                    params.height = 120;
                    newInspectionReportCard.setLayoutParams(params);
                }
                break;
            case R.id.new_inspection_report_card_date_iv:
                try {


                    final Calendar myCalendar = Calendar.getInstance();
                    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            myCalendar.set(Calendar.YEAR, year);
                            myCalendar.set(Calendar.MONTH, month);
                            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            String myFormat = "dd/MM/yyyy"; //In which you need put here
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.US);
                            reportCardDateText.setText(simpleDateFormat.format(myCalendar.getTime()));
                        }
                    };
                    new DatePickerDialog(this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }


    private void initDialog(View view) {
        reportCardDate = view.findViewById(R.id.new_inspection_report_card_date_iv);
    }

    private void initSpinnersDialog() {
        try {
            ArrayAdapter<CharSequence> wayNumSpinner = ArrayAdapter.createFromResource(this, R.array.waynumbers
                    , android.R.layout.simple_spinner_item);

            wayNumSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            newInspectionRoadNumSpinner.setAdapter(wayNumSpinner);

            ArrayAdapter<CharSequence> area = ArrayAdapter.createFromResource(this,R.array.area,
                    android.R.layout.simple_spinner_item);
            area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            newInspectionAreaSpinner.setAdapter(area);

            ArrayAdapter<CharSequence> roadType = ArrayAdapter.createFromResource(this,R.array.roads,
                    android.R.layout.simple_spinner_item);
            roadType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            newInspectionRoadTypeSpinner.setAdapter(roadType);

            ArrayAdapter<CharSequence> statue = ArrayAdapter.createFromResource(this,R.array.statue,
                    android.R.layout.simple_spinner_item);
            statue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            newInspectionFloorSignSpinner.setAdapter(statue);
            newInspectionUpperSignSpinner.setAdapter(statue);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}