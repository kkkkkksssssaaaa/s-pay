package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.controller

import dev.kkkkkksssssaaaa.spay.wallet.common.authentication.CurrentUser
import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.Wallet
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.controller.dto.UpdateBalanceRequest
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.service.FindWalletService
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.service.UpdateBalanceWalletService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/wallet")
class WalletController(
    private val findWalletService: FindWalletService,
    private val updateBalanceWalletService: UpdateBalanceWalletService,
) {
    @GetMapping("/me")
    fun getMyWallet(
        @CurrentUser user: User,
    ): ResponseEntity<Wallet> {
        return ResponseEntity.ok(findWalletService.get(user))
    }

    @PutMapping("/balance")
    fun doUpdateBalance(
        @CurrentUser user: User,
        @RequestBody request: UpdateBalanceRequest,
    ) {

    }
}