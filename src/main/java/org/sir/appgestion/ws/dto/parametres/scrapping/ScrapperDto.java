package org.sir.appgestionstock.ws.dto.parametres.scrapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScrapperDto {
    private String nom;
    private double prix;
    private String source;
}
