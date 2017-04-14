package com.yangg.firstapp.dal.runner;



import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class MybatisGeneratorRun {
	
	public static void main(String[] args) throws Exception{
		
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
		DefaultShellCallback shellCallbak = new DefaultShellCallback(true);//JAR包加载进来
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,shellCallbak,warnings);
		myBatisGenerator.generate(null);
		for(String string :warnings){
			System.out.println(string);
		}
		
 	}

}
