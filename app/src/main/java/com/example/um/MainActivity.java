package com.example.um;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button save;
    private CalendarView calendar;
    private EditText title,time,note;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = findViewById(R.id.button);
        calendar = findViewById(R.id.calendarView);
        time = findViewById(R.id.editTextTime);
        title = findViewById(R.id.editTextTitle);
        note = findViewById(R.id.editTextNote);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                date = day+"."+(month+1)+"."+year;

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().equals("")){
                    Snackbar.make(view,"Введите название события!",Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Записано!").setMessage("Событие: "+title.getText().toString()+"\nДата: "+date+"\nВремя: "+time.getText().toString()+"\nЗаметки: "+note.getText().toString()).show();
                title.setText("");
                time.setText("");
                note.setText("");
            }
        });
    }
}