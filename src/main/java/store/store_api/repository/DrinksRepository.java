package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.model.Drinks;

public interface DrinksRepository extends JpaRepository<Drinks, Long> {
    Drinks getReferenceById(DrinksDTO drinksDTO);

    void update(Long id);
}
