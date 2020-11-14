package com.example.photoclient

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFab(view)
        initToolbar(view)
    }

    private fun initToolbar(view: View) {
//        val toolbar = view.findViewById<Toolbar>(R.id.mainToolbar)
//        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
//        toolbar.title = javaClass.simpleName
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