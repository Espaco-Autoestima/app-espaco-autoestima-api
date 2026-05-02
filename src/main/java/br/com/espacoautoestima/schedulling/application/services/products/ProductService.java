package br.com.espacoautoestima.schedulling.application.services.products;

import br.com.espacoautoestima.schedulling.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
}
