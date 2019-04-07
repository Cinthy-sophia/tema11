package com.cinthyasophia.tema11.Ejercicio06;


public class Pelicula extends Multimedia {
    protected String actorPrincipal;
    protected String actrizPrincipal;
    protected String duracion;

    public Pelicula(String titulo, String autor, String formato, String duracion, String actorPrincipal, String actrizPrincipal, int year) {
        super(titulo, autor, formato, year);
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
        this.duracion= duracion;

    }

    public String getDuracion() {
        return duracion;
    }


    public String getActorPrincipal() {
        return actorPrincipal;
    }


    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nActor principal:" + actorPrincipal +
                "\nActriz principal:" + actrizPrincipal +
                "\nDuracion:" + duracion ;
    }
}
