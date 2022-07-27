import org.junit.Test

import org.junit.Assert.*
import ru.netology.mastercardMaestro
import ru.netology.transferFee
import ru.netology.vKPay
import ru.netology.visaMir

class MainKtTest {

    @Test
    fun mastercardMaestroFirstWhen() {
        val transferSum = 150_001
        val previousSum = 449_999

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("Вы превысили суточный лимит. Он составляет 150_000 рублей", fee)
    }
    @Test
    fun mastercardMaestroSecondWhen() {
        val transferSum = 100_000
        val previousSum = 500_001

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("Вы превысили лимит переводов за месяц. Он составляет 600_000 рублей", fee)
    }
    @Test
    fun mastercardMaestroThirdWhenFirstCondition() {
        val transferSum = 100
        val previousSum = 75_000

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("2060 копеек", fee)
    }
    @Test
    fun mastercardMaestroThirdWhenSecondCondition() {
        val transferSum = 2_000
        val previousSum = 598_000

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("3200 копеек", fee)
    }
    @Test
    fun mastercardMaestroThirdWhenThirdCondition() {
        val transferSum = 100_000
        val previousSum = 0

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("62000 копеек", fee)
    }
    @Test
    fun mastercardMaestroElse() {
        val transferSum = 75_000
        val previousSum = 0

        val fee = mastercardMaestro(previousSum, transferSum)

        assertEquals("0 копеек", fee)
    }

    @Test
    fun visaMirFirstWhen() {
        val transferSum = 150_001
        val previousSum = 449_999

        val fee = visaMir(previousSum, transferSum)

        assertEquals("Вы превысили суточный лимит. Он составляет 150_000 рублей", fee)
    }
    @Test
    fun visaMirSecondWhen() {
        val transferSum = 100_000
        val previousSum = 500_001

        val fee = visaMir(previousSum, transferSum)

        assertEquals("Вы превысили лимит переводов за месяц. Он составляет 600_000 рублей", fee)
    }
    @Test
    fun visaMirThirdWhen() {
        val transferSum = 10_000
        val previousSum = 0

        val fee = visaMir(previousSum, transferSum)

        assertEquals("7500 копеек", fee)
    }
    @Test
    fun visaMirElse() {
        val transferSum = 4_660
        val previousSum = 0

        val fee = visaMir(previousSum, transferSum)

        assertEquals("3500 копеек", fee)
    }

    @Test
    fun vKPayFirstWhen() {
        val transferSum = 15_001
        val previousSum = 0

        val fee = vKPay(previousSum, transferSum)

        assertEquals("Вы превысили суточный лимит. Он составляет 15_000 рублей", fee)
    }
    @Test
    fun vKPaySecondWhen() {
        val transferSum = 15_000
        val previousSum = 25_001

        val fee = vKPay(previousSum, transferSum)

        assertEquals("Вы превысили лимит переводов за месяц. Он составляет 40_000 рублей", fee)
    }
    @Test
    fun vKPayElse() {
        val transferSum = 15_000
        val previousSum = 25_000

        val fee = vKPay(previousSum, transferSum)

        assertEquals("0 копеек", fee)
    }

    @Test
    fun transferFeeFirstWhen() {
        val accountType = "Mastercard"
        val transferSum  = 100_000
        val previousSum = 0

        val fee = transferFee(accountType, previousSum, transferSum)

        assertEquals("62000 копеек", fee)
    }
    @Test
    fun transferFeeSecondWhen() {
        val accountType = "Maestro"
        val transferSum  = 2_000
        val previousSum = 598_000

        val fee = transferFee(accountType, previousSum, transferSum)

        assertEquals("3200 копеек", fee)
    }
    @Test
    fun transferFeeThirdWhen() {
        val accountType = "Visa"
        val transferSum  = 10_000
        val previousSum = 0

        val fee = transferFee(accountType, previousSum, transferSum)

        assertEquals("7500 копеек", fee)
    }
    @Test
    fun transferFeeFourthWhen() {
        val accountType = "Mir"
        val transferSum  = 4_660
        val previousSum = 0

        val fee = transferFee(accountType, previousSum, transferSum)

        assertEquals("3500 копеек", fee)
    }
    @Test
    fun transferFeeFithWhen() {
        val accountType = "VKPay"
        val transferSum  = 15_000
        val previousSum = 0

        val fee = transferFee(accountType, previousSum, transferSum)

        assertEquals("0 копеек", fee)
    }
}