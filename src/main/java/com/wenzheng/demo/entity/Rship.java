package com.wenzheng.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RE")
//@Data
public class Rship {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @StartNode
//    @JsonIgnoreProperties("RMode")
    private mode start;

    @JsonIgnore
    @EndNode
//    @JsonIgnoreProperties("RMode")
    private mode end;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public mode getStart() {
        return start;
    }

    public void setStart(mode start) {
        this.start = start;
    }

    public mode getEnd() {
        return end;
    }

    public void setEnd(mode end) {
        this.end = end;
    }
}
