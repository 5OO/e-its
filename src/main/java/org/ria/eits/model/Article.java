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

//    private boolean parentPage;
//    private boolean searchTopLevelPage;
//    private String layout;
//    private String date;
//    private String permalink;
   private String id;
//    private String endDate;
//    private String startDate;
//
//    @JsonProperty("media_order")
//    private String mediaOrder;
//
//    private String icon;
//    private String category;
//    private List<String> assignee;
}
