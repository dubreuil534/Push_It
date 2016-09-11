package com.push_it.isi.push_it.entities;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by Nickerson on 9/7/2016.
 */
public class ThreadCountDown implements Runnable {

    private int counter;
    TextView countdown;
    MediaPlayer soundCountDownFr;
    Handler handler;
    private boolean ready;
    private boolean reussi;
    private boolean surPause;
    private int tempsAttribuer;
    private int challenge;

    public ThreadCountDown(TextView countdown, MediaPlayer soundCountDownFr, Handler handler, boolean ready, boolean reussi, int tempsAttribuer, int counter, int challenge) {
        this.countdown = countdown;
        this.soundCountDownFr = soundCountDownFr;
        this.handler = handler;
        this.ready = ready;
        this.reussi = reussi;
        this.surPause = false;
        this.tempsAttribuer = tempsAttribuer;
        this.counter = counter;
        this.challenge = challenge;
    }

    @Override
    public void run() {

        if(surPause == false) {
            if (this.counter <= 0) {
                countdown.setText("");
                setReady(true);
            }

            if (this.ready == false) {
                soundCountDownFr.start();
                this.counter--;
                handler.postDelayed(this, 1000);
                countdown.setText(String.valueOf(this.counter));
            }

            if (this.ready == true && this.reussi == true) {
                this.counter++;
                handler.postDelayed(this, 1000);
                countdown.setText(String.valueOf(this.counter));
            }

            if (this.counter >= this.tempsAttribuer && this.ready == true && this.challenge == 1) {
                setReussi(false);
            }

        } else {
            soundCountDownFr.stop();
            handler.removeCallbacks(this);
        }
    }

    public boolean getSurPause() {
        return surPause;
    }

    public boolean isReussi() {
        return reussi;
    }

    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getChallenge() {
        return challenge;
    }

    public void setChallenge(int challenge) {
        this.challenge = challenge;
    }

    public void setSurPause(boolean surPause) {
        this.surPause = surPause;
    }

}
