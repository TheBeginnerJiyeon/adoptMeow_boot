package com.multi.adoptMeow.config;


import com.multi.adoptMeow.cat.model.dto.CatDTO;
import com.multi.adoptMeow.page.model.dto.PageDTO;
import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.multi.adoptMeow"}, annotationClass = Mapper.class)
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
		
		// configure for mybatis settings
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setJdbcTypeForNull(null);
		configuration.setMapUnderscoreToCamelCase(true);
		
		
		// set type alias(추가 예정)
		configuration.getTypeAliasRegistry().registerAlias("usersDTO", UsersDTO.class);
		configuration.getTypeAliasRegistry().registerAlias("catDTO", CatDTO.class);
		configuration.getTypeAliasRegistry().registerAlias("pageDTO", PageDTO.class);
		configuration.getTypeAliasRegistry().registerAlias("usersCategoryDTO", UsersCategoryDTO.class);
		
		
		bean.setConfiguration(configuration);
		
		
		return bean.getObject();
		
	}
	
	
}
