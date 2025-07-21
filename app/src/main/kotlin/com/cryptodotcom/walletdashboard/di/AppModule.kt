package com.cryptodotcom.walletdashboard.di

import com.cryptodotcom.walletdashboard.data.datasource.LocalDataSource
import com.cryptodotcom.walletdashboard.data.repository.WalletRepository
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
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSource()
    }
    
    @Provides
    @Singleton
    fun provideWalletRepository(localDataSource: LocalDataSource): WalletRepository {
        return WalletRepository(localDataSource)
    }
}
