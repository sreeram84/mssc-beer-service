package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {

              beerRepository.save(Beer.builder()
                              .beerName("Mango Beer")
                              .beerStyle("Pale")
                              .quantityToBrew(200)
                              .minOnHand(12)
                              .price(new BigDecimal("12.95"))
                              .upc(337100010021L)
                              .build());

            beerRepository.save(Beer.builder()
                    .beerName("Jeera Beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .price(new BigDecimal("11.95"))
                    .upc(337100010031L)
                    .build());

        }

    }
}
