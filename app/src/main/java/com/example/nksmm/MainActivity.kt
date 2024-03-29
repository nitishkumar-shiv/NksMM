package com.example.nksmm

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nksmm.ui.theme.NksMMTheme
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.storage
import java.io.File

class MainActivity : ComponentActivity(), GalleryHandler.GalleryListener  {
    private lateinit var galleryHandler: GalleryHandler

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        galleryHandler = GalleryHandler(this, this)
        galleryHandler.checkAndRequestPermission()


        setContent {
            NksMMTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScreen()
                }
            }
        }
    }

    override fun onPermissionGranted() {
        galleryHandler.accessGallery()

    }

    override fun onPermissionDenied() {
        Log.d("NMM", "onPermissionDenied: ")
    }

    override fun onImageLoaded(imagePath: String) {
        uploadImageToStorage(imagePath)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        galleryHandler.onRequestPermissionsResult(requestCode, grantResults)
    }
}



fun uploadImageToStorage(imagePath: String) {
    val storageRef = Firebase.storage.reference
    val file = Uri.fromFile(File(imagePath))
    val imageRef = storageRef.child("${file.lastPathSegment}")

    val uploadTask = imageRef.putFile(file)

    uploadTask.addOnSuccessListener { taskSnapshot ->
        // Image uploaded successfully, get download URL
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            // Uri contains the download URL
            val downloadUrl = uri.toString()
            // Call method to store download URL in Realtime Database
            Log.d("NMM", ": ")
        }
    }.addOnFailureListener { exception :Exception ->
        // Handle unsuccessful uploads
        Log.d("NMM", ":$exception ")
    }
}