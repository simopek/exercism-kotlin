import java.math.BigInteger
import kotlin.IllegalArgumentException

object Wordy {

    fun answer(input: String): Int {

        require(input.startsWith("What is")) {"invalid question"}
        require(input.endsWith("?")) {"invalid question"}

        val inputTokens = input.replace("\\s+".toRegex(), " ")
            .replace("What is", "").replace("?", "")
            .replace("multiplied by", "mult")
            .replace("divided by", "div")
            .replace("raised to the ([0-9]+)(st|th|nd|rd) power".toRegex(), "pow $1")
            .split(" ")
            .filter { s -> s.isNotBlank() }

        var result: BigInteger? = null
        var nextTokenType = TokenType.NUM
        var lastTokenType: TokenType? = null
        var operand: Operand? = null

        inputTokens.forEach { token ->

            lastTokenType = nextTokenType
            when (nextTokenType) {
                TokenType.NUM -> {

                    val tokenAsNum = token.toBigIntegerOrNull() ?: throw IllegalArgumentException("invalid question")
                    result = if (result == null) {
                        tokenAsNum
                    } else {
                        computeOperand(result!!, tokenAsNum!!, operand!!)
                    }
                    nextTokenType = TokenType.OPERAND_TOKEN
                    operand = null
                }
                TokenType.OPERAND_TOKEN -> {

                    when (token) {
                        "plus" -> {
                            operand = Operand.PLUS
                        }
                        "minus" -> {
                            operand = Operand.MINUS
                        }
                        "mult" -> {
                            operand = Operand.MULTIPLICATION
                        }
                        "div" -> {
                            operand = Operand.DIV
                        }
                        "pow" -> {
                            operand = Operand.POW
                        }
                        else -> throw IllegalArgumentException("invalid question")
                    }
                    nextTokenType = TokenType.NUM
                }
            }
        }

        if (lastTokenType == TokenType.OPERAND_TOKEN) {
            throw java.lang.IllegalArgumentException("invalid question")
        }

        return result!!.toInt()
    }

    private fun computeOperand(num1: BigInteger, num2: BigInteger, operand: Operand): BigInteger {

        return when (operand) {
            Operand.DIV -> num1 / num2
            Operand.MINUS -> num1 - num2
            Operand.MULTIPLICATION -> num1 * num2
            Operand.PLUS -> num1 + num2
            Operand.POW -> num1.pow(num2.toInt())
        }
    }
}
