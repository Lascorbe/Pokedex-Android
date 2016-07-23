package com.lascorbe.pokedex.data.datasource;

import com.lascorbe.pokedex.data.model.PokemonData;
import com.lascorbe.pokedex.domain.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonDataMapper {

    public static List<Pokemon> map(List<PokemonData> source) {
        List<Pokemon> result = new ArrayList<>(source.size());
        for (PokemonData pokemonData : source) {
            Pokemon pokemon = map(pokemonData);
            result.add(pokemon);
        }
        return result;
    }

    public static Pokemon map(PokemonData source) {
        return new Pokemon.Builder()
                .setId(source.getId())
                .setImageUrl(source.getImageUrl())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .build();
    }
}
