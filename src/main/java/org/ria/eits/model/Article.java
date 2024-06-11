package org.ria.eits.model;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private String title;
    private List<Article> childObjects;
}
