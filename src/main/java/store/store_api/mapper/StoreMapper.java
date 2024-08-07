package store.store_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.ResponseStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.model.Stores;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    ListStoreDTO toListStoreDTO(Stores stores);
    Stores toStoreCreateDTO(StoreCreateDTO storeCreateDTO);
    ResponseStoreDTO toResponseStoreDTO(Stores stores);
    AlterStoreDTO toAlterStoreDTO(Stores stores);
}
