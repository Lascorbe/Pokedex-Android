package com.lascorbe.pokedex.data.datasource;

import com.lascorbe.pokedex.data.model.PokemonData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PokemonLocalDataSource {
    private final Map<Long, PokemonData> cache = new LinkedHashMap<>();

    public PokemonLocalDataSource() {
        for (int counter = 1; counter <= 100; counter++) {
            buildFakePokemon(counter,
                    "http://vignette1.wikia.nocookie.net/pokemon/images/5/5b/129Magikarp_OS_anime_2.png/revision/latest?cb=20150101075047",
                    String.format(Locale.getDefault(), "Name %d", counter),
                    String.format(Locale.getDefault(), "Description %d", counter));
        }
    }

    private void buildFakePokemon(long id, String imageUrl, String name, String description) {
        PokemonData pokemon = new PokemonData.Builder()
                .setId(id)
                .setImageUrl(imageUrl)
                .setName(name)
                .setDescription(description)
                .build();
        cache.put(pokemon.getId(), pokemon);
    }

    public List<PokemonData> getPokemonList() {
        return new ArrayList<>(cache.values());
    }
}
