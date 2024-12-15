package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Test

import kotlin.math.roundToInt

class MainKtTest {

    @Test
    fun calculationCommission_exceedingTransferLimit() {
        val amount = 160_000
        val amountMonth = 600_000
        val card = "Mastercard"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(0, commission)
    }

    @Test
    fun calculationCommission_mastercardLimitWasExceededEarlier() {
        val amount = 10_000
        val amountMonth = 80_000
        val card = "Mastercard"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(80, commission)
    }

    @Test
    fun calculationCommission_mastercardLimitHasBeenExceededNow() {
        val amount = 10_000
        val amountMonth = 70_000
        val card = "Mastercard"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(50, commission)
    }

    @Test
    fun calculationCommission_usualVisaFeeHasBeenSelected() {
        val amount = 100_000
        val amountMonth = 70_000
        val card = "Visa"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(750, commission)
    }

    @Test
    fun calculationCommission_minimumCommissionForVisaHasBeenSelected() {
        val amount = 4_000
        val amountMonth = 70_000
        val card = "Visa"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(35, commission)
    }

    @Test
    fun calculationCommission_chooseTransferWithoutCommission() {
        val amount = 4_000
        val amountMonth = 70_000
        val card = "Мир"

        val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()

        assertEquals(0, commission)
    }
}