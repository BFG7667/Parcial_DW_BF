package com.example.demo.init;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Resolucion;
import com.example.demo.model.Televisor;
import com.example.demo.repository.TelevisorRepository;

import jakarta.transaction.Transactional;

@Configuration
public class DbInitializer implements CommandLineRunner{
    
    @Autowired
    private TelevisorRepository televisorRepository;

    private static final Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Override
    @Transactional
    public void run(String... args) throws Exception{

        if(televisorRepository.count() == 0){
            LocalDate currentDate = LocalDate.now();
            List<Televisor> televisores = new ArrayList<>();
            for (int i=0; i<5; i++){
                Televisor televisor = new Televisor();
                televisor.setMarca("SAMSUNG");
                televisor.setTamanoPantalla(12 * i);
                televisor.setResolucion(Resolucion.FULL_HD);
                televisor.setDescripcion("BUENO");
                televisor.setFuncionesAdicionales("TODAS");
                televisor.setPrecio(900000*i);
                televisor.setDescripcionGarantia("1 AÑO");
                televisor.setFechaCreacion(currentDate);

                televisores.add(televisor);
            }

            televisorRepository.saveAll(televisores);
            logger.debug("CINCO REGISTROS DE PRUEBA CREADOS");
            
        }
    }
}
