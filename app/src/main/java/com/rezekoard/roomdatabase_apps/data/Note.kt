package com.rezekoard.roomdatabase_apps.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note (
    val title: String,
    val description: String,
    val dateAdded: Long,

    // primary key
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)