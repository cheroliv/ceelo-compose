package ceelo.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ceelo.domain.DiceThrowResult
import ceelo.domain.compareThrows
import ceelo.domain.service.ICeeloService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel(private val ceeloService: ICeeloService) : ViewModel() {

    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    fun rollDices() {
        viewModelScope.launch {
            val game = ceeloService.launchLocalGame()
            val playerThrow = game.first()
            val computerThrow = game.last()
            val result = playerThrow.compareThrows(computerThrow)
            _uiState.value = GameState(
                playerDices = playerThrow,
                computerDices = computerThrow,
                result = result
            )
            ceeloService.saveGame(game)
        }
    }
}

data class GameState(
    val playerDices: List<Int> = emptyList(),
    val computerDices: List<Int> = emptyList(),
    val result: DiceThrowResult? = null
)
