package com.mitidimitara.exchangeRate.di

import com.mitidimitara.exchangeRate.data.remote.ExchangeRateApi
import com.mitidimitara.exchangeRate.data.remote.tasks.GetLatestExchangeRatesTask
import com.mitidimitara.exchangeRate.data.repository.ExchangeRateRemoteSource
import com.mitidimitara.exchangeRate.data.repository.ExchangeRateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideExchangeRateRepository(remoteSource: ExchangeRateRemoteSource) =
        ExchangeRateRepository(remoteSource)

    @Provides
    @Singleton
    fun provideExchangeRateRemoteSource(
        task: GetLatestExchangeRatesTask
    ): ExchangeRateRepository.RemoteSource =
        ExchangeRateRemoteSource(task)
}