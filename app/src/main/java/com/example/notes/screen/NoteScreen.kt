package com.example.notes.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.R
import com.example.notes.components.NoteButton
import com.example.notes.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(modifier: Modifier = Modifier) {
    val title = remember {
        mutableStateOf("")
    }
    val content = remember {
        mutableStateOf("")
    }

    Column(modifier = modifier
        .padding(6.dp)
        .fillMaxSize()) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "action")
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDADFE3))
        )

        // New Note Form
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                value = title.value,
                label = "Title",
                onValueChange = { v ->
                    title.value = v
                })
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                value = content.value,
                label = "Add a note",
                onValueChange = { v ->
                    content.value = v
                })
            NoteButton(label = "Save", onClick = {
                Log.d("NOTE", "save note title=${title.value} and content=${content.value}")
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}
