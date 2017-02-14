package com.research.robertodvp.audioanalyzer;

import android.media.AudioManager;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;

    private Button mRecordButton = null;
    private MediaRecorder mRecorder = null;

    private Button   mPlayButton = null;
    private MediaPlayer   mPlayer = null;

    VisualizerView mVisualizerView;
    private Visualizer mVisualizer;
    private MediaPlayer mMediaPlayer;
    private Button mViewAudioButton = null;

    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) finish();

    }

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void onViewAudio(boolean start) {
        if (start) {
            startViewingAudio();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    private void startViewingAudio() {
        initAudio();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        // Record to the external cache directory for visibility
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/audiorecordtest.mp4";

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        mRecordButton = (Button)findViewById(R.id.idRecordButton);
        mPlayButton = (Button)findViewById(R.id.idPlayButton);
        mViewAudioButton = (Button)findViewById(R.id.idViewAudtioButton);
        mVisualizerView = (VisualizerView)findViewById(R.id.idVisualizerView);

        mRecordButton.setOnClickListener(new View.OnClickListener() {
                                             boolean mStartRecording = true;
                                             public void onClick(View v) {
                                                 onRecord(mStartRecording);
                                                 if (mStartRecording) {
                                                     mRecordButton.setText("Stop Recording");
                                                 } else {
                                                     mRecordButton.setText("Start Recording");
                                                 }
                                                 mStartRecording = !mStartRecording;

                                             }
                                         }
        );

        mPlayButton.setOnClickListener(new View.OnClickListener() {
                                           boolean mStartPlaying = true;
                                           public void onClick(View v) {
                                               onPlay(mStartPlaying);
                                               if (mStartPlaying) {
                                                   mPlayButton.setText("Stop Playing");
                                               } else {
                                                   mPlayButton.setText("Start Playing");
                                               }
                                               mStartPlaying = !mStartPlaying;

                                           }
                                       }
        );

        mViewAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onViewAudio(true);
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    private void initAudio() {
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mMediaPlayer = MediaPlayer.create(this, Uri.parse(mFileName));

        setupVisualizerFxAndUI();
        // Make sure the visualizer is enabled only when you actually want to
        // receive data, and
        // when it makes sense to receive data.
        mVisualizer.setEnabled(true);
        // When the stream ends, we don't need to collect any more data. We
        // don't do this in
        // setupVisualizerFxAndUI because we likely want to have more,
        // non-Visualizer related code
        // in this callback.
        mMediaPlayer
                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mVisualizer.setEnabled(false);
                    }
                });
        mMediaPlayer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing() && mMediaPlayer != null) {
            mVisualizer.release();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


    private void setupVisualizerFxAndUI() {

        // Create the Visualizer object and attach it to our media player.
        mVisualizer = new Visualizer(mMediaPlayer.getAudioSessionId());
        //mVisualizer = new Visualizer(mFileName);
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
        mVisualizer.setDataCaptureListener(
                new Visualizer.OnDataCaptureListener() {
                    public void onWaveFormDataCapture(Visualizer visualizer,
                                                      byte[] bytes, int samplingRate) {
                        mVisualizerView.updateVisualizer(bytes);
                    }

                    public void onFftDataCapture(Visualizer visualizer,
                                                 byte[] bytes, int samplingRate) {
                    }
                }, Visualizer.getMaxCaptureRate() / 2, true, false);
    }
}
