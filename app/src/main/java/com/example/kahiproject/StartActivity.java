package com.example.kahiproject;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.kahiproject.FirstRun.muchMSG;
import static com.example.kahiproject.FirstRun.packsMSG;
import static com.example.kahiproject.FirstRun.priceMSG;
import static com.example.kahiproject.DataProccessor.PREFS_NAME;

public class StartActivity extends AppCompatActivity {

    public Chronometer chronometer;
    public static final String timeMSG = "time";
    public static final String TIMEELAPSED = "TimeToHealthActivity";
    public DataProccessor dataproc = new DataProccessor(this);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinf = getMenuInflater();
        menuinf.inflate(R.menu.start_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(getApplicationContext(), FirstRun.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(StartActivity.this,FirstRun.class));
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
        savings();
        chronometer = findViewById(R.id.chrono);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h   = (int)(elapsedMillis /3600000);
                int m = (int)(elapsedMillis - h*3600000)/60000;
                int s= (int)(elapsedMillis - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                chronometer.setText(hh+":"+mm+":"+ss);
            }
        });
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if(preferences.contains(timeMSG)) {

            long time = dataproc.getLong(timeMSG);
            long timeelapsed = SystemClock.elapsedRealtime() - time;
            chronometer.setBase(timeelapsed);
            chronometer.start();
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        }
    }
    @Override
    public void onStop () {
        super.onStop();
        DataProccessor dataprocs = new DataProccessor(this);
        long timesave = SystemClock.elapsedRealtime();
        dataprocs.setLong(timeMSG,timesave);
    }
    public void cigsPassed (View view) {
        int howmuch = dataproc.getInt(muchMSG);
        long elapsed = (SystemClock.elapsedRealtime()-chronometer.getBase());
        CigsPassed cigs = new CigsPassed(elapsed, howmuch);
        cigs.passedcigs();
        Toast.makeText(getApplicationContext(),cigs.toString(), Toast.LENGTH_LONG).show();
    }
    public void liferegained (View view) {
        int howmuch = dataproc.getInt(muchMSG);
        long elapsed = (SystemClock.elapsedRealtime()-chronometer.getBase());
        CigsPassed lifetime = new CigsPassed(elapsed, howmuch);
        lifetime.passedcigs();
        lifetime.lifetimeregained();
        Toast.makeText(getApplicationContext(),lifetime.toString2(),Toast.LENGTH_LONG).show();
    }

    public void moneySaved (View view) {
        long elapsed = (SystemClock.elapsedRealtime()-chronometer.getBase());
        int howmuch = dataproc.getInt(muchMSG);
        int cigsinpack = dataproc.getInt(packsMSG);
        float price = dataproc.getFloat(priceMSG);
        Money massi = new Money (elapsed, howmuch, cigsinpack, price);
        massi.savedMoney();
        Toast.makeText(getApplicationContext(),massi.toString(),Toast.LENGTH_LONG).show();
    }

    public void tipsPressed (View view) {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }

    public void healthPressed (View view) {
        Intent intent = new Intent (this, HealthActivity.class);
        intent.putExtra(TIMEELAPSED, SystemClock.elapsedRealtime()-chronometer.getBase());
        startActivity(intent);
    }
    public void diaryPressed (View view) {
        Intent intent = new Intent (this, DiaryActivity.class);
        startActivity(intent);
    }
    public void savings () {
        int howmuch = dataproc.getInt(muchMSG);
        int cigsinpack = dataproc.getInt(packsMSG);
        float price = dataproc.getFloat(priceMSG);
        LongtimeSavings savingsMonth = new LongtimeSavings(howmuch, cigsinpack, price);
        LongtimeSavings savingsYear = new LongtimeSavings(howmuch, cigsinpack, price);
        LongtimeSavings savingsFiveyears = new LongtimeSavings(howmuch, cigsinpack, price);
        LongtimeSavings savingsTenyears = new LongtimeSavings(howmuch, cigsinpack, price);

        TextView monthview = findViewById(R.id.onemonth);
        monthview.setText("\n\n     " +savingsMonth.onemonth() + "€");

        TextView yearview = findViewById(R.id.oneyear);
        yearview.setText("\n\n     " +savingsYear.oneyear() + "€");

        TextView fiveyearsview = findViewById(R.id.fiveyears);
        fiveyearsview.setText("\n\n     " +savingsFiveyears.fiveyear() + "€");

        TextView tenyearview = findViewById(R.id.tenyears);
        tenyearview.setText("\n\n     " +savingsTenyears.tenyears() + "€");

    }
}