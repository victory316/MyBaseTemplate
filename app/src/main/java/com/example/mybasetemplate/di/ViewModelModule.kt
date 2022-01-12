package com.example.mybasetemplate.di

import com.example.mybasetemplate.presentation.MaterialViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Provides
    @Singleton
    fun provideMaterialViewModel() = MaterialViewModel()
}