package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseTest {
    private lateinit var lottoPurchase: LottoPurchase

    @BeforeEach
    fun setUp() {
        lottoPurchase = LottoPurchase()
    }

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @NullAndEmptySource
    @ValueSource(strings = ["a", "!"])
    internal fun `입력한 값이 empty이거나 숫자가 아니면 IllegalArgumentException 에러 발생`(money: String?) {
        assertThrows<IllegalArgumentException> { lottoPurchase.getMoney(money) }
    }

    @ParameterizedTest(name = "`{0}`원을 내면 로또`{1}개를 구매할 수 있다`")
    @CsvSource(
        value = [
            "1000, 1",
            "1500, 1",
            "5000, 5",
            "10000, 10",

        ]
    )
    internal fun `가격에 따라 구입할 로또의 개수를 구한다`(price: Int, lottoCount: Int) {
        val lottoPrice = LottoPrice(price)
        assertThat(lottoPurchase.getLottoCount(lottoPrice)).isEqualTo(lottoCount)
    }

    @Test
    internal fun `입력한 개수에 맞추어 로또티켓을 준다`() {
        val expected = 5
        val lottoTickets = lottoPurchase.getLottoTickets(expected)
        assertThat(lottoTickets).hasSize(expected)
    }
}
