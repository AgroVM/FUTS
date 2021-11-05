package com.example.futs.data.cb

import com.example.futs.data.model.Goalscorers


interface GoalscorerRetrieved {
    fun onGoalScorerFetchedSuccess(goalscorers: List<Goalscorers>)

    fun onGoalScorerFetchedFailed()
}