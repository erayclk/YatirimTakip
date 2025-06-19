package com.example.yatrmtakip.model.presence

import java.util.Date
import java.util.Locale

fun main() {
    val portfolio = Portfolio()

    portfolio.addInvestment(Gold("Gram Altın", 50.0, 70.0, 75.0, Date())) // 5 x 50 = +250
    portfolio.addInvestment(Stock("Tesla", 10.0, 200.0, 210.0, "NASDAQ", 230.0,Date())) // +300
    portfolio.addInvestment(Crypto("Ethereum", 1.5, 1800.0, 1850.0, "Binance", 1950.0,Date())) // +225
    portfolio.addInvestment(Currency("EUR", 1000.0, 1.05, 1.08, 1.10,Date())) // +50

    portfolio.printPortfolioDetails()
}
