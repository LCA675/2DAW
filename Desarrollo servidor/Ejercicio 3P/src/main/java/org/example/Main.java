package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        AndaluciaFactory andalucia = new AndaluciaFactory();

        ElementoAndaluz flamenco = andalucia.createElementoAndaluz("flamenco");
        ElementoAndaluz gazpacho = andalucia.createElementoAndaluz("gazpacho");
        ElementoAndaluz feria = andalucia.createElementoAndaluz("feria");

        flamenco.describir();
        gazpacho.describir();
        feria.describir();

    }
}
