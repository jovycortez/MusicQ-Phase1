package com.group6.mobileappdev.musicq_phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ViewPlaylistMenu extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_playlist_menu);

        ImageView btn = (ImageView)findViewById(R.id.imageViewRave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPlaylistMenu.this, YoutubePlayer.class));
            }
        });
    }
}
