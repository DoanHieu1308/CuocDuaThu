package com.example.cuocduathu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnPlay;
    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int number = 3;
                Random random = new Random();
                int one   = random.nextInt(number);
                int two   = random.nextInt(number);
                int three = random.nextInt(number);

                // kiểm tra Win
                if(skOne.getProgress() >= skOne.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One win", Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked())
                    {
                        soDiem += 10;
                    }
                    else
                    {
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem + "");
                    Enable();
                }
                if (skTwo.getProgress() >= skTwo.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two win", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked())
                    {
                        soDiem += 10;
                    }
                    else
                    {
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem + "");
                    Enable();
                }
                if(skThree.getProgress() >= skThree.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three win", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked())
                    {
                        soDiem += 10;
                    }
                    else
                    {
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem + "");
                    Enable();
                }

                skOne.setProgress(skOne.getProgress()+one);
                skTwo.setProgress(skTwo.getProgress()+two);
                skThree.setProgress(skThree.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked())
                {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    ibtnPlay.setVisibility(view.INVISIBLE);
                    countDownTimer.start();

                    Disable();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui long dat cuoc truoc khi choi!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });
    }
    private void Enable()
    {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);

    }
    private void Disable()
    {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void Anhxa()
    {
        txtDiem  = (TextView) findViewById(R.id.textviewDiemso);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        cbOne    = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo    = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree  = (CheckBox) findViewById(R.id.checkboxThree);
        skOne    = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo    = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree  = (SeekBar) findViewById(R.id.seekbarThree);

    }
}