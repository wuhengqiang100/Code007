package com.java1234.init;

import com.java1234.entity.ArcType;
import com.java1234.entity.Link;
import com.java1234.service.ArcTypeService;
import com.java1234.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    初始化加载元素
* @Author:         wuhq
* @CreateDate:     2019/1/10 20:40
* @UpdateUser:     wuhq
* @UpdateDate:     2019/1/10 20:40
* @UpdateRemark:   
* @Version:        
*/

/**
 * 1:@Component spring来管理这个初始化类
 * 2:从ApplicationContextAware接口中获取applicationContext
 * 3:实现ServletContextListener接口,contextInitialized初始化方法中获取ServletContext
 */
@Component("initSystem")
public class InitSystem implements ServletContextListener,ApplicationContextAware{

    private static ApplicationContext applicationContext;

    //初始化的时候把资源类型静态实例化,方便使用
    public static Map<Integer,ArcType> arcTypeMap=new HashMap<Integer,ArcType>();

   /* @Autowired
    private ArcTypeService arcTypeService;*/

    /**
     * 加载数据到application缓存中
     * @param application
     */
    public void loadData(ServletContext application){
        //method01:老思路,通过applicationContext.getBean得到service
        //method02:spring注入获取service

        ArcTypeService arcTypeService= (ArcTypeService) applicationContext.getBean("arcTypeService");
        LinkService linkService= (LinkService) applicationContext.getBean("linkService");
        List<Link> allLinkList = linkService.listAll(Sort.Direction.ASC, "sort");
        List<ArcType> arcTypeList=arcTypeService.listAll(Sort.Direction.ASC,"sort");//根据排序sort字段升序
        for (ArcType arcType:arcTypeList){
            arcTypeMap.put(arcType.getId(),arcType);
        }
        application.setAttribute("allArcTypeList",arcTypeList);
        application.setAttribute("allLinkList",allLinkList);
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.loadData(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
