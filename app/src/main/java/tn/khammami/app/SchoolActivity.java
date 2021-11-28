package tn.khammami.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SchoolActivity extends AppCompatActivity {
    public static String SCHOOL_NAME_KEY = "school_name";
    public static String SCHOOL_DESCRIPTION_KEY = "school_description";
    public static String SCHOOL_LOGO_KEY = "school_logo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        TextView schoolNameTextView = findViewById(R.id.school_name);
        TextView schoolDescriptionTextView = findViewById(R.id.school_description);
        ImageView schoolLogoImageView = findViewById(R.id.school_logo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String schoolName = extras.getString(SCHOOL_NAME_KEY, "");
            String schoolDescription = extras.getString(SCHOOL_DESCRIPTION_KEY, "");
            int schoolLogo = extras.getInt(SCHOOL_LOGO_KEY, 0);

            if (!schoolName.isEmpty()) {
                schoolNameTextView.setText(schoolName);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(schoolName);
                }
            }
            if (!schoolDescription.isEmpty()) {
                schoolDescriptionTextView.setText(schoolDescription);
            }
            if (schoolLogo != 0) {
                schoolLogoImageView.setImageResource(schoolLogo);
            }
        }
    }
}