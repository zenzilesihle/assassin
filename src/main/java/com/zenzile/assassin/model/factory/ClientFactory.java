package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Client;
import com.zenzile.assassin.model.User;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;

public class ClientFactory {
    public static Client createClient(Client newClient) {
        Client factoryClient = new Client();

        factoryClient.setId(newClient.getId());
        factoryClient.setName(newClient.getName());
        factoryClient.setSurname(newClient.getSurname());
        factoryClient.setGender(newClient.getGender());
        factoryClient.setEmail(newClient.getEmail());
        factoryClient.setRegistrationDate(new Date());
        factoryClient.setAddress(factoryClient.getAddress());
        factoryClient.setUserType(UserType.CLIENT);

        return factoryClient;
    }
}
