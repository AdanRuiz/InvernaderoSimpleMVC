//ActuadorRiegoFactory,java
package com.tlg.inv.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActuadorRiegoFactory {

    private final ActuadorRiegoNormal actuadorRiegoNormal;
    private final ActuadorRiegoLluvia actuadorRiegoLluvia;

    @Autowired
    public ActuadorRiegoFactory(ActuadorRiegoNormal actuadorRiegoNormal, ActuadorRiegoLluvia actuadorRiegoLluvia) { 
        this.actuadorRiegoNormal = actuadorRiegoNormal;
        this.actuadorRiegoLluvia = actuadorRiegoLluvia;
    }
    
    public ActuadorRiegoFactory() {
        this.actuadorRiegoNormal = new ActuadorRiegoNormal() ;
        this.actuadorRiegoLluvia = new ActuadorRiegoLluvia() ;
    }

    public ActuadorRiego createActuadorRiego(String tipo) {
        switch (tipo.toLowerCase()) {
            case "lluvia":
                return actuadorRiegoLluvia;
            case "normal":
            default:
                return actuadorRiegoNormal;
        }
    }
}