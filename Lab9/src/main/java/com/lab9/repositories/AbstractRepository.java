package com.lab9.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.swing.text.html.parser.Entity;
import java.awt.*;

@NoRepositoryBean
public interface AbstractRepository extends CrudRepository<Integer, Entity> {


}
