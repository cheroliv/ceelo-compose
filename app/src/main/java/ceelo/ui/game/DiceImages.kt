package ceelo.ui.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ceelo.R

@Composable
fun DiceImages(dices: List<Int>, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        dices.forEach { dice ->
            val drawable = when (dice) {
                1 -> R.drawable.dice_face_one
                2 -> R.drawable.dice_face_two
                3 -> R.drawable.dice_face_three
                4 -> R.drawable.dice_face_four
                5 -> R.drawable.dice_face_five
                6 -> R.drawable.dice_face_six
                else -> R.drawable.dice_face_one // Should not happen
            }
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "Dice face $dice",
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp)
            )
        }
    }
}
