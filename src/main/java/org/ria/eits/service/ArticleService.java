package org.ria.eits.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ria.eits.model.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ArticleService {
    private static final String RIA_EITS_API_2_ARTICLE_2024 = "https://eits.ria.ee/api/2/article/2024";

    public List<List<String>> fetchData() {
        List<List<String>> data = new ArrayList<>();
        try {
            JsonFactory jsonFactory = new JsonFactory();
            URL url = new URL(RIA_EITS_API_2_ARTICLE_2024);
            try (JsonParser jsonParser = jsonFactory.createParser(url)) {
                if (jsonParser.nextToken() == JsonToken.START_ARRAY) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        Article article = objectMapper.readValue(jsonParser, Article.class);
                        log.debug("Processing article: {}", article.getId());
                        extractDataFromArticle(article, data);
                        log.debug("Processing completed");

                    }
                }
            }
        } catch (IOException e) {
            log.error("Error fetching or parsing JSON data", e);
        }
        return data;
    }

    private void extractDataFromArticle(Article article, List<List<String>> data) {
        if ((article.getTitle().matches("3\\.2.*") || article.getTitle().matches("3\\.3.*") || article.getTitle().matches("3\\.4.*")) && article.getChildObjects() != null) {
                for (Article child : article.getChildObjects()) {
                    List<String> row = new ArrayList<>();
                    row.add(article.getTitle().substring(article.getTitle().indexOf(' ') + 1));
                    row.add(child.getTitle().split(" ", 2)[0]);
                    row.add(child.getContent());
                    data.add(row);
                }
            }


        if (article.getChildObjects() != null) {
            for (Article child : article.getChildObjects()) {
                extractDataFromArticle(child, data);
            }
        }
    }
}
