package com.rezekoard.roomdatabase_apps.presentation
import com.rezekoard.roomdatabase_apps.data.Note

sealed interface NotesEvent {
    object SortNotes: NotesEvent

    data class DeleteNote(val note: Note): NotesEvent

    data class SaveNote(
        val title: String,
        val description: String,
    ): NotesEvent
}