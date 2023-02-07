package com.gestion.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.nom=:nom, u.prenom=:prenom, u.email=:email, u.sexe=:sexe  where u.id=:id")
    public void updateUserById(@Param("id") Long id, @Param("nom") String nom, @Param("prenom") String prenom , @Param("email") String email , @Param("sexe") String sexe);
}
