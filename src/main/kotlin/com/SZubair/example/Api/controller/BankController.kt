package com.SZubair.example.Api.controller

import com.SZubair.example.Api.model.Bank
import com.SZubair.example.Api.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.*

@RestController
@RequestMapping("api/banks")
class BankController(private val  service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    fun getBanks(): Collection<Bank>{
        return service.getBanks()
    }

    @GetMapping("{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank{
        return service.getBank(accountNumber)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank): Bank {
        service.addBank(bank)
        return bank
    }

    @PatchMapping
    fun updateBank(@RequestBody bank: Bank): Bank
    {
        return service.updateBank(bank)
    }
    @DeleteMapping("{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@PathVariable accountNumber: String): Unit{
            service.deleteBank(accountNumber)
    }
}