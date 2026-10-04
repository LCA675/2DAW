package org.example;

public class AndaluciaFactory extends ElementoAndaluzFactory{
    public AndaluciaFactory() {
    }

    @Override
    ElementoAndaluz createElementoAndaluz(String elemento) {
        if (elemento=="gazpacho"){
            Gazpacho gazpacho = new Gazpacho();
            return gazpacho;
        }
        if (elemento=="flamenco"){
            Flamenco flamenco = new Flamenco();
            return flamenco;
        }
        if (elemento=="feria"){
            FeriaDeAbril feria = new FeriaDeAbril();
            return feria;
        }

        return null;

    }
}
