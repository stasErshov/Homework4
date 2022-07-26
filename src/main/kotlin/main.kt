package ru.netology

fun main() {
    println(transferFee(transferSum = 5_000))
}

fun transferFee(accountType: String = "VKPay", previousSum: Int = 0, transferSum: Int) = when (accountType) {
    "Mastercard" -> mastercardMaestro(previousSum, transferSum)
    "Maestro" -> mastercardMaestro(previousSum, transferSum)
    "Visa" -> visaMir(previousSum, transferSum)
    "Mir" -> visaMir(previousSum, transferSum)
    "VKPay" -> vKPay(previousSum, transferSum)
    else -> "Этот тип карты/счета не поддерживается"
}


fun mastercardMaestro(previousSum: Int, transferSum: Int): String {
    val feeInProcentum = 0.6
    val feeCalculated = (transferSum * feeInProcentum).toInt()
    val additionalFee = 20 * 100
    val maxFeeFree = 75_000
    val maxPerDay = 150_000
    val maxPerMonth = 600_000
    val fee = when {
        transferSum > maxPerDay -> "Вы превысили суточный лимит. Он составляет 150_000 рублей"
        ((previousSum + transferSum) > maxPerMonth) -> "Вы превысили лимит переводов за месяц. Он составляет 600_000 рублей"
        (previousSum >= maxFeeFree) || ((previousSum + transferSum) > maxFeeFree) || transferSum > maxFeeFree -> (feeCalculated + additionalFee).toString() + " копеек"
        else -> "0 копеек"
    }
    return fee
}

fun visaMir(previousSum: Int, transferSum: Int): String {
    val feeInProcentum = 0.75
    val feeCalculated = (transferSum * feeInProcentum).toInt()
    val feeMin = 35 * 100
    val maxPerDay = 150_000
    val maxPerMonth = 600_000
    val fee = when {
        transferSum > maxPerDay -> "Вы превысили суточный лимит. Он составляет 150_000 рублей"
        ((previousSum + transferSum) > maxPerMonth) -> "Вы превысили лимит переводов за месяц. Он составляет 600_000 рублей"
        feeCalculated > feeMin -> "$feeCalculated копеек"
        else -> "$feeMin копеек"
    }
    return fee
}

fun vKPay(previousSum: Int, transferSum: Int): String {
    val maxPerDay = 15_000
    val maxPerMonth = 40_000
    val fee = when {
        transferSum > maxPerDay -> "Вы превысили суточный лимит. Он составляет 15_000 рублей"
        ((previousSum + transferSum) > maxPerMonth) -> "Вы превысили лимит переводов за месяц. Он составляет 40_000 рублей"
        else -> "0 копеек"
    }
    return fee
}