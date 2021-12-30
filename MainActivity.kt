package com.dev.radio_online

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonNext: Button

    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonNext = findViewById(R.id.buttonNext)

        RadioLaInolvidable()
        Next()


    }

    //PRIMAERA OPCION

    private fun RadioLaInolvidable() {

        val url = "https://24943.live.streamtheworld.com/CRP_LI_SC?csegid=20001&dist=20001&ttag=20001"; //"https://serverssl.innovatestream.pe:8080/http://167.114.118.120:7442/;";

        mediaPlayer = MediaPlayer()

        mediaPlayer.setDataSource(url)
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.prepareAsync()



        mediaPlayer.setOnPreparedListener {

            setOnClickListeners(this)
        }
    }

    private fun setOnClickListeners(context: Context) {
        buttonPlay.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(context, "Play Buscando Radio || Reproduciendo... ", Toast.LENGTH_SHORT).show()
        }

        buttonPause.setOnClickListener {
            mediaPlayer.pause()
            Toast.makeText(context, "En Pausa...", Toast.LENGTH_SHORT).show()
        }


    }

    private  fun Next(){
        buttonNext.setOnClickListener {
            val intent = Intent(this, Radio::class.java)
            this.startActivity(intent)
            mediaPlayer.release()
        }

    }


/*
    //Segunda Opcion
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

   private fun Radioondacero(){

         val urls = "https://streaming.gometri.com/stream/8011/stream/1/"; // your URL here
         mPlayer = MediaPlayer().apply {
             setAudioStreamType(AudioManager.STREAM_MUSIC)
             setDataSource(urls)
             prepare() // might take long! (for buffering, etc)
         }

         mPlayer.setOnPreparedListener {
             setOnClickListeners01(this)
        }

    }*/

}