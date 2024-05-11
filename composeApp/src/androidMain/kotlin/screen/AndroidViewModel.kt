package screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import screen.list.ListViewModel

class AndroidViewModel: ViewModel() {
    val viewModel = ListViewModel(viewModelScope)
}