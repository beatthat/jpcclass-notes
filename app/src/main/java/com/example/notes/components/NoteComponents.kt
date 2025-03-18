package com.example.notes.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    maxLines: Int = 1,
    onValueChange: (String) -> Unit = {},
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
        ),
        maxLines = maxLines,
        label = { Text(text=label, color = MaterialTheme.colorScheme.primary)},
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
        )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Button(onClick = onClick, shape = CircleShape, enabled = enabled) {
        Text(label)
    }
}
