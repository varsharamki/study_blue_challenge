package coding.studyblue.com.studybluecodingchallenge.view;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import coding.studyblue.com.studybluecodingchallenge.R;
import coding.studyblue.com.studybluecodingchallenge.model.Ocramius;

public class OcramiusRepoAdapter extends RecyclerView.Adapter<OcramiusRepoAdapter.OcramiusViewHolder> {

    Context context;
    ArrayList<Ocramius> ocramiusRepoList;

    public OcramiusRepoAdapter(Context context, ArrayList<Ocramius> ocramiusRepoList) {
        this.context = context;
        this.ocramiusRepoList = ocramiusRepoList;
    }

    @Override
    public OcramiusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View repoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repos_card_view, parent, false);
        return new OcramiusViewHolder(repoView);
    }

    @Override
    public void onBindViewHolder(OcramiusViewHolder holder, int position) {
        final Ocramius ocramius = ocramiusRepoList.get(position);
        try {
            if (ocramius != null) {
                if (!TextUtils.isEmpty(ocramius.getFullName())) {
                    holder.titleTxt.setText(ocramius.getFullName());
                }
                if (!TextUtils.isEmpty(ocramius.getDescription())) {
                    holder.descriptionTxt.setText(ocramius.getDescription());

                }
                if (!TextUtils.isEmpty(ocramius.getUrl())) {
                    holder.urlTxt.setText(ocramius.getUrl());
                }
                if (ocramius.getId() != 0) {
                    holder.idTxt.setText(String.valueOf(ocramius.getId()));
                }
                if (!TextUtils.isEmpty(ocramius.getOwner().getLogin())) {
                    holder.ownerLoginTxt.setText(ocramius.getOwner().getLogin());
                }
                if (!TextUtils.isEmpty(ocramius.getName())) {
                    holder.nameTxt.setText(ocramius.getName());
                }
                if (!TextUtils.isEmpty(ocramius.getLanguage())) {
                    holder.languageTxt.setText(ocramius.getLanguage());
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                okHttpClient.setProtocols(Arrays.asList(Protocol.HTTP_1_1));
                OkHttpDownloader downloader = new OkHttpDownloader(okHttpClient);
                Picasso picasso = new Picasso.Builder(context).downloader(downloader).build();

                if (!TextUtils.isEmpty(ocramius.getOwner().getAvatarUrl())) {
                    picasso.with(context).load(ocramius.getOwner().getAvatarUrl()).into(holder.avatarView);
                } else {
                    // place holder icon
                    picasso.with(context).load(R.mipmap.study_blue).into(holder.avatarView);
                }
                if (!TextUtils.isEmpty(ocramius.getUpdated_at())) {
                    String updatesAt = context.getResources().getString(R.string.updated_at) + "   " + ocramius.getUpdated_at();
                    holder.updatedAtTxt.setText(updatesAt);
                }
                if (!TextUtils.isEmpty(ocramius.getCreated_at())) {
                    String createdAt = context.getResources().getString(R.string.created_at) + "   " + ocramius.getCreated_at();
                    holder.createdAtTxt.setText(createdAt);
                }
                if (!TextUtils.isEmpty(ocramius.getPushed_at())) {
                    String pushedAt = context.getResources().getString(R.string.pushed_at) + "   " + ocramius.getPushed_at();
                    holder.pushedAtTxt.setText(pushedAt);
                }
                holder.bodyView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(ocramius.getClone_url()));
                        context.startActivity(intent);
                    }
                });


                holder.moreDetailsLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent moreDetailsIntent = new Intent(context, MoreDetailsActivity.class);
                        moreDetailsIntent.putExtra(context.getString(R.string.html_url), ocramius.getHtmlUrl());
                        moreDetailsIntent.putExtra(context.getString(R.string.subscribers_url), ocramius.getSubscribers_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.forks_url), ocramius.getForks_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.teams_url), ocramius.getTeams_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.tags_url), ocramius.getTags_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.hooks_url), ocramius.getHooks_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.languages_url), ocramius.getLanguages_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.statuses_url), ocramius.getStatuses_url());
                        moreDetailsIntent.putExtra(context.getString(R.string.stargazers_url), ocramius.getStargazersUrl());
                        moreDetailsIntent.putExtra(context.getString(R.string.contributors_url), ocramius.getContributors_url());

                        context.startActivity(moreDetailsIntent);
                    }
                });

            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            Log.e("OcramiusRepoAdapter: ", aio.getMessage());
        } catch (Exception e) {
            Log.e("OcramiusRepoAdapter: ", e.getMessage());

        }
    }

    @Override
    public int getItemCount() {
        return ocramiusRepoList.size();
    }

    public class OcramiusViewHolder extends RecyclerView.ViewHolder {
        //header view
        TextView titleTxt;
        @InjectView(R.id.description_txt)
        TextView descriptionTxt;
        @InjectView(R.id.url_txt)
        TextView urlTxt;
        @InjectView(R.id.header_view)
        LinearLayout headerLayout;
        // body view
        TextView idTxt;
        TextView nameTxt;
        TextView ownerLoginTxt;
        TextView languageTxt;
        ImageView avatarView;
        RelativeLayout bodyView;
        // footer view
        TextView updatedAtTxt;
        TextView createdAtTxt;
        TextView pushedAtTxt;

        RelativeLayout moreDetailsLayout;

        public OcramiusViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titleTxt = ButterKnife.findById(itemView, R.id.title_txt);
            descriptionTxt = ButterKnife.findById(itemView, R.id.description_txt);
            urlTxt = ButterKnife.findById(itemView, R.id.url_txt);
            headerLayout = ButterKnife.findById(itemView, R.id.header_view);

            idTxt = ButterKnife.findById(itemView, R.id.id_txt);
            nameTxt = ButterKnife.findById(itemView, R.id.name_txt);

            ownerLoginTxt = ButterKnife.findById(itemView, R.id.owner_login_txt);
            languageTxt = ButterKnife.findById(itemView, R.id.language_txt);

            updatedAtTxt = ButterKnife.findById(itemView, R.id.updated_at_txt);
            createdAtTxt = ButterKnife.findById(itemView, R.id.created_at_txt);

            pushedAtTxt = ButterKnife.findById(itemView, R.id.pushed_at_txt);
            avatarView = ButterKnife.findById(itemView, R.id.avatar);
            moreDetailsLayout = ButterKnife.findById(itemView, R.id.more_details);
            bodyView = ButterKnife.findById(itemView, R.id.body_view);


        }
    }


}
