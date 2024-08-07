package store.store_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.model.Drinks;

@Mapper
public interface DrinksMapper {
    DrinksMapper INSTANCE = Mappers.getMapper(DrinksMapper.class);

    ListDrinksDTO toListDrinksDTO(Drinks drinks);
    Drinks toDrinks(DrinksDTO drinksDTO);
    ResponseDrinksDTO toResponseDrinksDTO(Drinks drinks);
    AlterDrinksDTO toAlterDrinksDTO(Drinks drinks);
}
