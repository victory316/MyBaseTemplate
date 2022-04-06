//package com.example.mybasetemplate.di
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.android.scopes.ViewModelScoped
//
//@Module
//@InstallIn(ViewModelComponent::class)
//object RepositoryModule {
//
//    @Provides
//    @ViewModelScoped
//    fun provideMainRepository(
//        mainApi: MainApi
//    ): MainRepositoryInterface {
//        return MainRepositoryImpl(mainApi)
//    }
//}