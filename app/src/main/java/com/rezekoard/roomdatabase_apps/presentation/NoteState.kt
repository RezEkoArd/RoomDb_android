package com.rezekoard.roomdatabase_apps.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.rezekoard.roomdatabase_apps.data.Note

data class NoteState (
    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf("")
)