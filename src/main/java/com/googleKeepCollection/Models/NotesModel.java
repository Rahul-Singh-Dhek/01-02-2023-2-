package com.googleKeepCollection.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesModel {
    private String id;
    private String userName;
    private String title;
    private String content;

}
