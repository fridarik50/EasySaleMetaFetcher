package eu.projects.fridarik.easysalemetafetcher.network;

import eu.projects.fridarik.easysalemetafetcher.model.ReqResResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ReqResApiService {
    @GET("api/users")
    Call<ReqResResponse> getUsers();
}
