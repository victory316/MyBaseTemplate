package com.example.mybasetemplate.ext

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Activity.startActivity(activity: Activity) {
    startActivity(Intent(this, activity.javaClass))
}

fun Activity.startActivityClearTop(activity: Activity) {
    startActivity(Intent(this, activity.javaClass).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
}

fun Activity.setDelayedFunction(function: () -> Unit, delay: Long) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(delay)
        CoroutineScope(Dispatchers.Main).launch {
            function.invoke()
        }
    }
}

fun Activity.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun FragmentActivity.replaceFragment(id: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(id, fragment).commit()
}
