package ch.zli.m223.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;



import ch.zli.m223.model.Category;

public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category){
        entityManager.persist(category);
        return category;
    }

    @Transactional
    public void delete(Long id){
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }

    @Transactional
    public Category update(Category category){
        entityManager.merge(category);
        return category;
    }
}
