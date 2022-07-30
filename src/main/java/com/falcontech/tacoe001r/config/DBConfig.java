package com.falcontech.tacoe001r.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EntityScan("com.falcontech.tacoe001r.model")
@EnableJpaRepositories(basePackages = "com.falcontech.tacoe001r.repo")
public class DBConfig {
  private final Environment env;

  public DBConfig(Environment env) {
    this.env = env;
  }

  @Bean
  @Profile({"dev", "default"})
  public DataSource mysqlDataSourceDev() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://192.168.2.21:3306/taco_dev");
    dataSource.setUsername("test_user");
    dataSource.setPassword("rte.uY694a8bNrW-MQ_mBz");
    return dataSource;
  }

  @Bean
  @Profile("dev_docker")
  public DataSource mysqlDataSourceDevDocker() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3310/DB1");
    dataSource.setUsername("meadmin");
    dataSource.setPassword("badpass");
    return dataSource;
  }

  @Bean
  @Profile("prod")
  public DataSource mysqlDataSourceProd() {
    log.info("Loading [PRODUCTION] profiles from System Environment variables");
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(env.getProperty("TACO_APP_DATASOURCE_URL"));
    dataSource.setUsername(env.getProperty("TACO_APP_DB_USR"));
    dataSource.setPassword(env.getProperty("TACO_APP_DB_PSWD"));
    return dataSource;
  }

  @Bean
  @Profile("prod_docker")
  public DataSource mysqlDataSourceProdDocker() {
    log.info("Loading [PRODUCTION DOCKER] profiles from System Environment variables");
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(env.getProperty("TACO_APP_DATASOURCE_URL"));
    dataSource.setUsername(env.getProperty("TACO_APP_DB_USR"));
    dataSource.setPassword(env.getProperty("TACO_APP_DB_PSWD"));
    return dataSource;
  }
}
