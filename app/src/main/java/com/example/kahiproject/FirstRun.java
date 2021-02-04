package com.example.kahiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import static com.example.kahiproject.DataProccessor.PREFS_NAME;
import static com.example.kahiproject.StartActivity.timeMSG;

public class FirstRun extends AppCompatActivity {

    public static final String muchMSG = "howmuch";
    public static final String packsMSG = "packs";
    public static final String priceMSG = "price";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();

        }
    public void jatkaPressed (View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        DataProccessor dataproc = new DataProccessor(this);


        EditText howmuch = findViewById(R.id.editText);
        EditText packs = findViewById(R.id.editText2);
        EditText price = findViewById(R.id.editText3);

        String value = howmuch.getText().toString();
        int howmuchvalue = Integer.parseInt(value);

        String valuex = packs.getText().toString();
        int cigsinpackvalue = Integer.parseInt(valuex);

        String valuey = price.getText().toString();
        float packpricevalue = Float.parseFloat(valuey);


        dataproc.setInt(muchMSG,howmuchvalue);
        dataproc.setInt(packsMSG,cigsinpackvalue);
        dataproc.setFloat(priceMSG,packpricevalue);
    }
}
