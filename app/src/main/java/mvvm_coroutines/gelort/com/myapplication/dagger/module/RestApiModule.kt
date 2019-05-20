package mvvm_coroutines.gelort.com.myapplication.dagger.module

import dagger.Module
import dagger.Provides
import mvvm_coroutines.gelort.com.myapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by gelort on 2019-05-20.
 */

@Module
class RestApiModule {
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.d(message)
            }
        })
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        logger: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

//    @Provides
//    @Singleton
//    fun provideMoshi(
//        logger: Timber,
//        currentServerInteractor: GetCurrentServerInteractor
//    ): Moshi {
//        val url = currentServerInteractor.get() ?: ""
//        return Moshi.Builder()
//            .add(FallbackSealedClassJsonAdapter.ADAPTER_FACTORY)
//            .add(AppJsonAdapterFactory.INSTANCE)
//            .add(AttachmentAdapterFactory(NoOpLogger))
//            .add(
//                java.lang.Long::class.java,
//                ISO8601Date::class.java,
//                TimestampAdapter(CalendarISO8601Converter())
//            )
//            .add(
//                Long::class.java,
//                ISO8601Date::class.java,
//                TimestampAdapter(CalendarISO8601Converter())
//            )
//            .add(ReactionsAdapter())
//            .build()
//    }


}