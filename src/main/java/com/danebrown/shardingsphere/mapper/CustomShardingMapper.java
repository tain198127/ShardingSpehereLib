package com.danebrown.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danebrown.shardingsphere.dao.CustomSharding;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomShardingMapper extends BaseMapper<CustomSharding> {
}
