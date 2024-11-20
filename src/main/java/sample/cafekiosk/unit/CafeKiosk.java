package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 요구사항
 * 1. 주문 목록에 음료 추가/삭제 기능
 * 2. 주문 목록 전체 지우기
 * 3. 주문 목록 총 금액 계산하기
 * 4. 주문 생성하기
 */
@Getter
public class CafeKiosk {

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    public void remove(Beverage beverage) {
        beverages.remove(beverage);
    }

    public void clear() {
        beverages.clear();
    }

    public int calculateTotalPrice() {
        return beverages.stream()
                .mapToInt(Beverage::getPrice)
                .sum();
    }

    public Order createOrder() {
        return new Order(LocalDateTime.now(), beverages);
    }
}
