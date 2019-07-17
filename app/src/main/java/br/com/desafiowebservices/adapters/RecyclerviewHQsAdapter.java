package br.com.desafiowebservices.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.desafiowebservices.R;
import br.com.desafiowebservices.pojo.Result;

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
            imageHQHome = itemView.findViewById(R.id.imageSplash);
            numberHQHome = itemView.findViewById(R.id.editionNumber);


        }

        public void bind(Result result) {

            if (result.getThumbnail() != null) {
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(result.getThumbnail())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imageHQHome);

                numberHQHome.setText("#"+result.getIssueNumber());
            }
        }
    }

    public void clear() {
        this.results.clear();
        notifyDataSetChanged();
    }

    public void update(List<Result> results) {

        if (this.results.isEmpty()) {
            this.results = results;
        } else {
            this.results.addAll(results);
        }
        notifyDataSetChanged();
    }
}