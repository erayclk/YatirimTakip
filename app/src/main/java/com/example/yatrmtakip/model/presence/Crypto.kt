package com.example.yatrmtakip.model.presence

import java.util.Date

class Crypto(
    name: String,
    quantity: Double,
    buyPrice: Double,
    sellPrice: Double,
    val exchangeName: String,
    val currentMarketPrice: Double,
    date: Date
) : Investment(name, AssetType.CRYPTO, quantity, buyPrice, sellPrice,date) {

    override fun getValue(): Double = quantity * currentMarketPrice

    override fun getUnitPrice(): Double = currentMarketPrice

    override fun getDetails(): String {
        return "Kripto: $name ($exchangeName), miktar: $quantity, alış: $buyPrice, piyasa: $currentMarketPrice"
    }
}
