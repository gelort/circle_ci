package mvvm_coroutines.gelort.com.myapplication.dagger.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by gelort on 2019-05-20.
 */

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}