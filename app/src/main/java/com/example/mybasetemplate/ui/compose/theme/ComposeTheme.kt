package com.example.mybasetemplate.ui.compose.theme

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val JetchatDarkColorScheme = darkColors(
    primary = Color.Black,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.White,
    error = Color.White,
    onError = Color.White,
    background = Color.White,
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Color.White,
)

private val JetchatLightColorScheme = lightColors(
    primary = Color.Black,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.White,
    error = Color.White,
    onError = Color.White,
    background = Color.White,
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Color.White,
)

@SuppressLint("NewApi")
@Composable
fun JetchatTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val dynamicColor = isDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val myColorScheme = when {
        isDarkTheme -> JetchatDarkColorScheme
        else -> JetchatLightColorScheme
    }

    MaterialTheme(
        colors = myColorScheme
    ) {
        // TODO (M3): MaterialTheme doesn't provide LocalIndication, remove when it does
        val rippleIndication = rememberRipple()
        CompositionLocalProvider(
            LocalIndication provides rippleIndication,
            content = content
        )
    }
}
