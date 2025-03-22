package com.example.notes.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notes.model.Note

class NoteViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note>
        get() = _notes.toList()

    fun addNote(n: Note): Unit {
        _notes.add(n)
    }

    fun removeNote(n: Note): Boolean {
//        Log.d("LARRY", "removeNote " + n.id)
        val didRemove =  _notes.remove(n)
        Log.d("LARRY", "removeNote " + n.id + " didRemove=$didRemove, len=${_notes.count()}")
        return didRemove
    }
}
