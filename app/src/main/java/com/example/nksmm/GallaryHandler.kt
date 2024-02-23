package com.example.nksmm

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class GalleryHandler(
    private val activity: MainActivity,
    private val listener: GalleryListener
) {

    private val REQUEST_CODE_PERMISSION = 1001
        @RequiresApi(Build.VERSION_CODES.S)
        fun checkAndRequestPermission() {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_MEDIA_IMAGES), REQUEST_CODE_PERMISSION)
            } else {
                listener.onPermissionGranted()
            }
        }
    @RequiresApi(Build.VERSION_CODES.S)
    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                listener.onPermissionGranted()
            } else {
                listener.onPermissionDenied()
            }
        }
    }

    fun accessGallery() {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA)
        val cursor: Cursor? = activity.contentResolver.query(uri, projection, null, null, null)

        cursor.use {
            while (it?.moveToNext() == true) {
                val imagePath = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                listener.onImageLoaded(imagePath)
            }
        }
    }

    interface GalleryListener {
        fun onPermissionGranted()
        fun onPermissionDenied()
        fun onImageLoaded(imagePath: String)
    }
}
