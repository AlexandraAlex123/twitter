package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;

public class RegisterUserFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public RegisterUserDtO convertToDTO(Object o) {
        RegisterUser ru = (RegisterUser) o;
        RegisterUserDtO ruDTO = new RegisterUserDtO();
        ruDTO.setFirstName(ru.getFirstName());
        ruDTO.setLastName(ru.getLastName());
        ruDTO.setCreateDate(getDateAndTime(ru.getCreateDate()));
        if (ru.getAccount() != null) {
            ruDTO.setAccount(ru.getAccount().getUsername());
        } else {
            ruDTO.setAccount("Not created");
        }
        return ruDTO;
    }


}
