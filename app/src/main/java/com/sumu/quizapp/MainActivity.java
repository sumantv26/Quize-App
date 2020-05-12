package com.sumu.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.radio_button_true)
    RadioButton radioButtonQ1;
    @BindView(R.id._1991)
    RadioButton radioButtonQ2;
    @BindView(R.id.int_check_box)
    CheckBox checkBox1Q3;
    @BindView(R.id.double_check_box)
    CheckBox checkBox2Q3;
    @BindView(R.id.float_check_box)
    CheckBox checkBox3Q3;
    @BindView(R.id.obj_check_box)
    CheckBox checkBox4Q3;
    @BindView(R.id.q_4_edit_text)
    EditText editTextQ4;
    @BindView(R.id.q_5_edit_text)
    EditText editTextQ5;
    private int points = 0;
    private int pointOfQ1 = 0;
    private int pointOfQ2 = 0;
    private int pointOfQ3 = 0;
    private int pointOfQ4 = 0;
    private int pointOfQ5 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
}
    public void submit(View view) {
        if (radioButtonQ1.isChecked())
            pointOfQ1=1;
        else
            pointOfQ1=0;
        if (radioButtonQ2.isChecked())
            pointOfQ2=1;
        else
            pointOfQ2=0;
        if(checkBox1Q3.isChecked()
                && checkBox2Q3.isChecked()
                && checkBox3Q3.isChecked()
                && !checkBox4Q3.isChecked())

            pointOfQ3=1;
        else
            pointOfQ3=0;

        if(!TextUtils.isEmpty(editTextQ4.getText().toString())&&!TextUtils.isEmpty(editTextQ5.getText().toString())) {

            if (Integer.parseInt(editTextQ4.getText().toString()) == 2)
                pointOfQ4 = 1;
            else
                pointOfQ4 = 0;
            if (Integer.parseInt(editTextQ5.getText().toString()) == 6)
                pointOfQ5 = 1;
            else
                pointOfQ5 = 0;
            points=pointOfQ1+pointOfQ2+pointOfQ3+pointOfQ4+pointOfQ5;
            Toast.makeText(MainActivity.this,points+ " out of 5 is correct ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Please Fill All Text Fields",Toast.LENGTH_SHORT).show();
        }
    }
}
