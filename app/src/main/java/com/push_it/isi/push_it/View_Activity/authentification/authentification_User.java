package com.push_it.isi.push_it.View_Activity.authentification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.push_it.isi.push_it.bdamanager.UsagerManager;
import com.push_it.isi.push_it.entities.Usager;
import com.push_it.isi.push_it.fragment_profil_user.Nav_Profil;
import com.push_it.isi.push_it.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class authentification_User extends Activity {


    EditText courriel, pseudo, mdp, objectif, sexe;
    Button buttonAddUser;
    Button btnVoir;
    LinearLayout llResult;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification_user);

        courriel = (EditText) findViewById(R.id.courrielIns);
        pseudo = (EditText) findViewById(R.id.pseudoIns);
        mdp = (EditText) findViewById(R.id.mdpIns);
        objectif = (EditText) findViewById(R.id.dateIns);
        sexe = (EditText) findViewById(R.id.sexeIns);
        buttonAddUser = (Button) findViewById(R.id.addUserButton);
        btnVoir = (Button) findViewById(R.id.btn_voir);

        llResult = (LinearLayout) findViewById(R.id.ll_result);
        ctx = this;



        // ACTION CLIQUE SUR LE BUTTON AJOUT D'UN USAGER


        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmail(courriel.getText().toString())) {
                    courriel.setError("Email erreur");
                    courriel.requestFocus();

                } else if (!validatePseudo(pseudo.getText().toString())) {
                    pseudo.setError("Pseudo erreur");
                    pseudo.requestFocus();


                } else if (mdp.getText().length() < 5) {
                    mdp.setError("Password erreur. 5 caracteres min ! ");
                    mdp.requestFocus();


                } else if (objectif.getText() == null) {
                    objectif.setText(0);


                } else {


                    Usager user = new Usager(0, courriel.getText().toString(), pseudo.getText().toString(), mdp.getText().toString(), Integer.parseInt(objectif.getText().toString()), sexe.getText().toString());
                    UsagerManager.add(user, ctx);
                    Log.d("debug", user.getPseudo());
                    Log.d("debug", user.getEmail());
                    Log.d("debug", user.getMdp());
                    Log.d("debug", user.getSexe());
                    Log.d("debug", user.getC1() + "");


                    Intent intentConnexion = new Intent(ctx, Nav_Profil.class);
                    intentConnexion.putExtra("User", pseudo.getText().toString());
                    startActivity(intentConnexion);


                }


            }
        });


        btnVoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                llResult.removeAllViews();

                ArrayList<Usager> listEtu = UsagerManager.getAll(ctx);

                Log.d("debug", listEtu.size() + "");

                if (listEtu.size() > 0) {

                    for (Usager user : listEtu) {
                        TextView tv = new TextView(ctx);
                        tv.setText("Pseudo: " + user.getPseudo() + " ,Push-up: " + user.getNbPush_Up() + " ,MDP: " + user.getMdp());
                        llResult.addView(tv);
                    }
                } else
                    Toast.makeText(ctx, "Pas d etudiant dans la base de donnee", Toast.LENGTH_SHORT).show();
            }
        });


    }


    // METHODE DE VALIDATION FORMULAIRE

    private boolean validatePseudo(String pseudonyme) {


        String pseudonymePattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{2,}$";

        Pattern pattern = Pattern.compile(pseudonymePattern);
        Matcher matcher = pattern.matcher(pseudonyme);


        Log.d("debug", matcher.matches() + "");
        return matcher.matches();

    }


    private boolean validateEmail(String email) {

        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();


    }
}
