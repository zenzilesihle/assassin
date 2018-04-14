package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Target;
import com.zenzile.assassin.model.constants.TargetStatus;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;

public class TargetFactory {
    public static Target createTarget(Target newTaget) {
        Target targetFactory = new Target();

        targetFactory.setName(newTaget.getName());
        targetFactory.setSurname(newTaget.getSurname());
        //targetFactory.setAddress(newTaget.getAddress());
        targetFactory.setId(newTaget.getId());
        targetFactory.setEmail(newTaget.getEmail());
        targetFactory.setGender(targetFactory.getGender());
        targetFactory.setUserType(UserType.TARGET);
        targetFactory.setRegistrationDate(new Date());
        targetFactory.setTargetStatus(TargetStatus.ALIVE);

        return targetFactory;
    }
}
