package com.lascorbe.pokedex.presenter;

import com.lascorbe.pokedex.data.datasource.PokemonLocalDataSource;
import com.lascorbe.pokedex.data.repository.PokemonRepository;
import com.lascorbe.pokedex.domain.usecase.GetPokemonListUseCase;

public class PokedexPresenterFactory {
    public static PokedexPresenter getPresenter(PokedexPresenter.View view) {
        GetPokemonListUseCase useCase = getPokemonUseCase();
        return new PokedexPresenterImpl(view, useCase);
    }

    private static GetPokemonListUseCase getPokemonUseCase() {
        PokemonRepository repository = getPokemonRepository();
        GetPokemonListUseCase useCase = new GetPokemonListUseCase(repository);
        return useCase;
    }

    private static PokemonRepository getPokemonRepository() {
        PokemonLocalDataSource dataSource = getPokemonLocalDataSource();
        return new PokemonRepository(dataSource);
    }

    private static PokemonLocalDataSource getPokemonLocalDataSource() {
        return new PokemonLocalDataSource();
    }
}
