package com.danebrown.shardingsphere.service;

import com.danebrown.shardingsphere.dao.CustomSharding;
import com.danebrown.shardingsphere.dao.ShardingTest;
import com.danebrown.shardingsphere.mapper.CustomShardingMapper;
import com.danebrown.shardingsphere.mapper.ShardingTestMapper;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by danebrown on 2021/7/22
 * mail: tain198127@163.com
 *
 * @author danebrown
 */
@MapperScan("com.danebrown.shardingsphere")
@Log4j2
public class ShardingJDBC {
    private static final String MYBATIS_CONFIG = "org/mybatis/example/mybatis" + "-config.xml";
    @Autowired
    private ApplicationContext context;

    @Autowired
    private ShardingTestMapper mapper;
    
    @Autowired
    private CustomShardingMapper customShardingMapper;

//    public void init() {
//        try {
//            InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Transactional
    public void runsql() {
//        List<ShardingTest> list = mapper.selectList(null);
        ShardingTest st =  new ShardingTest();
        st.setName("akk");
        st.setRegDate(new Date());
        st.setName("11212256");
        st.setShardingKey("4");
        mapper.insert(st);
        List<ShardingTest> list1 = mapper.selectList(null);
        log.info("selectList:[{}]",list1);
    
    
        CustomSharding cs = new CustomSharding();
        cs.setName("custom1");
        cs.setRegDate(new Date());
        cs.setShardingKey("tain198127@163.com");
        customShardingMapper.insert(cs);
        List<CustomSharding> csList = customShardingMapper.selectList(null);
        for (CustomSharding customSharding : csList) {
            log.info("customSharding:[{}]",customSharding);
        }
    }
    
}
