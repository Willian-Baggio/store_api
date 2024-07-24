package store.store_api.service;

import jakarta.validation.ValidationException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.model.Addres;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.repository.AddresRepository;

@Service
public class AddresService {

    @Autowired
    AddresRepository addresRepository;

    public Addres addresRegister(AddresDataDTO data) throws BadRequestException {
        if (addresRepository.existsByZipCode(data.getZipCode())) {
            throw new BadRequestException("CEP já cadastrado");
        }

        var addres = new Addres(data.street(), data.neighborhood(),
                data.zipCode(), data.number(), data.complement(), data.city(), data.uf());
        addresRepository.save(addres);
        return new Addres(addres);
    }

    public AlterAddresDTO alterAddres(AlterAddresDTO alterAddresDTO) {
        if (!addresRepository.existsById(alterAddresDTO.id())) {
            throw new ValidationException("Addres with ID " + alterAddresDTO.id() + " does not exist.");
        }

        var addres = new Addres(alterAddresDTO);
        addresRepository.save(addres);
        return new AlterAddresDTO(addres);
    }

    public void deleteAddres(Long id) {
        if (!addresRepository.existsById(id)) {
            throw new ValidationException("Addres with ID " + id + " does not exist.");
        }

        addresRepository.deleteById(id);
    }
}
