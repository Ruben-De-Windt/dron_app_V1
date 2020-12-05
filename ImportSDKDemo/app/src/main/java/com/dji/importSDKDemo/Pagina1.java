package com.dji.importSDKDemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dji.common.battery.BatteryState;
import dji.sdk.base.BaseProduct;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.products.Aircraft;

public class Pagina1 extends AppCompatActivity {
    private static BaseProduct mProduct;

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
    }

    private void GetHeading()
    {
        TextView infoHeading = findViewById(R.id.txtHeading);
        infoHeading.setText("");

        Aircraft aircraft = (Aircraft) mProduct;
        FlightController flightController = aircraft.getFlightController();
        //showToast("Heading: "+ flightController.getCompass().getHeading());
        String text = "Heading: " + flightController.getCompass().getHeading();
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
                String batteryInfoProcent = "BatteryEnergyRemainingPercent: " + djiBatteryState.getChargeRemainingInPercent()+"%";
                String batteryInfoCurrent =  "CurrentCurrent: : "+djiBatteryState.getCurrent()+"mA";
                String batteryInfoVoltage = "CurrentVoltage: : "+djiBatteryState.getVoltage()+"mV";

                infoProcent.setText(batteryInfoProcent);
                infoCurrent.setText(batteryInfoCurrent);
                infoVoltage.setText(batteryInfoVoltage);
            }
        });
    }

    public void GetHeading(View view) {
    }

    public void GetBatteryInfo(View view) {
    }
}