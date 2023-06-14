package com.nubank.esboco.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nubank.esboco.infra.MotivationConstants
import com.nubank.esboco.R
import com.nubank.esboco.infra.SecurityPreferences
import com.nubank.esboco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSalvar.setOnClickListener { handleSave() }

        verifyUserName()

    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(applicationContext, ActivityName::class.java))
        }
    }

    private fun handleSave() {
        val name = binding.editNome.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            val intentActivityName = Intent(applicationContext, ActivityName::class.java)
            startActivity(intentActivityName)
        } else {
            Toast.makeText(applicationContext, R.string.digiteNome, Toast.LENGTH_SHORT).show()
        }
    }

}