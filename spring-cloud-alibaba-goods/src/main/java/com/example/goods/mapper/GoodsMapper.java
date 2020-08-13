package com.example.goods.mapper;

import com.example.common.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    Goods get(@Param("id") Integer id);

    List<Goods> list();

    Boolean create(Goods goods);

    Boolean update(Goods goods);
}
