package rh.javapleno.colaborador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.model.Colaborador;
import rh.javapleno.colaborador.repository.ColaboradorRepository;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public void startDB() {

        Colaborador c1 = new Colaborador(null, "Luiz Generoso", 380.00);
        Colaborador c2 = new Colaborador(null, "Antonio Generoso", 320.00);
        Colaborador c3 = new Colaborador(null, "Felipe Generoso", 390.00);
        Colaborador c4 = new Colaborador(null, "Giulia Cleto", 285.00);
        Colaborador c5 = new Colaborador(null, "Gleice Cleto", 395.00);

        colaboradorRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
    }
}
