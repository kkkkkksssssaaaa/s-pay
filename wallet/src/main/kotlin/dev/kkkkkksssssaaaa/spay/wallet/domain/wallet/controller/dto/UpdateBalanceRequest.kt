package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.controller.dto

data class UpdateBalanceRequest(
    val walletId: Long,
    val amount: Double,
) {
    companion object {

    }
}