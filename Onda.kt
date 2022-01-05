package com.pguides.myradio2

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Onda : AppCompatActivity() {

      private lateinit var BPlayPause:Button
      private  lateinit var BBack:Button
      private  lateinit var Mplayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onda)


        BPlayPause = findViewById(R.id.buttonPlayPause)
        BBack = findViewById(R.id.buttonBack)
        RadioOndaCero()

    }

    private fun RadioOndaCero(){

        val url = "https://streaming.gometri.com/stream/8011/stream/1/"
        Mplayer = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(url)
            prepare()
        }
        Mplayer.setOnPreparedListener {
            PlayOnda(this)
        }
    }

    private fun PlayOnda(context: Context){

        BPlayPause.setOnClickListener {
            if (Mplayer.isPlaying){
                Mplayer.pause()
                BPlayPause.setBackgroundResource(R.drawable.ic_pause)
                Toast.makeText(context, "En Pause...", Toast.LENGTH_SHORT).show()
            }else
            {
                Mplayer.start()
                BPlayPause.setBackgroundResource(R.drawable.ic_play)
                Toast.makeText(context, "En Play...", Toast.LENGTH_SHORT).show()
            }
        }
        Back()
    }

    private  fun Back(){
        BBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            this.startActivity(intent)
            Mplayer.release()
        }
    }

}
