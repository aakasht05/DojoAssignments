package com.tony.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.productscategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

}
