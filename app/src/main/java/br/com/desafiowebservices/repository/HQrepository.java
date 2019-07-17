package br.com.desafiowebservices.repository;

import br.com.desafiowebservices.pojo.HQResponse;
import io.reactivex.Single;

import static br.com.desafiowebservices.data.network.ApiService.PRIVATE_KEY;
import static br.com.desafiowebservices.data.network.ApiService.PUBLIC_KEY;
import static br.com.desafiowebservices.data.network.ApiService.getApiService;
import static br.com.desafiowebservices.utils.AppUtil.md5;

public class HQrepository {
    public Single<HQResponse> getComics() {
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);
        return getApiService().getComics("magazine", "comic", true, "focDate", "50", ts, hash, PUBLIC_KEY);
    }
}
