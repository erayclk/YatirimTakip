package com.example.yatrmtakip.model.presence

import java.util.Date

class Currency(
    name: String,
    quantity: Double,
    buyPrice: Double,
    sellPrice: Double,
    val exchangeRate: Double,
    date: Date,
) : Investment(name, AssetType.CURRENCY, quantity, buyPrice, sellPrice,date) {

    override fun getValue(): Double = quantity * exchangeRate

    override fun getUnitPrice(): Double = exchangeRate

    override fun getDetails(): String {
        return "Döviz: $name, miktar: $quantity, alış: $buyPrice, kur: $exchangeRate"
    }
}
