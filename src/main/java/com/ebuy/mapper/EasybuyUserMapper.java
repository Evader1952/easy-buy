package com.ebuy.mapper;

import com.ebuy.pojo.EasybuyUser;
import com.ebuy.pojo.EasybuyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EasybuyUserMapper {
    long countByExample(EasybuyUserExample example);

    int deleteByExample(EasybuyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUser record);

    int insertSelective(EasybuyUser record);

    List<EasybuyUser> selectByExample(EasybuyUserExample example);

    EasybuyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyUser record, @Param("example") EasybuyUserExample example);

    int updateByExample(@Param("record") EasybuyUser record, @Param("example") EasybuyUserExample example);

    int updateByPrimaryKeySelective(EasybuyUser record);

    int updateByPrimaryKey(EasybuyUser record);
}