package coding.studyblue.com.studybluecodingchallenge.view;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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

public class OcramiusRepoAdapter extends RecyclerView.Adapter<OcramiusRepoAdapter.OcramiusViewHolder>{

    Context context;
    ArrayList<Ocramius> ocramiusRepoList;

    public class OcramiusViewHolder extends RecyclerView.ViewHolder{
        //header view
      TextView titleTxt;
        @InjectView(R.id.description_txt) TextView  descriptionTxt;
        @InjectView(R.id.url_txt)TextView urlTxt;
        @InjectView(R.id.header_view)LinearLayout headerLayout;
        // body view
        TextView idTxt;
        TextView nameTxt;
        TextView ownerLoginTxt;
        TextView languageTxt;
        ImageView avatarView;
        RelativeLayout bodyView ;
        // footer view
        TextView updatedAtTxt;
        RelativeLayout moreDetailsLayout;

        public OcramiusViewHolder(View itemView) {
            super(itemView);
            context=itemView.getContext();
            titleTxt= ButterKnife.findById(itemView,R.id.title_txt);
            descriptionTxt=ButterKnife.findById(itemView,R.id.description_txt);
            urlTxt=ButterKnife.findById(itemView,R.id.url_txt);
headerLayout=ButterKnife.findById(itemView,R.id.header_view);

            idTxt=ButterKnife.findById(itemView,R.id.id_txt);
            nameTxt=ButterKnife.findById(itemView,R.id.name_txt);

            ownerLoginTxt=ButterKnife.findById(itemView,R.id.owner_login_txt);
            languageTxt=ButterKnife.findById(itemView,R.id.language_txt);

            updatedAtTxt=ButterKnife.findById(itemView,R.id.updated_at_txt);
            avatarView=ButterKnife.findById(itemView,R.id.avatar);
            moreDetailsLayout=ButterKnife.findById(itemView, R.id.more_details);
            bodyView=ButterKnife.findById(itemView,R.id.body_view);


        }
    }
    public OcramiusRepoAdapter(Context context, ArrayList<Ocramius> ocramiusRepoList) {
        this.context = context;
        this.ocramiusRepoList = ocramiusRepoList;
    }

    @Override
    public OcramiusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View repoView= LayoutInflater.from(parent.getContext()).inflate(R.layout.repos_card_view, parent, false);
        return new OcramiusViewHolder(repoView);
    }

    @Override
    public void onBindViewHolder(OcramiusViewHolder holder, int position) {
final Ocramius ocramius=ocramiusRepoList.get(position);

if(ocramius!=null) {

    holder.titleTxt.setText("asdlkasldk;laskdl");

    holder.descriptionTxt.setText(ocramius.getDescription());
    holder.urlTxt.setText(ocramius.getUrl());
    holder.idTxt.setText(String.valueOf(ocramius.getId()));
    holder.ownerLoginTxt.setText(ocramius.getOwner().getLogin());
    holder.nameTxt.setText(ocramius.getName());
    holder.languageTxt.setText(ocramius.getLanguage());

    OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setProtocols(Arrays.asList(Protocol.HTTP_1_1));
    OkHttpDownloader downloader = new OkHttpDownloader(okHttpClient);
    Picasso picasso = new Picasso.Builder(context).downloader(downloader).build();
    picasso.with(context).load(ocramius.getOwner().getAvatarUrl()).into(holder.avatarView);

    holder.updatedAtTxt.setText(ocramius.getUpdated_at());
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

        }
    });

}
}

    @Override
    public int getItemCount() {
        return ocramiusRepoList.size();
    }


}
