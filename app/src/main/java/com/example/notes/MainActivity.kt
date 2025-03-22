package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.screen.NoteViewModel
import com.example.notes.screen.NoteScreen
import com.example.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel: NoteViewModel by viewModels<NoteViewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NoteScreen(
                        modifier = Modifier.padding(innerPadding),
                        notes = viewModel.notes,
                        onAddNote = {n ->
                            viewModel.addNote(n)
                        },
                        onRemoveNote = {n ->
                            viewModel.removeNote(n)
                        }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    NotesTheme {
        NoteScreen()
    }
}
