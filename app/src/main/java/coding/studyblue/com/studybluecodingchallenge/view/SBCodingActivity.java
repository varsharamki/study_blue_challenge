package coding.studyblue.com.studybluecodingchallenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import coding.studyblue.com.studybluecodingchallenge.R;
import coding.studyblue.com.studybluecodingchallenge.model.Ocramius;
import coding.studyblue.com.studybluecodingchallenge.presenter.GithubRepoService;
import coding.studyblue.com.studybluecodingchallenge.presenter.OcramiusClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SBCodingActivity extends AppCompatActivity {

    RecyclerView ocramiusRecyclerView;
    private ArrayList<Ocramius> list = new ArrayList<>();
    private OcramiusRepoAdapter ocramiusRepoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbcoding);

        ocramiusRecyclerView = ButterKnife.findById(this, R.id.sbRecyclerView);
        try {
            GithubRepoService githubRepoService = OcramiusClient.getGithubRepoService();
            Call<ArrayList<Ocramius>> listCall = githubRepoService.getOcramiusJson();
            listCall.enqueue(new Callback<ArrayList<Ocramius>>() {
                @Override
                public void onResponse(Call<ArrayList<Ocramius>> call, Response<ArrayList<Ocramius>> response) {
                    if (response.isSuccessful()) {
                        list = response.body();
                        if (list != null) {
                            populateRecylerView(list);
                        }
                    }

                }

                @Override
                public void onFailure(Call<ArrayList<Ocramius>> call, Throwable t) {
                    try {
                        if (t != null) {
                            Log.e(SBCodingActivity.class.getSimpleName(), t.getMessage());
                        } else {
                            if (call.isCanceled()) {
                                call.execute();
                            }
                        }
                    } catch (IOException io) {
                        Log.e(SBCodingActivity.class.getSimpleName(), io.getMessage());

                    }

                }
            });

        } catch (Exception ioe) {
            Log.e(SBCodingActivity.class.getSimpleName(), ioe.getMessage());
        }
    }

    private void populateRecylerView(ArrayList<Ocramius> ocramiuses) {
        if (ocramiuses != null) {
            ocramiusRepoAdapter = new OcramiusRepoAdapter(this, ocramiuses);
            RecyclerView.LayoutManager grid = new LinearLayoutManager(this);
            ocramiusRecyclerView.setLayoutManager(grid);
            ocramiusRecyclerView.setAdapter(ocramiusRepoAdapter);
        }
    }

}
