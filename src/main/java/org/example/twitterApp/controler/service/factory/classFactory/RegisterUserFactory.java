package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;

import java.util.Set;
import java.util.TreeSet;

public class RegisterUserFactory extends ValidateValueClass implements UserFactoryInterface {

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


//    @Override
//    public Set<RegisterUserDtO> createDTO(Set<?> list) {
//        Set<RegisterUserDtO> ruDTOs = new TreeSet<>();
//        for (int i = 0; i < list.size(); i++) {
//            RegisterUserDtO ruDTO;
//            if (ru.getTwitterUser() != null) {
//                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), ru.getTwitterUser().getUsername(), getDateAndTime(ru.getCreateDate()));
//            } else {
//                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), "Not created", getDateAndTime(ru.getCreateDate()));
//            }
//            ruDTOs.add(ruDTO);
//        }
//        return ruDTOs;
//    }

}
