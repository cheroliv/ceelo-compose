package ceelo.ui.stats

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import ceelo.service.local.inmemory.CeeloServiceInMemory
import ceelo.ui.stats.composables.GameRow

@Composable
fun StatsScreen(
    modifier: Modifier = Modifier,
    statsViewModel: StatsViewModel = viewModel(
        factory = StatsViewModelFactory(
            CeeloServiceInMemory(LocalContext.current)
        )
    )
) {
    val statsState by statsViewModel.uiState.collectAsState()

    LazyColumn(modifier = modifier) {
        items(statsState.games) { game ->
            GameRow(game = game)
        }
    }
}
