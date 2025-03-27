package dev.kkkkkksssssaaaa.spay.exchange.domain.currency

abstract class Currency (
    val type: CurrencyType
) {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Currency) return false

        return other.type == this.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}