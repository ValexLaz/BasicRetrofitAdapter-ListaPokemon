package practica.univalle.basicretrofitadapter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import practica.univalle.basicretrofitadapter.Models.Pokemon;
import practica.univalle.basicretrofitadapter.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<Pokemon> movieList;

    public UserAdapter(Context context, List<Pokemon> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Pokemon pokemon = movieList.get(position);
        holder.titleTextView.setText(pokemon.name);
        holder.overviewTextView.setText(pokemon.hp);
        holder.releaseDateTextView.setText(String.valueOf(pokemon.base_experience));
        holder.ataque.setText(pokemon.ataque);
        holder.ataque_especial.setText(pokemon.ataqueEspecial);
        holder.defensa.setText(pokemon.defensa);

        Picasso.get()
                .load(pokemon.url)
                .placeholder(R.drawable.ic_launcher_background) // Opcional
                .error(R.drawable.ic_launcher_foreground) // Opcional
                .into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterImageView;
        private TextView titleTextView;
        private TextView overviewTextView;
        private TextView releaseDateTextView;
        private TextView ataque;
        private TextView ataque_especial;
        private TextView defensa;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.poster_image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            overviewTextView = itemView.findViewById(R.id.overview_text_view);
            releaseDateTextView = itemView.findViewById(R.id.release_date_text_view);
            ataque=itemView.findViewById(R.id.ataque);
            ataque_especial=itemView.findViewById(R.id.ataque_especial);
            defensa=itemView.findViewById(R.id.defensa);
        }
    }
}
