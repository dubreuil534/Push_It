package com.push_it.isi.push_it.fragment_profil_user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.fragment_profil_user.Challenge;
import com.push_it.isi.push_it.fragment_profil_user.Home;
import com.push_it.isi.push_it.fragment_profil_user.Session;
import com.push_it.isi.push_it.fragment_profil_user.Setting;
import com.push_it.isi.push_it.fragment_profil_user.Statistique;

public class Nav_Profil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Home.OnFragmentInteractionListener,
        Challenge.OnFragmentInteractionListener,
        Session.OnFragmentInteractionListener,
        Setting.OnFragmentInteractionListener,
        Statistique.OnFragmentInteractionListener {

    String infoPseudo;

    TextView pseudoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pseudoText = (TextView) findViewById(R.id.pseudo);

        Intent retour = getIntent();
        infoPseudo = retour.getStringExtra("User");
        Log.d("debug", infoPseudo);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav__profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Home home = new Home();

            Bundle bundle = new Bundle();
            bundle.putString("home", infoPseudo);

            home.setArguments(bundle);
            FragmentManager managerHome = getSupportFragmentManager();
            managerHome.beginTransaction().replace(R.id.content_nav__profil, home, home.getTag()).commit();


        } else if (id == R.id.challenge) {

            Intent intentPseudo = new Intent();
            intentPseudo.putExtra("UserPseudo",infoPseudo);

            Challenge challenge = new Challenge();
            FragmentManager managerChallenge = getSupportFragmentManager();
            managerChallenge.beginTransaction().replace(R.id.content_nav__profil, challenge, challenge.getTag()).commit();

        } else if (id == R.id.seances) {
            Session session = new Session();
            FragmentManager managerHome = getSupportFragmentManager();
            managerHome.beginTransaction().replace(R.id.content_nav__profil, session, session.getTag()).commit();

        } else if (id == R.id.statistique) {
            Statistique statistique = new Statistique();
            FragmentManager managerHome = getSupportFragmentManager();
            managerHome.beginTransaction().replace(R.id.content_nav__profil, statistique, statistique.getTag()).commit();

        } else if (id == R.id.nav_manage) {


            Setting setting = new Setting();


            Bundle bundle = new Bundle();
            bundle.putString("setting", infoPseudo);


            setting.setArguments(bundle);

            FragmentManager managerHome = getSupportFragmentManager();
            managerHome.beginTransaction().replace(R.id.content_nav__profil, setting, setting.getTag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
