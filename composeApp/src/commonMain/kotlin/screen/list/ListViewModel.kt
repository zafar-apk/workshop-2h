package screen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.ClientHolder
import data.getAllRockets
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    throwable.printStackTrace()
    println("error: ${throwable.message}")
}

class ListViewModel(
    coroutineScope: CoroutineScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob() + exceptionHandler
    )
) {

    private val _state: MutableState<RocketState> = mutableStateOf(RocketState.Loading)
    val state: State<RocketState> get() = _state

    init {
        coroutineScope.launch(exceptionHandler) {
            _state.value = RocketState.Loading
            val httpClient = ClientHolder.client
            _state.value = runCatching {
                val rockets = getAllRockets(httpClient)
                RocketState.Success(rockets)
            }
                .getOrElse { exception ->
                    exception.printStackTrace()
                    RocketState.Error(exception.message ?: "Unknown error has happened")
                }
        }
    }
}