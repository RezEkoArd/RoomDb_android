package com.rezekoard.roomdatabase_apps.di

import android.app.Application
import androidx.room.Room
import com.rezekoard.roomdatabase_apps.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) : NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            "notes.db"
        ).build()
    }
}