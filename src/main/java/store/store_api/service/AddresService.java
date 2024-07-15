package store.store_api.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        var addres = new Addres(data);
        addresRepository.save(addres);
        return new Addres(addres);
    }
}
