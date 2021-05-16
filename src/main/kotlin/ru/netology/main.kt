package ru.netology

fun main() {
    val transferAmount = 500_000.0   //сумма перевода
    val typeOfCard = "Maestro"
    val amountOfPreviousTransfers = 7_600_000   //Сумма предыдущих переводов в этом месяце
    whichCard(typeOfCard, transferAmount, amountOfPreviousTransfers)
}

private fun whichCard(typeOfCard: String, transferAmount: Double, amountOfPreviousTransfers: Int) {
    when (typeOfCard) {
        "Mastercard", "Maestro" -> masterCardAndMaestro(transferAmount, amountOfPreviousTransfers)
        "Visa", "Mir" -> visaAndMir(transferAmount)
        "VK pay" -> println("Сумма перевода  ${transferAmount.toInt()} копеек")
    }
}

fun masterCardAndMaestro(transferAmount: Double, amountOfPreviousTransfers: Int) {
    when {
        amountOfPreviousTransfers > 7_500_000 -> {
            var amountAfterCommission = transferAmount - (transferAmount * 0.006)
            amountAfterCommission -= 2000.0    //минус 20 рублей, возможно не так понял задание
            println("Сумма перевода ${amountAfterCommission.toInt()} копеек")
        }
        amountOfPreviousTransfers < 7_500_000 -> println("Сумма перевода ${transferAmount.toInt()} копеек")
    }
}

fun visaAndMir(transferAmount: Double) {
    when {
        transferAmount > 3500 -> {
            val amountAfterCommission = transferAmount - (transferAmount * 0.0075)
            println("Сумма перевода после комиссии ${amountAfterCommission.toInt()} копеек")
        }
        transferAmount < 3500 -> println("Сумма перевода недостаточна")
    }
}