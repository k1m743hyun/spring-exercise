package com.k1m743hyun.corespring.beandefinition;

import com.k1m743hyun.corespring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");

     @Test
     @DisplayName("빈 메타 정보 확인")
    void findApplicationBean() {

         String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
         for (String beanDefinitionName : beanDefinitionNames) {
             BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

             if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                 System.out.println("beanDefinitionName = " + beanDefinitionName);
                 System.out.println("beanDefinition = " + beanDefinition);
             }
         }
     }
}
