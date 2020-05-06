package com.wenzheng.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@Data
@NodeEntity
@NoArgsConstructor
public class mode {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer r=30;
    private double fx;
    private double fy;
    private String color="#ff4500";

    @JsonIgnoreProperties({"start", "end"})
    @Relationship(type = "RE", direction = OUTGOING)
    List<Rship> RMode = new ArrayList<>();

//    @Relationship(type = "RE", direction = OUTGOING)
//    List<mode> remode = new ArrayList<>();
}
