package com.melihkarakilinc.notuygulamasi.view

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.melihkarakilinc.notuygulamasi.R
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionbar = supportActionBar
        LoadLanguage()
        actionbar!!.title = resources.getString(R.string.app_name)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dil, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.en) {
            SetLocale("en")
            recreate()
            return true
        }
        if (id == R.id.ar) {
            SetLocale("ar")
            recreate()
            return true
        }
        if (id == R.id.tr) {
            SetLocale("tr")
            recreate()
            return true
        }

        return super.onOptionsItemSelected(item)

    }

    private fun SetLocale(lang: String) {
        val locale = Locale(lang)
        //Seçilen dilimizi bir sonraki girişlerde default dil haline getiriyoruz.
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        config.setLocale(locale)

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        //Ayrıca seçilen dili geçici olarak kayıt altına alıyoruz.
        val editor: SharedPreferences.Editor =
            getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }

    private fun LoadLanguage() {
        val pref: SharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language: String? = pref.getString("My_Lang", "en")
        SetLocale(language!!)
    }
}