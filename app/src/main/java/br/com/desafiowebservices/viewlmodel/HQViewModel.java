package br.com.desafiowebservices.viewlmodel;

import android.util.Log;

import br.com.desafiowebservices.data.network.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.desafiowebservices.utils.AppUtil.md5;

public class HQViewModel {
    // CompositeDisposable para adicionarmos as chamadas do RXJava
    private CompositeDisposable disposable = new CompositeDisposable();
    // Parâmetros necessários para requisição da API MARVEL
// Chave pública que será usada como como parâmetro
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    // Chave privada que será usada como como parâmetro
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";
    // Timestamp do horário da requisição
    String ts = Long.toString(System.currentTimeMillis() / 1000);
    // Hash criacom com as chaves pública e privada e o timestamp
    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public void getComics() {
        disposable.add(
                ApiService.getApiService().getComics("magazine", "comic", true, "focDate", ts, hash, PUBLIC_KEY, PRIVATE_KEY)

                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(response -> Log.i("LOG", "Success: " + response), throwable -> Log.i("LOG", "Error: " + throwable.getMessage())));
    }
}

