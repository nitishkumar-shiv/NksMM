package com.example.nksmm

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
import kotlin.math.log

class MainActivity : ComponentActivity(), GalleryHandler.GalleryListener  {
    private lateinit var galleryHandler: GalleryHandler

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        galleryHandler = GalleryHandler(this, this)
        galleryHandler.checkAndRequestPermission()


        setContent {
            NksMMTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
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
        Log.d("Nmm ","NMM")
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        galleryHandler.onRequestPermissionsResult(requestCode, grantResults)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NksMMTheme {
        Greeting("Android")
    }
}