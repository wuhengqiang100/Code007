package com.java1234.controller;

import com.java1234.entity.ArcType;
import com.java1234.entity.Article;
import com.java1234.init.InitSystem;
import com.java1234.service.ArticleService;
import com.java1234.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
* @Description:    帖子资源Controller层
* @Author:         wuhq
* @CreateDate:     2019/1/11 13:47
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/11 13:47
* @UpdateRemark:   
* @Version:        
*/

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据条件分页查询资源帖子
     * @param page
     * @return
     */
    @RequestMapping("/list/{id}")
    public ModelAndView list(@RequestParam(value="typeId",required = false) Integer typeId,@PathVariable(value = "id",required = false) Integer page,HttpServletRequest request){

        ModelAndView mav=new ModelAndView();
        Article s_article=new Article();
        s_article.setState(2);//审核通过的帖子

        if(typeId==null){
            mav.addObject("title","第"+page+"页");
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("tMenu","t_"+typeId);
            ArcType arcType=InitSystem.arcTypeMap.get(typeId);//根据typeId直接从初始处获得静态数据
            s_article.setArcType(arcType);
            mav.addObject("title",arcType.getName()+"_第"+page+"页");
        }
        s_article.setHot(true);
        List<Article> indexHotArticleList= articleService.list(s_article,1,43, Sort.Direction.DESC,"publishDate");
        List<Article> indexArticleList= articleService.list(s_article,page,20, Sort.Direction.DESC,"publishDate");
        Long total=articleService.getTotal(s_article);
        mav.addObject("articleList",indexArticleList);
        mav.addObject("hotArticleList",indexHotArticleList);
        StringBuffer param=new StringBuffer();
        if (typeId!=null){
            param.append("?typeId="+typeId);//把typeId传入分页条件?后面的内容
        }
        mav.addObject("pageCode", PageUtil.genPagination("/article/list",total,page,20,param.toString()));
        mav.setViewName("index");
        return mav;
    }

}
