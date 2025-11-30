package ceelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ceelo.theme.CeeloComposeTheme
import ceelo.ui.game.GameScreen
import ceelo.ui.navigation.BottomNavigationBar
import ceelo.ui.navigation.Screen
import ceelo.ui.stats.StatsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CeeloComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Game.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Game.route) { GameScreen() }
            composable(Screen.Stats.route) { StatsScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CeeloComposeTheme {
        MainScreen()
    }
}