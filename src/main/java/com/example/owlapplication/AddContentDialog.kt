package com.example.owlapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp

@Composable
fun AddContentDialog(onDismiss: () -> Unit, onConfirm: (String) -> Unit) {
    var newContent by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add New Content") },
        text = {
            Column {
                BasicTextField(
                    value = newContent,
                    onValueChange = { newContent = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    singleLine = false
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(newContent) // Pass the new content
                    onDismiss() // Close the dialog
                }
            ) {
                Text("Confirm", color = Color.Green)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = Color.Red)
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}