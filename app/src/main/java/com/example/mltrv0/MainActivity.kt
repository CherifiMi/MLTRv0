package com.example.mltrv0

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mltrv0.R.drawable.pic
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runTextRecognition()
        Log.d("hillo", "seccess")

    }

    private fun runTextRecognition() {

        val myimage = BitmapFactory.decodeResource(resources, pic)

        val image = InputImage.fromBitmap(myimage, 0)

        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        val result = recognizer.process(image)
            .addOnSuccessListener { visionText ->
                // Task completed successfully
                Log.d("hillo", "seccess")
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                // ...
            }.result
    }
}