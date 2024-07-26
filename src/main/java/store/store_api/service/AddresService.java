package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.model.Addres;
import store.store_api.repository.AddresRepository;

@Service
public class AddresService {

    @Autowired
    AddresRepository addresRepository;

    public Addres addresRegister(AddresDataDTO data){
        if (addresRepository.existsByZipCode(data.getZipCode())) {
            throw new ValidationException("CEP já cadastrado");
        }

        var addres = new Addres(data.street(), data.neighborhood(),
                data.zipCode(), data.number(), data.complement(), data.city(), data.uf());
        return addresRepository.save(addres);
    }

    public Addres alterAddres(AlterAddresDTO alterAddresDTO) {
        if (!addresRepository.existsById(alterAddresDTO.id())) {
            throw new ValidationException("Addres with ID " + alterAddresDTO.id() + " does not exist.");
        }

        var addres = addresRepository.getReferenceById(alterAddresDTO.id());
        addres.update(alterAddresDTO);
        return addresRepository.save(addres);
    }

    public void deleteAddres(Long id) {
        if (!addresRepository.existsById(id)) {
            throw new ValidationException("Addres with ID " + id + " does not exist.");
        }

        addresRepository.deleteById(id);
    }
}
