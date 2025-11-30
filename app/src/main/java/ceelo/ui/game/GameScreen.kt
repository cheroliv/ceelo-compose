package ceelo.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ceelo.domain.PLAYER_ONE_NAME
import ceelo.domain.PLAYER_TWO_NAME
import ceelo.service.local.inmemory.CeeloServiceInMemory

@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel(
        factory = GameViewModelFactory(
            CeeloServiceInMemory(LocalContext.current)
        )
    )
) {
    val gameState by gameViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = PLAYER_ONE_NAME)
            DiceImages(dices = gameState.playerDices)
        }

        Text(text = "Result: ${gameState.result?.name ?: "Roll the dices"}")

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = PLAYER_TWO_NAME)
            DiceImages(dices = gameState.computerDices)
        }

        Button(onClick = { gameViewModel.rollDices() }) {
            Text(text = "Roll")
        }
    }
}
