package com.lascorbe.pokedex.presenter;

import com.lascorbe.pokedex.domain.model.Pokemon;
import com.lascorbe.pokedex.domain.usecase.GetPokemonListUseCase;

import java.util.List;

public class PokedexPresenterImpl implements PokedexPresenter {
    private final View view;
    private final GetPokemonListUseCase getPokemonListUseCase;

    public PokedexPresenterImpl(View view, GetPokemonListUseCase getPokemonListUseCase) {
        this.view = view;
        this.getPokemonListUseCase = getPokemonListUseCase;
    }

    @Override
    public void onRequestPokemonList() {
        List<Pokemon> pokemonList = getPokemonListUseCase.execute();
        view.renderPokemons(pokemonList);
    }
}
