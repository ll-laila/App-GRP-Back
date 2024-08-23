package org.sir.appgestionstock.ws.dto.contacts;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sir.appgestionstock.bean.core.ClientProduitNiveauPrix;
import org.sir.appgestionstock.ws.dto.ClientProduitNiveauPrixDto;
import org.sir.appgestionstock.ws.dto.adresse.AdresseDto;
import org.sir.appgestionstock.ws.dto.parametres.EntrepriseDto;
import org.sir.appgestionstock.ws.dto.parametres.NiveauPrixDto;
import org.sir.appgestionstock.ws.dto.parametres.DevisesDto;
import org.sir.appgestionstock.ws.dto.parametres.TaxeDto;
import org.sir.appgestionstock.bean.enums.LangueEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
private Long id;
private String nom;
private String code;
private String email;
private String siteweb;
private String telephone;
private int taxeNumero;
private float rabais;
private LangueEnum languePDF;
private int valeurCommandeMinimale;
private AdresseDto adresse;
private DevisesDto devises;
private NiveauPrixDto niveauPrix;
private TaxeDto taxe;
private List<ClientProduitNiveauPrixDto> clientProduitNiveauPrixes;
private EntrepriseDto entreprise;
private Long idNiveauPrix;
    private Long idEntreprise;


public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}

    public Long getIdNiveauPrix() {
        return idNiveauPrix;
    }
    public void setIdNiveauPrix(Long id) {
        this.id = id;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }
    public void setIdEntreprise(Long id) {
        this.idEntreprise = id;
    }
public String getNom() {
return nom;
}
public void setNom(String value) {
this.nom = value;
}
public String getCode() {
return code;
}
public void setCode(String value) {
this.code = value;
}
public String getEmail() {
return email;
}
public void setEmail(String value) {
this.email = value;
}
public String getSiteweb() {
return siteweb;
}
public void setSiteweb(String value) {
this.siteweb = value;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String value) {
this.telephone = value;
}
public int getTaxeNumero() {
return taxeNumero;
}
public void setTaxeNumero(int value) {
this.taxeNumero = value;
}
public float getRabais() {
return rabais;
}
public void setRabais(float value) {
this.rabais = value;
}
public LangueEnum getLanguePDF() {
return languePDF;
}
public void setLanguePDF(LangueEnum value) {
this.languePDF = value;
}
public int getValeurCommandeMinimale() {
return valeurCommandeMinimale;
}
public void setValeurCommandeMinimale(int value) {
this.valeurCommandeMinimale = value;
}
public AdresseDto getAdresse() {
return adresse;
}
public void setAdresse(AdresseDto value) {
this.adresse = value;
}
public DevisesDto getDevises() {
return devises;
}
public void setDevises(DevisesDto value) {
this.devises = value;
}
public NiveauPrixDto getNiveauPrix() {
return niveauPrix;
}
public void setNiveauPrix(NiveauPrixDto value) {
this.niveauPrix = value;
}
public TaxeDto getTaxe() {
return taxe;
}
public void setTaxe(TaxeDto value) {
this.taxe = value;
}
public EntrepriseDto getEntreprise() {
return entreprise;
}
public void setEntreprise(EntrepriseDto value) {
this.entreprise = value;
}

    public List<ClientProduitNiveauPrixDto> getClientProduitNiveauPrixes() {
        return clientProduitNiveauPrixes;
    }

    public void setClientProduitNiveauPrixes(List<ClientProduitNiveauPrixDto> clientProduitNiveauPrixes) {
        this.clientProduitNiveauPrixes = clientProduitNiveauPrixes;
    }
}