package com.pguides.myradio2

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private  lateinit var Bplay:Button
    private  lateinit var Bpause:Button
    private  lateinit var BNext: Button
    private  lateinit var MPlayer:MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Bplay = findViewById(R.id.buttonPlay)
        Bpause = findViewById(R.id.buttonPause)
        BNext = findViewById(R.id.buttonNext)

        RadioZona()
    }

    private fun RadioZona(){

        val url = "https://us-b4-p-e-ft6-audio.cdn.mdstrm.com/live-audio-aw/5fada54116646e098d97e6a5"

        MPlayer = MediaPlayer()
        MPlayer.setDataSource(url)
        MPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        MPlayer.prepareAsync()

        MPlayer.setOnPreparedListener {
            PlayZona(this)
        }
    }


    private fun PlayZona(context: Context){

        Bplay.setOnClickListener {
            MPlayer.start()
            Toast.makeText(context, "En Play...", Toast.LENGTH_SHORT).show()
        }

        Bpause.setOnClickListener {
            MPlayer.pause()
            Toast.makeText(context, "En Pause...", Toast.LENGTH_SHORT).show()
        }
        Next()
    }

    private fun Next(){

        BNext.setOnClickListener {
            val int = Intent(this,Onda::class.java)
            this.startActivity(int)
            MPlayer.release()
        }
    }



}
