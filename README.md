# 📱 Veda Technology Internship Companion App

A modern, native Android application built using **Kotlin**, **MVVM Architecture**, and **Jetpack Room Database**. This app enables prospective interns to explore detailed internship opportunities at Veda Technology, view rich role requirements, and submit their applications directly within the app interface.

---

## ✨ Features

- **Dynamic Job Listing (Explore Mode)**: Displays available internship listings with short previews using `RecyclerView` and `MaterialCardView`.
- **Detailed Job Overview**: Displays a comprehensive 15+ line breakdown for each role including Location, Duration, Stipend, Key Responsibilities, Requirements, and Benefits upon selecting a position.
- **In-App Application Flow**: Integrated application form (`ApplyActivity`) supporting user detail submission (Name, Email, Phone, Portfolio/GitHub links).
- **Interactive Feedback**: Reusable confirmation dialogs (`AlertDialog`) acknowledging successful submissions.
- **Local Persistence**: Built on Room Database with reactive updates powered by `LiveData` and `ViewModel`.

---

## 🛠️ Tech Stack & Architecture

- **Language**: Kotlin
- **UI Components**: Material Design 3, XML, ConstraintLayout, ScrollView, RecyclerView
- **Architecture**: Model-View-ViewModel (MVVM)
- **Database / Storage**: Room Persistence Library, LiveData
- **Concurrency**: Kotlin Coroutines (`viewModelScope`)
- **IDE**: Android Studio

##📁 Project Structure
- com.example.vedatechnologyinternshipcompanionapp/
│
├── data/
│   ├── AppDatabase.kt          # Room Database setup & migrations
│   ├── InternshipDao.kt        # Data Access Object for Room queries
│   └── InternshipItem.kt       # Database Entity Model (short & full descriptions)
│
├── ui/
│   ├── MainActivity.kt         # Launcher screen & RecyclerView container
│   ├── DetailActivity.kt       # Full role specification & detail view
│   ├── ApplyActivity.kt        # Application submission form
│   └── InternshipAdapter.kt   # RecyclerView ListAdapter with DiffUtil
│
└── viewmodel/
    └── InternshipViewModel.kt  # ViewModel connecting UI to Room Database

---

## 💻 System & Prerequisites

Before running the application, make sure you have the following installed and set up:
- **Android Studio** (Ladybug / Jellyfish or newer recommended).
- **JDK 17** or higher (configured in Android Studio).
- **Android SDK Platform** API Level 34 / 35 (Minimum SDK support: API 24+ / Android 7.0).
- An **Android Device** (physical hardware connected via USB/Wireless Debugging) or an **Android Virtual Device (AVD)** emulator.

---

## 🚀 How to Run the App (Step-by-Step Guide)

### Step 1: Clone or Download the Project
1. Open your terminal or Git Bash.
2. Run the following command to clone the repository:
   ```bash
   git clone [https://github.com/shanmukhapriya23/VedaTechnologyInternshipCompanion.git](https://github.com/shanmukhapriya23/VedaTechnologyInternshipCompanion.git)
