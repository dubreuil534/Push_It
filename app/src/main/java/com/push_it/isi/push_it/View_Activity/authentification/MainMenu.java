package com.push_it.isi.push_it.View_Activity.authentification;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


import com.push_it.isi.push_it.R;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {


    ArrayList<String> descriptionText = new ArrayList<String>();
    ArrayList<String> titleText = new ArrayList<String>();
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    TextView descriptionView;
    TextView titleView;
    Button inscriptionBtn;
    Button connectionBtn;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descriptionText.add("Inscrivez-vous pour vivre l'experience Push-it gratuitement sur votre mobile");
        descriptionText.add("Defier vos amis avec vos statistiques mensuel ou bien de l'affronter en direct");
        descriptionText.add("Creer vos propre entrainement personnaliser et donnez-vous des objetifs ");
        titleText.add("Bienvenue");
        titleText.add("Challenge");
        titleText.add("Statistique");


        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        inscriptionBtn = (Button) findViewById(R.id.inscription);
        connectionBtn = (Button) findViewById(R.id.connectionBtn);
        ctx=this;


         descriptionView = (TextView) findViewById(R.id.description);
         titleView = (TextView) findViewById(R.id.title);
        descriptionView.setText(descriptionText.get(0));
        titleView.setText(titleText.get(0));

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                descriptionView.setText(descriptionText.get(0));
                titleView.setText(titleText.get(0));
                descriptionView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_out_right));
                titleView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_out_right));

            }

        });


        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                descriptionView.setText(descriptionText.get(1));
                titleView.setText(titleText.get(1));
                descriptionView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_out_right));
                titleView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_out_right));

            }

        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                descriptionView.setText(descriptionText.get(2));
                titleView.setText(titleText.get(2));
                descriptionView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_in_left));
                titleView.setAnimation(AnimationUtils.loadAnimation(MainMenu.this,android.R.anim.slide_in_left));

            }

        });

        inscriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ctx, authentification_User.class);
                startActivity(intent1);

            }
        });

        connectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ctx, Login_In.class);
                startActivity(intent2);
            }
        });




    }
}
