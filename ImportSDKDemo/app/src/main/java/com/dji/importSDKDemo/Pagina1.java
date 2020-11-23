package com.dji.importSDKDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pagina1 extends AppCompatActivity {

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
    }
}