package com.dji.importSDKDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import dji.common.flightcontroller.LocationCoordinate3D;
import dji.common.flightcontroller.FlightControllerState;
import dji.sdk.base.BaseComponent;
import dji.sdk.base.BaseProduct;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.products.Aircraft;
import dji.sdk.sdkmanager.DJISDKInitEvent;
import dji.sdk.sdkmanager.DJISDKManager;
import dji.common.battery.BatteryState;

import dji.sdk.flightcontroller.LandingGear;


public class Pagina1 extends AppCompatActivity {
    BaseProduct mProduct = CAM.getProductInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina1);


        Button homeBtnpagina1 = (Button) findViewById (R.id.homeBtnPagina1);
        homeBtnpagina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeSwitchpagina1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeSwitchpagina1);
            }
        });

        Button getHeading = (Button) findViewById (R.id.btnHeading);
        getHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetHeading();
            }
        });

        Button getBattery = (Button) findViewById (R.id.btnBattery);
        getBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetBatteryInfo();
            }
        });

        Button getHeight = (Button) findViewById (R.id.btnHeight);
        getHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetHeight();
            }
        });

    }

    private void GetHeading()
    {
        TextView infoHeading = findViewById(R.id.txtHeading);
        infoHeading.setText("");

        Aircraft aircraft = (Aircraft) mProduct;
        FlightController flightController = aircraft.getFlightController();
        //showToast("Heading: "+ flightController.getCompass().getHeading());
        String text = flightController.getCompass().getHeading()+"°";
        //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        //toast.show();
        infoHeading.setText(text);


    }

    private void GetBatteryInfo()
    {
        TextView infoProcent = findViewById(R.id.txtBatteryProcent);
        TextView infoCurrent = findViewById(R.id.txtBatteryCurrent);
        TextView infoVoltage = findViewById(R.id.txtBatteryVoltage);
        infoProcent.setText("");
        infoCurrent.setText("");
        infoVoltage.setText("");

        mProduct.getBattery().setStateCallback(new BatteryState.Callback() {
            @Override
            public void onUpdate(BatteryState djiBatteryState) {
                String batteryInfoProcent = djiBatteryState.getChargeRemainingInPercent()+"%";
                String batteryInfoCurrent =  djiBatteryState.getCurrent()+"mA";
                String batteryInfoVoltage = djiBatteryState.getVoltage()+"mV";

                infoProcent.setText(batteryInfoProcent);
                infoCurrent.setText(batteryInfoCurrent);
                infoVoltage.setText(batteryInfoVoltage);
            }
        });
    }
    private void GetHeight()
    {
        TextView infoHeight = findViewById(R.id.txtHeight);
        infoHeight.setText("");

        Aircraft aircraft = (Aircraft) mProduct;
        FlightController flightController = aircraft.getFlightController();
        FlightControllerState flightControllerState = flightController.getState();
        LocationCoordinate3D locationCoordinate3D = flightControllerState.getAircraftLocation();
        //showToast("Heading: "+ flightController.getCompass().getHeading());
        String text = locationCoordinate3D.getAltitude()+"m.";
        //Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        //toast.show();
        infoHeight.setText(text);


    }

}