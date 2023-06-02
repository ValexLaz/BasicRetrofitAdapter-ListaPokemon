package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.Adapters.UserAdapter;
import practica.univalle.basicretrofitadapter.Models.Pokemon;
import practica.univalle.basicretrofitadapter.Service.PokemonResponse;
import practica.univalle.basicretrofitadapter.Service.ConectionAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pokemon> pokemonList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        getPokemonAPI(14);//vacio sin variable
        PokeLista(1,10);
    }

    public void initAdapter(){
        pokemonList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, pokemonList);
        recyclerView.setAdapter(userAdapter);
    }

    public void getPokemonAPI(int id) {
        Call<PokemonResponse> call = ConectionAPI.getConectionAPI().getPokemon(id);//getPokemon(1)
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body().getPokemon();
                    pokemon.setHp("HP: "+response.body().getStats().get(0).getBase_stat());
                    pokemon.setAtaque("Ataque: "+response.body().getStats().get(1).getBase_stat());
                    pokemon.setAtaqueEspecial("Ataque Especial: "+response.body().getStats().get(3).getBase_stat());
                    pokemon.setDefensa("Defensa: "+response.body().getStats().get(2).getBase_stat());
                    pokemonList.add(pokemon);
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de pokemones: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("MainActivity", "onFailure al obtener la lista de pokemones: " + t.toString());
            }
        });

    }
    public void PokeLista(int first, int last){
        for(int i = first;i<= last;i++){
            getPokemonAPI(i);
        }
    }

}
