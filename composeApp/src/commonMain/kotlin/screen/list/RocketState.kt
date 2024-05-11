package screen.list

sealed interface RocketState {
    data object Loading : RocketState
    data class Success(val rockets: RocketList) : RocketState
    data class Error(val message: String) : RocketState
}
