package com.example.photoclient

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFab(view)
        initToolbar(view)
        initRV()
    }

    private fun initRV() {
        val adapter = MainRVAdapter()
        val mainRV = view?.findViewById<RecyclerView>(R.id.main_rec_view)
        mainRV?.adapter = adapter
        mainRV?.layoutManager = GridLayoutManager(context, 2)
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