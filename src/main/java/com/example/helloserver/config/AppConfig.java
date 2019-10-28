package com.example.helloserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.core.constant.properties.ShardingPropertiesConstant;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//@Configuration
public class AppConfig {

//    @Bean
//    DataSource druidDataSource(DataSourceProperties properties) throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(properties.getUrl());
//        druidDataSource.setPassword(properties.getPassword());
//        druidDataSource.setUsername(properties.getUsername());
//        druidDataSource.setFilters("stat,slf4j");
//        druidDataSource.setPoolPreparedStatements(true);
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(100);
//        return druidDataSource;
//    }

    @Bean
    DataSource dataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("no", "my$->{no % 2 + 1}"));
        Properties properties = new Properties();
        properties.setProperty("sql.show", "true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, properties);
    }

    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE", "id");
        return result;
    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("user", "my$->{1..2}.user$->{0..1}");
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user$->{id % 2}"));
        return result;
    }

/*    TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order_item", "ds${0..1}.t_order_item${0..1}");
        return result;
    }*/

    Map<String, DataSource> createDataSourceMap() throws SQLException {
        Map<String, DataSource> result = new HashMap<>();
        DataSource my1 = createDataSource("jdbc:mysql://localhost:3306/my1?serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull",
                "root", "111111");
        DataSource my2 = createDataSource("jdbc:mysql://localhost:3306/my2?serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull",
                "root", "111111");
        result.put("my2", my2);
        result.put("my1", my1);
        return result;
    }

    DataSource createDataSource(String url, String name, String password) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(password);
        druidDataSource.setUsername(name);
        druidDataSource.setFilters("stat,slf4j");
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(100);
        return druidDataSource;
    }
}
