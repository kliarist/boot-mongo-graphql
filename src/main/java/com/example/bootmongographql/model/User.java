package com.example.bootmongographql.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@QueryEntity
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Instant createdAt;
    private String nationality;
    @DBRef(lazy = true)
    private List<Article> articles;
}
