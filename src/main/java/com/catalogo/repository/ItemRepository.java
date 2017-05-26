package com.catalogo.repository;

import com.catalogo.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by stefanini on 25/05/17.
 */
public interface ItemRepository extends MongoRepository<Item, String> {
    public Item findByNome(String nome);
}
