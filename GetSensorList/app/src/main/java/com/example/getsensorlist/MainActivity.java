package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextSensors;
    SensorManager sensorManager;
    List<Sensor> sensorlist;
    Button  mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSensors = findViewById(R.id.textSensors);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

            @Override
            public void onClick(View view) {
                sensorManager = (SensorManager)
                        getSystemService(SENSOR_SERVICE);

                sensorlist = sensorManager.getSensorList(Sensor.TYPE_ALL);

                mTextSensors.append("# Sensors:" + sensorlist.size() + ")\n\n");
                for(Sensor sensor : sensorlist) {
                    mTextSensors.append("Sensor name:" + sensor.getName() + "\n");
                    mTextSensors.append("Sensor type:" + sensor.getType() + "\n\n");
                }
            }
}