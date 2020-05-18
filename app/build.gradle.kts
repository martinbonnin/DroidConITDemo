plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.apollographql.apollo").version("2.0.3")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "net.mbonnin.droidconitdemo"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java) {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.squareup.okhttp3:okhttp:4.7.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha02")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta6")

    implementation("com.apollographql.apollo:apollo-runtime:2.0.3")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.0.3")

    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

apollo {
    generateKotlinModels.set(true)
}