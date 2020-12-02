package com.example.testsensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{


    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    private   Sensor accelerometer,gyroscope,magnetometer,light,pressure,temperature,humidity;

    TextView xValue,yValue,zValue;
    TextView gyroXValue,gyroYValue,gyroZValue;
    TextView xMagnetoValue,yMagnetoValue,zMagnetoValue;
    TextView Light,Pressure,Temperature,Humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Accelerometer
        xValue=(TextView)findViewById(R.id.xValue);
        yValue=(TextView)findViewById(R.id.yValue);
        zValue=(TextView)findViewById(R.id.zValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE); //string

        //sensor initialization
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer!=null){

            sensorManager.registerListener((SensorEventListener) this, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Accelerometer Listener");
        }else{
            xValue.setText("Accelerometer Not Supported!");
            yValue.setText("Accelerometer Not Supported!");
            zValue.setText("Accelerometer Not Supported!");
        }



        //Gyroscope
        gyroXValue=(TextView)findViewById(R.id.gyroXValue);
        gyroYValue=(TextView)findViewById(R.id.gyroYValue);
        gyroZValue=(TextView)findViewById(R.id.gyroZValue);


        //sensor initialization
        gyroscope=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(gyroscope!=null){

            sensorManager.registerListener((SensorEventListener) this, gyroscope,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Gyroscope Listener");
        }else{
            gyroXValue.setText("Gyroscope Not Supported!");
            gyroYValue.setText("Gyroscope Not Supported!");
            gyroZValue.setText("Gyroscope Not Supported!");
        }
        //Magnetometer

        xMagnetoValue=(TextView)findViewById(R.id.xMagnetoValue);
        yMagnetoValue=(TextView)findViewById(R.id.yMagnetoValue);
        zMagnetoValue=(TextView)findViewById(R.id.zMagnetoValue);


        //sensor initialization
        magnetometer=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(magnetometer!=null){

            sensorManager.registerListener((SensorEventListener) this, magnetometer,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Accelerometer Listener");
        }else{
            xMagnetoValue.setText("Magnetometer Not Supported!");
            yMagnetoValue.setText("Magnetometer Not Supported!");
            zMagnetoValue.setText("Magnetometer Not Supported!");
        }


        //Light,Pressure,Temperatue,Humidity
        Light=(TextView)findViewById(R.id.Light);
        Pressure=(TextView)findViewById(R.id.Pressure);
        Temperature=(TextView)findViewById(R.id.Temperature);
        Humidity=(TextView)findViewById(R.id.Humidity);


        //sensor initialization
        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(light!=null){

            sensorManager.registerListener((SensorEventListener) this, light,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Light Listener");
        }else{
            Light.setText("Light Not Supported!");

        }

        pressure=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(pressure!=null){

            sensorManager.registerListener((SensorEventListener) this, pressure,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Pressure Listener");
        }else{
            Pressure.setText("Pressure Not Supported!");

        }

        temperature=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperature!=null){

            sensorManager.registerListener((SensorEventListener) this, temperature,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Temperature Listener");
        }else{
            Temperature.setText("Temperature Not Supported!");

        }


        humidity=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(humidity!=null){

            sensorManager.registerListener((SensorEventListener) this,humidity,SensorManager.SENSOR_DELAY_NORMAL);//alt+sft+ent hardware cast

            Log.d(TAG, "onCreate: Registered Humidity Listener");
        }else{
            Humidity.setText("Humidity Not Supported!");

        }




    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor sensor=sensorEvent.sensor;

        if(sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            Log.d(TAG, "onSensorChanged: X: "+sensorEvent.values[0]+ "  Y: "+sensorEvent.values[1]+"  Z: "+sensorEvent.values[2]);
            xValue.setText("xValue: "+sensorEvent.values[0]);
            yValue.setText("yValue: "+sensorEvent.values[1]);
            zValue.setText("zValue: "+sensorEvent.values[2]);

        }
        else if(sensor.getType()==Sensor.TYPE_GYROSCOPE){

            gyroXValue.setText("gyroXValue: "+sensorEvent.values[0]);
            gyroYValue.setText("gyroYValue: "+sensorEvent.values[1]);
            gyroZValue.setText("gyroZValue: "+sensorEvent.values[2]);
        }
        else if(sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){

            xMagnetoValue.setText("xMagnetoValue: "+sensorEvent.values[0]);
            yMagnetoValue.setText("yMagnetoValue: "+sensorEvent.values[1]);
            zMagnetoValue.setText("zMagnetoValue: "+sensorEvent.values[2]);
        }
        else if(sensor.getType()==Sensor.TYPE_LIGHT){
            Light.setText("Light: "+sensorEvent.values[0]);
        }
        else if(sensor.getType()==Sensor.TYPE_PRESSURE){
            Pressure.setText("Pressure: "+sensorEvent.values[0]);
        }
        else if(sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE){
            Temperature.setText("Temperature: "+sensorEvent.values[0]);
        }
        else if(sensor.getType()==Sensor.TYPE_RELATIVE_HUMIDITY){
            Humidity.setText("Humidity: "+sensorEvent.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}



