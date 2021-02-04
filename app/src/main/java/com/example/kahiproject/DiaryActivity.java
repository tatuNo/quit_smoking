package com.example.kahiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class DiaryActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayadapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinf = getMenuInflater();
        menuinf.inflate(R.menu.add_diary_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.add_note) {
            Intent intent = new Intent(getApplicationContext(), DiaryEditor.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        ListView listview = findViewById(R.id.ListViewDiary);
        SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("notes",MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedpref.getStringSet("notes", null);
        if (set == null) {
            notes.add("Esimerkki, poista pitkällä painalluksella");

        } else {
            notes = new ArrayList(set);
        }

        arrayadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        listview.setAdapter(arrayadapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DiaryEditor.class);
                intent.putExtra("noteId", position);
                startActivity(intent);

            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int itemToDelete = position;

                new AlertDialog.Builder(DiaryActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Oletko varma?")
                        .setMessage("Haluatko poistaa muistiinpanon?")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(itemToDelete);
                                arrayadapter.notifyDataSetChanged();
                                SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("notes",MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(DiaryActivity.notes);
                                sharedpref.edit().putStringSet("notes", set).apply();
                            }
                        })
                        .setNegativeButton("Ei", null)
                        .show();

                return true;
            }
        });
    }
}

