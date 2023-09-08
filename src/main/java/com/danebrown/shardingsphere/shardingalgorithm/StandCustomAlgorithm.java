package com.danebrown.shardingsphere.shardingalgorithm;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.MurmurHash3;
import org.apache.shardingsphere.sharding.algorithm.sharding.ShardingAutoTableAlgorithmUtil;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.Properties;

/**
 * 自定义算法
 */
public class StandCustomAlgorithm implements StandardShardingAlgorithm {
    public static final String SHARDING_COUNT_KEY = "sharding-count";
    private static final String ALGORITHM_EXPRESSION_KEY = "algorithm-expression";
    @Getter
    private Properties props;
    private int shardingcount;
    @Autowired
    private ApplicationContext context;
    
    @SneakyThrows
    @Override
    public String doSharding(final Collection collection, final PreciseShardingValue preciseShardingValue) {
        int hash = MurmurHash3.hash32x86(preciseShardingValue.getValue().toString().getBytes());
        String idx = String.valueOf(hash % shardingcount);
        return ShardingAutoTableAlgorithmUtil.findMatchedTargetName(collection, idx, preciseShardingValue.getDataNodeInfo()).orElse(null).toString();
    }
    
    @Override
    public Collection<String> doSharding(final Collection collection, final RangeShardingValue rangeShardingValue) {
        return collection;
    }
    
    @Override
    public Properties getProps() {
        return this.props;
    }
    
    @Override
    public void init(final Properties props) {
        shardingcount = getShardingCount(props);
        this.props = props;
    }
    
    private int getShardingCount(final Properties props) {
        Preconditions.checkArgument(props.containsKey(SHARDING_COUNT_KEY), "Sharding count cannot be null.");
        return Integer.parseInt(props.getProperty(SHARDING_COUNT_KEY));
    }
}
