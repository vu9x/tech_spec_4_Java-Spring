package org.example.domain;

import org.springframework.stereotype.Component;

@Component
public class GasolineEngine implements iEngin{
    public GasolineEngine() {
        System.out.println("Создан экземпляр GasolineEngine");
    }

    @Override
    public void startEngin() {
        System.out.println("Запущен бензиновый двигатель!");
    }
}
