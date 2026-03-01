package com.fengqingyang10.findyou

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ipTextView: TextView
    private lateinit var portTextView: TextView
    private lateinit var serverButton: Button
    private lateinit var clientButton: Button
    private lateinit var ipEditText: EditText
    private lateinit var portEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ipTextView = findViewById(R.id.ipTextView)
        portTextView = findViewById(R.id.portTextView)
        serverButton = findViewById(R.id.serverButton)
        clientButton = findViewById(R.id.clientButton)
        ipEditText = findViewById(R.id.ipEditText)
        portEditText = findViewById(R.id.portEditText)

        serverButton.setOnClickListener { startServer() }
        clientButton.setOnClickListener { startClient() }
    }

    private fun startServer() {
        val ip = ipEditText.text.toString()
        val port = portEditText.text.toString().toInt()
        // Add server logic here
        ipTextView.text = "IP: $ip"
        portTextView.text = "Port: $port"
    }

    private fun startClient() {
        val ip = ipEditText.text.toString()
        val port = portEditText.text.toString().toInt()
        // Add client logic here
        ipTextView.text = "IP: $ip"
        portTextView.text = "Port: $port"
    }
}