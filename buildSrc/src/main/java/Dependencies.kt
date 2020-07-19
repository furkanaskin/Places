/**
 * Created by Furkan on 12.07.2020
 */

object BuildVersions {
    const val compileSdkVersion = 29
    const val minSdkVersion = 23
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val android_plugin = "4.1.0-beta02"
    const val kotlin = "1.3.72"
    const val support_version = "1.0.0"
    const val appCompatVersion = "1.2.0-alpha03"
    const val coreKtxVersion = "1.3.0-alpha02"
    const val rxJavaVersion = "2.2.18"
    const val rxKotlinVersion = "2.4.0"
    const val rxAndroidVersion = "2.1.1"
    const val rxAnimationsVersion = "0.0.6"
    const val timberVersion = "4.7.1"
    const val dagger = "2.28-alpha"
    const val dagger_lifecycle = "1.0.0-alpha01"
    const val retrofitVersion = "2.7.2"
    const val okHttpVersion = "4.4.1"
    const val picassoVersion = "2.71828"
    const val navigationVersion = "2.3.0"
    const val fragmentVersion = "1.2.5"
    const val threetenabpVersion = "1.2.2"
    const val stethoVersion = "1.5.1"
    const val lifecycleViewModelKtxVersion = "2.3.0-alpha01"
    const val lifecycleVersion = "2.2.0"
    const val roomVersion = "2.2.3"
    const val dataBindingVersion = "4.1.0-beta02"
    const val moshiConverterVersion = "2.7.2"
    const val moshiVersion = "1.9.2"
    const val materialDesignVersion = "1.3.0-alpha01"
    const val coreTestingVersion = "2.1.0"
    const val mockKVersion = "1.9.3"
    const val truthExtVersion = "1.3.0-alpha03"
    const val truthVersion = "1.0"
    const val androidxTestRunnerVersion = "1.3.0-alpha03"
    const val espressoCoreVersion = "3.3.0-alpha03"
    const val junitVersion = "4.12"
    const val junitExtVersion = "1.1.1"
    const val robolectricVersion = "4.3.1"
    const val easyPermissionsVersion = "3.0.0"
    const val gmsLocationVersion = "17.0.0"
    const val preferencesVersion = "1.1.1"
    const val constraintVersion = "1.1.3"
    const val ratingBarVersion = "1.5.0"
    const val recyclerViewVersion = "1.2.0-alpha04"
}

object BuildPlugins {
    const val androidGradle = "com.android.tools.build:gradle:${Versions.android_plugin}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val daggerGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
    const val navigationGradle =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
}

object Dependencies {
    const val kotlinLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val androidxTestRunner = "androidx.test:runner:${Versions.androidxTestRunnerVersion}"
    const val androidxTestRules = "androidx.test:rules:${Versions.androidxTestRunnerVersion}"
    const val junitTestExt = "androidx.test.ext:junit-ktx:${Versions.junitExtVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val truth = "com.google.truth:truth:${Versions.truthVersion}"
    const val truthExt = "androidx.test.ext:truth:${Versions.truthExtVersion}"
    const val mockK = "io.mockk:mockk:${Versions.mockKVersion}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"

    const val supportv4 = "androidx.legacy:legacy-support-v4:${Versions.support_version}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val materialDesign =
        "com.google.android.material:material:${Versions.materialDesignVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val cardView = "androidx.cardview:cardview:${Versions.support_version}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val preferencesKtx = "androidx.preference:preference-ktx:${Versions.preferencesVersion}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    const val rxAnimations = "com.mikhaellopez:rxanimation:${Versions.rxAnimationsVersion}"

    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val lifecycleAnnotation =
        "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtxVersion}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    const val fragment = "androidx.fragment:fragment:${Versions.fragmentVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    const val dataBindingCompilerKapt =
        "androidx.databinding:databinding-compiler:${Versions.dataBindingVersion}"
    const val dataBindingCompilerAnnotation =
        "androidx.databinding:databinding-compiler:${Versions.dataBindingVersion}"

    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val daggerAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"

    const val daggerViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.dagger_lifecycle}"
    const val daggerHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.dagger_lifecycle}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val moshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
    const val easyPermissions = "pub.devrel:easypermissions:${Versions.easyPermissionsVersion}"
    const val threetenabp = "com.jakewharton.threetenabp:threetenabp:${Versions.threetenabpVersion}"
    const val ratingBar = "com.github.ome450901:SimpleRatingBar:${Versions.ratingBarVersion}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val gmsLocation =
        "com.google.android.gms:play-services-location:${Versions.gmsLocationVersion}"
    const val stethoCore = "com.facebook.stetho:stetho:${Versions.stethoVersion}"
    const val stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stethoVersion}"
    const val stethoUrlConnection =
        "com.facebook.stetho:stetho-urlconnection:${Versions.stethoVersion}"
}