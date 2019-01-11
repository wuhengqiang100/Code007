package com.java1234.controller;

import com.java1234.entity.Article;
import com.java1234.service.ArticleService;
import com.java1234.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 首页或者跳转url控制器
 * @author Administrator
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 网站根目录请求
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView root(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("tMenu","t_0");
		Article s_article=new Article();
		s_article.setState(2);//审核通过的帖子
		List<Article> indexArticleList= articleService.list(s_article,1,20, Sort.Direction.DESC,"publishDate");
		Long total=articleService.getTotal(s_article);

		s_article.setHot(true);
		List<Article> indexHotArticleList= articleService.list(s_article,1,43, Sort.Direction.DESC,"publishDate");
		ModelAndView mav=new ModelAndView();
		mav.addObject("title","首页");
		mav.addObject("articleList",indexArticleList);
		mav.addObject("hotArticleList",indexHotArticleList);
		mav.addObject("pageCode", PageUtil.genPagination("/article/list",total,1,20,""));
		mav.setViewName("index");
		return mav;
	}
}
