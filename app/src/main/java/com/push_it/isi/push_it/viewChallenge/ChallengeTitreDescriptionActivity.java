package com.push_it.isi.push_it.viewChallenge;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.push_it.isi.push_it.R;

public class ChallengeTitreDescriptionActivity extends AppCompatActivity {

    Intent intent;
    Intent accepter;
    TextView tvTitre;
    TextView tvDescription;
    Button btn;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_titre_description);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intent = getIntent();
        tvTitre = (TextView) findViewById(R.id.tvTitre);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        btn = (Button) findViewById(R.id.accepterChallenge);
        ctx = this;

        tvTitre.setText(intent.getStringExtra("titre"));
        tvDescription.setText(intent.getStringExtra("description"));

        if (intent.getStringExtra("numeroChallenge").equals("dix")) {
            tvDescription.setTextSize(27);
        } else if (intent.getStringExtra("numeroChallenge").equals("cinq")) {
            tvDescription.setTextSize(30);
        } else if (intent.getStringExtra("numeroChallenge").equals("sept")) {
            tvDescription.setTextSize(27);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (intent.getStringExtra("numeroChallenge")) {
                    case "un":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+60);
                        accepter.putExtra("nombrePushUp", ""+5);
                        startActivity(accepter);
                        break;
                    case "deux":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+120);
                        accepter.putExtra("nombrePushUp", ""+100);
                        startActivity(accepter);
                        break;
                    case "trois":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+100000);
                        accepter.putExtra("nombrePushUp", ""+25);
                        startActivity(accepter);
                        break;
                    case "quatre":
                        accepter = new Intent(ctx, ChallengeFourActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+3);
                        startActivity(accepter);
                        break;
                    case "cinq":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+60);
                        accepter.putExtra("nombrePushUp", ""+75);
                        startActivity(accepter);
                        break;
                    case "six":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+100000);
                        accepter.putExtra("nombrePushUp", ""+100);
                        startActivity(accepter);
                        break;
                    case "sept":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+60);
                        accepter.putExtra("nombrePushUp", ""+75);
                        startActivity(accepter);
                        break;
                    case "huit":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+90);
                        accepter.putExtra("nombrePushUp", ""+75);
                        startActivity(accepter);
                        break;
                    case "neuf":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+90);
                        accepter.putExtra("nombrePushUp", ""+50);
                        startActivity(accepter);
                        break;
                    case "dix":
                        accepter = new Intent(ctx, ChallengeOneActivity.class);
                        accepter.putExtra("tempsAttribuer", ""+100000);
                        accepter.putExtra("nombrePushUp", ""+60);
                        startActivity(accepter);
                        break;
                }
            }
        });

    }
}
