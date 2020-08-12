package com.example.goods.mapper;

import com.example.common.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> list();

    Boolean create(Goods goods);
}
