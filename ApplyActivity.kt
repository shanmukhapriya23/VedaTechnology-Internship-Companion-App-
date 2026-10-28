package com.example.vedatechnologyinternshipcompanionapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        val jobTitle = intent.getStringExtra("EXTRA_TITLE") ?: "Internship"
        val company = intent.getStringExtra("EXTRA_COMPANY") ?: "Veda Technology"

        findViewById<TextView>(R.id.tvApplyingFor).text = "Apply for $jobTitle"
        findViewById<TextView>(R.id.tvCompanySub).text = company

        val etFullName = findViewById<TextInputEditText>(R.id.etFullName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)
        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmitApplication)

        btnSubmit.setOnClickListener {
            val name = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show()
            } else {
                showSuccessDialog(name, jobTitle)
            }
        }
    }

    private fun showSuccessDialog(name: String, title: String) {
        AlertDialog.Builder(this)
            .setTitle("Application Successful!")
            .setMessage("Thank you, $name!\n\nYour application for '$title' at Veda Technology has been submitted successfully. We will reach out to you soon.")
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                finish() // Closes ApplyActivity and returns back
            }
            .show()
    }
}