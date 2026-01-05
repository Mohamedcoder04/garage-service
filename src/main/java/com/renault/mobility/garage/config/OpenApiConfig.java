package com.renault.mobility.garage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Garage Management API")
                        .version("0.0.1")
                        .description("""
                    API pour la gestion des garages, véhicules et accessoires :
                    - Garages : création, mise à jour, suppression, recherche et listing paginé/trié.
                    - Véhicules : ajout au garage, mise à jour, suppression, listing par garage et par modèle.
                    - Accessoires : ajout au véhicule, mise à jour, suppression, listing par véhicule.
                    """)
                        .contact(new Contact()
                                .name("Mohamed Aghzer")
                                .email("mohamed.aghzer01@gmail.com")
                        )
                );
    }
}

