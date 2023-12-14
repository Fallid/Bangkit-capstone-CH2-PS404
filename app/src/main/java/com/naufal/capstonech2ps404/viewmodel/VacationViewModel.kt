package com.naufal.capstonech2ps404.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.model.Vacation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VacationsViewModel(private val repository: VacationRepository): ViewModel() {
    private val _groupedVacations = MutableStateFlow(
        repository.getVacations().sortedBy { it.name }.groupBy { it.name[0] }
    )

    val groupedVacation: StateFlow<Map<Char, List<Vacation>>> get () = _groupedVacations
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedVacations.value = repository.searchVacations(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}

class ViewModelFactory(private val repository: VacationRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VacationsViewModel::class.java)) {
            return VacationsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}