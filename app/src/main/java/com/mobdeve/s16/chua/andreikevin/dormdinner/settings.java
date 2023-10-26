package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {

    SeekBar sliderSettings;
    TextView sliderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        this.sliderSettings = (SeekBar) findViewById(R.id.sliderSettings);
        this.sliderValue = (TextView) findViewById(R.id.sliderValue);

        sliderSettings.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    // When the progress value has changed
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        sliderValue.setText(String.valueOf(progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
                );
    }
}