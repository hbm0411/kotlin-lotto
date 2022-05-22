package lotto.view

import lotto.Const

class InputView {
    fun readPrice(): Int {
        printMsg(Const.OutputMsg.GET_PRICE_MSG)
        val input = readInputAndRequireNotBlank()
        return converseToInt(input)
    }

    private fun printMsg(message: String) = println(message)

    private fun readInputAndRequireNotBlank(): String {
        val input = readlnOrNull()
        require(!input.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR }

        return input
    }

    private fun converseToInt(value: String) = requireNotNull(value.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR }
}
