package com.danebrown.shardingsphere;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 *
 */
@Log4j2
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/SHARDING_TEST_1");
        dataSource1.setUsername("root");
        dataSource1.setPassword("Bd1981@7");
        dataSourceMap.put("SHARDING_TEST_0", dataSource1);

        HikariDataSource dataSource2 = new HikariDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setJdbcUrl("jdbc:mysql://localhost:3306/SHARDING_TEST_2");
        dataSource2.setUsername("root");
        dataSource2.setPassword("Bd1981@7");
        dataSourceMap.put("SHARDING_TEST_1", dataSource2);

        TableRuleConfiguration orderTableRuleConfig =
                new TableRuleConfiguration("SHARDING_TEST", "SHARDING_TEST_$" +
                        "{0..1}.SHARDING_TEST_${0..1}");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "SHARDING_TEST_${id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "SHARDING_TEST_${id % 2}"));

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());

        String sql = "SELECT o.* FROM SHARDING_TEST o WHERE o.id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)
        ){
            preparedStatement.setInt(1,2);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()) {
                    log.warn("rs:{}",rs);
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getDate(2));
                }
            }
        }



    }
}
