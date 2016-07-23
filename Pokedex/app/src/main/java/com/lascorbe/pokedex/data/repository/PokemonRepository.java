package com.lascorbe.pokedex.data.repository;

import com.lascorbe.pokedex.data.datasource.PokemonDataMapper;
import com.lascorbe.pokedex.data.datasource.PokemonLocalDataSource;
import com.lascorbe.pokedex.data.model.PokemonData;
import com.lascorbe.pokedex.domain.model.Pokemon;

import java.util.List;

public class PokemonRepository {
    private final PokemonLocalDataSource localDataSource;

    public PokemonRepository(PokemonLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    public List<Pokemon> getPokemonList() {
        List<PokemonData> source = localDataSource.getPokemonList();
        List<Pokemon> result = PokemonDataMapper.map(source);
        return result;
    }
}
