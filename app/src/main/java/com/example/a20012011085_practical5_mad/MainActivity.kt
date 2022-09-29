package com.example.a20012011085_practical5_mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<FloatingActionButton>(R.id.playbutton)
        val stop = findViewById<FloatingActionButton>(R.id.stopbutton)
        val forwardbutton=findViewById<FloatingActionButton>(R.id.forwardbutton)
        val backwardbutton=findViewById<FloatingActionButton>(R.id.backwardbutton)
        var count = 0
        play.setOnClickListener {
            count++
            play()
            if(count%2!=0){
                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_pause_circle_filled_24))
            }
            else{
                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_play_arrow_24))
            }
        }
        stop.setOnClickListener {
            stop()
        }

        forwardbutton.setOnClickListener {
            Intent(applicationContext, Myservise::class.java).putExtra(
                Myservise.Service1,
                Myservise.ForWard
            ).apply {
                startService(this)
            }
        }
        backwardbutton.setOnClickListener {
            Intent(applicationContext, Myservise::class.java).putExtra(
                Myservise.Service1,
                Myservise.BackWard
            ).apply {
                startService(this)
            }
        }
    }
    fun play() {
        Intent(applicationContext, Myservise::class.java).putExtra(
            Myservise.Service1,
            Myservise.PlayPause
        ).apply {
            startService(this)
        }
    }
    fun stop() {
        Intent(applicationContext, Myservise::class.java).apply {
            stopService(this)
        }
    }
}
