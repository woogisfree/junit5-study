package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTypeTest {

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType() throws Exception {
        //given
        ProductType givenType = ProductType.HANDMADE;

        //when
        boolean result = ProductType.containsStockType(givenType);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType2() throws Exception {
        //given
        ProductType givenType = ProductType.BOTTLE;

        //when
        boolean result = ProductType.containsStockType(givenType);

        //then
        assertTrue(result);
    }

}