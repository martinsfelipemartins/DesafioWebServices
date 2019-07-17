package br.com.desafiowebservices.data.network;

import br.com.desafiowebservices.pojo.HQResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("comics?")
    Single<HQResponse> getComics(@Query("format") String format,
                                     @Query("formatType") String formatType,
                                     @Query("noVariants") boolean noVariants,
                                     @Query("orderBy") String orderBy,
                                     @Query("limit") String limit,
                                     @Query("ts") String ts,
                                     @Query("hash") String hash,
                                     @Query("apikey") String apikey);
}
