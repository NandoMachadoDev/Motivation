package com.nubank.esboco.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.nubank.esboco.R
import com.nubank.esboco.data.Mock
import com.nubank.esboco.infra.MotivationConstants
import com.nubank.esboco.infra.SecurityPreferences
import com.nubank.esboco.databinding.ActivityNameBinding

class ActivityName : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityNameBinding
    private lateinit var securityPreferences: SecurityPreferences

    private var filter = MotivationConstants.FILTER.INFINITO
    private val mock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icInfinito.setOnClickListener(this)
        binding.icRosto.setOnClickListener(this)
        binding.icNoite.setOnClickListener(this)
        binding.buttonNovaFrase.setOnClickListener(this)

        handleUserName()
        handleFilter(R.id.ic_infinito)
        handleNextFrase()

    }

    override fun onClick(view: View) {
        val id: Int = view.id

        val listId = listOf(
            R.id.ic_infinito,
            R.id.ic_rosto,
            R.id.ic_noite
        )
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.buttonNovaFrase) {
            handleNextFrase()
        }
    }

    private fun handleNextFrase() {
        binding.textFraseCenter.text = Mock().getFrases(filter)
    }

    private fun handleFilter(id: Int) {
        binding.icInfinito.setColorFilter(ContextCompat.getColor(this, R.color.roxo_default_icons))
        binding.icRosto.setColorFilter(ContextCompat.getColor(this, R.color.roxo_default_icons))
        binding.icNoite.setColorFilter(ContextCompat.getColor(this, R.color.roxo_default_icons))

        filter = when (id) {
            R.id.ic_infinito -> {
                binding.icInfinito.setColorFilter(ContextCompat.getColor(this, R.color.white))
                MotivationConstants.FILTER.INFINITO
            }

            R.id.ic_rosto -> {
                binding.icRosto.setColorFilter(ContextCompat.getColor(this, R.color.white))
                MotivationConstants.FILTER.ROSTO
            }

            else -> {
                binding.icNoite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                MotivationConstants.FILTER.NOITE
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textKotlin.text = "Olá, $name!"
    }

}