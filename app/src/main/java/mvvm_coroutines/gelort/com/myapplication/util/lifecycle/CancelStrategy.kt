package mvvm_coroutines.gelort.com.myapplication.util.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.Job

/**
 * Created by gelort on 2019-05-16.
 */

class CancelStrategy(owner: LifecycleOwner, val jobs: Job) : LifecycleObserver {

    init {
        owner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        jobs.cancel()
    }
}