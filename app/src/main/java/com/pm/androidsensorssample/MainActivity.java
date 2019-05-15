package com.pm.androidsensorssample;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //To get access to device hardware info of sensors
    SensorManager sensorManager;

    TextView sensorsListTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorsListTV = findViewById(R.id.sensors_list);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        getPhoneSensorList();
    }

    private void getPhoneSensorList() {
        List<Sensor> sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        String listSensorString = "";

        for (Sensor s : sensorsList) {
            listSensorString += s.getName() + "\n";
        }
        sensorsListTV.setVisibility(View.VISIBLE);
        sensorsListTV.setText(listSensorString);
    }


}
