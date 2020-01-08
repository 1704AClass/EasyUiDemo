package com.easyui.mapper;

import com.easyui.pojo.Power;
import com.easyui.pojo.PowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PowerMapper {
    int countByExample(PowerExample example);

    int deleteByExample(PowerExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Power record);

    int insertSelective(Power record);

    List<Power> selectByExample(PowerExample example);
    
    List<Power> getPowerByUid(@Param("uid") Integer uid);

    Power selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByExample(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}