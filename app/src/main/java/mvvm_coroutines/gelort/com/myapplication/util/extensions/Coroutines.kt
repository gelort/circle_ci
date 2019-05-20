package mvvm_coroutines.gelort.com.myapplication.util.extensions

import kotlinx.coroutines.*
import mvvm_coroutines.gelort.com.myapplication.util.lifecycle.CancelStrategy

/**
 * Created by gelort on 2019-05-16.
 */

@ExperimentalCoroutinesApi
fun launchUI(strategy: CancelStrategy, block: suspend CoroutineScope.() -> Unit): Job =
    MainScope().launch(context = strategy.jobs, block = block)