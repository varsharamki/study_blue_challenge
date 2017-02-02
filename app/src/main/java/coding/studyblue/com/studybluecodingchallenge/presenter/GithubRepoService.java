package coding.studyblue.com.studybluecodingchallenge.presenter;


import java.util.ArrayList;

import coding.studyblue.com.studybluecodingchallenge.model.Ocramius;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubRepoService {

    @GET("/users/ocramius/repos")
    Call<ArrayList<Ocramius>> getOcramiusJson();

}
