package com.webportal;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by amarendra on 24/09/16.
 */
@Configuration
public class MongoDBService {

   /* @Bean
    MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    MongoDbFactory mongoDbFactory (){
        return new SimpleMongoDbFactory(new MongoClient(), "computerDB");
    }*/

}
