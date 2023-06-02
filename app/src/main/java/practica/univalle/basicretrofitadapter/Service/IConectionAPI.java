package practica.univalle.basicretrofitadapter.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IConectionAPI {
    @GET("/api/v2/pokemon/{id}")
    Call<PokemonResponse> getPokemon(@Path("id") int id);
    //@GET("/api/users")
    //Call<PokemonResponse> getUserPerPage(@Query("page") int page, @Query("per_page") int per_page);
}
