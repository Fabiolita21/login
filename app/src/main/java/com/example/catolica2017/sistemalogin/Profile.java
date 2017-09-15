package com.example.catolica2017.sistemalogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by williamramos on 31/08/17.
 */

public class Profile extends AppCompatActivity {

    private Button btnSair;

    @Override
    protected void onCreate(Bundle bundle) {


        super.onCreate(bundle);

        setContentView(R.layout.profile);

        this.btnSair = (Button) findViewById(R.id.btn_sair);


        this.btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();


            }
        });


    }

}
