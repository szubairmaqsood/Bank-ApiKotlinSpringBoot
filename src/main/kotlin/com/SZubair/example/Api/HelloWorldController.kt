package com.SZubair.example.Api

import com.SZubair.example.Api.model.Bank
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/Hello")
class HelloWorldController {

    @GetMapping("/springboot")
    fun helloWorld(): String {
        //return "This is a Hello String, it is an end Point"
        val a = Bank("Zubair",10.0,10)
        return "These are account details ${a.accountNumber}  ${a.trust} ${a.transactionFee}"
    }
}