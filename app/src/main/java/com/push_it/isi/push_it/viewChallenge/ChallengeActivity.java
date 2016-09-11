package com.push_it.isi.push_it.viewChallenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.entities.Challenge;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class ChallengeActivity extends Activity {

    ListAdapter challengeAdapt;
    Context ctx;
    Intent selectedItem;
    ListView listChallenge;
    TextView tv;
    LinearLayout ll;
    ArrayList<Challenge> arrayChallenge = new ArrayList<>();
    ArrayList<String> nomImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ctx = this;

        ll = new LinearLayout(ctx);
        ll.setBackgroundColor(Color.BLACK);

        tv = new TextView(ctx);
        tv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setText("Liste des Challenges");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(40);
        tv.setTextColor(Color.WHITE);

        listChallenge = new ListView(ctx);

        String[] listDesChallenge = getResources().getStringArray(R.array.listChallenge);
        String[] listDesDescription = getResources().getStringArray(R.array.listeDescription);
        challengeAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDesChallenge);

        for(int i = 0; i < 10; i++) {
            Challenge challenge = new Challenge(listDesChallenge[i], listDesDescription[i]);
            arrayChallenge.add(challenge);
        }

        Field[] fs = R.drawable.class.getFields();

        for(Field f : fs) {
            if (f.getName().equals("onehandpushup")) {
                Log.d("debug", f.getName().toString());
                try {
                    Log.d("debug", "Valeur de la ressources : "+f.getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        listChallenge.setAdapter(challengeAdapt);

        listChallenge.addHeaderView(tv);

        listChallenge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 1:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(0).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(0).getDescription());
                        selectedItem.putExtra("numeroChallenge", "un");
                        startActivity(selectedItem);
                        break;
                    case 2:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(1).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(1).getDescription());
                        selectedItem.putExtra("numeroChallenge", "deux");
                        startActivity(selectedItem);
                        break;
                    case 3:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(2).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(2).getDescription());
                        selectedItem.putExtra("numeroChallenge", "trois");
                        startActivity(selectedItem);
                        break;
                    case 4:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(3).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(3).getDescription());
                        selectedItem.putExtra("numeroChallenge", "quatre");
                        startActivity(selectedItem);
                        break;
                    case 5:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(4).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(4).getDescription());
                        selectedItem.putExtra("numeroChallenge", "cinq");
                        startActivity(selectedItem);
                        break;
                    case 6:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(5).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(5).getDescription());
                        selectedItem.putExtra("numeroChallenge", "six");
                        startActivity(selectedItem);
                        break;
                    case 7:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(6).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(6).getDescription());
                        selectedItem.putExtra("numeroChallenge", "sept");
                        startActivity(selectedItem);
                        break;
                    case 8:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(7).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(7).getDescription());
                        selectedItem.putExtra("numeroChallenge", "huit");
                        startActivity(selectedItem);
                        break;
                    case 9:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(8).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(8).getDescription());
                        selectedItem.putExtra("numeroChallenge", "neuf");
                        startActivity(selectedItem);
                        break;
                    case 10:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(9).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(9).getDescription());
                        selectedItem.putExtra("numeroChallenge", "dix");
                        startActivity(selectedItem);
                        break;
                    case 11:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(0).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(0).getDescription());
                        startActivity(selectedItem);
                        break;
                }
            }

        });
        this.setContentView(listChallenge);
    }

}
