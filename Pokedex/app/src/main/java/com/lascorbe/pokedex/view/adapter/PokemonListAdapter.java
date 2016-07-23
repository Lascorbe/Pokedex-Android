package com.lascorbe.pokedex.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lascorbe.pokedex.R;
import com.lascorbe.pokedex.domain.model.Pokemon;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class PokemonListAdapter extends ArrayAdapter<Pokemon> {
    public PokemonListAdapter(Context context) {
        super(context, R.layout.item_pokemon);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View result = convertView;
        if (result == null) {
            result = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        Pokemon pokemon = getItem(position);
        renderItem(pokemon, result);
        return result;
    }

    private void renderItem(Pokemon pokemon, View view) {
        ImageView avatarImageView = (ImageView) view.findViewById(R.id.avatar);
        Picasso.with(getContext())
                .load(pokemon.getImageUrl())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(avatarImageView);

        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        nameTextView.setText(pokemon.getName());

        TextView descriptionTextView= (TextView) view.findViewById(R.id.description);
        descriptionTextView.setText(pokemon.getDescription());
    }
}