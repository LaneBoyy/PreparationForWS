package ru.laneboy.preparationforws.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.ActivityMainBinding
import ru.laneboy.preparationforws.presentation.fragments.MainScreenFragment
import ru.laneboy.preparationforws.presentation.fragments.SplashScreenFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        removeStatusBar()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        ПОМЕНЯТЬ, КОГДА БУДЕТ ГОТОВО
        launchSplashScreenFragment()
//        launchMainScreenFragment()

    }

    private fun launchSplashScreenFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SplashScreenFragment.newInstance())
            .commit()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun launchMainScreenFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainScreenFragment.newInstance())
            .commit()
    }
}