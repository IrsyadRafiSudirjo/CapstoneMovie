package com.example.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    val passphrase: ByteArray = SQLiteDatabase.getBytes("movie".toCharArray())
    val factory = SupportFactory(passphrase)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): com.example.core.data.source.local.room.MovieDatabase =
        Room.databaseBuilder(
            context,
            com.example.core.data.source.local.room.MovieDatabase::class.java, "Movie.db"
        ).openHelperFactory(factory).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: com.example.core.data.source.local.room.MovieDatabase): com.example.core.data.source.local.room.MovieDao =
        database.movieDao()
}