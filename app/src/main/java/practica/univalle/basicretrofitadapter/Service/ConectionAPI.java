package practica.univalle.basicretrofitadapter.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConectionAPI {
    private static final String BASE_URL = "https://pokeapi.co/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static IConectionAPI IConectionAPI = retrofit.create(IConectionAPI.class);

    public static IConectionAPI getConectionAPI() {
        return IConectionAPI;
    }
}
