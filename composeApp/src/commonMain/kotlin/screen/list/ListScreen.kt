package screen.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun ListScreen(
    viewModel: ListViewModel = ListViewModel()
) {

    val state by viewModel.state

    when (state) {
        is RocketState.Loading -> {
            Text("Идет загрузка...")
        }

        is RocketState.Success -> {
            val rockets = (state as RocketState.Success).rockets
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(rockets) { rocket ->
                    RocketItem(
                        rocket = rocket,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        is RocketState.Error -> {
            Text("Возникла ошибка - ${(state as RocketState.Error).message}")
        }
    }
}