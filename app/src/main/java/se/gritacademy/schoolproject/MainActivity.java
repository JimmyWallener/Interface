package se.gritacademy.schoolproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked "+getApplication());


        /*
        * Creating a checkbox that when checked vibrates.
        * */

        checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long[] pattern = {0,100,1000};

                if (isChecked && vibrator.hasVibrator()) {
                    vibrator.vibrate(pattern, 0);
                } else {
                    vibrator.cancel();
                }
            }
        });


        /*
        * Creating night mode by flipping the switch.
        *
        * */
        Switch switchNightMode = findViewById(R.id.nightMode);
        int currentMode = AppCompatDelegate.getDefaultNightMode();

        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            switchNightMode.setChecked(true);

        } else {
            switchNightMode.setChecked(false);
        }

        switchNightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartActivity();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartActivity();
                }
            }
        });
    }


    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked "+getApplication());

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked "+getApplication());
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked "+getApplication());
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked "+getApplication());
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked "+getApplication());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked "+getApplication());
    }
}
