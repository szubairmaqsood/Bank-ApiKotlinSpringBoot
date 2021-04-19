package com.SZubair.example.Api.datasource.mock

import com.SZubair.example.Api.datasource.BankDataSource
import com.SZubair.example.Api.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource:  BankDataSource{
    val banks = mutableListOf(
            Bank("1234",10.0,10),
            Bank("1010",11.0,11),
            Bank("5678",12.0,12),
    )
    override fun getBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull(){ it.accountNumber == accountNumber} ?: throw NoSuchElementException("Element with this id does not exist")
    }

    override fun createBank(bank: Bank): Bank {
        if (banks.any{it.accountNumber == bank.accountNumber})
        {
            throw IllegalArgumentException("Bank with account Number ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
      val currentBank  =banks.firstOrNull(){ it.accountNumber == bank.accountNumber} ?: throw NoSuchElementException("Element with this id does not exist")
        banks.remove(bank)
        banks.add(bank)
        return bank;
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank  =banks.firstOrNull(){ it.accountNumber == accountNumber} ?: throw NoSuchElementException("Element with this id does not exist")
        banks.remove(currentBank)
    }


}