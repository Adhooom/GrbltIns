package com.example.ad3am.grbltins.view;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ad3am.grbltins.R;
import com.example.ad3am.grbltins.model.NewInspectionFormBojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewInspectionForm extends AppCompatActivity implements View.OnClickListener {
    //report card elements
    LinearLayout mReportCardLinearLayout;
    ImageView reportCardArrow;
    EditText reportCardWayNameEt;
    Spinner reportCardRoadNumSpinner;
    ImageView reportCardDate;
    TextView reportCardDateText;
    //details card elements
    LinearLayout mDetailsCardLinearLayout;
    ImageView detailsCardArrow;
    Spinner detailsCardAreaSpinner;
    Spinner detailsCardRoadTypeSpinner;
    EditText detailsCardRoadImportantsEt;
    EditText detailsCardRoadExplanationEt;
    Spinner detailsCardFloorSignSpinner;
    Spinner detailsCardUpperSignSpinner;
    //information card elements
    LinearLayout mInformationCardLinearLayout;
    ImageView informationCardArrow;
    EditText informationCardActualSpeedEt;
    EditText informationCardSpeedDesignEt;
    EditText informationCardTrafficReportEt;
    EditText informationCardProgressOperationEt;
    EditText informationCardKmLocationEt;
    EditText informationCardAccidentNumEt;
    EditText informationCardKilledNumEt;
    EditText informationCardInjuryNumEt;
    //passsing card
    LinearLayout mPassingCardLinearLayout;
    ImageView passingCardArrow;
    EditText passingCardFirstNote;
    EditText passingCardSecondNote;
    EditText passingCardThirdNote;
    EditText passingCardForthLiningNote;
    EditText passingCardForthReflectionsNote;
    EditText passingCardForthUpperSignsNote;
    EditText passingCardForthFloorSignsNote;
    EditText passingCardFifthNote;
    EditText passingCardsixthSafeSpaces;
    EditText passingCardsixthRandoumTurn;
    EditText passingCardsixthWeatherEffect;
    //advices card
    LinearLayout mAdvicesCardLinearLayout;
    ImageView advicesCardArrow;
    EditText advicesCardShortTermOne;
    EditText advicesCardShortTermTwo;
    EditText advicesCardShortTermThree;
    EditText advicesCardShortTermFour;
    EditText advicesCardShortTermFive;
    EditText advicesCardLongTermOne;
    EditText advicesCardLongTermTwo;
    EditText advicesCardLongTermThree;
    EditText advicesCardLongTermFour;
    EditText advicesCardLongTermFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inspection_form);
        init();
        getData();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewInspectionForm.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void init() {
        //first card
        mReportCardLinearLayout = findViewById(R.id.report_card_content_layout);
        reportCardArrow = findViewById(R.id.report_card_arrow);
        reportCardArrow.setOnClickListener(this);
        reportCardWayNameEt = findViewById(R.id.report_card_wayname_et);
        reportCardRoadNumSpinner = findViewById(R.id.report_card_way_num_spinner);
        reportCardDateText = findViewById(R.id.report_card_date_tv);
        reportCardDate = findViewById(R.id.new_inspection_report_card_date_iv);
        reportCardDate.setOnClickListener(this);
        //second card
        mDetailsCardLinearLayout = findViewById(R.id.details_card_content_layout);
        detailsCardArrow = findViewById(R.id.details_card_arrow);
        detailsCardArrow.setOnClickListener(this);
        detailsCardAreaSpinner = findViewById(R.id.details_card_spinner_area);
        detailsCardRoadTypeSpinner = findViewById(R.id.details_card_spinner_road_type);
        detailsCardRoadImportantsEt = findViewById(R.id.details_card_et_road_importants);
        detailsCardRoadExplanationEt = findViewById(R.id.details_card_et_road_explanation);
        detailsCardFloorSignSpinner = findViewById(R.id.details_card_spinner_floor_sign_statue);
        detailsCardUpperSignSpinner = findViewById(R.id.details_card_spinner_upper_sign_statue);
        //third card
        mInformationCardLinearLayout = findViewById(R.id.information_card_content_layout);
        informationCardArrow = findViewById(R.id.information_card_arrow);
        informationCardArrow.setOnClickListener(this);
        informationCardActualSpeedEt = findViewById(R.id.information_card_et_speed_actual);
        informationCardSpeedDesignEt = findViewById(R.id.information_card_et_speed_design);
        informationCardTrafficReportEt = findViewById(R.id.information_card_et_traffic_report);
        informationCardProgressOperationEt = findViewById(R.id.information_card_et_progress_operations);
        informationCardKmLocationEt = findViewById(R.id.information_card_et_km_location);
        informationCardAccidentNumEt = findViewById(R.id.information_card_et_accident_num);
        informationCardKilledNumEt = findViewById(R.id.information_card_et_killed_num);
        informationCardInjuryNumEt = findViewById(R.id.information_card_et_injurd_num);
        //forth card
        mPassingCardLinearLayout = findViewById(R.id.passing_card_content_layout);
        passingCardArrow = findViewById(R.id.passing_card_arrow);
        passingCardArrow.setOnClickListener(this);
        passingCardFirstNote = findViewById(R.id.passing_card_et_first_note);
        passingCardSecondNote = findViewById(R.id.passing_card_et_second_note);
        passingCardThirdNote = findViewById(R.id.passing_card_et_third_note);
        passingCardForthLiningNote = findViewById(R.id.passing_card_et_forth_lining);
        passingCardForthReflectionsNote = findViewById(R.id.passing_card_forth_et_reflections);
        passingCardForthUpperSignsNote = findViewById(R.id.passing_card_forth_et_upper_signs);
        passingCardForthFloorSignsNote = findViewById(R.id.passing_card_forth_et_floor_signs);
        passingCardFifthNote = findViewById(R.id.passing_card_fifth_note);
        passingCardsixthSafeSpaces = findViewById(R.id.passing_card_sixth_et_safe_spaces);
        passingCardsixthRandoumTurn = findViewById(R.id.passing_card_sixth_et_randoum_turn);
        passingCardsixthWeatherEffect = findViewById(R.id.passing_card_sixth_et_weather_effect);
        //fivth card
        mAdvicesCardLinearLayout = findViewById(R.id.advices_card_content_layout);
        advicesCardArrow = findViewById(R.id.advices_card_arrow);
        advicesCardArrow.setOnClickListener(this);
        advicesCardShortTermOne = findViewById(R.id.advices_card_et_shorterm_one);
        advicesCardShortTermTwo = findViewById(R.id.advices_card_et_shorterm_two);
        advicesCardShortTermThree = findViewById(R.id.advices_card_et_shorterm_three);
        advicesCardShortTermFour = findViewById(R.id.advices_card_et_shorterm_four);
        advicesCardShortTermFive = findViewById(R.id.advices_card_et_shorterm_five);
        advicesCardLongTermOne = findViewById(R.id.advices_card_et_longterm_one);
        advicesCardLongTermTwo = findViewById(R.id.advices_card_et_longterm_two);
        advicesCardLongTermThree = findViewById(R.id.advices_card_et_longterm_three);
        advicesCardLongTermFour = findViewById(R.id.advices_card_et_longterm_four);
        advicesCardLongTermFive = findViewById(R.id.advices_card_et_longterm_five);


        initSpinnersDialog();
    }

    public void getData() {
        //first card
        String wayName = reportCardWayNameEt.getText().toString();
        String wayNum = reportCardRoadNumSpinner.getSelectedItem().toString();
        String date = reportCardDateText.getText().toString();
        //second card
        String area = detailsCardAreaSpinner.getSelectedItem().toString();
        String roadType = detailsCardRoadTypeSpinner.getSelectedItem().toString();
        String roadImportants = detailsCardRoadImportantsEt.getText().toString();
        String roadExplanition = detailsCardRoadExplanationEt.getText().toString();
        String floorSign = detailsCardFloorSignSpinner.getSelectedItem().toString();
        String upperSign = detailsCardUpperSignSpinner.getSelectedItem().toString();
        //third card
        String actualSpeed = informationCardActualSpeedEt.getText().toString();
        String designSpeed = informationCardSpeedDesignEt.getText().toString();
        String trafficReport = informationCardTrafficReportEt.getText().toString();
        String progressOperation = informationCardProgressOperationEt.getText().toString();
        String kmLocation = informationCardKmLocationEt.getText().toString();
        String accidentNum = informationCardAccidentNumEt.getText().toString();
        String killedNum = informationCardKilledNumEt.getText().toString();
        String injuryNum = informationCardInjuryNumEt.getText().toString();
        //forth card
        String firstNote = passingCardFirstNote.getText().toString();
        String secondNote = passingCardSecondNote.getText().toString();
        String thirdNotes = passingCardThirdNote.getText().toString();
        String liningNote = passingCardForthLiningNote.getText().toString();
        String reflectionNote = passingCardForthReflectionsNote.getText().toString();
        String upperSignsNotes = passingCardForthUpperSignsNote.getText().toString();
        String floorSignsNotes = passingCardForthFloorSignsNote.getText().toString();
        String fifthNote = passingCardFifthNote.getText().toString();
        String safeSpaces = passingCardsixthSafeSpaces.getText().toString();
        String randomTurns = passingCardsixthRandoumTurn.getText().toString();
        String weatherEffect = passingCardsixthWeatherEffect.getText().toString();
        //fivth card
        String shortTermOne = advicesCardShortTermOne.getText().toString();
        String shortTermTwo = advicesCardShortTermTwo.getText().toString();
        String shortTermThree = advicesCardShortTermThree.getText().toString();
        String shortTermFour = advicesCardShortTermFour.getText().toString();
        String shortTermFive = advicesCardShortTermFive.getText().toString();
        String longTermOne = advicesCardLongTermOne.getText().toString();
        String longTermTwo = advicesCardLongTermTwo.getText().toString();
        String longTermThree = advicesCardLongTermThree.getText().toString();
        String longTermFour = advicesCardLongTermFour.getText().toString();
        String longTermFive = advicesCardLongTermFive.getText().toString();

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.report_card_arrow:
                    arrowFunction(mReportCardLinearLayout, reportCardArrow);
                    break;
                case R.id.new_inspection_report_card_date_iv:
                    dateDialog();
                    break;
                case R.id.details_card_arrow:
                    arrowFunction(mDetailsCardLinearLayout, detailsCardArrow);
                    break;
                case R.id.information_card_arrow:
                    arrowFunction(mInformationCardLinearLayout, informationCardArrow);
                    break;
                case R.id.passing_card_arrow:
                    arrowFunction(mPassingCardLinearLayout, passingCardArrow);
                    break;
                case R.id.advices_card_arrow:
                    arrowFunction(mAdvicesCardLinearLayout, advicesCardArrow);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dateDialog() {
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

    private void initSpinnersDialog() {
        try {
            ArrayAdapter<CharSequence> wayNumSpinner = ArrayAdapter.createFromResource(this, R.array.waynumbers
                    , android.R.layout.simple_spinner_item);

            wayNumSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            reportCardRoadNumSpinner.setAdapter(wayNumSpinner);

            ArrayAdapter<CharSequence> area = ArrayAdapter.createFromResource(this, R.array.area,
                    android.R.layout.simple_spinner_item);
            area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            detailsCardAreaSpinner.setAdapter(area);

            ArrayAdapter<CharSequence> roadType = ArrayAdapter.createFromResource(this, R.array.roads,
                    android.R.layout.simple_spinner_item);
            roadType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            detailsCardRoadTypeSpinner.setAdapter(roadType);

            ArrayAdapter<CharSequence> statue = ArrayAdapter.createFromResource(this, R.array.statue,
                    android.R.layout.simple_spinner_item);
            statue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            detailsCardFloorSignSpinner.setAdapter(statue);
            detailsCardUpperSignSpinner.setAdapter(statue);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void arrowFunction(LinearLayout linearLayout, ImageView imageView) {
        if (linearLayout.getVisibility() == View.GONE) {
            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.collaps);
        } else if (linearLayout.getVisibility() == View.VISIBLE) {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.expand);
        }
    }
}
