package com.ebuy.mapper;

import com.ebuy.pojo.EasybuyNews;
import com.ebuy.pojo.EasybuyNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EasybuyNewsMapper {
    long countByExample(EasybuyNewsExample example);

    int deleteByExample(EasybuyNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    int insertSelective(EasybuyNews record);

    List<EasybuyNews> selectByExample(EasybuyNewsExample example);

    EasybuyNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyNews record, @Param("example") EasybuyNewsExample example);

    int updateByExample(@Param("record") EasybuyNews record, @Param("example") EasybuyNewsExample example);

    int updateByPrimaryKeySelective(EasybuyNews record);

    int updateByPrimaryKey(EasybuyNews record);
}