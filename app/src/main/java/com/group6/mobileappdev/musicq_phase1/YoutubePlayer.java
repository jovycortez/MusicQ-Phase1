package com.group6.mobileappdev.musicq_phase1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
        btn3 = (Button)findViewById(R.id.btnDislike);

    }

    @Override
    public void onInitializationSuccess(Provider provider, final YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            /*Button click listener cast to a variable and get the url*/
           // player.loadPlaylist("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            //https://www.youtube.com/watch?v=h70n82G-zz4&nohtml5=False
            player.loadPlaylist("KDxJlW6cxRk&list=PLxtNsXIpXlFOpyQP_pBU2bNQUiGtpdIWU");

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   player.next();
                }
            });
          //  https://www.youtube.com/watch?v=KDxJlW6cxRk&list=PLxtNsXIpXlFOpyQP_pBU2bNQUiGtpdIWU
           // player.cuePlaylist("MKXK8xwYDIA&index=1&list=RDMKXK8xwYDIA"); //https://www.youtube.com/watch?v=MKXK8xwYDIA&list=RDMKXK8xwYDIA#t=1
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }




}