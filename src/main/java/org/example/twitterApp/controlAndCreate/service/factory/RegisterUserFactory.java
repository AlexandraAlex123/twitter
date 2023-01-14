package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;

public class RegisterUserFactory extends ValidateFactory implements Factory {

    @Override
    public RegisterUserDtO convertToDTO(Object o) {
        RegisterUserDtO ruDTO;
        RegisterUser ru = (RegisterUser) o;
        if (ru.getTwitterUser() != null) {
            ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), ru.getTwitterUser().getUsername(), getDateAndTime(ru.getCreateDate()));
        } else {
            ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), "Not created", getDateAndTime(ru.getCreateDate()));
        }
        return ruDTO;
    }


}
