package com.example.futs.data.cb

import com.example.futs.data.model.Table


interface TableRetrieved {
    fun onTableFetchedSuccess(table: List<Table>)

    fun onTableFetchedFailed()
}