package com.example.notes.model

import java.util.UUID

class NoteViewModel {
    val _notes: MutableList<Note> = mutableListOf<Note>()
//    val notes: List<Note>
//        get() = _notes.toList()
    val notes = _notes

    fun addNote(n: Note): Unit {
        _notes.add(n)
    }

    fun removeNote(id: UUID): Boolean {
        return _notes.removeIf {
            n -> n.id === id
        }
    }
}
