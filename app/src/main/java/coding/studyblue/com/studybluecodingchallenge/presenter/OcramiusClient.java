package coding.studyblue.com.studybluecodingchallenge.presenter;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OcramiusClient {

    public static final String BASE_URL = "https://api.github.com/";

    /**
     * @return
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * @return
     */
    public static GithubRepoService getGithubRepoService() {
        return getRetrofitInstance().create(GithubRepoService.class);
    }

}
