package com.example.photoclient

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFab(view)
        initToolbar(view)
        isClicked(view)
    }

    private fun isClicked(view: View) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            findNavController().navigate(R.id.action_menu_main_to_testFragment)
        }
    }

    private fun initToolbar(view: View) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            Calendar.getInstance().time.toString()
    }

    private fun initFab(view: View) {
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showSnackBar(view)
        }
    }

    private fun showSnackBar(myView: View) {
        Snackbar.make(myView, R.string.added, Snackbar.LENGTH_SHORT)
            .setAction(R.string.ok) {
            }
            .show()
    }
}