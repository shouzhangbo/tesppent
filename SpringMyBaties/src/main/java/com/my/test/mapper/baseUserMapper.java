package com.my.test.mapper;

import com.my.test.mapper.baseUser;
import com.my.test.mapper.baseUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface baseUserMapper {
    int countByExample(baseUserExample example);

    int deleteByExample(baseUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(baseUser record);

    int insertSelective(baseUser record);

    List<baseUser> selectByExample(baseUserExample example);

    baseUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") baseUser record, @Param("example") baseUserExample example);

    int updateByExample(@Param("record") baseUser record, @Param("example") baseUserExample example);

    int updateByPrimaryKeySelective(baseUser record);

    int updateByPrimaryKey(baseUser record);
}