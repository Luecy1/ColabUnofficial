package com.github.luecy1.colabunofficial.util

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkState(): Boolean {

    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = cm.activeNetworkInfo ?: return false

    return networkInfo.isConnected
}