package org.ria.eits.service;

import lombok.extern.slf4j.Slf4j;
import org.ria.eits.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ArticleService {
    private static final String RIA_EITS_API_2_ARTICLE_2024 = "https://eits.ria.ee/api/2/article/2024";

    public List<List<String>> fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        Article[] articles = restTemplate.getForObject(RIA_EITS_API_2_ARTICLE_2024, Article[].class);
        List<List<String>> data = new ArrayList<>();
        if (articles != null) {
            log.debug("articles length {} bytes ", articles.length);
            log.debug(Arrays.toString(articles));
            extractTitles(articles, data, List.of("3.2 Põhimeetmed", "3.3 Standardmeetmed", "3.4 Kõrgmeetmed"));
        } else {
            log.warn("No articles retrieced from the API.");
        }

        return data;
    }

    private void extractTitles(Article[] articles, List<List<String>> data, List<String> sections) {
        for (Article article : articles) {
            if (sections.contains(article.getTitle()) && article.getChildObjects() != null) {
                    for (Article child : article.getChildObjects()) {
                        List<String> row = new ArrayList<>();
                        row.add(article.getTitle());
                        row.add(child.getTitle());
                        row.add(child.getContent());
                        data.add(row);
                    }
                }

            if (article.getChildObjects() != null) {
                extractTitles(article.getChildObjects().toArray(new Article[0]), data, sections);
            }
        }
    }
}
