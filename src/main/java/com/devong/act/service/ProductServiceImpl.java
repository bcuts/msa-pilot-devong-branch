package com.devong.act.service;

import com.devong.act.common.CommonConstants;
import com.devong.act.model.Product;
import com.devong.act.repository.BranchRepository;
import com.devong.act.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    BranchRepository branchDao;

    @Autowired
    ProductRepository productDao;

    @Override
    public List<String> getProducts(String branchId) {
        if(branchDao.exists(branchId)) {
            return productDao.getAllProductsInBranch(branchId);
        }else{
            throw new EntityNotFoundException(CommonConstants.EXCEPTION_NOT_EXIST_BRANCH);
        }
    }

    @Override
    public Product putProduct(String branchId, String productId) throws Exception {
        if(branchDao.exists(branchId)) {
            if (productDao.countProductInBranch(branchId, productId) == 0) {
                Product product = new Product();
                product.setBranchId(branchId);
                product.setProductId(productId);
                return productDao.save(product);
            } else {
                throw new EntityExistsException(CommonConstants.EXCEPTION_CONFLICT_PRODUCT);
            }
        }else {
            throw new EntityNotFoundException(CommonConstants.EXCEPTION_NOT_EXIST_BRANCH);
        }
    }

    @Override
    public void deleteProduct(String branchId, String productId) {
        Product product = new Product();
        product.setBranchId(branchId);
        product.setProductId(productId);
        productDao.delete(productId);
    }
}
