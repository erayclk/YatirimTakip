package com.example.yatrmtakip.model.presence

import java.util.Date

class Stock(
    name: String,
    quantity: Double,
    buyPrice: Double,
    sellPrice: Double,
    val marketName: String,
    val currentMarketPrice: Double,
    date: Date,

    ) : Investment(name, AssetType.STOCK, quantity, buyPrice, sellPrice, date ) {

    override fun getValue(): Double = quantity * currentMarketPrice

    override fun getUnitPrice(): Double = currentMarketPrice

    override fun getDetails(): String {
        return "Hisse: $name ($marketName), miktar: $quantity, alış: $buyPrice, piyasa: $currentMarketPrice"
    }
}
