package com.example.mybasetemplate.ui.compose.only_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybasetemplate.ui.compose.ui.theme.LayoutsCodelabTheme

class ComposeCodelabActivitySecond : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

// Modifier를 유동적으로 달 수 있는 추천 컨벤션
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row {
        Surface(
            modifier = modifier
                .size(50.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = { /* Ignoring onClick */ })
                .padding(16.dp)
                .size(50.dp)
        ) {

        }

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minuites ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

// Modifier를 유동적으로 달 수 있는 추천 컨벤션
@Composable
fun PhotographerCardWithDefaultModifier(modifier: Modifier = Modifier) {
    Row(modifier) { }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    LayoutsCodelabTheme {
        PhotographerCard()
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
//        BodyContent(
//            Modifier
//                .padding(innerPadding)
//                .padding(8.dp)
//        )

        BodyContent()
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}

// then : DefaultModifier 값이 없는 경우 별도의 Modifier 값 적용이 가능
@Preview
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.then(Modifier.padding(100.dp))) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}
