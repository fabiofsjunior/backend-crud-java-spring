package com.crud.demo.repository;
import com.crud.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsarioRepository extends JpaRepository<UserEntity, Long>{


}