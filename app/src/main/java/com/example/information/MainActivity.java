package com.example.information;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    MaterialButton btn_regs, btn_cancel ;
    TextView txt_name, txt_phonenum, show;
    Switch btn_gender;
    SeekBar seekBar;
    CheckBox checkBox;
    RadioButton rad_rock, rad_rap, rad_pop_ballad;
    RadioGroup radioGroup;

    String name, phone_num, gender, level, age, sport, music;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (txt_name.getText().toString() != null){
            outState.putString("get_Name", txt_name.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.get("get_Name")!=null){
            txt_name.setText(savedInstanceState.get("get_Name").toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.trinhdo_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btn_cancel = this.findViewById(R.id.btn_cancel);
        txt_name = this.findViewById(R.id.txt_name);
        txt_phonenum = this.findViewById(R.id.txt_phonenum);
        btn_gender = this.findViewById(R.id.btn_gender);
        seekBar = this.findViewById(R.id.seekBar3);
        checkBox = this.findViewById(R.id.chechkbx);
        rad_rock = this.findViewById(R.id.rad_rock);
        rad_rap = this.findViewById(R.id.rad_rap);
        rad_pop_ballad = this.findViewById(R.id.rad_pop_ballad);
        radioGroup = findViewById(R.id.radiogroup);
        btn_regs = this.findViewById(R.id.btn_regs);
        show = this.findViewById(R.id.show);
        int step = 1;
        int max = 91;
        int min = 1;

        seekBar.setMax((max - min) / step);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = (i * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                show.setText("" + i);
                show.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                age = show.getText().toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                name = txt_name.getText().toString();
                phone_num = txt_phonenum.getText().toString();
                level = spinner.getSelectedItem().toString();
                if (btn_gender.isChecked()){
                    gender = "Nữ";
                } else {
                    gender = "Nam";
                }
                if(checkBox.isChecked()){
                    sport = "Có";
                } else {
                    sport = "Không";
                }
                if (rad_rock.isChecked()){
                    music = "RocknRoll";
                } else if (rad_rap.isChecked()) {
                    music = "Rap";
                } else if (rad_pop_ballad.isChecked()) {
                    music = "Pop/Ballad";
                }else {

                    return;
                }
                intent.putExtra("Name_data", name);
                intent.putExtra("Phone_data", phone_num);
                intent.putExtra("Gender_data", gender);
                intent.putExtra("Level_data", level);
                intent.putExtra("Age_data", age);
                intent.putExtra("Sport_data", sport);
                intent.putExtra("Music_data", music);
                startActivity(intent);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_name.setText("");
                txt_phonenum.setText("");
                btn_gender.setChecked(false);
                seekBar.setProgress(1);
                checkBox.setChecked(false);
                spinner.setSelection(0);
                radioGroup.clearCheck();

            }
        });
    }
    public void  onClick(View view){

    }

}