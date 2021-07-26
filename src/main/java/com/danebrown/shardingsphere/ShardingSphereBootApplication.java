package com.danebrown.shardingsphere;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.swing.*;

/**
 * Created by danebrown on 2021/7/26
 * mail: tain198127@163.com
 *
 * @author danebrown
 */
@SpringBootApplication(
        excludeName = {"org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration"}
)
@Configuration
@Log4j2
public class ShardingSphereBootApplication implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ShardingSphereBootApplication.class).
                web(WebApplicationType.NONE)
                .run(args);
    }




    @Override
    public void run(String... args) throws Exception {
        System.out.println("ok");
    }
}
