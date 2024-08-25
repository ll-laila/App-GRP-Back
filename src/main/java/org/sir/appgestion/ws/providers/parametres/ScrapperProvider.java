package org.sir.appgestionstock.ws.providers.parametres;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sir.appgestionstock.ws.dto.parametres.scrapping.ScrapperDto;
import org.sir.appgestionstock.ws.dto.parametres.scrapping.ScrapperRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/scrapper")
public class ScrapperProvider {

    @PostMapping
    public ResponseEntity<List<ScrapperDto>> scrapper(@RequestBody ScrapperRequest request) {
        List<ScrapperDto> products = new ArrayList<>();
        String baseUrl = "https://www.jumia.ma/" + request.getCategorie() + "/?q=tout#catalog-listing";
        boolean hasNextPage = true;
        int pageNumber = 1;

        while (hasNextPage) {
            try {
                // Charger la page actuelle
                String url = baseUrl + "&page=" + pageNumber;
                Document doc = Jsoup.connect(url).get();
                Elements books = doc.select(".core");

                for (Element book : books) {
                    String title = book.select(".name").text();
                    String price = book.select(".prc").text();

                    // Filtrer les produits par le nom
                    if (title.toLowerCase().contains(request.getProductName().toLowerCase())) {
                        String priceOnly = price.replaceAll("[^\\d.]", "");
                        ScrapperDto sp = ScrapperDto.builder()
                                .nom(title)
                                .prix(Double.parseDouble(priceOnly))
                                .source(baseUrl)
                                .build();

                        products.add(sp);
                    }
                }

                if (products.size() > 100) break;

                // Vérifier s'il existe une page suivante
                Element nextPageElement = doc.select("a.pg[aria-label='Page suivante']").first();
                hasNextPage = nextPageElement != null;

                pageNumber++;

            } catch (IOException e) {
                e.printStackTrace();
                hasNextPage = false;
            }
        }

        return ResponseEntity.ok(products);
    }
}
