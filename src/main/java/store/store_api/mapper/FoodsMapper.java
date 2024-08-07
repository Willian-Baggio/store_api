package store.store_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.foods.ResponseFoodsDTO;
import store.store_api.model.Foods;

@Mapper
public interface FoodsMapper {
    FoodsMapper INSTANCE = Mappers.getMapper(FoodsMapper.class);

    ListFoodsDTO toListFoodsDTO(Foods foods);
    Foods toFoods(FoodsDTO foodsDTO);
    ResponseFoodsDTO toResponseFoodsDTO(Foods foods);
    AlterFoodsDTO toAlterFoodsDTO(Foods foods);
}
