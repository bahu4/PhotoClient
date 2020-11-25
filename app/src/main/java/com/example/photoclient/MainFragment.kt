package com.example.photoclient

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    val CAMERA_REQUEST_CODE = 0

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
            makePhoto()
        }
    }

    private fun makePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        }
    }

    private fun showSnackBar(myView: View) {
        Snackbar.make(myView, R.string.added, Snackbar.LENGTH_SHORT)
            .setAction(R.string.ok) {
            }
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = view?.findViewById<ImageView>(R.id.imageView)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    imageView?.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(context, "Unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}