package com.example.beaEstilsApp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : AppCompatActivity() {
    //Splash time
    private var splashScreenStays :Boolean = true
    private val DELAY:Long = 1500L

    //Elementos
    private lateinit var btnCitas: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        //Usamos el splash creado
        val screenSplash: SplashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Incrementamos el tiempo del Splash
        screenSplash.setKeepOnScreenCondition{splashScreenStays}
        Handler(Looper.getMainLooper()).postDelayed({ splashScreenStays = false }, DELAY)

        //Inicializamos componentes y listeners
        initComponents()
        initListeners()

    }
    private fun initComponents() {
        btnCitas=findViewById(R.id.btnCitas)
    }

    private fun initListeners(){

        //ingreso a citas
        btnCitas.setOnClickListener{
            val intent = Intent(this, Citas::class.java)
            startActivity(intent)
        }
    }





}

