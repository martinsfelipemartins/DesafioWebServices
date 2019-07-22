package br.com.desafiowebservices.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.desafiowebservices.R;
import br.com.desafiowebservices.pojo.Result;
import br.com.desafiowebservices.views.DetailActivity;

public class RecyclerviewHQsAdapter extends RecyclerView.Adapter<RecyclerviewHQsAdapter.ViewHolder> {
    private List<Result> results;

    public RecyclerviewHQsAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hq_item_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Result result = results.get(position);
        holder.bind(result);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String transitionName = "image_" + position;
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("comic", result);
                intent.putExtra("transitionName", transitionName);

                holder.imageHQHome.setTransitionName(transitionName);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) holder.itemView.getContext(),
                                holder.imageHQHome, transitionName);

                holder.itemView.getContext().startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageHQHome;
        TextView numberHQHome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHQHome = itemView.findViewById(R.id.imageHQHome);
            numberHQHome = itemView.findViewById(R.id.editionNumber);


        }


            private void bind(Result result) {
                Picasso.get().load(result.getThumbnail().getPath() + "/portrait_incredible." + result.getThumbnail().getExtension())
                        .placeholder(R.drawable.marvel_logo)
                        .error(R.drawable.marvel_logo)
                        .into(imageHQHome);

                numberHQHome.setText("# " + result.getIssueNumber());
            }


    }

   /* public void clear() {
        this.result.clear();
        notifyDataSetChanged();
    }*/

    public void update(List<Result> resultList) {

            this.results = resultList;
            notifyDataSetChanged();
        }
    }
