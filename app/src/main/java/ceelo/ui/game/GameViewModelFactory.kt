package ceelo.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ceelo.domain.service.ICeeloService

class GameViewModelFactory(private val ceeloService: ICeeloService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameViewModel(ceeloService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
