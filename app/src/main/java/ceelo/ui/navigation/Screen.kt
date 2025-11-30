package ceelo.ui.navigation

sealed class Screen(val route: String) {
    object Game : Screen("game")
    object Stats : Screen("stats")
}
