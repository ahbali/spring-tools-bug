package com.example.demo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c JOIN c.chambres chambre WHERE chambre.id = :chambreId")
    Set<Client> findByChambreId(@Param("chambreId") Long chambreId);

    @Query("SELECT c \n" +
           "FROM Client c \n" +
           "    JOIN c.chambres chambre \n" +
           "WHERE chambre.id = :chambreId")
    Set<Client> findByChambreId2(@Param("chambreId") Long chambreId);
}
