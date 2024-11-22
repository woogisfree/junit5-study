package sample.cafekiosk.spring.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<sample.cafekiosk.spring.domain.product.Product, Long> {

    /**
     * select *
     * from product
     * where selling_status in ('SELLING', 'HOLD')
     */
    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingStatuses);
}
