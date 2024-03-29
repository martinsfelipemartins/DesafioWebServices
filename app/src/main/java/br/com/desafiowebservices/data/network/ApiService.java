package br.com.desafiowebservices.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

/*
    public key = "6eb7e8896ec5850c52515a8a23ee97f0"
    private key = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
*/


    private static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";


    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
/* configurações da conexão, onde podemos setar o timeout e outras opções para
            as requisições*/

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);


            // Inicializamos o retrofit
            retrofit = new Retrofit.Builder()
// Url obrigatória
                    .baseUrl(BASE_URL)
// adapter para o uso do RXJava
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
// Conversor que transforma-rá o json recebido em classes Java
                    .addConverterFactory(GsonConverterFactory.create())
// Adicionamos as configurações de requisição configurado acima
                    .client(httpClient.build()).build();
        }
        return retrofit;
    }

    public static API getApiService() {
        return getRetrofit().create(API.class);
    }
}
