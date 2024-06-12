package org.ria.eits.controller;

import lombok.RequiredArgsConstructor;
import org.ria.eits.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/")
    public String getTitles(Model model) {
        List<List<String>> data = articleService.fetchData();
        model.addAttribute("data", data);
        return "index";
    }
}
