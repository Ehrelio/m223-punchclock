package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tag;

@ApplicationScoped
public class TagService {
    
    @Inject
    EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag){
        entityManager.persist(tag);
        return tag;
    }

    @Transactional
    public Tag update(Tag tag){
        entityManager.merge(tag);
        return tag;
    }

    @Transactional
    public void delete(Long id){
        Tag tag = entityManager.find(Tag.class, id);
        entityManager.remove(tag);
    }     
}
