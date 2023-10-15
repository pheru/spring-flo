package com.example.springflo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/kunde")
public class KundeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KundeController.class);

    private static final Map<Integer, Kunde> KUNDEN = new HashMap<>();

    public KundeController() {
        KUNDEN.put(1, new Kunde("Philipp", "Bruckner"));
        KUNDEN.put(2, new Kunde("Flo", "Gerneth"));
    }

    @GetMapping
    public Collection<Kunde> getKunde(@RequestParam(required = false) final String name) {
        LOGGER.info("Name {}", name);
        return KUNDEN.values();
    }

    @GetMapping("/{id}")
    public Kunde getKundeZuId(@PathVariable final int id) {
        LOGGER.info("ID {}", id);
        return KUNDEN.get(id);
    }

    @GetMapping("/dummy")
    public int dummy() {
        return 123;
    }

    @PostMapping("/{id}")
    public void postKunde(@PathVariable final int id,
                          @RequestBody final Kunde kunde) {
        KUNDEN.put(id, kunde);
    }

    public static class Kunde {
        private String vorname;
        private String nachname;

        public Kunde() {
        }

        public Kunde(String vorname, String nachname) {
            this.vorname = vorname;
            this.nachname = nachname;
        }

        public String getVorname() {
            return vorname;
        }

        public void setVorname(String vorname) {
            this.vorname = vorname;
        }

        public String getNachname() {
            return nachname;
        }

        public void setNachname(String nachname) {
            this.nachname = nachname;
        }
    }
}
