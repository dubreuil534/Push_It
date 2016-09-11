package com.push_it.isi.push_it.viewChallenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.bdamanager.UsagerManager;
import com.push_it.isi.push_it.entities.ThreadCountDown;
import com.push_it.isi.push_it.entities.Usager;
import com.push_it.isi.push_it.entities.UserStatic;


public class ChallengeOneActivity extends Activity implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    Context ctx;
    TextView tvPushUp;
    int nbPushUp;
    int nbPushUpAFaire;
    int scoreFinal;
    boolean descendu;
    boolean remonter;
    TextView countdown;
    MediaPlayer pushUpSound;
    MediaPlayer soundCountDownFr;
    Button btn;
    int counter = 10;
    public boolean ready;
    public boolean reussi;
    Handler handler;
    ThreadCountDown monThreadCountDown;
    int tempsAttribuer;
    Intent intent;
    boolean readyThread;
    boolean completer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_push_up);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nbPushUp = 1;
        descendu = false;
        remonter = true;
        ctx = this;

        intent = getIntent();

        String temps = intent.getStringExtra("tempsAttribuer");
        String nombre = intent.getStringExtra("nombrePushUp");

        tempsAttribuer = Integer.parseInt(temps);
        nbPushUpAFaire = Integer.parseInt(nombre);

        ready = true;

        completer = false;

        readyThread = false;

        reussi = true;

        handler = new Handler();

        countdown = (TextView) findViewById(R.id.countdown);

        btn = (Button) findViewById(R.id.startChrono);

        pushUpSound = MediaPlayer.create(ctx, R.raw.sound_effect_cut);

        soundCountDownFr = MediaPlayer.create(ctx, R.raw.push_it_fr);

        tvPushUp = (TextView) findViewById(R.id.nbpushup);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        monThreadCountDown = new ThreadCountDown(countdown, soundCountDownFr, handler, readyThread, reussi, tempsAttribuer, counter, 1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setEnabled(false);
                handler.post(monThreadCountDown);
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        monThreadCountDown.setSurPause(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        monThreadCountDown.setSurPause(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        monThreadCountDown.setSurPause(true);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (monThreadCountDown.isReady() == true) {
            if (ready == true) {
                if (descendu == true && sensorEvent.values[1] <= -3.0 && reussi == true) {
                    descendu = false;
                    scoreFinal += nbPushUp;
                    tvPushUp.setText("" + scoreFinal);
                    remonter = true;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pushUpSound.start();
                        }
                    });
                } else if (sensorEvent.values[1] >= -1.5) {
                    descendu = true;
                }
            }

        }

        if (monThreadCountDown.isReussi() == false) {
            countdown.setText(String.valueOf("Non Completé"));


            monThreadCountDown.setSurPause(true);
            ready = false;
            btn.setEnabled(true);
            btn.setText("Retour à la liste");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(ctx, ChallengeActivity.class);
                    startActivity(intent);
                }
            });
        } else if (scoreFinal == nbPushUpAFaire && completer == false) {
            countdown.setText(String.valueOf("Complété!!"));

            completer = true;


            UserStatic.usagerEnCour.setNbPush_Up(UserStatic.usagerEnCour.getNbPush_Up() + scoreFinal);


            UsagerManager.update(UserStatic.usagerEnCour, ctx);



            Log.d("debug", UserStatic.usagerEnCour.getNbPush_Up() + "  Dans Static");




            monThreadCountDown.setSurPause(true);
            ready = false;
            btn.setEnabled(true);
            btn.setText("Retour à la liste");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(ctx, ChallengeActivity.class);
                    startActivity(intent);
                }
            });
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
