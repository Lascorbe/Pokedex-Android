package com.lascorbe.pokedex.presenter;

import com.lascorbe.pokedex.domain.model.Pokemon;

import java.util.List;

public interface PokedexPresenter {
    void onRequestPokemonList();

    interface View {
        void renderPokemons(List<Pokemon> pokemons);
    }
}
