package com.github.capstone.mommymater2

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.github.capstone.mommymater2.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        val duration : Long = 2000
        object : CountDownTimer(duration, duration) {
            override fun onTick(millisUntilFinished: Long) {
                playAnimation()
            }

            override fun onFinish() {
                startActivity(intent)

            }
        }.start()
    }



    fun playAnimation(){

        val onGambar = ObjectAnimator.ofFloat(binding.LogoIntro, View.ALPHA, 1f).setDuration(600)
        val onTeks = ObjectAnimator.ofFloat(binding.Judul, View.ALPHA, 1f).setDuration(600)



        val fadeOut = ObjectAnimator.ofFloat(binding.LogoIntro, View.ALPHA, 0f).setDuration(600)
        val fadeOutTeks = ObjectAnimator.ofFloat(binding.Judul, View.ALPHA, 0f).setDuration(600)


        AnimatorSet().apply {
            playSequentially( onTeks,  onGambar, fadeOutTeks, fadeOut)
            start()
        }

    }
}