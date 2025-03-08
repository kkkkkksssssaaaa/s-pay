package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

interface CalculateFeeService {
    fun doCalculate(amount: Double): Fee
}