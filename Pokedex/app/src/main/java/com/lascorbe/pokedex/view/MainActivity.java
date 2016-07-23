package com.lascorbe.pokedex.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.lascorbe.pokedex.R;
import com.lascorbe.pokedex.domain.model.Pokemon;
import com.lascorbe.pokedex.presenter.PokedexPresenter;
import com.lascorbe.pokedex.presenter.PokedexPresenterFactory;
import com.lascorbe.pokedex.view.adapter.PokemonListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity
                          implements PokedexPresenter.View {
    private ListView listView;
    private PokedexPresenter pokedexPresenter;
    private PokemonListAdapter pokemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeList();
        initializePresenter();
    }

    //region PRIVATE

    private void initializeList() {
        pokemonListAdapter = new PokemonListAdapter(this);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(pokemonListAdapter);
    }

    private void initializePresenter() {
        pokedexPresenter = PokedexPresenterFactory.getPresenter(this);
        pokedexPresenter.onRequestPokemonList();
    }

    //endregion

    //region PokedexPresenter.View

    @Override
    public void renderPokemons(List<Pokemon> pokemons) {
        pokemonListAdapter.clear();
        pokemonListAdapter.addAll(pokemons);
        pokemonListAdapter.notifyDataSetChanged();
    }

    //endregion
}
