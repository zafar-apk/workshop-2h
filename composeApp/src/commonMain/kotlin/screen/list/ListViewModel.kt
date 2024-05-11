package screen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import data.ClientHolder
import data.getAllRockets
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class ListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return ListViewModel() as T
    }
}

class ListViewModel : ViewModel() {

    private val _state: MutableState<RocketState> = mutableStateOf(RocketState.Loading)
    val state: State<RocketState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = RocketState.Loading
            val httpClient = ClientHolder.httpClient
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