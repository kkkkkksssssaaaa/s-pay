package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.controller

import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.controller.dto.UpdateBalanceRequest
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.service.UpdateBalanceWalletService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/wallet")
class WalletController(
    private val updateBalanceWalletService: UpdateBalanceWalletService,
) {
    @PutMapping("/balance")
    fun doUpdateBalance(
        // TODO: 사용자 정보 가져와야 함
        @RequestBody request: UpdateBalanceRequest,
    ) {

    }
}