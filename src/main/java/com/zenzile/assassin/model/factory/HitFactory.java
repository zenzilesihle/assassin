package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Hit;

public class HitFactory {
    public static Hit createHit(Hit newHit) {
        Hit factoryHit = new Hit();

        factoryHit.setId(newHit.getId());
        factoryHit.setAmount(newHit.getAmount());
        factoryHit.setClient(newHit.getClient());
        factoryHit.setMember(newHit.getMember());
        factoryHit.setTargets(newHit.getTargets());

        return factoryHit;
    }
}
