package vn.iostar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
