package com.push_it.isi.push_it.View_Activity.authentification;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.push_it.isi.push_it.bdamanager.UsagerManager;
import com.push_it.isi.push_it.entities.Usager;
import com.push_it.isi.push_it.fragment_profil_user.Nav_Profil;
import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.entities.UserStatic;

public class Login_In extends AppCompatActivity {

    Button connexionBtn;
    Context ctx;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__in);

        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPass);
        connexionBtn = (Button) findViewById(R.id.connexionBtnSinIn);
        ctx = this;

        connexionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String info1 = email.getText().toString();
                String info2 = password.getText().toString();

                Usager userLogin = new Usager();
                userLogin.setPseudo(info1);
                userLogin.setMdp(info2);

                Log.d("debug", userLogin.getNbPush_Up() + "Clique connexion");


                if (UsagerManager.getSearchUser(userLogin, ctx) == null) {

                    Toast.makeText(ctx, "Login invalide", Toast.LENGTH_LONG).show();


                } else {

                    Log.d("debug", userLogin.getPseudo() + "USER");

                    Toast.makeText(ctx, "Login Valide", Toast.LENGTH_LONG).show();
                    Intent homeIntent = new Intent(ctx, Nav_Profil.class);
                    homeIntent.putExtra("User", userLogin.getPseudo());
                    UserStatic.usagerEnCour = UsagerManager.getSearchUserSetting(userLogin, ctx);



                    startActivity(homeIntent);
                    //   UserStatic.setPseudo(info1);


                }


            }
        });
    }
}
