package com.dji.importSDKDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pagina2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina2);

        Button homeBtnpagina2 = (Button) findViewById (R.id.homeBtnPagina2);
        homeBtnpagina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeSwitchpagina2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeSwitchpagina2);
            }
        });
    }
}