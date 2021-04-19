package com.example.weatherapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            val animation: Animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.bottom_to_top)
            binding.imgSplashLogo.setVisibility(View.VISIBLE)
            animation.reset()

            binding.imgSplashLogo.startAnimation(animation)
            delay(3000)
            var intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}