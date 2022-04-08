package com.example.mybasetemplate.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.example.mybasetemplate.ext.startActivity
import com.example.mybasetemplate.ui.compose.mixed_compose.MixedComposeActivity
import com.example.mybasetemplate.ui.compose.only_compose.ComposeCodelabActivity
import com.example.mybasetemplate.ui.compose.only_compose.ComposeCodelabActivityFirst
import com.example.mybasetemplate.ui.compose.only_compose.ComposeCodelabActivitySecond
import com.example.mybasetemplate.ui.compose.ui.theme.MyBaseTemplateTheme
import com.example.mybasetemplate.ui.compose.ui.theme.Typography

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyBaseTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        Greeting(content = "Hello Compose!")
                        OutlinedButtonWithFunction("Tutorial : Jetpack Compose Basic ",
                            function = {
                                startActivity(ComposeCodelabActivity())
                            })
                        OutlinedButtonWithFunction("CODELAB : Jetpack Compose Basic",
                            function = {
                                startActivity(ComposeCodelabActivityFirst())
                            })

                        OutlinedButtonWithFunction("CODELAB : Layouts in Jetpack Compose",
                            function = {
                                startActivity(ComposeCodelabActivitySecond())
                            })

                        OutlinedButtonWithFunction("Mix with Android Views",
                            function = {
                                startActivity(MixedComposeActivity())
                            })

                    }
                }
            }
        }
    }
}

@Composable
fun ActivityContent() {

}

@Composable
fun OutlinedButtonWithFunction(title: String, function: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        val button = createRef()

        OutlinedButton(onClick = { function.invoke() },
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
    Text(text = content, style = Typography.body1)
}

@Composable
@Preview("ButtonPreview")
fun OutlinedButtonPreview() {
    OutlinedButtonWithFunction("Only using Compose",
        function = {
        })
}
