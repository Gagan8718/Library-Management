
package com.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


import com.LibraryManagement.model.Author;

import jakarta.transaction.Transactional;
@Transactional
public interface AuthorRepo extends JpaRepository<Author,Integer> {
    @Modifying

    
    @Query("update Author a set a.name=:#{#new_author.name} at, where a.id=:#{#new_author.id}")

    void updateAuthorDetails(@Param("new_author") Author new_author);

    @Modifying
    @Query("delete Author a where a.id=:given_id")
    int deleteCustom(@Param("given_id") int id);
}


