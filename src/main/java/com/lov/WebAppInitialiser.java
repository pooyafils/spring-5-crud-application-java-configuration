package com.lov;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
       // return new Class[0];
         return new Class[]{AppConfig.class};
       //why?

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
          return new Class[]{WebConfig.class};
         //  return new Class[]{AppConfig.class};
        //this is a other approch where viewrosolver is not
        //in  the seperate file
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[]{"/"};
    }

}

