package com.group6.mobileappdev.musicq_phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatePlaylist extends AppCompatActivity {

    EditText PlaylistET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);

        PlaylistET = (EditText) findViewById(R.id.editTextPartyName);


        Button btn = (Button)findViewById(R.id.btnSavePlaylist);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePlaylist.this, ViewPlaylistMenu.class));
            }
        });

    }

    public void OnSavePlaylist(View view){
        String playlistname = PlaylistET.getText().toString();
        BackgroundTask backgroundTask = new BackgroundTask(this);
        String type = "addPlaylist";
        backgroundTask.execute(type,playlistname,"");

    }
}