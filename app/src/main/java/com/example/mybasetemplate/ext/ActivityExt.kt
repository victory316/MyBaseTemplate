package com.example.mybasetemplate.ext

import android.app.Activity
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Activity.startActivity(activity: Activity) {
    startActivity(Intent(this, activity.javaClass))
}

fun Activity.setDelayedFunction(function: () -> Unit, delay: Long) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(delay)
        function.invoke()
    }
}