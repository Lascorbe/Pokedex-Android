package com.lascorbe.pokedex.domain.usecase;

import com.lascorbe.pokedex.data.repository.PokemonRepository;
import com.lascorbe.pokedex.domain.model.Pokemon;
import java.util.List;

public class GetPokemonListUseCase {
    private final PokemonRepository repository;

    public  GetPokemonListUseCase(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<Pokemon> execute() {
        return repository.getPokemonList();
    }
}
