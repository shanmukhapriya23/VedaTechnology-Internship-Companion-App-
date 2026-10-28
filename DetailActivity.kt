package com.example.vedatechnologyinternshipcompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("EXTRA_TITLE") ?: "Internship Details"
        val company = intent.getStringExtra("EXTRA_COMPANY") ?: "Veda Technology"
        val description = intent.getStringExtra("EXTRA_DESCRIPTION") ?: "No details available."

        findViewById<TextView>(R.id.tvDetailTitle).text = title
        findViewById<TextView>(R.id.tvDetailCompany).text = company
        findViewById<TextView>(R.id.tvDetailDescription).text = description

        // Navigate to Application Form
        findViewById<MaterialButton>(R.id.btnApply).setOnClickListener {
            val intent = Intent(this, ApplyActivity::class.java).apply {
                putExtra("EXTRA_TITLE", title)
                putExtra("EXTRA_COMPANY", company)
            }
            startActivity(intent)
        }
    }
}