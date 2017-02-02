package coding.studyblue.com.studybluecodingchallenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.ButterKnife;
import coding.studyblue.com.studybluecodingchallenge.R;

public class MoreDetailsActivity extends AppCompatActivity {

    TextView txt_html;
    TextView txt_subscribers_url;
    TextView txt_forks_url;
    TextView txt_team_url;
    TextView txt_tags_url;
    TextView txt_hooks_url;
    TextView txt_lang_url;
    TextView txt_statuses_url;
    TextView txt_stargazers_url;
    TextView txt_contributors_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txt_html = ButterKnife.findById(this, R.id.textView);
        txt_subscribers_url = ButterKnife.findById(this, R.id.textView2);
        txt_forks_url = ButterKnife.findById(this, R.id.textView3);
        txt_team_url = ButterKnife.findById(this, R.id.textView4);
        txt_tags_url = ButterKnife.findById(this, R.id.textView5);
        txt_hooks_url = ButterKnife.findById(this, R.id.textView6);
        txt_lang_url = ButterKnife.findById(this, R.id.textView7);
        txt_statuses_url = ButterKnife.findById(this, R.id.textView8);
        txt_stargazers_url = ButterKnife.findById(this, R.id.textView9);
        txt_contributors_url = ButterKnife.findById(this, R.id.textView10);
        if (getIntent() != null) {
            txt_html.setText(getIntent().getStringExtra(getResources().getString(R.string.html_url)));
            txt_subscribers_url.setText(getIntent().getStringExtra(getResources().getString(R.string.subscribers_url)));
            txt_forks_url.setText(getIntent().getStringExtra(getResources().getString(R.string.forks_url)));
            txt_team_url.setText(getIntent().getStringExtra(getResources().getString(R.string.teams_url)));
            txt_tags_url.setText(getIntent().getStringExtra(getResources().getString(R.string.tags_url)));
            txt_hooks_url.setText(getIntent().getStringExtra(getResources().getString(R.string.hooks_url)));
            txt_lang_url.setText(getIntent().getStringExtra(getResources().getString(R.string.languages_url)));
            txt_statuses_url.setText(getIntent().getStringExtra(getResources().getString(R.string.statuses_url)));
            txt_stargazers_url.setText(getIntent().getStringExtra(getResources().getString(R.string.stargazers_url)));
            txt_contributors_url.setText(getIntent().getStringExtra(getResources().getString(R.string.contributors_url)));
        }
    }

}
