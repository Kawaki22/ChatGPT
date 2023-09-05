package com.ai.chatgpt.di

import com.ai.chatgpt.Utils
import com.ai.chatgpt.network.ChatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideChatGptApi(): ChatApi = Retrofit.Builder()
        .baseUrl(Utils.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(ChatApi::class.java)

}