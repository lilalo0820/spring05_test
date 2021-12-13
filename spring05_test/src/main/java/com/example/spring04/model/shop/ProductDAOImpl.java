package com.example.spring04.model.shop;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> list() {
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDTO detail(int product_code) {
		return sqlSession.selectOne("product.detail", product_code);
	}

	@Override
	public void update(ProductDTO dto) {
		sqlSession.update("product.update", dto);
	}

	@Override
	public void delete(int product_code) {
		sqlSession.delete("product.delete", product_code);
	}

	@Override
	public void insert(ProductDTO dto) {
		sqlSession.insert("product.insert", dto);
//		productDTO [product_code=0, product_name=fdsafdf, price=123124, description=dsfsdaf, filename=doom logo.png, file1=org.springframework.web.multipart.commons.CommonsMultipartFile@72a5439d]
	}

	@Override
	public String file_info(int product_code) {
		return sqlSession.selectOne("product.file_info", product_code);
	}

}