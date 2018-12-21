package com.chendi.project.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DataSourceConnectionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataBaseConfig {
    protected String databaseUrl="jdbc:postgresql://localhost:5432/pigge";
    protected String databaseUserName="DiChen";
    protected String databasePassword="password123";
    protected String driverClassName="org.postgresql.ds.PGSimpleDataSource";

    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUserName);
        dataSource.setPassword(databasePassword);
//        dataSource.setValidationQuery(databaseValidationQuery);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        return dataSource;
    }
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[] { "com.chendi.project.domain","com.chendi.project.repository" });
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        props.put("hibernate.hbm2ddl.auto", "validate");// helps to validate table names and cols to the java class
//        props.put("hibernate.physical_naming_strategy", "com.overture.family.extend.hibernate.ImprovedNamingStrategy")
        props.put("hibernate.connection.charSet","UTF-8");
        props.put("hibernate.show_sql","true");// helps to debug to see the sql query in the log
//        props.put("")


//            <property name="hibernate.ejb.interceptor" value="com.overture.family.repository.jpa.DBNullsFirstLastInteceptor"/>

        factoryBean.setJpaProperties(props);

        return factoryBean;
    }




}
