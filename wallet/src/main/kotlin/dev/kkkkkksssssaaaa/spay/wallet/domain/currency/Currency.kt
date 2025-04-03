package dev.kkkkkksssssaaaa.spay.wallet.domain.currency

import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.impl.Dollar
import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.impl.Euro
import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.impl.Won
import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.impl.Yen
import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.impl.Yuan

abstract class Currency (
    val type: CurrencyType
) {
    companion object {
        fun typeOf(type: CurrencyType): Currency {
            return when (type) {
                CurrencyType.KRW -> Won()
                CurrencyType.USD -> Dollar()
                CurrencyType.EUR -> Euro()
                CurrencyType.JPY -> Yen()
                CurrencyType.CNY -> Yuan()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Currency) return false

        return other.type == this.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}