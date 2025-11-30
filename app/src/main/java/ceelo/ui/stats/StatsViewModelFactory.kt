package ceelo.ui.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ceelo.domain.service.ICeeloService

class StatsViewModelFactory(private val ceeloService: ICeeloService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StatsViewModel(ceeloService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
