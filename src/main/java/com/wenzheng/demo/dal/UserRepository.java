package com.wenzheng.demo.dal;

import com.wenzheng.demo.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsernameAndPassword(String name, String password);

    User findByUsername(String name);

    @Query("select status from User u where u.id=?1")
    String findStatusById(String id);

    @Transactional()
    @Modifying
    @Query("update User u set u.password = ?2 where u.username = ?1")
    int updatePasswordByUsername(String username, String password);

    @Transactional()
    @Modifying
    @Query("update User u set u.status = ?2,u.updateTime=?3 where u.id = ?1")
    int updateStatusById(String id, String status, Date date);

    @Override
    <S extends User> List<S> findAll(Example<S> example);

    @Override
    List<User> findAll();
}
