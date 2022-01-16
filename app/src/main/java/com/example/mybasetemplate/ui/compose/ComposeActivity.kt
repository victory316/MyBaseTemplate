package com.example.mybasetemplate.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybasetemplate.ui.compose.ui.dialog.ComposeDialogs.AlertDialogSample
import com.example.mybasetemplate.ui.compose.ui.theme.MyBaseTemplateTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyBaseTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    Column(modifier = Modifier.padding(24.dp)) {
                        Greeting(content = "Hello Compose!")
                        OutlinedButtonExample("Only using Compose")
                        OutlinedButtonExample("Mix with Android Views")
                    }
                }
            }

        }
    }
}

@Composable
fun OutlinedButtonExample(title: String) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val button = createRef()

        OutlinedButton(onClick = { /* Do something! */ },
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(title)
        }
    }
}


@Composable
fun Greeting(content: String) {
    Text(text = content, fontWeight = FontWeight.Bold)
}