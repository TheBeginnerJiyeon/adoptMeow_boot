package com.multi.adoptMeow.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.multi.adoptMeow"}, annotationClass = Mapper.class)
*/
public class MyBatisConfiguration {
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		
		return new DataSourceTransactionManager(dataSource);
		
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/**/*.xml");
		
		bean.setMapperLocations(resources);
		bean.setDataSource(dataSource);
		return bean.getObject();
		
	}
	
	
}
