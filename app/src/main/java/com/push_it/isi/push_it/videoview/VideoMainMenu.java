package com.push_it.isi.push_it.videoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.push_it.isi.push_it.R;

import java.io.IOException;

/**
 * Created by DominicDubreuil on 16-09-08.
 */


public class VideoMainMenu extends SurfaceView implements SurfaceHolder.Callback {


    public VideoMainMenu(Context context) {
        super(context);
        init();
    }

    private MediaPlayer mp;
    private boolean has_started = false;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) public VideoMainMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public VideoMainMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public VideoMainMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mp = new MediaPlayer();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.video3);
        try {
            if (!has_started) {
                has_started = true;
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            }

            mp.prepare();
            android.view.ViewGroup.LayoutParams lp = getLayoutParams();
            lp.height = getHeight();
            lp.width = getWidth();

            Log.d("debug",getWidth()+"");
            Log.d("debug",getWidth()+"");

            setLayoutParams(lp);
            mp.setDisplay(getHolder());
            mp.setLooping(true);
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp.stop();
    }
}
