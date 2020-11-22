package com.example.photoclient

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        redBtn.setOnClickListener {
            changeAppStyle(R.style.AppTheme_Red)
        }
        blueBtn.setOnClickListener {
            changeAppStyle(R.style.AppTheme)
        }
    }

    private fun changeAppStyle(style: Int) {
        val sp = requireActivity().getSharedPreferences("THEME", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putInt("THEME", style)
        editor.apply()
        requireActivity().recreate()
    }
}
