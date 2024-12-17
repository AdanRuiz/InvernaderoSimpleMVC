//Invernadero.java
package com.tlg.inv.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Invernadero {

    private final ActuadorRiegoFactory actuadorRiegoFactory;
    private ActuadorRiego actuadorRiego;
    private String invernaderoId;

    @Autowired
    public Invernadero(ActuadorRiegoFactory actuadorRiegoFactory) {
        invernaderoId="";
        this.actuadorRiegoFactory = actuadorRiegoFactory;
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego("normal");
    }

    public Invernadero(String id) { 
        actuadorRiegoFactory = new ActuadorRiegoFactory();
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego("normal");
    }

    public Invernadero(String id, String tipo) {
        this.invernaderoId = id;
        this.actuadorRiegoFactory = new ActuadorRiegoFactory();
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipo);
    }
    
    public Invernadero() { 
        this("noId", "normal"); 
    }

    public String getInvernaderoId() {
        return invernaderoId;
    }

    public String getActuadorRiego() { 
        return actuadorRiego.getClass().getSimpleName(); 
    }

    public void setActuadorRiego(String tipo) {
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipo);
    }

    public void setInvernaderoId(String id) {
        this.invernaderoId = id;
    }

    public void regar() {
        actuadorRiego.activar();
        System.out.println("Invernadero "+invernaderoId+" regando.");
    }

    @Override
    public String toString() { 
        return "{" + "\"invernaderoId\": \"" + invernaderoId + "\"," + "\"actuadorRiego\": \"" + actuadorRiego.getClass().getSimpleName() + "\"" + "}";
    }
}
