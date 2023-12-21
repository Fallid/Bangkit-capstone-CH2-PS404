package com.naufal.capstonech2ps404.data.repository

import com.naufal.capstonech2ps404.model.Dummy
import com.naufal.capstonech2ps404.model.Vacation

class VacationRepository {
    fun getVacations():List<Vacation>{
        return Dummy.vacations
    }

    fun searchVacations(query: String ): List<Vacation>{
        return Dummy.vacations.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}