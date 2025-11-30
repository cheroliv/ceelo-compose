package ceelo.ui.stats

import androidx.lifecycle.ViewModel
import ceelo.domain.service.ICeeloService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StatsViewModel(private val ceeloService: ICeeloService) : ViewModel() {

    private val _uiState = MutableStateFlow(StatsState())
    val uiState: StateFlow<StatsState> = _uiState.asStateFlow()

    init {
        loadGames()
    }

    private fun loadGames() {
        _uiState.value = StatsState(games = ceeloService.allGames())
    }
}

data class StatsState(
    val games: List<List<List<Int>>> = emptyList()
)
