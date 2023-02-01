package com.googleKeepCollection.Services;

import com.googleKeepCollection.Models.NotesModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class collectionService {

    WebClient.Builder builder=WebClient.builder();
    Logger logger = LoggerFactory.getLogger(collectionService.class);
    public List<NotesModel> getUserCollection(@PathVariable String userName){
        logger.info("We are inside getUserCollection [service].");
        String url= "http://localhost:3000/user/note/get/"+userName;
        logger.info("Fetching data from another Api.");
        List<NotesModel> response=builder.build().get().uri(url).retrieve().toEntity(List.class).block().getBody();
        logger.info("Service is Gonna Send Back the Response from getUserCollectionByTitle");
        return response;
    }

    public List<NotesModel> getUserCollectionByTitle(@PathVariable String title){
        logger.info("We are inside getUserCollectionByTitle [service].");
        String url= "http://localhost:3000/user/note/title/"+title;
        logger.info("Fetching data from another Api.");
        WebClient.Builder builder=WebClient.builder();
        List<NotesModel> response=builder.build().get().uri(url).retrieve().toEntity(List.class).block().getBody();
        logger.info("Service is Gonna Send Back the Response from getUserCollectionByTitle");
        return response;
    }
}
