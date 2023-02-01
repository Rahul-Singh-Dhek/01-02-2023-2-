package com.googleKeepCollection.Controllers;

import com.googleKeepCollection.Models.NotesModel;
import com.googleKeepCollection.Services.collectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class collectionController {

    Logger logger = LoggerFactory.getLogger(collectionController.class);
    @Autowired
    private collectionService service;
    @GetMapping("/userName/{userName}")
    public ResponseEntity<?> getUserCollectionByUserName(@PathVariable String userName){
        logger.info("GetUserCollectionApi is Hit");
        List<NotesModel> output=service.getUserCollection(userName);
        if(output.size()==0){
            logger.info("User Have given Wrong UserName.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given UserName Does not Exists in the DataBase.");
        }
        logger.info("GetUserCollectionApi is Gonna Send Response.");
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getUserCollectionByTitle(@PathVariable String title){
        List<NotesModel> output=service.getUserCollectionByTitle(title);
        if(output.size()==0){
            logger.info("No title Found with The given Title.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Title name found in the DataBase");
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
