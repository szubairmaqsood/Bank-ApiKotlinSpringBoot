package com.SZubair.example.Api.service

import com.SZubair.example.Api.datasource.BankDataSource
import com.SZubair.example.Api.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


class BankService ()  private val dataSource: BankDataSource){

    fun getBanks(): Collection<Bank>{
        val banks = dataSource.getBanks()
        return banks
    }

    fun getBank(accountNumber: String):Bank{
        return dataSource.retrieveBank(accountNumber)
    }

    fun addBank(bank: Bank): Bank {
        return dataSource.createBank(bank)
    }

    fun updateBank(bank: Bank): Bank{
        return dataSource.updateBank(bank)
    }

    fun deleteBank(accountNumber: String): Unit{
        dataSource.deleteBank(accountNumber)
    }
}