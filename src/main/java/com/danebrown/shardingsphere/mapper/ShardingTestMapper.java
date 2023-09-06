package com.danebrown.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danebrown.shardingsphere.dao.ShardingTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by danebrown on 2021/7/22
 * mail: tain198127@163.com
 *
 * @author danebrown
 */
@Mapper
public interface ShardingTestMapper extends BaseMapper<ShardingTest> {
    List<ShardingTest> selectAll();

}
