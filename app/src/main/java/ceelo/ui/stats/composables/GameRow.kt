package ceelo.ui.stats.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ceelo.ui.game.DiceImages

@Composable
fun GameRow(game: List<List<Int>>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DiceImages(dices = game.first())
        Text(text = "vs")
        DiceImages(dices = game.last())
    }
}

@Preview(showBackground = true)
@Composable
fun GameRowPreview() {
    GameRow(game = listOf(listOf(4, 5, 6), listOf(1, 1, 1)))
}
