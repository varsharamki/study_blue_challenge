package coding.studyblue.com.studybluecodingchallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
    private ArrayList<Ocramius> list=new ArrayList<>();
private OcramiusRepoAdapter ocramiusRepoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbcoding);

        ocramiusRecyclerView=ButterKnife.findById(this,R.id.sbRecyclerView);
        /*
         check for internet connection
         create the recylerview layout to display =cardview with header and footer
         copy paste the recylerview adapter part from the [revious cmbtemam thigny

         */
        GithubRepoService githubRepoService= OcramiusClient.getGithubRepoService();
        Call<ArrayList<Ocramius>> listCall = githubRepoService.getOcramiusJson();
        listCall.enqueue(new Callback<ArrayList<Ocramius>>() {
            @Override
            public void onResponse(Call<ArrayList<Ocramius>> call, Response<ArrayList<Ocramius>> response) {
                if(response.isSuccessful()) {
                    list = response.body();
                    if (list!=null) {
                        populateRecylerView(list);
                    }
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Ocramius>> call, Throwable t) {

            }
        });

    }

    private void populateRecylerView(ArrayList<Ocramius> ocramiuses){
        if(ocramiuses!=null){
           ocramiusRepoAdapter=new OcramiusRepoAdapter(this,ocramiuses);
            RecyclerView.LayoutManager grid = new LinearLayoutManager(this);
            ocramiusRecyclerView.setLayoutManager(grid);
            ocramiusRecyclerView.setAdapter(ocramiusRepoAdapter);
        }
    }

}
