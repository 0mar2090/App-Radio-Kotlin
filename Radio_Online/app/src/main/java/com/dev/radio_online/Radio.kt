package com.dev.radio_online

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Radio : AppCompatActivity() {

    private  lateinit var buttonBack:Button
    private  lateinit var buttonPlayPause : Button
    private lateinit var  mPlayer :MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        buttonPlayPause = findViewById(R.id.buttonPlayPause)
        buttonBack = findViewById(R.id.buttonBack)

        Radioondacero()
        Back()
    }

    //Segunda Opcion

    private fun Radioondacero(){

        val urls = "https://streaming.gometri.com/stream/8011/stream/1/";
        mPlayer = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(urls)
            prepare()
        }

        mPlayer.setOnPreparedListener {
            setOnClickListeners01(this)
        }

    }

    private fun setOnClickListeners01(context: Context) {

        buttonPlayPause.setOnClickListener {

            if(mPlayer.isPlaying){

                mPlayer.pause()

                buttonPlayPause.setBackgroundResource(R.drawable.ic_pause)
                Toast.makeText(context, "En Pausa... ", Toast.LENGTH_SHORT).show()

            }else{

                mPlayer.start()
                buttonPlayPause.setBackgroundResource(R.drawable.ic_play)
                Toast.makeText(context, "Play Buscando Radio || Reproduciendo... ", Toast.LENGTH_LONG).show()
            }

        }

    }

    private  fun Back(){

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            mPlayer.release()

        }
    }

}