package com.example.kahiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static com.example.kahiproject.StartActivity.TIMEELAPSED;

public class HealthActivity extends AppCompatActivity {
    ProgressBar bloodpressure;
    ProgressBar oxygen;
    ProgressBar bloodNic;
    ProgressBar taste;
    ProgressBar lungs;
    ProgressBar dependence;
    ProgressBar bloodcirc;
    ProgressBar insulin;

    TextView bloodpressureText;
    TextView oxygenText;
    TextView nicotineText;
    TextView tasteText;
    TextView lungsText;
    TextView depenceText;
    TextView bloodCircText;
    TextView insulinText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        Bundle extras = getIntent().getExtras();
        int scale = 100000;
        long scaleLong = 100000;
        long currentprogress = extras.getLong(TIMEELAPSED);

        bloodpressure = findViewById(R.id.progressBarbloodpsr);
        bloodpressureText = findViewById(R.id.bloodprText);
        int bloodpressuremax = 7200000 / scale;
        bloodpressure.setMax(bloodpressuremax);
        currentprogress /= scaleLong;
        int progress = (int) currentprogress;
        bloodpressure.setProgress(progress);
        if (progress >= bloodpressuremax) {
            String maxprc = Integer.toString(100);
            bloodpressureText.setText(maxprc + "%");
        } else {
            double percent = Math.round ((( progress / (double) bloodpressuremax) * 100.0) * 10) / 10.0;
            String percentstring = Double.toString(percent);
            bloodpressureText.setText(percentstring + "%");
        }

        oxygen = findViewById(R.id.progressBarOx);
        oxygenText = findViewById(R.id.oxygenTxt);
        int oxygenmax = 43200000/ scale;
        oxygen.setMax(oxygenmax);
        oxygen.setProgress(progress);
        if (progress >= oxygenmax) {
            String maxprc = Integer.toString(100);
            oxygenText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress / (double)oxygenmax) * 100.0) *10) / 10.0;
            String percentstring = Double.toString(percent);
            oxygenText.setText(percentstring + "%");
        }

        bloodNic = findViewById(R.id.progressBarNic);
        nicotineText = findViewById(R.id.nicotineTxt);
        int bloodNicmax = 86400000 / scale;
        bloodNic.setMax(bloodNicmax);
        bloodNic.setProgress(progress);
        if (progress >= bloodNicmax) {
            String maxprc = Integer.toString(100);
            nicotineText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress /(double) bloodNicmax) * 100.0) *10) / 10.0;
            String percentstring = Double.toString(percent);
            nicotineText.setText(percentstring + "%");
        }

        taste = findViewById(R.id.progressBarTaste);
        tasteText = findViewById(R.id.tasteTxt);
        int tastemax = 172800000 / scale;
        taste.setMax(tastemax);
        taste.setProgress(progress);
        if (progress >= tastemax) {
            String maxprc = Integer.toString(100);
            tasteText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress / (double) tastemax) * 100.0) *10) / 10.0;
            String percentstring = Double.toString(percent);
            tasteText.setText(percentstring + "%");
        }

        lungs = findViewById(R.id.progressBarLungs);
        lungsText = findViewById(R.id.lungsTxt);
        int lungsmax = 259200000 / scale;
        lungs.setMax(lungsmax);
        lungs.setProgress(progress);
        if (progress >= lungsmax) {
            String maxprc = Integer.toString(100);
            lungsText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress / (double) lungsmax)* 100.0) *10) / 10.0;
            String percentstring = Double.toString(percent);
            lungsText.setText(percentstring + "%");
        }

        dependence = findViewById(R.id.progressBarDepen);
        depenceText = findViewById(R.id.depenceTxt);
        int depedencemax = 345600000 / scale;
        dependence.setMax(depedencemax);
        dependence.setProgress(progress);
        if (progress >= depedencemax) {
            String maxprc = Integer.toString(100);
            depenceText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress / (double) depedencemax) * 100.0) *10) / 10.0;
            String percentstring = Double.toString(percent);
            depenceText.setText(percentstring + "%");
        }

        bloodcirc = findViewById(R.id.progressBarCircblood);
        bloodCircText = findViewById(R.id.bloodcircTxt);
        int bloodcircmax = 864000000 / scale;
        bloodcirc.setMax(bloodcircmax);
        bloodcirc.setProgress(progress);
        if (progress >= bloodcircmax) {
            String maxprc = Integer.toString(100);
            bloodCircText.setText(maxprc + "%");
        } else {
            double percent = Math.round (((progress / (double) bloodcircmax) * 100) *10) / 10.0;
            String percentstring = Double.toString(percent);
            bloodCircText.setText(percentstring + "%");
        }

        insulin = findViewById(R.id.progressBarInsulin);
        insulinText = findViewById(R.id.insulinTxt);
        int insulinmax = 51840;
        insulin.setMax(insulinmax);
        insulin.setProgress(progress);
        if (progress >= insulinmax) {
            String maxprc = Integer.toString(100);
            insulinText.setText(maxprc +"%");
        } else {
            double percent = Math.round(((progress / (double) insulinmax) * 100) *10) / 10.0;
            String percentstring = Double.toString(percent);
            insulinText.setText(percentstring + "%");
        }



    }
}
