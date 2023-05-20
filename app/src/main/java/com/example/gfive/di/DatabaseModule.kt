package com.example.gfive.di

import android.content.Context
import com.example.gfive.data.database.GFiveDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = GFiveDatabase.getInstance(context)


    @Provides
    fun provideDao(database: GFiveDatabase) = database.gfiveDao()
}