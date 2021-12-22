package za.co.app.bitrisebuddy

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import za.co.app.bitrisebuddy.model.data.apis.ApplicationApi
import za.co.app.bitrisebuddy.model.data.apis.BuildsApi
import za.co.app.bitrisebuddy.model.data.apis.UserApi
import za.co.app.bitrisebuddy.model.repository.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BitriseBuddyModule {

    const val  API_BASE_URL = "https://api.bitrise.io/v0.1/"

    @Provides
    @Singleton
    fun applicationApiService(): ApplicationApi {
         return Retrofit.Builder().baseUrl(API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(ApplicationApi::class.java)
    }

    @Provides
    @Singleton
    fun userApiService(): UserApi {
         return Retrofit.Builder().baseUrl(API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun buildsApiService(): BuildsApi {
         return Retrofit.Builder().baseUrl(API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(BuildsApi::class.java)
    }

    private fun okHttpClient() = OkHttpClient().newBuilder()
        .callTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun repository (api: ApplicationApi, @ApplicationContext context : Context) : IAppsRepository{
        return AppsRepository(api, context)
    }

    @Provides
    @Singleton
    fun userRepository (userApi: UserApi, @ApplicationContext context : Context) : IUserRepository{
        return UserRepository(userApi, context)
    }

    @Provides
    @Singleton
    fun buildRepository (buildsApi: BuildsApi, @ApplicationContext context : Context) : IBuildsRepository {
        return BuildsRepository(buildsApi, context)
    }
}