package com.wenzheng.demo.dal;

import com.wenzheng.demo.entity.mode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface modeRepository extends Neo4jRepository<mode, Long> {
    mode findByName(String name);

    @Query("match data=(n:`mode`{name:'挂号'})-[*1..9]->(e)-[r]-(q) where e.name=$0 return data")
    List<mode> getModesByName(String name);

    List<mode> findAll();

    mode findById(long id);

    @Query("MATCH DATA=(M)-[R]-(N) WHERE ID(M)=$0 RETURN DATA")
    List<mode> getById(long id);

    void deleteById(long id);

    @Query("MATCH (n)-[r]-(e) where ID(r)=$0 set r.name=$1")
    void updatelink(long shipid, String shipname);
}
