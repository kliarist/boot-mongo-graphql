package com.example.bootmongographql.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.example.bootmongographql.model.Article;
import com.example.bootmongographql.model.User;
import com.example.bootmongographql.repository.ArticleRepository;
import com.example.bootmongographql.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;


    @PostConstruct
    private void generateData() {
        List<User> users = new ArrayList<>();
        Instant now = Instant.now();
        users.add(User.builder().name("Igor").createdAt(now).age(24).articles(new ArrayList<>()).build());
        users.add(User.builder().name("Ellen").createdAt(now).age(24).articles(new ArrayList<>()).build());
        users.add(User.builder().name("John").createdAt(now).age(53).articles(new ArrayList<>()).build());
        users.add(User.builder().name("Nazar").createdAt(now).age(14).articles(new ArrayList<>()).build());
        users = userRepository.saveAll(users);

        List<Article> articles = new ArrayList<>();
        articles.add(Article.builder().title("Java 8 Lambdas").minutesRead(8).id(users.get(0).getId().toString()).build());
        articles.add(Article.builder().title("GraphQL Getting Started").minutesRead(10).id(users.get(1).getId().toString()).build());
        articles.add(Article.builder().title("Spring Boot + WebSockets").minutesRead(6).id(users.get(3).getId().toString()).build());
        articles = articleRepository.saveAll(articles);

        users.get(0).setArticles(articles);
        users.get(0).setArticles(articles);
        users.get(1).setArticles(articles);
        users.get(3).setArticles(articles);
        userRepository.saveAll(users);

    }
}
