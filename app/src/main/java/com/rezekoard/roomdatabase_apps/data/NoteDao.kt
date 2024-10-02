package com.rezekoard.roomdatabase_apps.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//DAO adalah komponen utama Room yang
    // bertanggung jawab untuk menentukan antarmuka yang mengakses database

@Dao
interface NoteDao {

    @Upsert
    // suspend = to async the function
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNoteOrderByDateAdded(): Flow<List<Note>>

    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNoteOrderByTitle(): Flow<List<Note>>
}
