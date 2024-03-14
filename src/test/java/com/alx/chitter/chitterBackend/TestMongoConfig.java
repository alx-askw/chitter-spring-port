package com.alx.chitter.chitterBackend;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Configuration
public class TestMongoConfig {
    private static final String collectionName = "peeps";

    private static final String userCollectionName = "users";

    @Bean
    public static MongoTemplate mongoTemplate(){
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb://127.0.0.1:27017/chitterTest"));
    }

    public static void clearTestCollection(){
        System.out.println("Clearing testing DB");
        mongoTemplate().remove(new Query(), collectionName);
    }

    public static void populateTestCollection(List<Peeps> peeps){
        System.out.println("Populating testing DB");
        mongoTemplate().insert(peeps, collectionName);
    }

    public static void clearUserTestCollection(){
        System.out.println("Clearing user testing DB");
        mongoTemplate().remove(new Query(), userCollectionName);
    }

    public static void populateUserTestCollection(List<User> users){
        System.out.println("Populating user testing DB");
        mongoTemplate().insert(users, userCollectionName);
    }



}
