package org.ria.eits.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Article {
    private String title;
    private String content;

    @JsonProperty("child_objects")
    private List<Article> childObjects;

    private String id;
}
