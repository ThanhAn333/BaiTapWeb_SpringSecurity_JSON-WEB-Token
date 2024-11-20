package vn.iostar.Service;

import java.util.List;

import vn.iostar.entity.Product;

public interface ProductServices {
	void delete(Long id);
	Product get(Long id);
	Product save(Product product);
	List<Product> listAll();
} 
