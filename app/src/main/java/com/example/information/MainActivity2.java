package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView name, phone, gender, level, age, sport, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    name = findViewById(R.id.name_data);
    phone = findViewById(R.id.phone_data);
    gender = findViewById(R.id.gender_data);
    level = findViewById(R.id.level_data);
    age = findViewById(R.id.age_data);
    sport = findViewById(R.id.sport_data);
    music = findViewById(R.id.music_data);
    Intent intent = getIntent();

    String data_name = intent.getStringExtra("Name_data");
    name.setText(data_name);
    String data_phone = intent.getStringExtra("Phone_data");
    phone.setText(data_phone);
    String data_gender = intent.getStringExtra("Gender_data");
    gender.setText(data_gender);
    String data_level = intent.getStringExtra("Level_data");
    level.setText(data_level);
    String data_age = intent.getStringExtra("Age_data");
    age.setText(data_age);
    String data_sport = intent.getStringExtra("Sport_data");
    sport.setText(data_sport);
    String data_music = intent.getStringExtra("Music_data");
    music.setText(data_music);
    }
}