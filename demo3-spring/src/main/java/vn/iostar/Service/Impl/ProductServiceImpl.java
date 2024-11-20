package vn.iostar.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.Repository.ProductRepository;
import vn.iostar.Service.ProductServices;
import vn.iostar.entity.Product;
@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository repo;
	
	public ProductServiceImpl(ProductRepository repo)
	{
		this.repo =repo;
	}
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Product get(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return repo.save(product);
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
