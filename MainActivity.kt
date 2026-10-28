package com.example.vedatechnologyinternshipcompanionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: InternshipViewModel
    private lateinit var adapter: InternshipAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Setup RecyclerView with Click Listener
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewInternships)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = InternshipAdapter { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_TITLE", selectedItem.title)
                putExtra("EXTRA_COMPANY", selectedItem.company)
                // FIX: Pass the full detailed information here so it appears only in DetailActivity
                putExtra("EXTRA_DESCRIPTION", selectedItem.fullDescription)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // 2. Initialize ViewModel
        viewModel = ViewModelProvider(this)[InternshipViewModel::class.java]

        // 3. Observe LiveData from Database
        viewModel.allInternships.observe(this) { internships ->
            internships?.let {
                adapter.submitList(it)
            }
        }

        // 4. Populate Database with Short Summaries & Full Details on Explore Click
        val btnExplore = findViewById<MaterialButton>(R.id.btnExplore)
        btnExplore.setOnClickListener {
            Toast.makeText(this, "Loading Veda Technology Internships...", Toast.LENGTH_SHORT).show()

            // Android Developer Role
            viewModel.insert(
                InternshipItem(
                    title = "Android Developer Intern",
                    company = "Veda Technology",
                    description = "Duration: 6 Months • Stipend: ₹18,000 - ₹22,000 / mo\nBuild modern MVVM Android apps using Kotlin and Jetpack Room.",
                    fullDescription = """
                        📍 Location: Remote / Hybrid (Secunderabad, India)
                        🗓 Duration: 6 Months (Full-Time)
                        💰 Stipend: ₹18,000 - ₹22,000 / month
                        🕒 Working Hours: Monday to Friday (9:30 AM - 6:30 PM)

                        📌 ABOUT THE ROLE:
                        We are seeking a highly motivated Android Developer Intern to join our engineering team. In this role, you will help design and construct production-ready Android applications using modern MVVM architecture, Kotlin, and Google Jetpack libraries.

                        📋 KEY RESPONSIBILITIES:
                        - Develop dynamic, user-friendly UI layouts matching modern Material Design standards.
                        - Integrate RESTful APIs using Retrofit and handle network data serialization.
                        - Implement local database caching and data persistence utilizing Room and LiveData.
                        - Write clean, maintainable Kotlin code following industry best practices.
                        - Debug runtime crashes, fix bug tickets, and optimize UI performance.

                        🎯 REQUIREMENTS & QUALIFICATIONS:
                        - Pursuing or recently completed B.Tech / B.E / M.Tech / MCA in Computer Science.
                        - Strong fundamentals in Object-Oriented Programming (OOP) and Data Structures.
                        - Hands-on experience with Android Studio, Kotlin, XML layouts, and Git version control.
                        - Familiarity with Coroutines and ViewModel architecture is a strong plus.
                        - Good communication skills and ability to thrive in a collaborative team environment.

                        🎁 PERKS & BENEFITS:
                        - Official Certificate of Completion and Letter of Recommendation (LOR).
                        - Pre-Placement Offer (PPO) opportunities based on internship performance.
                        - Mentorship from senior software engineers and access to internal learning modules.
                    """.trimIndent()
                )
            )

            // UI/UX Design Role
            viewModel.insert(
                InternshipItem(
                    title = "UI/UX Design Intern",
                    company = "Veda Technology",
                    description = "Duration: 3-6 Months • Stipend: ₹14,000 - ₹18,000 / mo\nCreate mobile wireframes, UI prototypes, and design systems using Figma.",
                    fullDescription = """
                        📍 Location: On-Site (Secunderabad, India)
                        🗓 Duration: 3 to 6 Months (Full-Time)
                        💰 Stipend: ₹14,000 - ₹18,000 / month
                        🕒 Working Hours: Monday to Friday (9:30 AM - 6:30 PM)

                        📌 ABOUT THE ROLE:
                        Veda Technology is looking for a creative UI/UX Design Intern. You will work closely with product managers and engineers to craft seamless, visually appealing mobile and web interface experiences for thousands of end-users.

                        📋 KEY RESPONSIBILITIES:
                        - Create low and high-fidelity wireframes, user journeys, interactive prototypes, and mockups.
                        - Conduct user research, competitor analysis, and usability testing to refine design decisions.
                        - Build and maintain reusable Material 3 Design System component libraries.
                        - Collaborate with mobile developers to ensure design pixel-perfection during implementation.
                        - Design marketing assets, app icons, and graphics for mobile applications.

                        🎯 REQUIREMENTS & QUALIFICATIONS:
                        - Degree or diploma in Design, Fine Arts, Human-Computer Interaction (HCI), or CS.
                        - Proficiency in industry tools such as Figma, Adobe XD, and Illustrator.
                        - Understanding of user-centered design principles, typography, grids, and color theory.
                        - Portfolio demonstrating mobile app wireframes, UI prototypes, or case studies.
                        - High attention to detail and strong creative problem-solving skills.

                        🎁 PERKS & BENEFITS:
                        - Flexible workspace and modern hardware tools.
                        - Mentorship from product leads and design industry experts.
                        - Certificate of Completion and potential full-time role offer.
                    """.trimIndent()
                )
            )

            // Backend Developer Role
            viewModel.insert(
                InternshipItem(
                    title = "Backend Developer Intern",
                    company = "Veda Technology",
                    description = "Duration: 6 Months • Stipend: ₹20,000 - ₹25,000 / mo\nDevelop secure REST APIs, microservices, and databases using Node.js / Python.",
                    fullDescription = """
                        📍 Location: Remote / Hybrid
                        🗓 Duration: 6 Months (Full-Time)
                        💰 Stipend: ₹20,000 - ₹25,000 / month
                        🕒 Working Hours: Monday to Friday (9:30 AM - 6:30 PM)

                        📌 ABOUT THE ROLE:
                        Join our backend infrastructure team to design, deploy, and maintain scalable server architecture, microservices, and databases powering our mobile applications and client products.

                        📋 KEY RESPONSIBILITIES:
                        - Write clean, testable RESTful APIs and microservices using Node.js / Java Spring Boot.
                        - Design, optimize, and maintain relational (PostgreSQL) and NoSQL (MongoDB) databases.
                        - Implement secure user authentication protocols (OAuth2, JWT) and data encryption standards.
                        - Set up automated unit tests and participate in CI/CD cloud deployment pipelines.
                        - Monitor server metrics, analyze database query performance, and resolve backend bugs.

                        🎯 REQUIREMENTS & QUALIFICATIONS:
                        - Degree in Computer Science, Information Technology, or related engineering discipline.
                        - Practical knowledge of Java, Python, or JavaScript / Node.js backend development.
                        - Understanding of database design, SQL queries, indexing, and REST architecture.
                        - Basic knowledge of Docker, AWS / GCP cloud platforms, or Postman API testing.
                        - Strong analytical problem-solving skills and eagerness to learn new backend stacks.

                        🎁 PERKS & BENEFITS:
                        - Full hands-on experience building production enterprise cloud systems.
                        - Internship completion certificate and performance-based PPO opportunity.
                        - Friendly team culture with flexible working hours.
                    """.trimIndent()
                )
            )
        }
    }
}