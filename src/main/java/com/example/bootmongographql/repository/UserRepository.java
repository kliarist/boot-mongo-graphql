package com.example.bootmongographql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import com.example.bootmongographql.model.User;

@GraphQlRepository
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {
}
