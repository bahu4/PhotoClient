package com.example.photoclient

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val redBtn = view.findViewById<Button>(R.id.red_btn)
        redBtn.setOnClickListener {
            changeAppStyle(R.style.AppTheme_Red)
        }
        val blueBtn = view.findViewById<Button>(R.id.blue_btn)
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
