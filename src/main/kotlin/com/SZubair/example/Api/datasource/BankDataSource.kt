package com.SZubair.example.Api.datasource

import com.SZubair.example.Api.model.Bank

interface BankDataSource {
    fun getBanks() : Collection<Bank>
    fun retrieveBank(accountNumber: String) : Bank
    fun createBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
    fun deleteBank(bank: String)
}