package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Hit;
import com.zenzile.assassin.model.constants.TargetStatus;

public class HitFactory {
    public static Hit createHit(Hit newHit) {

        return new Hit
                .HitBuilder(newHit.getCodename())
                .address(newHit.getAddress())
                .admin(newHit.getAdmin())
                .amount(newHit.getAmount())
                .member(newHit.getMember())
                .targetStatus(TargetStatus.ALIVE)
                .build();
    }
}
