package store.store_api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.model.Drinks;

@Component
@RequiredArgsConstructor
public class DrinksMapper {

    private final ModelMapper mapper;

    public ListDrinksDTO toListDrinksDTO(Drinks drinks) {
        return mapper.map(drinks, ListDrinksDTO.class);
    }

    public Drinks toDrinks(DrinksDTO drinksDTO) {
        return mapper.map(drinksDTO, Drinks.class);
    }

    public ResponseDrinksDTO toResponseDrinksDTO(Drinks drinks) {
        return mapper.map(drinks, ResponseDrinksDTO.class);
    }

    public AlterDrinksDTO toAlterDrinksDTO(Drinks drinks) {
        return mapper.map(drinks, AlterDrinksDTO.class);
    }
}
