
package com.holo

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    companion object {
        private const val PERMISSION_REQUEST = 100
    }

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.rgb(7, 10, 20)
        window.navigationBarColor = Color.rgb(7, 10, 20)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(7, 10, 20))
        }

        val title = TextView(this).apply {
            text = "HOLO-02"
            textSize = 36f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "PERSONAL AI INTERFACE"
            textSize = 12f
            setTextColor(Color.rgb(0, 220, 255))
            gravity = Gravity.CENTER
        }

        statusText = TextView(this).apply {
            text = "SYSTEM STANDBY"
            textSize = 14f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val initializeButton = Button(this).apply {
            text = "INITIALIZE HOLO"
            setOnClickListener {
                requestHoloPermissions()
            }
        }

        layout.addView(title)
        layout.addView(subtitle)

        layout.addView(
            statusText,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100
            )
        )

        layout.addView(initializeButton)

        setContentView(layout)
    }

    private fun requestHoloPermissions() {
        val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )

        val missingPermissions = permissions.filter {
            checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED
        }

        if (missingPermissions.isEmpty()) {
            statusText.text = "PERMISSIONS GRANTED"
        } else {
            requestPermissions(
                missingPermissions.toTypedArray(),
                PERMISSION_REQUEST
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (requestCode == PERMISSION_REQUEST) {
            val allGranted = grantResults.isNotEmpty() &&
                grantResults.all {
                    it == PackageManager.PERMISSION_GRANTED
                }

            statusText.text = if (allGranted) {
                "PERMISSIONS GRANTED"
            } else {
                "PERMISSIONS NOT FULLY GRANTED"
            }
        }
    }
}
