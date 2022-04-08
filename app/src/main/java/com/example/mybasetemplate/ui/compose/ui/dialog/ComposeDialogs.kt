package com.example.mybasetemplate.ui.compose.ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

object ComposeDialogs {

    @Composable
    fun AlertDialogSample() {
        val openDialog = remember { mutableStateOf(false) }

        MaterialTheme {
            Column {

                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text("Click me")
                }

                if (openDialog.value) {

                    AlertDialog(
                        onDismissRequest = {
                            // Dismiss the dialog when the user clicks outside the dialog or on the back
                            // button. If you want to disable that functionality, simply use an empty
                            // onCloseRequest.
                            openDialog.value = false
                        },
                        title = {
                            Text(text = "Dialog Title")
                        },
                        text = {
                            Text("Here is a text ")
                        },
                        confirmButton = {
                            Button(

                                onClick = {
                                    openDialog.value = false
                                }) {
                                Text("This is the Confirm Button")
                            }
                        },
                        dismissButton = {
                            Button(

                                onClick = {
                                    openDialog.value = false
                                }) {
                                Text("This is the dismiss Button")
                            }
                        }
                    )
                }
            }
        }
    }
}
