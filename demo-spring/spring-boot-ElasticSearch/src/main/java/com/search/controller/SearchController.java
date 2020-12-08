package com.search.controller;

import com.search.bo.*;
import com.search.service.ArticleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class SearchController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/select/{id}")
    //查询索引
    public JsonResult findById(@PathVariable String id) {

        //articleRepository.findAll();
        Optional<Article> article = articleRepository.findById(id);
        JsonResult jsonResult = new JsonResult(true);
        jsonResult.put("article", article.orElse(null));
        return jsonResult;
    }

    @GetMapping("/delete/{id}")
    //删除索引
    public JsonResult delete(@PathVariable String id) {
        // 根据 id 删除
        articleRepository.deleteById(id);
        //articleRepository.deleteAll();
        return new JsonResult(true, "删除成功");
    }


    @GetMapping(value = "/save/{title}")
    //新增/更新 索引
    public JsonResult save(@PathVariable String title) {
        Article article = getArticle(title);

        // 新增或更新
        String verifyRes = verifySaveForm(article);
        if (!StringUtils.isEmpty(verifyRes)) {
            return new JsonResult(false, verifyRes);
        }

        if (StringUtils.isEmpty(article.getId())) {
            article.setCreateTime(new Date());
        }

        Article a = articleRepository.save(article);
        boolean res = a.getId() != null;
        return new JsonResult(res, res ? "保存成功" + a.getId() : "");
    }

    private String verifySaveForm(Article article) {
        if (article == null || StringUtils.isEmpty(article.getTitle())) {
            return "标题不能为空";
        } else if (StringUtils.isEmpty(article.getContent())) {
            return "内容不能为空";
        }

        return null;
    }

    private Article getArticle(String title) {
        Article article = Article.builder().id("wLdhQXYBiVfhTrfMGmX5").title(title).content("2222222222222").build();

        return article;
    }

}
