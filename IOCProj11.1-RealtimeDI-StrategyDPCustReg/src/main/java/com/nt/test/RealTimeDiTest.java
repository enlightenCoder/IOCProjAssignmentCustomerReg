package com.nt.test;

import java.io.IOException;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;

public class RealTimeDiTest {
	
	
	
	public static void main(String[] args) {
		
		// create the IOC CONTAINER
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfg/applicationContext.xml");
		MainController controller = factory.getBean("controller", MainController.class);
		Menu menu = new Menu();
		menu.display(controller);
		
		

		
	}

}
