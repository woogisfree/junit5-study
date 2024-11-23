package sample.cafekiosk.spring.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockTest {

    @Test
    @DisplayName("재고의 수량이 제공된 수량보다 적은지 확인한다.")
    void isQuantityLessThan() throws Exception {
        //given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        //when
        boolean result = stock.isQuantityLessThan(quantity);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("재고를 주어진 개수만큼 차감할 수 있다.")
    void deductQuantity() throws Exception {
        //given
        Stock stock = Stock.create("001", 2);
        int quantity = 1;

        //when
        stock.deductQuantity(quantity);

        //then
        assertEquals(stock.getQuantity(), 1);
    }

    @Test
    @DisplayName("재고보다 더 많은 수량을 차감하려고 하면 예외가 발생한다.")
    void deductQuantityException() throws Exception {
        //given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        //when //then
        assertThatThrownBy(() -> stock.deductQuantity(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차감할 재고 수량이 없습니다.");
    }
}