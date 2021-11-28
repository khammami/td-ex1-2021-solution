package tn.khammami.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView logo;

    public SchoolViewHolder(@NonNull View itemView) {
        super(itemView);

        this.name = itemView.findViewById(R.id.school_name);
        this.description = itemView.findViewById(R.id.school_description);
        this.logo = itemView.findViewById(R.id.school_logo);
    }
}
