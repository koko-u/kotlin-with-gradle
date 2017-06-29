package jp.co.kokou.sample

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

import org.assertj.core.api.Assertions.assertThat;

object CalculatorSpec : Spek({
    describe("a calculator") {
        val calculator = Calculator()

        describe("addition") {
            val sum = calculator.sum(2, 4)

            it("should return the sum of two numbers") {
                assertThat(sum).isEqualTo(6)
            }
        }
    }
})
